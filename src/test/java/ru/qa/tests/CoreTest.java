package ru.qa.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import ru.qa.core.BaseTest;


public class CoreTest extends BaseTest {

    protected String BaseUrl = "https://сайт/";


    // Все тесты делались валидными только для РУ домена,
    // так как для обучения я думаю этого достаточно,
    // в последующем, при необходимости можно переделать под все домены
    @Test
    void testOpenLoginPopupOnMainPageForUnregUser() {
        corePage.open(BaseUrl + "lk/basket");
        corePage.ClickOnElement(corePage.loginButton);
        corePage.waitForElementVisible(corePage.authForm);

        Assertions.assertTrue(corePage.waitForElementVisible(corePage.authForm).isDisplayed());
        Assertions.assertTrue(corePage.getCodeButton.isDisplayed(), "Кнопка отправки кода не отображается");
        Assertions.assertTrue(corePage.getCodeButton.isEnabled(), "Кнопка отправки кода недоступна");
        Assertions.assertTrue(corePage.phoneInput.isDisplayed(), "Поле ввода номера телефона не отображается");
        Assertions.assertTrue(corePage.phoneInput.isEnabled(), "Поле ввода номера телефона недоступно");
        Assertions.assertTrue(corePage.phoneRegion.isDisplayed(), "Кнопка смены префикса телефона не отображается");
        Assertions.assertTrue(corePage.phoneRegion.isEnabled(), "Кнопка смены префикса телефона недоступно");
        Assertions.assertEquals("с правилами пользования торговой площадкой",corePage.linkTermsOfUse.getText(),"Текст в ссылке на правила отсутствует");
        Assertions.assertEquals("Политика конфиденциальности",corePage.linkReturnPolice.getText(),"Текст в ссылке на политику отсутствует");
    }

    @Test
    void testCheckTermsLinkOpensInNewTab() {
        corePage.open(BaseUrl + "lk/basket");
        corePage.ClickOnElement(corePage.loginButton);
        corePage.waitForElementVisible(corePage.authForm);
        corePage.ClickOnElement(corePage.linkTermsOfUse);
        corePage.switchToNewTab();

        Assertions.assertEquals("https://legal.wildberries.ru/consumers-offer/country/ru/lang/ru/", driver.getCurrentUrl());
    }

    @Test
    void testCheckReturnPoliceLinkOpensInNewTab() {
        corePage.open(BaseUrl + "lk/basket");
        corePage.ClickOnElement(corePage.loginButton);
        corePage.waitForElementVisible(corePage.authForm);
        corePage.ClickOnElement(corePage.linkReturnPolice);
        corePage.switchToNewTab();

        Assertions.assertEquals("https://legal.wildberries.ru/privacypolicy/country/ru/lang/ru/", driver.getCurrentUrl());
    }

    @Test
    void testOpenTheMap() {
        corePage.open(BaseUrl);
        corePage.ClickOnElement(corePage.geoPopupButton);
        corePage.waitForElementVisible(corePage.mapPopup);

        Assertions.assertEquals("Выберите способ доставки",corePage.deliveryChangeHeader.getText(),"текст заголовка типа доставок отсутствует");
        Assertions.assertEquals("Закрыть",corePage.closeMapButton.getText(),"текст в кнопке закрытия отсутствует");
        Assertions.assertTrue(corePage.closeMapButton.isDisplayed(), "Кнопка закрыть карту не отображается");
        Assertions.assertTrue(corePage.closeMapButton.isEnabled(), "Кнопка закрыть карту недоступна");
        String placeholder = corePage.mapSearchInput.getAttribute("placeholder");
        Assertions.assertEquals("Поиск мест и адресов", placeholder, "Некорректный placeholder у поля поиска");
        Assertions.assertEquals("Пункт выдачи",corePage.PVZButton.getText(),"Некорректный текст пункта выдачи на карте");
        Assertions.assertTrue(corePage.PVZButton.isDisplayed(), "Кнопка смены доставки на ПВЗ не отображается");
        Assertions.assertTrue(corePage.PVZButton.isEnabled(), "Кнопка смены доставки на ПВЗ недоступна");
        Assertions.assertEquals("Курьером",corePage.courierButton.getText(),"Некорректный текст курьерской доставки на карте");
        Assertions.assertTrue(corePage.courierButton.isDisplayed(), "Кнопка смены доставки на курьерскую не отображается");
        Assertions.assertTrue(corePage.courierButton.isEnabled(), "Кнопка смены доставки на курьерскую недоступна");
        Assertions.assertTrue(corePage.zoomInButton.isDisplayed(), "Кнопка увеличения карты не отображается");
        Assertions.assertTrue(corePage.zoomInButton.isEnabled(), "Кнопка увеличения карты недоступна");
        Assertions.assertTrue(corePage.zoomOutButton.isDisplayed(), "Кнопка уменьшения карты не отображается");
        Assertions.assertTrue(corePage.zoomOutButton.isEnabled(), "Кнопка уменьшения карты недоступна");
        Assertions.assertTrue(corePage.userLocationButton.isDisplayed(), "Кнопка геолокации пользователя не отображается");
        Assertions.assertTrue(corePage.userLocationButton.isEnabled(), "Кнопка геолокации пользователя карты недоступна");
    }

}


