package Test;

import main.MainPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Test_0_BrandsTest extends BaseTest {
    private MainPage mainPage = new MainPage();


    @Test
    public void checkFollowingBrands() {
        List<String> expectedBrandNames = new ArrayList<>();
        expectedBrandNames.add("Apple");
        expectedBrandNames.add("Canon");
        expectedBrandNames.add("Hewlett-Packard");
        expectedBrandNames.add("HTC");
        expectedBrandNames.add("Palm");
        expectedBrandNames.add("Sony");

        List<String>  actualBrand = mainPage.clickBrandsElement()
                .getBrandList();

        Assertions.assertThat(actualBrand)
                .as("It is not actual Brand")
                .isEqualTo(
                        expectedBrandNames);
    }




}


