package ru.qa.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.qa.core.BaseTest;


public class CoreTest extends BaseTest {

    protected String BaseUrl = "https://сайт/";


    // Все UI Smoke тесты делались валидными только для РУ домена,
    // так как для обучения я думаю этого достаточно,
    // в последующем, при необходимости можно переделать под все домены
    @Test
    void testOpenLoginPopupOnMainPageForUnregisterUser() {
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

        Assertions.assertEquals("https://legal.wildberries.ru/consumers-offer/country/ru/lang/ru/", driver.getCurrentUrl(), "Открылась некорректная страница Оферты");
    }

    @Test
    void testCheckReturnPoliceLinkOpensInNewTab() {
        corePage.open(BaseUrl + "lk/basket");
        corePage.click(corePage.loginButton);
        corePage.waitUntilVisible(corePage.authForm);
        corePage.click(corePage.linkReturnPolice);
        corePage.switchToNewTab();

        Assertions.assertEquals("https://legal.wildberries.ru/privacypolicy/country/ru/lang/ru/", driver.getCurrentUrl(),"Открылась некорректная страница Правил");
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

    //Позже подумаю над тем, что бы вынести все повторяющиеся элементы в отдельный хелпер,
    // что бы читать стало удобней, пока оставлю так
    @Test
    void testDesktopDiamondsInMenuForUnregisterUser() {
        corePage.open(BaseUrl + "lk/basket");
        corePage.waitUntilVisible(corePage.diamondsMenu);

        // Проверка кнопки Wibes до клика
        Assertions.assertTrue(corePage.wibesButton.isDisplayed(), "Кнопка Wibes не отображается");
        Assertions.assertTrue(corePage.wibesButton.isEnabled(), "С кнопкой Wibes запрещено взаимодействовать");
        Assertions.assertTrue(corePage.isElementClickable(corePage.wibesButton), "Кнопка Wibes не кликабельна");

        // Сохраняем текущию вкладку
        String mainWindow = driver.getWindowHandle();

        // Кликаем на Wibes и переходим на открытую вкладку
        corePage.click(corePage.wibesButton);
        corePage.switchToNewTab();
        Assertions.assertEquals("https://wibes.ru/clips?utm_source=main_topbar&utm_medium=inner_wb", driver.getCurrentUrl(),"Открылась некорректная страница Wibes");

        // Закрываем новую вкладку и возвращаемся обратно
        driver.close();
        driver.switchTo().window(mainWindow);

        // Проверяем что вернулись успешно
        Assertions.assertEquals(BaseUrl + "lk/basket", driver.getCurrentUrl(), "Не удалось вернуться на основную страницу");

        // Все тоже самое, но для остальных кнопок в даймондах
        // Отели
        Assertions.assertTrue(corePage.hotelsButton.isDisplayed(), "Кнопка Отели не отображается");
        Assertions.assertTrue(corePage.hotelsButton.isEnabled(), "С кнопкой Отели запрещено взаимодействовать");
        Assertions.assertTrue(corePage.isElementClickable(corePage.hotelsButton), "Кнопка Отели не кликабельна");

        corePage.click(corePage.hotelsButton);
        corePage.switchToNewTab();
        Assertions.assertEquals("https://stage.wildberries.ru/travel/hotel?entry_point=tab_header", driver.getCurrentUrl(),"Открылась некорректная страница Отелей");

        driver.close();
        driver.switchTo().window(mainWindow);
        Assertions.assertEquals(BaseUrl + "lk/basket", driver.getCurrentUrl(), "Не удалось вернуться на основную страницу");

        // Авиабилеты
        Assertions.assertTrue(corePage.aviaButton.isDisplayed(), "Кнопка Авиабилеты не отображается");
        Assertions.assertTrue(corePage.aviaButton.isEnabled(), "С кнопкой Авиабилеты запрещено взаимодействовать");
        Assertions.assertTrue(corePage.isElementClickable(corePage.aviaButton), "Кнопка Авиабилеты не кликабельна");

        corePage.click(corePage.aviaButton);
        corePage.switchToNewTab();
        Assertions.assertEquals("https://stage.wildberries.ru/travel/avia?entry_point=tab_header", driver.getCurrentUrl(),"Открылась некорректная страница покупки Авиабилетов");

        driver.close();
        driver.switchTo().window(mainWindow);
        Assertions.assertEquals(BaseUrl + "lk/basket", driver.getCurrentUrl(), "Не удалось вернуться на основную страницу");

        // Фан и Сан
        Assertions.assertTrue(corePage.funSunButton.isDisplayed(), "Кнопка FunSun не отображается");
        Assertions.assertTrue(corePage.funSunButton.isEnabled(), "С кнопкой FunSun запрещено взаимодействовать");
        Assertions.assertTrue(corePage.isElementClickable(corePage.funSunButton), "Кнопка FunSun не кликабельна");

        corePage.click(corePage.funSunButton);
        corePage.switchToNewTab();
        Assertions.assertEquals("https://stage.wildberries.ru/travel/tours?entry_point=tab_header", driver.getCurrentUrl(),"Открылась некорректная страница покупки FunSun");

        driver.close();
        driver.switchTo().window(mainWindow);
        Assertions.assertEquals(BaseUrl + "lk/basket", driver.getCurrentUrl(), "Не удалось вернуться на основную страницу");

        //Ресейл
        Assertions.assertTrue(corePage.resaleButton.isDisplayed(), "Кнопка Ресейла не отображается");
        Assertions.assertTrue(corePage.resaleButton.isEnabled(), "С кнопкой Ресейла запрещено взаимодействовать");
        Assertions.assertTrue(corePage.isElementClickable(corePage.resaleButton), "Кнопка Ресейла не кликабельна");

        corePage.click(corePage.resaleButton);
        wait.until(ExpectedConditions.urlContains("/catalog/resale"));
        Assertions.assertEquals(BaseUrl + "catalog/resale", driver.getCurrentUrl(), "Открылась некорректная страница Ресейл");

        driver.navigate().back();
        wait.until(ExpectedConditions.urlContains(BaseUrl + "lk/basket"));
        Assertions.assertTrue(driver.getCurrentUrl().startsWith(BaseUrl + "lk/basket"), "Не удалось вернуться на основную страницу");

        // ВБ Клуб
        Assertions.assertTrue(corePage.wbClubButton.isDisplayed(), "Кнопка WbClub не отображается");
        Assertions.assertTrue(corePage.wbClubButton.isEnabled(), "С кнопкой WbClub запрещено взаимодействовать");
        Assertions.assertTrue(corePage.isElementClickable(corePage.wbClubButton), "Кнопка WbClub не кликабельна");

        corePage.click(corePage.wbClubButton);
        wait.until(ExpectedConditions.urlContains("/subscription"));
        Assertions.assertEquals(BaseUrl + "subscription", driver.getCurrentUrl(), "Открылась некорректная страница WbClub");

        driver.navigate().back();
        wait.until(ExpectedConditions.urlContains(BaseUrl + "lk/basket"));
        Assertions.assertTrue(driver.getCurrentUrl().startsWith(BaseUrl + "lk/basket"), "Не удалось вернуться на основную страницу");

        // Дропдаун для бизнеса
        // Проверки до клика
        Assertions.assertTrue(corePage.businessDropdown.isDisplayed(), "Дропдаун для бизнеса не отображается");
        Assertions.assertTrue(corePage.businessDropdown.isEnabled(), "С Дропдаун для бизнеса запрещено взаимодействовать");
        Assertions.assertTrue(corePage.isElementClickable(corePage.businessDropdown), "Дропдаун для бизнеса не кликабельный");
        Assertions.assertTrue(corePage.businessDropdownMenu.getAttribute("class").contains("hide"), "Дропдаун для бизнеса уже открыт до клика");

        corePage.click(corePage.businessDropdown);
        corePage.waitUntilVisible(corePage.businessDropdownMenu);

        // Проверки после клика
        Assertions.assertFalse(corePage.businessDropdownMenu.getAttribute("class").contains("hide"), "Дропдаун для бизнеса не раскрылся после клика");
        Assertions.assertTrue(corePage.buyAsBusinessButton.isDisplayed(), "Кнопка WbClub не отображается");
        Assertions.assertTrue(corePage.buyAsBusinessButton.isEnabled(), "С кнопкой WbClub запрещено взаимодействовать");
        Assertions.assertTrue(corePage.isElementClickable(corePage.buyAsBusinessButton), "Кнопка WbClub не кликабельна");
        Assertions.assertTrue(corePage.sellerButton.isDisplayed(), "Кнопка стать продавцом не отображается");
        Assertions.assertTrue(corePage.sellerButton.isEnabled(), "С кнопкой стать продавцом запрещено взаимодействовать");
        Assertions.assertTrue(corePage.isElementClickable(corePage.sellerButton), "Кнопка стать продавцом не кликабельна");
        Assertions.assertTrue(corePage.openPickUpPointButton.isDisplayed(), "Кнопка открыть пункт выдачи не отображается");
        Assertions.assertTrue(corePage.openPickUpPointButton.isEnabled(), "С кнопкой открыть пункт выдачи запрещено взаимодействовать");
        Assertions.assertTrue(corePage.isElementClickable(corePage.openPickUpPointButton), "Кнопка открыть пункт выдачи не кликабельна");
        Assertions.assertTrue(corePage.businessPurchaseButton.isDisplayed(), "Кнопка товары для бизнеса не отображается");
        Assertions.assertTrue(corePage.businessPurchaseButton.isEnabled(), "С кнопкой товары для бизнеса запрещено взаимодействовать");
        Assertions.assertTrue(corePage.isElementClickable(corePage.businessPurchaseButton), "Кнопка товары для бизнеса не кликабельна");
        Assertions.assertTrue(corePage.chinaWholesaleButton.isDisplayed(), "Кнопка оптом из Китая не отображается");
        Assertions.assertTrue(corePage.chinaWholesaleButton.isEnabled(), "С кнопкой оптом из Китая запрещено взаимодействовать");
        Assertions.assertTrue(corePage.isElementClickable(corePage.chinaWholesaleButton), "Кнопка оптом из Китая не кликабельна");

        // Еаптека
        Assertions.assertTrue(corePage.eaptekaButton.isDisplayed(), "Кнопка Еаптека не отображается");
        Assertions.assertTrue(corePage.eaptekaButton.isEnabled(), "С кнопкой Еаптека запрещено взаимодействовать");
        Assertions.assertTrue(corePage.isElementClickable(corePage.eaptekaButton), "Кнопка Еаптека не кликабельна");

        corePage.click(corePage.eaptekaButton);
        wait.until(ExpectedConditions.urlContains("/eapteka"));
        Assertions.assertEquals(BaseUrl + "eapteka", driver.getCurrentUrl(), "Открылась некорректная страница Еаптека");

        driver.navigate().back();
        wait.until(ExpectedConditions.urlContains(BaseUrl + "lk/basket"));
        Assertions.assertTrue(driver.getCurrentUrl().startsWith(BaseUrl + "lk/basket"), "Не удалось вернуться на основную страницу");

        // Работа в WB
        corePage.waitUntilVisible(corePage.diamondsMenu);
        Assertions.assertTrue(corePage.workButton.isDisplayed(), "Кнопка Работа в WB не отображается");
        Assertions.assertTrue(corePage.workButton.isEnabled(), "С кнопкой Работа в WB запрещено взаимодействовать");
        Assertions.assertTrue(corePage.isElementClickable(corePage.workButton), "Кнопка Работа в WB не кликабельна");

        corePage.click(corePage.workButton);
        corePage.switchToNewTab();
        Assertions.assertEquals("https://career.rwb.ru/", driver.getCurrentUrl(),"Открылась некорректная страница карьерного портала");

        driver.close();
        driver.switchTo().window(mainWindow);
        Assertions.assertTrue(driver.getCurrentUrl().startsWith(BaseUrl + "lk/basket"), "Не удалось вернуться на основную страницу");

        // Кнопка "еще"
        // Проверки до клика
        Assertions.assertTrue(corePage.moreDropdown.isDisplayed(), "Дропдаун еще не отображается");
        Assertions.assertTrue(corePage.moreDropdown.isEnabled(), "С Дропдаун еще запрещено взаимодействовать");
        Assertions.assertTrue(corePage.isElementClickable(corePage.moreDropdown), "Дропдаун еще не кликабельный");
        Assertions.assertTrue(corePage.moreDropdownMenu.getAttribute("class").contains("hide"), "Дропдаун еще уже открыт до клика");

        corePage.click(corePage.moreDropdown);
        corePage.waitUntilVisible(corePage.moreDropdownMenu);

        // Проверки после клика
        Assertions.assertFalse(corePage.moreDropdownMenu.getAttribute("class").contains("hide"), "Дропдаун еще не раскрылся после клика");
        Assertions.assertTrue(corePage.realtyButton.isDisplayed(), "Кнопка новостройки не отображается");
        Assertions.assertTrue(corePage.realtyButton.isEnabled(), "С кнопкой новостройки запрещено взаимодействовать");
        Assertions.assertTrue(corePage.isElementClickable(corePage.realtyButton), "Кнопка новостройки не кликабельна");
        Assertions.assertTrue(corePage.brandsButton.isDisplayed(), "Кнопка бренды не отображается");
        Assertions.assertTrue(corePage.brandsButton.isEnabled(), "С кнопкой бренды запрещено взаимодействовать");
        Assertions.assertTrue(corePage.isElementClickable(corePage.brandsButton), "Кнопка бренды не кликабельна");
    }

    @Test
    void testFooterOnBasketPage() {
        corePage.open(BaseUrl + "lk/basket");

    }
}


