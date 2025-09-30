package com.north.democustomerresponse.util;

import java.math.BigDecimal;

public class MarkingUtil {
    private MarkingUtil() {
        throw new IllegalStateException("Utility class");
    }

    public static String markingValue(BigDecimal value) {
        String numberStr = value.toString();
        StringBuilder masked = new StringBuilder();
        for (int i = 0; i < numberStr.length(); i++) {
            if (isDigit(numberStr, i)) {
                masked.append('X');
            } else{
                masked.append(numberStr.charAt(i));
            }
        }
        return masked.toString();
    }

    public static boolean isDigit(String numberStr, int i) {
        return Character.isDigit(numberStr.charAt(i));
    }

}
