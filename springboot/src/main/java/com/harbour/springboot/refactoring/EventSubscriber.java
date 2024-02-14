package com.harbour.springboot.refactoring;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.DeleteMessageBatchRequestEntry;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
import com.google.gson.Gson;
import com.harbour.springboot.refactoring.notimportant.ExternalRequestDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.util.Set;

@Service
public class EventSubscriber {
    Logger logger = LoggerFactory.getLogger(EventSubscriber.class);

    private static final Set<Integer> NON_RETRYABLE_STATUS_CODES = Set.of(400, 202);

    private final BackOffTimeDTO backOffTimeDTO = new BackOffTimeDTO();

    private final ExternalEventService externalEventService;
    private final String queueUrl;
    private final AmazonSQS amazonSqs;
    private final Clock clock;
    private final Gson gson;
    private final BackOffTimeEvaluationService backOffTimeEvaluationService;

    public EventSubscriber(
            ExternalEventService externalEventService,
            @Value("${sqs.events_queue_url}") String queueUrl,
            AmazonSQS amazonSqs,
            Clock clock,
            Gson gson,
            BackOffTimeEvaluationService backOffTimeEvaluationService) {
        this.externalEventService = externalEventService;
        this.queueUrl = queueUrl;
        this.amazonSqs = amazonSqs;
        this.clock = clock;
        this.gson = gson;
        this.backOffTimeEvaluationService = backOffTimeEvaluationService;
        this.backOffTimeDTO.setBackOffTimeDurationInMinutes(1);
        this.backOffTimeDTO.setRetryAfterTimeInMillis(Long.MIN_VALUE);
    }

    @Scheduled(fixedDelayString = "${sqs.polling_interval}")
    public void receiveMessages() {
        if (backOffTimeDTO.getRetryAfterTimeInMillis() > clock.instant().toEpochMilli()) {
            return;
        }

        try {
            var receiveMessageRequest = new ReceiveMessageRequest(queueUrl).withMaxNumberOfMessages(10);
            var messages = amazonSqs.receiveMessage(receiveMessageRequest).getMessages();
            if (messages.isEmpty()) {
                return;
            }

            var requestDTOS =
                    messages.stream()
                            .map(message -> gson.fromJson(message.getBody(), ExternalRequestDTO.class))
                            .toList();
            var response = externalEventService.sendEvents(requestDTOS);

            response.ifPresent(
                    resp -> backOffTimeEvaluationService.evaluateBackOffTime(resp, messages, backOffTimeDTO));

            if (response.isEmpty() || NON_RETRYABLE_STATUS_CODES.contains(response.get().status())) {

                amazonSqs.deleteMessageBatch(
                        queueUrl,
                        messages.stream()
                                .map(
                                        m -> new DeleteMessageBatchRequestEntry(m.getMessageId(), m.getReceiptHandle()))
                                .toList());

                backOffTimeDTO.setBackOffTimeDurationInMinutes(1);
            }

        } catch (Exception e) {
            logger
                    .error(
                            String.format("Error processing events with status code: [%s]", e.getMessage()), e);
        }
    }
}