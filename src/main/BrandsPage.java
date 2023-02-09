package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;



public class BrandsPage extends BasePage{
    private final By brandListLocator = By.xpath(
            "//id('content')//div[@class ='col-sm-3' ]");
    public BrandsPage getBrandList() {
        WebElement brand = driver.findElement(brandListLocator);
        String brandName = brand.getText();
        return this;
    }
}
