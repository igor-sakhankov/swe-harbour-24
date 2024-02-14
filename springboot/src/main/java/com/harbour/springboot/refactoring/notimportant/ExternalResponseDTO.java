package com.harbour.springboot.refactoring.notimportant;

import java.util.Collection;
import java.util.Map;

public record ExternalResponseDTO(
        int status, Map<String, Collection<String>> headers) {}