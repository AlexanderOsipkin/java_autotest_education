package ru.qa.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.qa.core.BaseTest;


public class CoreTest extends BaseTest {

    protected String BaseUrl = "https://сайт/";


    // Все тесты делались валидными только для РУ домена,
    // так как для обучения я думаю этого достаточно,
    // в последующем, при необходимости можно переделать под все домены
    @Test
    void testOpenLoginPopupOnMainPageForUnregUser() {
        corePage.open(BaseUrl + "lk/basket");
        corePage.click(corePage.loginButton);
        corePage.waitUntilVisible(corePage.authForm);

        Assertions.assertTrue(corePage.authForm.isDisplayed(), "Попап авторизации не видим");
        Assertions.assertTrue(corePage.getCodeButton.isDisplayed(), "Кнопка отправки кода не отображается");
        Assertions.assertTrue(corePage.getCodeButton.isEnabled(), "С кнопкой отправки кода запрещено взаимодействовать");
        Assertions.assertTrue(corePage.isElementClickable(corePage.getCodeButton), "Кнопка получения кода не кликабельна");
        Assertions.assertTrue(corePage.phoneInput.isDisplayed(), "Поле ввода номера телефона не отображается");
        Assertions.assertTrue(corePage.phoneInput.isEnabled(), "С полем ввода номера телефона запроещено взаимодействовать");
        Assertions.assertTrue(corePage.isElementClickable(corePage.phoneInput), "Поле ввода номера телефона не кликабельно");
        Assertions.assertTrue(corePage.phoneRegion.isDisplayed(), "Кнопка смены префикса телефона не отображается");
        Assertions.assertTrue(corePage.phoneRegion.isEnabled(), "С кнопкой смены префикса запрещено взаимодействовать");
        Assertions.assertTrue(corePage.isElementClickable(corePage.phoneRegion), "Кнопка ссмены региона номера телефона не кликабельна");
        Assertions.assertEquals("с правилами пользования торговой площадкой",corePage.linkTermsOfUse.getText(),"Текст в ссылке на правила отсутствует");
        Assertions.assertEquals("Политика конфиденциальности",corePage.linkReturnPolice.getText(),"Текст в ссылке на политику отсутствует");
    }

    @Test
    void testCheckTermsLinkOpensInNewTab() {
        corePage.open(BaseUrl + "lk/basket");
        corePage.click(corePage.loginButton);
        corePage.waitUntilVisible(corePage.authForm);
        corePage.click(corePage.linkTermsOfUse);
        corePage.switchToNewTab();

        Assertions.assertEquals("https://legal.wildberries.ru/consumers-offer/country/ru/lang/ru/", driver.getCurrentUrl());
    }

    @Test
    void testCheckReturnPoliceLinkOpensInNewTab() {
        corePage.open(BaseUrl + "lk/basket");
        corePage.click(corePage.loginButton);
        corePage.waitUntilVisible(corePage.authForm);
        corePage.click(corePage.linkReturnPolice);
        corePage.switchToNewTab();

        Assertions.assertEquals("https://legal.wildberries.ru/privacypolicy/country/ru/lang/ru/", driver.getCurrentUrl());
    }

    @Test
    void testOpenTheMap() {
        corePage.open(BaseUrl +"lk");
        corePage.click(corePage.geoPopupButton);
        corePage.waitUntilVisible(corePage.mapPopup);

        Assertions.assertEquals("Выберите способ доставки",corePage.deliveryChangeHeader.getText(),"текст заголовка типа доставок отсутствует");
        Assertions.assertEquals("Закрыть",corePage.closeMapButton.getText(),"текст в кнопке закрытия отсутствует");
        Assertions.assertTrue(corePage.closeMapButton.isDisplayed(), "Кнопка закрыть карту не отображается");
        Assertions.assertTrue(corePage.closeMapButton.isEnabled(), "С кнопкой закрытия карты запрещено взаимодействовать");
        Assertions.assertTrue(corePage.isElementClickable(corePage.closeMapButton), "Кнопка закрытия карты не кликабельбна");
        String placeholder = corePage.mapSearchInput.getAttribute("placeholder");
        Assertions.assertEquals("Поиск мест и адресов", placeholder, "Некорректный placeholder у поля поиска");
        Assertions.assertEquals("Пункт выдачи",corePage.PVZButton.getText(),"Некорректный текст пункта выдачи на карте");
        Assertions.assertTrue(corePage.PVZButton.isDisplayed(), "Кнопка смены доставки на ПВЗ не отображается");
        Assertions.assertTrue(corePage.PVZButton.isEnabled(), "С кнопкой ПВЗ запрещено взаимодействовать");
        Assertions.assertTrue(corePage.isElementClickable(corePage.PVZButton), "Кнопка смены доставки на ПВЗ не кликабельна");
        Assertions.assertEquals("Курьером",corePage.courierButton.getText(),"Некорректный текст курьерской доставки на карте");
        Assertions.assertTrue(corePage.courierButton.isDisplayed(), "Кнопка смены доставки на курьерскую не отображается");
        Assertions.assertTrue(corePage.courierButton.isEnabled(), "С кнопкой Курьером запрещено взаимодействовать");
        Assertions.assertTrue(corePage.isElementClickable(corePage.courierButton), "Кнопка смены доставки на курьерскую не кликабельна");
        Assertions.assertTrue(corePage.zoomInButton.isDisplayed(), "Кнопка увеличения карты не отображается");
        Assertions.assertTrue(corePage.zoomInButton.isEnabled(), "С кнопкой увеличения карты запрещено взаимодействовать");
        Assertions.assertTrue(corePage.isElementClickable(corePage.zoomInButton), "Кнопка увеличения карты не кликабельна");
        Assertions.assertTrue(corePage.zoomOutButton.isDisplayed(), "Кнопка уменьшения карты не отображается");
        Assertions.assertTrue(corePage.zoomOutButton.isEnabled(), "С кнопкой уменьшения карты запрещено взаимодействовать");
        Assertions.assertTrue(corePage.isElementClickable(corePage.zoomOutButton), "Кнопка уменьшения карты не кликабельна");
        Assertions.assertTrue(corePage.userLocationButton.isDisplayed(), "Кнопка геолокации пользователя не отображается");
        Assertions.assertTrue(corePage.userLocationButton.isEnabled(), "С кнопкой геолокации запрещено взаимодействовать");
        Assertions.assertTrue(corePage.isElementClickable(corePage.userLocationButton), "Кнопка геолокации не кликабельна");
    }

    @Test
    void testSiteHaveHeader() {
        corePage.open(BaseUrl + "lk");

        Assertions.assertTrue(corePage.siteHeader.isDisplayed(), "Шапка сайта не отображается");
        Assertions.assertTrue(corePage.mainLogo.isDisplayed(), "Лого сайта в шапке не оторбражается");
        Assertions.assertTrue(corePage.mainLogo.isEnabled(), "С лого сайта запрещено взаимодействовать");
        Assertions.assertTrue(corePage.isElementClickable(corePage.mainLogo), "Лого в шапке не кликабельно");
        Assertions.assertTrue(corePage.siteBurgerMenu.isDisplayed(), "Меню сайта не отобаражается");
        Assertions.assertTrue(corePage.siteBurgerMenu.isEnabled(), "С меню сайта запрещено взаимодействовать");
        Assertions.assertTrue(corePage.isElementClickable(corePage.siteBurgerMenu), "Меню шапке не кликабельно");
        Assertions.assertTrue(corePage.siteSearchInput.isDisplayed(), "Поле поиска не оторбражается");
        Assertions.assertTrue(corePage.siteSearchInput.isEnabled(), "С полем поиска запрещено взаимодействовать");
        String placeholder = corePage.siteSearchInput.getAttribute("placeholder");
        Assertions.assertEquals("Найти на Wildberries", placeholder, "Некорректный placeholder у поля поиска");
        Assertions.assertTrue(corePage.isElementClickable(corePage.siteSearchInput), "Поле поиска в шапке не кликабельно");
        Assertions.assertTrue(corePage.searchEmblem.isDisplayed(), "Поиск по картинке не отображается");
        Assertions.assertTrue(corePage.searchEmblem.isEnabled(), "С поиском по картинке запрещено взаимодействовать");
        Assertions.assertTrue(corePage.isElementClickable(corePage.searchEmblem), "Поиск по картинке не кликабельный");
        Assertions.assertTrue(corePage.siteAddressButton.isDisplayed(), "Кнопка адресов не отображается");
        Assertions.assertTrue(corePage.siteAddressButton.isEnabled(), "С кнопкой адресов запрещено взаимодейтсвовать");
        Assertions.assertEquals("Адреса", corePage.siteAddressButton.getText(), "Некорректный текст в кнопке адресов");
        Assertions.assertTrue(corePage.isElementClickable(corePage.siteAddressButton), "Адреса в шапке не кликабельны");
        Assertions.assertTrue(corePage.loginButton.isDisplayed(), "Кнопка входа в лк не отображается");
        Assertions.assertTrue(corePage.loginButton.isEnabled(), "С кнопкой авторизации запрещено взаимодействовать");
        Assertions.assertEquals("Войти", corePage.loginButton.getText(), "Некорректный текст в кнопке авторизации");
        Assertions.assertTrue(corePage.isElementClickable(corePage.loginButton), "Кнопка авторизации в шапке не кликабельна");
        Assertions.assertTrue(corePage.siteBasketButton.isDisplayed(), "Кнопка корзины не отображается");
        Assertions.assertTrue(corePage.siteBasketButton.isEnabled(), "С кнопкой корзины запрещено взаимодействовать");
        Assertions.assertEquals("Корзина", corePage.siteBasketButton.getText(), "Некорректный текст в кнопке корзины");
        Assertions.assertTrue(corePage.isElementClickable(corePage.siteBasketButton), "Кнопка корзины в шапке не кликабельна");
        Assertions.assertTrue(corePage.diamondsMenu.isDisplayed(), "Даймонды в шапке не отображаются");
        Assertions.assertTrue(corePage.diamondsMenu.isEnabled(), "С даймондами в шапке запрещено взаимодействовать");
        Assertions.assertTrue(corePage.cashbackButton.isDisplayed(), "Кнопка кешбека не отображается");
        Assertions.assertTrue(corePage.cashbackButton.isEnabled(), "С кнопкой кешбека запрещено взаимодействовать");
        Assertions.assertEquals("КЕШБЭК", corePage.cashbackButton.getText(), "Некорректный текст в кнопке кешбека");
        Assertions.assertTrue(corePage.isElementClickable(corePage.cashbackButton), "Кнопка кешбека в шапке не кликабельна");
        Assertions.assertTrue(corePage.selectedCurrencyButton.isDisplayed(), "Кнопка валюты не отображается");
        Assertions.assertTrue(corePage.selectedCurrencyButton.isEnabled(), "С кнопкой валюты запрещено взаимодействовать");
        Assertions.assertTrue(corePage.isElementClickable(corePage.selectedCurrencyButton), "Кнопка валюты в шапке не кликабельна");
    }

    @Test
    void testDiamondsInMenu() {

    }

}


