package com.harbour.springboot.refactoring.notimportant;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExternalApi {
    public Response postRequest(List<ExternalRequestVM> eventsRequestVMS) {
        return null;
    }
}
