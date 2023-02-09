package Test;

import main.BrandsPage;
import main.MainPage;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class BrandsTest extends BaseTest {
    private MainPage mainPage;


    @Test

    public void checkFollowingBrands() {
       String actualBrand = mainPage.ClickBrandsElement()
                       .getBrandList();

        Assertions.assertThat(actualBrand)
                .as("Not Brand")
                .isEqualTo(
                        "Apple");
    }


}


