package Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import main.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class BaseTest {

        @BeforeMethod(alwaysRun = true)
        public void setUp() {
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.get("https://demo.opencart.com/");
            driver.manage().window().maximize();
            BasePage.setDriver(driver);
        }

        @AfterMethod(alwaysRun = true)
        public void quite() {
            BasePage.getDriver().quit();
        }

}
