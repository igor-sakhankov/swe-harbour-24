package com.harbour.springboot.refactoring;

import com.harbour.springboot.refactoring.dtos.ExternalApi;
import com.harbour.springboot.refactoring.dtos.ExternalRequestDTO;
import com.harbour.springboot.refactoring.dtos.ExternalRequestVM;
import com.harbour.springboot.refactoring.dtos.ExternalResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@Service
public class ExternalEventService {

    public static final String RETRY_AFTER_HEADER = "Retry-After";
    public static final int BAD_REQUEST_STATUS_CODE = 400;
    public static final int TOO_MANY_REQUESTS_STATUS_CODE = 429;
    public static final Set<Integer> RETRYABLE_ERROR_CODES_WITHOUT_EXPONENTIAL_BACK_OFF =
            Set.of(401, 403);
    private final ExternalApi apiClient;
    private final String environment;

    @Autowired
    public ExternalEventService(
            @Lazy ExternalApi externalApi,
            @Value("${external.environment}") String environment) {
        this.apiClient = externalApi;
        this.environment = environment;
    }

    /**
     * Sends events to External system In case of failure, the events are forwarded to DLQ
     *
     * @param requestDTOS list of events to be sent
     */
    public Optional<ExternalResponseDTO> sendEvents(List<ExternalRequestDTO> requestDTOS) {
        var eventsRequestVMS = requestDTOS.stream().map(this::mapRequest).toList();
        if (eventsRequestVMS.isEmpty()) {
            return Optional.empty();
        }

        try (var response = apiClient.postRequest(eventsRequestVMS)) {
            return Optional.of(
                    new ExternalResponseDTO(response.status(), response.headers()));
        } catch (Exception e) {
            return Optional.of(new ExternalResponseDTO(500, Map.of()));
        }
    }

    private ExternalRequestVM mapRequest(ExternalRequestDTO externalRequestDTO) {
        return new ExternalRequestVM(
                externalRequestDTO.eventName(),
                environment);
    }
}
