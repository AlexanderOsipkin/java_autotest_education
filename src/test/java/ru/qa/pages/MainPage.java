package ru.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.qa.core.BaseTest;

import java.time.Duration;

public class MainPage extends BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    //открываем страницу
    public void open(String url) {
        driver.get(url);
    }

    //Ищем элемент по CSS
    public WebElement getElementByCss(String cssSelector) {
        return driver.findElement(By.cssSelector(cssSelector));
    }

    //Ищем элемент по XPath
    public WebElement getElementByXPath(String xPath) {
        return driver.findElement(By.xpath(xPath));
    }

    //кликаем на элемент после ожидания
    public void ClickOnElement(WebElement locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    // хелпер для проверки того, что верная ссылка открылась в соседней вкладке
    public void switchToNewTab() {
        String currentWindow = driver.getWindowHandle();
        for (String window : driver.getWindowHandles()) {
            if (!window.equals(currentWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }
    }

    // хелпер что бы дождаться элемента
    public WebElement waitForElementVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

}
