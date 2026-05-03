package ru.qa.tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTest {
    @Test
    void openGoogleTest() {
        WebDriver driver = new ChromeDriver(); // запуск Chrome
        driver.get("https://www.google.com/"); // открытие страницы
        driver.quit(); // закрытие браузера
    }
}
