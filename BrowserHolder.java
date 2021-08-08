package cx.en.oq.driver;

import org.openqa.selenium.WebDriver;

public class BrowserHolder {
    private WebDriver driver = null;
    private static BrowserHolder browserHolder = null;

    private BrowserHolder(){

    }

    public static BrowserHolder getInstance(){
        if (browserHolder == null){
            browserHolder = new BrowserHolder();
        }
        return browserHolder;
    }

    public void initDriver(Browsers browsers){
        if (driver == null)
            driver = BrowserInit.initDriver(browsers);
        driver.manage().window().maximize();
    }

    public WebDriver getDriver(){
        return driver;
    }
}
