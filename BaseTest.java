package cx.en.oq.utils;

import cx.en.oq.driver.BrowserInit;
import cx.en.oq.driver.Browsers;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

@Listeners({TestListener.class, AllureScreenShooter.class})
public class BaseTest {
    protected WebDriver driver = null;

    @Step
    protected void goToUrl(String url) {
        driver.get(url);
    }
    @BeforeSuite
    public void InitAll() {
        driver = BrowserInit.initDriver(Browsers.CHROME);
        driver.manage().window().maximize();
        PropertiesReader.getInstance("app.properties");
    }

    @AfterSuite
    public void deactivateAll() {
        if (driver != null) {
            driver.quit();
        }
    }
}
