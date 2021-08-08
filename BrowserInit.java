package cx.en.oq.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Arrays;

public class BrowserInit {
    public static WebDriver initDriver(Browsers browsers) {
        switch (browsers) {
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            case EDGE:
                WebDriverManager.edgedriver();
                return new EdgeDriver();
            case CHROME:
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            default:
                return null;
        }
    }

    public static WebDriver initDriver() {
        try {
            String browser = System.getProperty("browserType", "chrome");
            return initDriver(Browsers.valueOf(browser.toUpperCase()));
        } catch (Exception e) {
            System.out.println("Please check 'browserType parameter'.\n" +
                    "Now we can support only: " + Arrays.asList(Browsers.values()));
        }
        return null;
    }
}
