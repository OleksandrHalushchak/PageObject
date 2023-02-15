package main;

import org.openqa.selenium.By;

public class RegisterPage extends BasePage {

    private final By firstNameFieldLocator = By.id("input-firstname");
    private final By lastNameFieldLocator = By.id("input-lastname");
    private final By emailFieldLocator = By.id("input-email");
    private final By passwordFieldLocator = By.id("input-password");
    private final By subscribeYesRadioButtonLocator = By.id("input-newsletter-yes");
    private final By checkboxLocator = By.xpath("//input[@type='checkbox']");
    private final By continueButtonLocator = By.xpath(
            "//button[text()='Continue']");
    private final By pageTitleLocator = By.xpath(
            "//div[@id='content']//p");

    public RegisterPage enterFirstName(String FirstName) {
        waitUntilVisible(firstNameFieldLocator, 20);
        find(firstNameFieldLocator).sendKeys(FirstName);
        return this;
    }

    public RegisterPage enterLastName(String LastName) {
        find(lastNameFieldLocator).sendKeys(LastName);
        return this;
    }

    public RegisterPage enterEmail(String Email) {
        find(emailFieldLocator).sendKeys(Email);
        return this;
    }

    public RegisterPage enterPassword(String Password) {
        find(passwordFieldLocator).sendKeys(Password);
        scroll(300);
        return this;
    }
    public RegisterPage subscribeYesRadioButton() {
        find(subscribeYesRadioButtonLocator).click();
        scroll(300);
        return this;
    }
    public RegisterPage clickCheckbox() {
        find(checkboxLocator).click();
        return this;
    }
    public RegisterPage clickContinueButton() {
        find(continueButtonLocator).click();
        return this;
    }
    public String getPageTitle() {
        return find(pageTitleLocator).getText();

    }
}
