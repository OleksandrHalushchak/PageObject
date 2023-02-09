package main;

import org.openqa.selenium.By;

import main.BasePage;

public class MainPage extends BasePage {
    private final By menuBrandsWebElementLocator = By.xpath(
            "//ul[@class='list-unstyled']//a[text()='Brands']");
    public MainPage openMainPage() {
        getDriver().get("https://demo.opencart.com/");
        return this;
    }

    public BrandsPage ClickBrandsElement() {
       find(menuBrandsWebElementLocator).click();
        return new BrandsPage();
    }




}