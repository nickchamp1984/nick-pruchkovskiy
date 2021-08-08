package cx.en.oq.utils;

import cx.en.oq.driver.BrowserHolder;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class TestListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test '" + result.getName() + "' started!");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test '" + result.getName() + "' finished!");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test '" + result.getName() + "' failed!");
        File screenshotAs = ((TakesScreenshot) BrowserHolder.getInstance().getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshotAs, new File(result.getName() + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Tests begin!");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Tests end!");
    }

}
