package ru.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[data-testid='phoneInput']")
    private WebElement phoneInput;

    @FindBy(css = "input[inputmode='numeric']")
    private WebElement codeInput;

    public void enterPhone(String phone) {
        phoneInput.sendKeys(phone);
    }

    public void enterCode(String code) {
        codeInput.sendKeys(code);
    }
}