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
        CorePage.open(BaseUrl + "lk/basket");
        CorePage.ClickOnElement(CorePage.LoginButton);
        CorePage.waitForElementVisible(CorePage.AuthForm);

        Assertions.assertTrue(CorePage.waitForElementVisible(CorePage.AuthForm).isDisplayed());
        Assertions.assertTrue(CorePage.GetCodeButton.isDisplayed());
        Assertions.assertTrue(CorePage.PhoneInput.isDisplayed());
        Assertions.assertTrue(CorePage.PhoneRegion.isDisplayed());
        Assertions.assertTrue(CorePage.AuthForm.getText().contains("Войти или создать профиль"), "текст в popup отсутствует");
        Assertions.assertTrue(CorePage.linkTermsOfUse.getText().contains("с правилами пользования торговой площадкой"), "Ссылка на правила отсутствует");
        Assertions.assertTrue(CorePage.linkReturnPolice.getText().contains("Политика конфиденциальности"), "Ссылка на политику отсутствует");
    }

    @Test
    void checkTermsLinkOpensInNewTab(){
        CorePage.open(BaseUrl + "lk/basket");
        CorePage.ClickOnElement(CorePage.LoginButton);
        CorePage.waitForElementVisible(CorePage.AuthForm);
        CorePage.ClickOnElement(CorePage.linkTermsOfUse);
        CorePage.switchToNewTab();

        Assertions.assertEquals("https://legal.wildberries.ru/consumers-offer/country/ru/lang/ru/", driver.getCurrentUrl());
    }

    @Test
    void checkReturnPoliceLinkOpensInNewTab(){
        CorePage.open(BaseUrl + "lk/basket");
        CorePage.ClickOnElement(CorePage.LoginButton);
        CorePage.waitForElementVisible(CorePage.AuthForm);
        CorePage.ClickOnElement(CorePage.linkReturnPolice);
        CorePage.switchToNewTab();

        Assertions.assertEquals("https://legal.wildberries.ru/privacypolicy/country/ru/lang/ru/", driver.getCurrentUrl());
    }

}


