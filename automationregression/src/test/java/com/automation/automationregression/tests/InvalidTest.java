package com.automation.automationregression.tests;

import com.automation.automationregression.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InvalidTest extends BaseTest {

    @Test
    public void testInvalidCase() {

        getDriver().get("https://www.google.com");

        String title = getDriver().getTitle();
        System.out.println("Invalid Test Title: " + title);

        Assert.assertTrue(title.contains("Facebook"));
    }
}