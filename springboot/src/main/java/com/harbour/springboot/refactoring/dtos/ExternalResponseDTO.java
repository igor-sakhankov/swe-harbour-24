package com.harbour.springboot.refactoring.dtos;

import java.util.Collection;
import java.util.Map;

public record ExternalResponseDTO(
        int status, Map<String, Collection<String>> headers) {}