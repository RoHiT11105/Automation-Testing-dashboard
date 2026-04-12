package com.automation.automationregression.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public WebDriver getDriver() {
        return driver.get();
    }

    @BeforeMethod
    public void setUp() {
        driver.set(new ChromeDriver());
        getDriver().manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        getDriver().quit();
        driver.remove();
    }
}