package com.automation.automationregression.utils;

public class TestStatusUtil {

    public static boolean isValid(String status) {
        return status.equalsIgnoreCase("PASS") ||
                status.equalsIgnoreCase("FAIL");
    }
}