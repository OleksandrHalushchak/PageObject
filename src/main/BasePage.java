package main;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public abstract class BasePage {

        public static WebDriver driver;

        //set driver for base page
        public static void setDriver(WebDriver webDriver) {
            driver = webDriver;
        }

        //method for get driver from any page
        public static WebDriver getDriver() {
            return driver;
        }

        public WebElement find(By locator) {
            return getDriver().findElement(locator);
        }

        public List<WebElement> findAll(By locator) {
            return getDriver().findElements(locator);
        }

        public WebElement waitUntilVisible(By locator, int seconds) {
            return new WebDriverWait(getDriver(), Duration.ofSeconds(seconds))
                    .until(ExpectedConditions.presenceOfElementLocated(locator));
        }

    public WebElement waitUntilClickable(By locator, int seconds) {
        return new WebDriverWait (getDriver(), Duration.ofSeconds(seconds))
                .until(ExpectedConditions.elementToBeClickable(locator));
    }


        public static void scroll(int pixels) {
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        }
    public void selectByText(By selectLocator, String text) {
        Select select = new Select(getDriver().findElement(selectLocator));
        select.selectByVisibleText(text);
    }

    public String getSelectedValue(By selectLocator) {
        Select select = new Select(getDriver().findElement(selectLocator));
        return select.getFirstSelectedOption().getText();
    }

}


