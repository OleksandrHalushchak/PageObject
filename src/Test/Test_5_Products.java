package Test;

import main.MainPage;
import main.components.Products;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.util.List;

public class Test_5_Products extends BaseTest {
    private final MainPage mainPage = new MainPage();

    @Test

    public void Test_5() {
        String cameraCanonName = "Canon EOS 5D";
        String cameraNikonName = "Nikon D300";
        String expectedPriceOld = "$122.00";
        String expectedPriceNew = "$98.00";
        String expectedNikonPriceTax = "Ex Tax: $80.00";
        int expectedcount = 2;
        int count = 0;


        mainPage.openCamerasTopMenu();

        List<Products> products = mainPage.getAllProductsFromMainPage();

        Products cameraToCheck = null;

        for (Products product : products) {
            if (product.getName().equals(cameraCanonName)) {
                cameraToCheck = product;
            }
            count++;
        }

        Assertions.assertThat(count)
                .as(" 2 cameras exist on page")
                .isEqualTo(expectedcount);

        Assertions.assertThat(cameraToCheck.getPriceNew())
                .as("Canon EOS 5D has new price 98.00")
                .isEqualTo(expectedPriceNew);

        Assertions.assertThat(cameraToCheck.getPriceOld())
                .as("Check that Canon EOS 5D has old price 122.00")
                .isEqualTo(expectedPriceOld);

        for (Products product : products) {
            if (product.getName().equals(cameraNikonName)) {
                cameraToCheck = product;
            }
        }
        Assertions.assertThat(cameraToCheck.getPriceTax())
                .as("Nikon D300 has ex.rate 80.00")
                .isEqualTo(expectedNikonPriceTax);
    }
}






