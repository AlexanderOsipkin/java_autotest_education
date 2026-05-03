package ru.qa.tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FirstTest {
    @Test
    void openGoogleTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver(); // запуск Chrome
        driver.get("https://www.google.com/"); // открытие страницы
        assertTrue(driver.getTitle().contains("Google")); // проверка нахождения на странице гугла
        WebElement searchForm = driver.findElement(By.cssSelector(".gLFyf[title=\"Поиск\"]")); // ищем форму ввода
        //  xpath вариант:
        //  WebElement searchForm = driver.findElement(By.xpath("//*[@title=\"Поиск\"]"));
        searchForm.sendKeys("Прогноз погоды"); // вводим значение
        searchForm.sendKeys(Keys.ENTER); // нажимаем enter
        Thread.sleep(3000); // физическое ожидание теста 3 сек
        driver.quit(); // закрытие браузера
    }
}
