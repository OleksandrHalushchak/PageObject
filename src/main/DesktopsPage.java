package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class DesktopsPage extends BasePage {

    private final By numberValueProductsOnPageLocator = By.id("input-limit");
    private final By sortValueOnPageLocator = By.id("input-sort");
    private final By numberProductsOnPageLocator = By.xpath("//div[@class='product-thumb']");
    private final By selectNumberValueProductsOnPageLocator = By.xpath("//select[@id='input-limit']//option[text()='25']");

    private final By bottomPageTextLocator = By.xpath("//div[@class='col-sm-6 text-end']");


    public String getnumberValueProductsOnPage() {
        return find(numberValueProductsOnPageLocator).getAttribute("value");

    }

    public String getSortValueOnPage() {
        return find(sortValueOnPageLocator).getAttribute("value");
    }

    public int getnumberProductsOnPage() {
        List<String> ProductsOnPage = new ArrayList<>();
        int Count = 0;
        List<WebElement> productsOnPage = driver.findElements(numberProductsOnPageLocator);
        for (WebElement webElement : productsOnPage) {
            Count++;
        }
        return Count;
    }

    public DesktopsPage selectNumberValueProductsOnPage() {
         find(selectNumberValueProductsOnPageLocator).click();
        // Select numberOfProduct = new Select((WebElement) numberValueProductsOnPageLocator);
        //  numberOfProduct.selectByVisibleText("25");
        return this;
    }

    public String getBottomPageText() {
        return find(bottomPageTextLocator).getText();
    }
}