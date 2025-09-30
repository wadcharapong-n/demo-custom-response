package com.north.democustomerresponse.util;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;

class MarkingUtilTest {

    @Test
    void testMarkingValue() {
        BigDecimal value = new BigDecimal("123.45");
        String result = MarkingUtil.markingValue(value);
        assertEquals("XXX.XX", result);

        BigDecimal value2 = new BigDecimal("12.450");
        String result2 = MarkingUtil.markingValue(value2);
        assertEquals("XX.XXX", result2);
    }

    @Test
    void testIsDigit() {
        String number = "123.45";
        assertTrue(MarkingUtil.isDigit(number, 0));
        assertTrue(MarkingUtil.isDigit(number, 1));
        assertTrue(MarkingUtil.isDigit(number, 2));
        assertFalse(MarkingUtil.isDigit(number, 3));
        assertTrue(MarkingUtil.isDigit(number, 4));
    }

}