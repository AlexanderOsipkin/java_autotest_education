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
    public WebElement loginButton;

    @Getter
    @FindBy(css = "[data-testid=\"authForm\"]")
    public WebElement authForm;

    @Getter
    @FindBy(css = "[data-testid=\"phoneInput\"]")
    public WebElement phoneInput;

    @Getter
    @FindBy(css = "[data-class=\"btn\"]")
    public WebElement phoneRegion;

    @Getter
    @FindBy(css = "[data-test-id=\"auth-phone-input-get-code-btn\"]")
    public WebElement getCodeButton;

    @Getter
    @FindBy(css = "[data-test-id=\"auth-title-login-or-create-a-profile\"]")
    public WebElement authTitle;

    @Getter
    @FindBy(css = "[data-testid=\"linkTermsOfUse\"]")
    public WebElement linkTermsOfUse;

    @Getter
    @FindBy(css = "[data-testid=\"linkReturnPolice\"]")
    public WebElement linkReturnPolice;

    @Getter
    @FindBy(css = "[data-testid=\"geo-delivery-points-popup-open\"]")
    public WebElement geoPopupButton;

    @Getter
    @FindBy(xpath = "//div[@role='dialog' and contains(@class,'popup-geo')]")
    public WebElement mapPopup;

    @Getter
    @FindBy(xpath = "//div[@role='dialog']//h2[contains(text(),'Выберите способ доставки')]")
    public WebElement deliveryChangeHeader;

    @Getter
    @FindBy(xpath = "//div[@role='dialog']//button[text()='Закрыть']")
    public WebElement closeMapButton;

    @Getter
    @FindBy(css = "[data-testid=\"map-search-input\"]")
    public WebElement mapSearchInput;


    // тут мы ассертим только текст, поэтому span,
    // если нужна кнопка, то можно юзануть дополнительно input[data-testid='delivery-way-map-self']
    @Getter
    @FindBy(css = "span[data-testid=\"delivery-way-map-self\"]")
    public WebElement PVZButton;

    @Getter
    @FindBy(css = "[data-testid=\"delivery-way-map-courier\"]")
    public WebElement courierButton;

    @Getter
    @FindBy(css = ".map-controlls .map-controlls__zoom-in")
    public WebElement zoomInButton;

    @Getter
    @FindBy(css = ".map-controlls .map-controlls__zoom-out")
    public WebElement zoomOutButton;

    @Getter
    @FindBy(css = ".map-controlls .map-controlls__user-location")
    public WebElement userLocationButton;

}
