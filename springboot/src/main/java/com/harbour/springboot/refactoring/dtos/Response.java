package com.harbour.springboot.refactoring.dtos;

import org.springframework.http.StreamingHttpOutputMessage;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class Response implements AutoCloseable {
    @Override
    public void close() throws Exception {
        System.out.printf("Response closed.");
    }

    public int status() {
        return 200;
    }

    public Map<String, Collection<String>> headers() {
        return Map.of("Content-Type", List.of("application/json"));
    }

    public StreamingHttpOutputMessage.Body body() {
        return null;
    }
}
