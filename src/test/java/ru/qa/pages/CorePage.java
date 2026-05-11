package ru.qa.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class CorePage extends MainPage {
    public CorePage(WebDriver driver) {
        super(driver);
    }

    @Getter
    @FindBy(css = "[data-wba-header-name=\"Login\"]" )
    public WebElement LoginPopup;

    @Getter
    @FindBy(css = "[data-testid=\"authForm\"]")
    public WebElement AuthForm;

    @Getter
    @FindBy(css = "[data-test-id=\"auth-title-h2\"]")
    public WebElement AuthTitle;

}
