package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;


public class BrandsPage extends BasePage {
    private final By brandListLocator = By.xpath(
            "//div [@class ='row']//div[@class ='row mb-3' ]//div[@class ='col-sm-3']");




    public List<String> getBrandList() {

        List<String> brandNames = new ArrayList<>();

        List<WebElement> brand = driver.findElements(brandListLocator);
        for (WebElement webElement : brand) {
            brandNames.add(webElement.getText());
        }
            return brandNames;

    }
}
