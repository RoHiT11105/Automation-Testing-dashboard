package com.automation.automationregression.tests;

import com.automation.automationregression.base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleTest extends BaseTest {

    @Test
    public void testGoogleSearch() {

        getDriver().get("https://www.google.com");

        getDriver().findElement(By.name("q")).sendKeys("Selenium");
        getDriver().findElement(By.name("q")).submit();

        try { Thread.sleep(2000); } catch (Exception e) {}

        String title = getDriver().getTitle();
        System.out.println("Google Test Title: " + title);

        Assert.assertTrue(title.contains("Selenium"));
    }
}