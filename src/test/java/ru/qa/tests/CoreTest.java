package ru.qa.tests;

import  org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import ru.qa.core.BaseTest;


public class CoreTest extends BaseTest {

    protected String BaseUrl = "https://сайт/";

    @Test
    void testOpenLoginPopupOnMainPageForUnregUser() {
        CorePage.open(BaseUrl);
        CorePage.ClickOnElement(CorePage.LoginPopup);



    }
}
