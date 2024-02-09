package com.harbour.springboot.testable;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TaxCalculatorTest {
    @Mock
    private VatProvider vatProvider;

    @InjectMocks
    private TaxCalculator taxCalculator;

    public static Stream<Arguments> provideCalculateTax() {
        return Stream.of(
                Arguments.of(5000, 0),
                Arguments.of(19000, 1900)
        );
    }

    @ParameterizedTest
    @MethodSource("provideCalculateTax")
    void calculateTax(double income, double expectedTax) {
        // When
        double calculated = taxCalculator.calculateTax(income);
        // Then
        assertEquals(expectedTax, calculated);
    }

    @Test
    void calculatePriceWithoutVat() {
        // When
        when(vatProvider.getVat()).thenReturn(0.2);
        double calculated = taxCalculator.calculatePriceWithoutVat(100);
        // Then
        assertEquals(80, calculated);
    }

    @Test
    void shouldIGoToSki() {
        // When
        boolean shouldIGoToSki = taxCalculator.shouldIGoToSki(5000);
        // Then
        assertTrue(shouldIGoToSki);
    }
}