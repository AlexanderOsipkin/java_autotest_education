package ru.qa.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import ru.qa.core.BaseTest;


public class CoreTest extends BaseTest {

    protected String BaseUrl = "https://сайт/";

    @Test
    void testOpenLoginPopupOnMainPageForUnregUser() {
        CorePage.open(BaseUrl + "lk");
        CorePage.ClickOnElement(CorePage.LoginPopup);
        Assertions.assertTrue(CorePage.AuthForm.getText().contains("Войти или создать профиль"), "текст в popup отсутствует");
        Assertions.assertTrue(CorePage.linkTermsOfUse.getText().contains("с правилами пользования торговой площадкой"), "Ссылка на правила отсутствует");
        Assertions.assertTrue(CorePage.linkReturnPolice.getText().contains("Политика конфиденциальности"), "Ссылка на политику отсутствует");

    }

    @Test
    void checkTermsLinkOpensInNewTab (){
        CorePage.open(BaseUrl + "lk");
        CorePage.ClickOnElement(CorePage.LoginPopup);
        CorePage.ClickOnElement(CorePage.linkTermsOfUse);
        CorePage.switchToNewTab();
        Assertions.assertEquals("https://legal.wildberries.ru/consumers-offer/country/ru/lang/ru/", driver.getCurrentUrl());
    }
}


