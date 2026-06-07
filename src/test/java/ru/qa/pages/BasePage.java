package ru.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    //открываем страницу
    public void open(String url) {
        driver.get(url);
    }

    //кликаем на элемент после ожидания
    public void click(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    // хелпер для проверки того, что верная ссылка открылась в соседней вкладке
    public void switchToNewTab() {
        String currentWindow = driver.getWindowHandle();
        wait.until(driver -> driver.getWindowHandles().size() > 1);
        for (String window : driver.getWindowHandles()) {
            if (!window.equals(currentWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }
    }

    // хелпер что бы дождаться элемента
    public void waitUntilVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    //Хелпер для проверки, что элемент кликабельный, но без клика на него
    public boolean isElementClickable(WebElement element) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            return element.isDisplayed();
        }
        catch (Exception e) {
            return false;
        }
    }
}
