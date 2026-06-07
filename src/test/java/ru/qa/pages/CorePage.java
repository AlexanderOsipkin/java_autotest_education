package ru.qa.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class CorePage extends BasePage {
    public CorePage(WebDriver driver) {
        super(driver);
    }


    // не лучший мой вариант использования локаторов,
    // так как на странице /lk их будет по 2,
    // но для проверок на странице /basket - Более чем достаточно
    // в будущем попробую порефакторить или заменить на xpath
    @Getter
    @FindBy(css = "[data-testid=\"login\"]")
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

    // тут мы используем этот локатор для ассерта только текста, поэтому span,
    // если нужна кнопка, то можно юзануть дополнительно input[data-testid='delivery-way-map-self']
    // ну или уйти в xpath
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

    @Getter
    @FindBy(css = "[id=\"header\"]")
    public WebElement siteHeader;

    @Getter
    @FindBy(css = "[data-testid=\"main-logo-wb\"]")
    public WebElement mainLogo;

    @Getter
    @FindBy(css = ("[data-wba-header-name=\"Catalog\"]"))
    public WebElement siteBurgerMenu;

    @Getter
    @FindBy(css = "[id=\"searchInput\"]")
    public WebElement siteSearchInput;

    @Getter
    @FindBy(css = "[id=\"searchByImageFormAbNew\"]")
    public WebElement searchEmblem;

    @Getter
    @FindBy(css = "[data-wba-header-name=\"Pick_up_points\"]")
    public WebElement siteAddressButton;

    @Getter
    @FindBy(css = "[data-testid=\"basket-header\"]")
    public WebElement siteBasketButton;

    @Getter
    @FindBy(css = "[id=\"diamondsMenu\"]")
    public WebElement diamondsMenu;

    @Getter
    @FindBy(css = "[id=\"nonAuthBalanceBlock\"]")
    public WebElement cashbackButton;

    @Getter
    @FindBy(css = "[data-testid=\"selected-currency\"]")
    public WebElement selectedCurrencyButton;

    @Getter
    @FindBy(css = ".simple-menu__diamonds-wrap [data-menu-id=\"wibes\"] a")
    public WebElement wibesButton;

    @Getter
    @FindBy(css = ".simple-menu__diamonds-wrap [data-menu-id=\"hotels\"] a")
    public WebElement hotelsButton;

    @Getter
    @FindBy(css = ".simple-menu__diamonds-wrap [data-menu-id=\"avia\"] a")
    public WebElement aviaButton;

    @Getter
    @FindBy(css = ".simple-menu__diamonds-wrap [data-menu-id=\"funSun\"] a")
    public WebElement funSunButton;

    @Getter
    @FindBy(css = ".simple-menu__diamonds-wrap [data-menu-id=\"resale\"] a")
    public WebElement resaleButton;

    @Getter
    @FindBy(css = ".simple-menu__diamonds-wrap [data-menu-id=\"wbClub\"] a")
    public WebElement wbClubButton;

    // Дропдаун для бизнеса
    @Getter
    @FindBy(css = ".simple-menu__diamonds-wrap li[data-menu-id='business'] > span")
    public WebElement businessDropdown;

    @Getter
    @FindBy(css = ".simple-menu__diamonds-wrap li[data-menu-id='business'] ul")
    public WebElement businessDropdownMenu;

    @Getter
    @FindBy(css = ".simple-menu__diamonds-wrap [data-menu-id=\"buyAsBusiness\"] a")
    public WebElement buyAsBusinessButton;

    @Getter
    @FindBy(css = ".simple-menu__diamonds-wrap [data-menu-id=\"seller\"] a")
    public WebElement sellerButton;

    @Getter
    @FindBy(css = ".simple-menu__diamonds-wrap [data-menu-id=\"openPickUpPoint\"] a")
    public WebElement openPickUpPointButton;

    @Getter
    @FindBy(css = ".simple-menu__diamonds-wrap [data-menu-id=\"business_purchase\"] a")
    public WebElement businessPurchaseButton;

    @Getter
    @FindBy(css = ".simple-menu__diamonds-wrap [data-menu-id=\"china_wholesale\"] a")
    public WebElement chinaWholesaleButton;

    @Getter
    @FindBy(css = ".simple-menu__diamonds-wrap [data-menu-id=\"work\"]")
    public WebElement workButton;

    @Getter
    @FindBy(css = ".simple-menu__diamonds-wrap [data-menu-id=\"eapteka\"]")
    public WebElement eaptekaButton;

    // Дропдаун еще
    @Getter
    @FindBy(css = ".simple-menu__diamonds-wrap [data-menu-id=\"more\"] > span")
    public WebElement moreDropdown;

    @Getter
    @FindBy(css = ".simple-menu__diamonds-wrap li[data-menu-id='more'] ul")
    public WebElement moreDropdownMenu;

    @Getter
    @FindBy(css = ".simple-menu__diamonds-wrap [data-menu-id=\"realty\"] a")
    public WebElement realtyButton;

    @Getter
    @FindBy(css = ".simple-menu__diamonds-wrap [data-menu-id=\"brands\"] a")
    public WebElement brandsButton;

    @Getter
    @FindBy(css = "[id=\"footer\"]")
    public WebElement mainFooter;

    @Getter
    @FindBy(css = ".media-placements-zones [data-analitics-code=\"FBS\"]")
    public WebElement mediaPlacementsInFooter;

    @Getter
    @FindBy(css = ".footer__list-wrap--buyers")
    public WebElement buyersListInFooter;

    @Getter
    @FindBy(css = ".footer__inner-wrap")
    public WebElement sellersAndPartnersInFooter;

    @Getter
    @FindBy(css = ".footer__list-wrap--ourprojects")
    public WebElement ourProjectsInFooter;

    @Getter
    @FindBy(css = ".footer__list-wrap--company")
    public WebElement companyInFooter;

    @Getter
    @FindBy(css = ".footer__list-wrap--download")
    public WebElement downloadsInFooter;

    @Getter
    @FindBy(css = ".footer-social__icon--vk")
    public WebElement vkIconInFooter;

    @Getter
    @FindBy(css = "footer-social__icon--ok")
    public WebElement okIconInFooter;

    @Getter
    @FindBy(css = "footer-social__icon--telegram")
    public WebElement tgIconInFooter;

    @Getter
    @FindBy(css = ".footer__out")
    public WebElement avroraIconInFooter;

    @Getter
    @FindBy(css = ".footer__link")
    public WebElement recTechLinkInFooter;

}
