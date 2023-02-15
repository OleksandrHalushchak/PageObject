package Test;

import lombok.SneakyThrows;
import main.MainPage;
import main.components.Products;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static main.BasePage.driver;

public class Test_3_Products extends BaseTest {

    private final MainPage mainPage = new MainPage();


    @Test
// Check that products were sorted correctly  'Name (A - Z)'
    public void checkProductsSortedCorrectlyAZ() {

        List<String> expectedProductsNamesToCheck = new ArrayList<>();
        expectedProductsNamesToCheck.add("Apple Cinema 30\"");
        expectedProductsNamesToCheck.add("Canon EOS 5D");
        expectedProductsNamesToCheck.add("HP LP3065");
        expectedProductsNamesToCheck.add("HTC Touch HD");
        expectedProductsNamesToCheck.add("iPhone");
        expectedProductsNamesToCheck.add("iPod Classic");
        expectedProductsNamesToCheck.add("MacBook");
        expectedProductsNamesToCheck.add("MacBook Air");
        expectedProductsNamesToCheck.add("Palm Treo Pro");
        expectedProductsNamesToCheck.add("Product 8");

        mainPage.moveToDesktopsTopMenu()
                .clickShowAllDesktopsDropdown();
        mainPage.selectSortValueDropdown("Name (A - Z)");

        List<String> productsNamesToCheck = new ArrayList<>();

        List<Products> products = mainPage.getAllProductsFromMainPage();
        for (Products product : products) {
            productsNamesToCheck.add(product.getName());
        }

        Assertions.assertThat(productsNamesToCheck)
                .as("sorted  are not correctly")
                .isEqualTo(expectedProductsNamesToCheck);
    }
        @Test
// // Check that products were sorted correctly 'Price (Low > High)'
        public void checkProductsSortedCorrectlyLowHigh() {

            List<String> expectedProductsNamesToCheckLowHigh = new ArrayList<>();
            expectedProductsNamesToCheckLowHigh.add("Canon EOS 5D");
            expectedProductsNamesToCheckLowHigh.add("Apple Cinema 30\"");
            expectedProductsNamesToCheckLowHigh.add("HP LP3065");
            expectedProductsNamesToCheckLowHigh.add("HTC Touch HD");
            expectedProductsNamesToCheckLowHigh.add("iPod Classic");
            expectedProductsNamesToCheckLowHigh.add("Product 8");
            expectedProductsNamesToCheckLowHigh.add("iPhone");
            expectedProductsNamesToCheckLowHigh.add("Samsung SyncMaster 941BW");
            expectedProductsNamesToCheckLowHigh.add("Palm Treo Pro");
            expectedProductsNamesToCheckLowHigh.add("MacBook");

            mainPage.moveToDesktopsTopMenu()
                    .clickShowAllDesktopsDropdown();
            mainPage.selectSortValueDropdown("Price (Low > High)");

        List<String> productsNamesToCheckLowTiHight = new ArrayList<>();
        List<Products> productsLowTiHight = mainPage.getAllProductsFromMainPage();
        for (Products product : productsLowTiHight) {
            productsNamesToCheckLowTiHight.add(product.getName());
        }

        Assertions.assertThat(productsNamesToCheckLowTiHight)
                .as("sorted  are not correctly")
                .isEqualTo(expectedProductsNamesToCheckLowHigh);


    }


}
