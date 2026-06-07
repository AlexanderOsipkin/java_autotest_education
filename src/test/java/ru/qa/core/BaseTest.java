package ru.qa.core;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.qa.pages.CorePage;
import ru.qa.pages.BasePage;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;

    protected BasePage basePage;
    protected CorePage corePage;


    // Переделал на Each потому что таким образом каждый тест получает чистый браузер
    // тесты независимы, меньше нестабильного поведения при параллельных запусках
    @BeforeEach
    public void initContext() {
        try {
            // Настройка опций для подключения к существующему браузеру
            ChromeOptions options = new ChromeOptions();

            // открывает браузер на весь экран
            options.addArguments("--window-size=1440,900");

            // отключает уведомления в хром
            options.addArguments("--disable-notifications");

            // Инициализация драйвера
            driver = new ChromeDriver(options);

            //Ожидаем элементы сайта 10 секунд
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            //Добавим классы с описанием страниц для инициализации
            basePage = new BasePage(driver);
            corePage = new CorePage(driver);

        } catch (Exception e) {
            System.err.println("Ошибка при создании контекста или инициализации драйвера: " + e.getMessage());
            throw new RuntimeException("Не удалось инициализировать драйвер", e);
        }
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}