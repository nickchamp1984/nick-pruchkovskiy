package cx.en.oq.tests;

import cx.en.oq.utils.BaseTest;
import cx.en.oq.utils.BasePage;
import cx.en.oq.utils.PropertiesReader;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.testng.annotations.Test;



@Owner("Nick Pruchkovskiy")
public class LoginTest extends BaseTest {
    /*
Go to the url: http://54.37.125.177/
Choose "Log in" from main menu
Enter VALID credentials and press "Log in"
     */


    @Test
    @TmsLink("ONQA0104-1")
    @Severity(SeverityLevel.MINOR)
    public void loginTest(){
        goToUrl(PropertiesReader.getInstance().getPropertyByName("baseUrl") + "login");
        clickLoginButton();
        enterCredentialsAndSubmitLogin();
    }

    @Step
    private void clickLoginButton() {
        driver.findElement(By.xpath("//a[@class='ico-login']")).click();
    }

    @Step
    private void enterCredentialsAndSubmitLogin() {
        driver.findElement(By.id("Email")).sendKeys(PropertiesReader.getInstance().getPropertyByName("userEmail"));
        driver.findElement(By.name("Password")).sendKeys(PropertiesReader.getInstance().getPropertyByName("userPass"));
        driver.findElement(By.xpath("//button[@type='submit'] [@class$='login-button']")).click();
    }
}
