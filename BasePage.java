package cx.en.oq.utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

// To be extended as much as possible

public class BasePage {

    @FindBy(id = "customerCurrency")
    private WebElement customerCurrency;

    @FindBy(xpath = "//a[@class='ico-register']")
    private WebElement registerButton;

    @FindBy(id = "Email")
    private WebElement emailLoginFormInput;

    @FindBy(name = "Password")
    private WebElement passwordLoginFormInput;

    @FindBy(id = "RememberMe")
    private WebElement rememberMeCheckBox;

    @FindBy(css = ".button-1.register-button")
    private WebElement loginButton;

    @FindBy(id = "Email-error")
    private WebElement emailErrorMessage;

    @FindBy(xpath = "//button")
    private List<WebElement> buttons;


    public boolean isEmailErrorVisible(){
        return emailErrorMessage.isDisplayed();
    }

    public String getErrorEmailMessageText(){
        return emailErrorMessage.getText();
    }

    public List<String> getButtonText(){
        return buttons.stream().map(WebElement::getText).collect(Collectors.toList());
    }

}
