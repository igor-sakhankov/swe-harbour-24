package com.harbour.springboot.testable;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntParserTest {

    @Test
    void parse() {
        assertEquals(5, IntParser.Parse("5"));
    }
}