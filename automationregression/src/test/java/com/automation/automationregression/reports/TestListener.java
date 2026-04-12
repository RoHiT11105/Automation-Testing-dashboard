package com.automation.automationregression.reports;

import com.automation.automationregression.utils.ScreenshotUtil;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.ITestContext;

public class TestListener implements ITestListener {

    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest = ExtentManager.getInstance()
                .createTest(result.getMethod().getMethodName());
        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().pass("Test Passed ✅");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        test.get().fail("Test Failed ❌");
        test.get().fail(result.getThrowable());

        try {
            Object currentClass = result.getInstance();
            WebDriver driver = (WebDriver) result.getTestClass()
                    .getRealClass()
                    .getDeclaredField("driver")
                    .get(currentClass);

            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, result.getMethod().getMethodName());

            test.get().addScreenCaptureFromPath(screenshotPath);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentManager.getInstance().flush();
    }
}