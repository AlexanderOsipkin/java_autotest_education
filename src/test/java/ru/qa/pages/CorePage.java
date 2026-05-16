package ru.qa.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class CorePage extends MainPage {
    public CorePage(WebDriver driver) {
        super(driver);
    }


    // не лучший мой вариант использования локаторов,
    // так как на странице /lk их будет по 2,
    // в будущем попробую порефакторить или заменить на xpath
    @Getter
    @FindBy(css = "[data-wba-header-name=\"Login\"]")
    public WebElement LoginButton;

    @Getter
    @FindBy(css = "[data-testid=\"authForm\"]")
    public WebElement AuthForm;

    @Getter
    @FindBy(css = "[data-testid=\"phoneInput\"]")
    public WebElement PhoneInput;

    @Getter
    @FindBy(css = "[data-class=\"btn\"]")
    public WebElement PhoneRegion;

    @Getter
    @FindBy(css = "[data-test-id=\"auth-phone-input-get-code-btn\"]")
    public WebElement GetCodeButton;

    @Getter
    @FindBy(css = "[data-test-id=\"auth-title-login-or-create-a-profile\"]")
    public WebElement AuthTitle;

    @Getter
    @FindBy(css = "[data-testid=\"linkTermsOfUse\"]")
    public WebElement linkTermsOfUse;

    @Getter
    @FindBy(css = "[data-testid=\"linkReturnPolice\"]")
    public WebElement linkReturnPolice;

}
