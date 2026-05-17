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


    // Переделал на Each потому что - каждый тест получает чистый браузер
    // тесты независимы, меньше нестабильног оповедения при параллельных запусках
    @BeforeEach
    public void initContext() {
        try {
            //System.setProperty("webdriver.chrome.driver", "/Users/user/Downloads/chromedriver-win64/chromedriver.exe");
            // Настройка опций для подключения к существующему браузеру
            ChromeOptions options = new ChromeOptions();

            // открывает браузер на весь экран
            options.addArguments("--start-maximized");

            // отключает уведомления в хром
            options.addArguments("--disable-notifications");

            //options.setExperimentalOption("debuggerAddress", "localhost:9222");//http://localhost:9222/json/version
            // Инициализация драйвера
            driver = new ChromeDriver(options);

            //Ожидаем элементы сайта 10 секунд
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            //Добавим классы описанием страниц для инициализации
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