package main;

import lombok.SneakyThrows;
import main.components.Products;
import org.openqa.selenium.By;
import main.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainPage extends BasePage {
    private final By menuBrandsWebElementLocator = By.xpath(
            "//a[text()='Brands']");
    private final By accountDropdownLocator = By.xpath(
            "//span[text()='My Account']");
    private final By registerDropdownLocator = By.xpath(
            "//a[text()='Register']");
    private final By desktopsTopMenuLocator = By.xpath(
            "//ul[@class='nav navbar-nav']//a[text()='Desktops']");
    private final By ShowAllDesktopsDropdownLocator = By.xpath(
            "//ul[@class='nav navbar-nav']//a[text()='Show All Desktops']");
    private final By camerasTopMenuLocator = By.xpath(
            "//ul[@class='nav navbar-nav']//a[text()='Cameras']");
    private final By sortValueOnPageLocator = By.id("input-sort");
    private final By numberProductsOnPageLocator = By.xpath("//div[@class='product-thumb']");
    private final By productContainerLocator = By.xpath(
            "//div[@class='product-thumb']");
    private final By currentCurrencyLocator = By.xpath(
            "//strong");
    private final By dollarCurrencyLocator = By.xpath(
            "//a[@href='USD']");
    private final By euroCurrencyLocator = By.xpath(
            "//a[@href='EUR']");
    private final By poundSterlingCurrencyLocator = By.xpath(
            "//a[@href='GBP']");
    private final By iphoneLocator = By.xpath(
            "//div[@class='description']//a[text()='iPhone']");

    @SneakyThrows
    public BrandsPage clickBrandsElement() {
        scroll(500);
        waitUntilClickable(menuBrandsWebElementLocator, 20);
        find(menuBrandsWebElementLocator).click();
        return new BrandsPage();
    }

    public MainPage clickAccountDropdownLocator() {
        find(accountDropdownLocator).click();
        return this;
    }

    public RegisterPage clickRegisterDropdownLocator() {
        find(registerDropdownLocator).click();
        return new RegisterPage();
    }

    public MainPage moveToDesktopsTopMenu() {
        find(desktopsTopMenuLocator).click();
        //   Actions actions = new Actions(driver);
        //  actions.moveToElement((WebElement) desktopsTopMenuLocator);
        return this;
    }

    public DesktopsPage clickShowAllDesktopsDropdown() {
        find(ShowAllDesktopsDropdownLocator).click();
        return new DesktopsPage();
    }

    @SneakyThrows
    public List<Products> getAllProductsFromMainPage() {
        List<Products> product = new ArrayList<>();
        List<WebElement> containers = findAll(productContainerLocator);
        for (WebElement container : containers) {
            Products productComponent = new Products(container);
            product.add(productComponent);
        }
        return product;
    }

    public void selectSortValueDropdown(String value) {
        selectByText(sortValueOnPageLocator, value);
    }

    public String getValueFromSortDropDown() {
        return getSelectedValue(sortValueOnPageLocator);
    }

    public void selectNumberProductsOnPageDropdown(String value) {
        selectByText(numberProductsOnPageLocator, value);
    }

    public String getNumberProductsOnPageDropdown() {
        return getSelectedValue(numberProductsOnPageLocator);
    }

    public String currentCurrency() {
        return find(currentCurrencyLocator).getText();
    }

    public MainPage selectDollarAsCurrentCurrency() {
        if (Objects.equals(currentCurrency(), "$ US Dollar")) {
        } else {
            find(currentCurrencyLocator).click();
            find(dollarCurrencyLocator).click();
        }
        return this;
    }

    public MainPage selectEuroAsCurrentCurrency() {
        find(currentCurrencyLocator).click();
        find(euroCurrencyLocator).click();
        return this;
    }

    public MainPage selectPoundSterlingAsCurrentCurrency() {
        find(currentCurrencyLocator).click();
        find(poundSterlingCurrencyLocator).click();
        return this;
    }

    public iPhonePage ClickIphone() {
        scroll(400);
        find(iphoneLocator).click();
        return new iPhonePage();
    }
    public CamerasPage openCamerasTopMenu(){
        find(camerasTopMenuLocator).click();
        return new CamerasPage();
    }

}