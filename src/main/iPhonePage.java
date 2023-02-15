package main;

import org.openqa.selenium.By;

public class iPhonePage extends BasePage {
private final By iPhonePriceLocator = By.xpath("//ul[@class='list-unstyled']//span[@class='price-new']");
    private final By euroCurrencyLocator = By.xpath(
            "//a[@href='EUR']");
    private final By poundSterlingCurrencyLocator = By.xpath(
            "//a[@href='GBP']");
    private final By currentCurrencyLocator = By.xpath(
            "//strong");

    public iPhonePage selectEuroAsCurrentCurrency() {
        find(currentCurrencyLocator).click();
        find(euroCurrencyLocator).click();
        return this;
    }

    public iPhonePage selectPoundSterlingAsCurrentCurrency() {
        find(currentCurrencyLocator).click();
        find(poundSterlingCurrencyLocator).click();
        return this;
    }
public String getIPhonePrice() {
        return find(iPhonePriceLocator).getText();
    }



}
