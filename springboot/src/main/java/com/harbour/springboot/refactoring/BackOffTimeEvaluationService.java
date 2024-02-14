package com.harbour.springboot.refactoring;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.Message;
import com.harbour.springboot.refactoring.notimportant.ExternalResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static com.harbour.springboot.refactoring.ExternalEventService.BAD_REQUEST_STATUS_CODE;
import static com.harbour.springboot.refactoring.ExternalEventService.RETRYABLE_ERROR_CODES_WITHOUT_EXPONENTIAL_BACK_OFF;
import static com.harbour.springboot.refactoring.ExternalEventService.RETRY_AFTER_HEADER;
import static com.harbour.springboot.refactoring.ExternalEventService.TOO_MANY_REQUESTS_STATUS_CODE;

@Service
public class BackOffTimeEvaluationService {

  Logger logger = LoggerFactory.getLogger(BackOffTimeEvaluationService.class);

  private final Clock clock;
  private final AmazonSQS amazonSqs;
  private final String dlqUrl;

  public BackOffTimeEvaluationService(
      Clock clock, AmazonSQS amazonSqs, @Value("${sqs.events_queue_dlq_url}") String dlqUrl) {
    this.clock = clock;
    this.amazonSqs = amazonSqs;
    this.dlqUrl = dlqUrl;
  }

  public void evaluateBackOffTime(
      ExternalResponseDTO externalResponseDTO,
      List<Message> messages,
      BackOffTimeDTO backOffTimeDTO) {

    if (BAD_REQUEST_STATUS_CODE == externalResponseDTO.status()) {
      messages.forEach(message -> amazonSqs.sendMessage(dlqUrl, message.getBody()));
      return;
    }

    if (RETRYABLE_ERROR_CODES_WITHOUT_EXPONENTIAL_BACK_OFF.contains(
        externalResponseDTO.status())) {
      backOffTimeDTO.setBackOffTimeDurationInMinutes(1);
      return;
    }

    logger
        .info(
            "Retryable event with status code: [%s] and headers: [%s]",
            externalResponseDTO.status(),
            externalResponseDTO.headers());

    int maxBackOffTimeDurationInMinutes = 5;
    if (externalResponseDTO.status() == TOO_MANY_REQUESTS_STATUS_CODE
        && externalResponseDTO.headers().containsKey(RETRY_AFTER_HEADER)) {

      var mayBeRetryAfterValueInSeconds =
          extractRetryAfterValueInSeconds(externalResponseDTO.headers().get(RETRY_AFTER_HEADER));

      if (mayBeRetryAfterValueInSeconds.isPresent()) {
        int retryAfterValueInSeconds =
            Math.min(
                Math.abs(mayBeRetryAfterValueInSeconds.get()),
                maxBackOffTimeDurationInMinutes * 60);
        backOffTimeDTO.setRetryAfterTimeInMillis(
            clock.instant().toEpochMilli() + retryAfterValueInSeconds * 1000L);
        return;
      }
    }

    backOffTimeDTO.setRetryAfterTimeInMillis(
        clock.instant().toEpochMilli()
            + (long) backOffTimeDTO.getBackOffTimeDurationInMinutes() * 60 * 1000);

    backOffTimeDTO.setBackOffTimeDurationInMinutes(
        Math.max(
            maxBackOffTimeDurationInMinutes, backOffTimeDTO.getBackOffTimeDurationInMinutes() + 2));
  }

  private Optional<Integer> extractRetryAfterValueInSeconds(Collection<String> retryAfterHeader) {

    for (String value : retryAfterHeader) {
      if (value.matches("\\d+")) {
        return Optional.of(Integer.parseInt(value));
      }
    }
    return Optional.empty();
  }
}