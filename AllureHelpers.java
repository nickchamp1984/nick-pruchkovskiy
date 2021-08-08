package cx.en.oq.utils;

import cx.en.oq.driver.BrowserHolder;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.nio.charset.StandardCharsets;

public class AllureHelpers {

    @SuppressWarnings("UnusedReturnValue")
    @Attachment(value = "AllureTextReport", type = "text/plain", fileExtension = ".txt")
    public static String attachText(final String text) {
        return text;
    }

    @SuppressWarnings("UnusedReturnValue")
    @Attachment(value = "AllureCSVReport", type = "text/csv", fileExtension = ".csv")
    public static String attachCSV(final String csv) {
        return csv;
    }

    @SuppressWarnings("UnusedReturnValue")
    @Attachment(value = "Html source", type = "text/html", fileExtension = ".html")
    public static byte[] getPageSource() {
        return getPageSourceBytes();
    }

    @SuppressWarnings("UnusedReturnValue")
    @Attachment(value = "Screenshot", type = "image/png", fileExtension = ".png")
    public static byte[] takeScreenshot() {
        return getScreenshotBytes();
    }

//    @SuppressWarnings("UnusedReturnValue")
//    @Attachment(value = "{name}", type = "image/png", fileExtension = ".png")
//    public static byte[] takeScreenshot(final String name) {
//        return getScreenshotBytes();
//    }

    public static byte[] getPageSourceBytes() {
        return BrowserHolder.getInstance().getDriver().getPageSource().getBytes(StandardCharsets.UTF_8);
    }

    public static byte[] getScreenshotBytes() {
        return ((TakesScreenshot) BrowserHolder.getInstance().getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
