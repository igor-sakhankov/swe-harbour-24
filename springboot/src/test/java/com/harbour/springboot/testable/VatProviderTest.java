package com.harbour.springboot.testable;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VatProviderTest {

    @Test
    void getVat() {
        // Given
        VatProvider vatProvider = new VatProvider();
        // When
        double vat = vatProvider.getVat();
        // Then
        assertEquals(20, vat);
    }
}