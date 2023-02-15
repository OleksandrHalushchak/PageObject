package Test;

import main.MainPage;
import main.components.Products;
import main.iPhonePage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Test_4_Products extends BaseTest {
    private final MainPage mainPage = new MainPage();
    private final iPhonePage iPhonePage = new iPhonePage();

    @Test
    //Check that Iphone price 123.20
    public void checkIphonePriceDol() {
        String expectedCurrentCurrency = "$";
        String actuaCurrentCurrency = mainPage
                .currentCurrency();

        Assertions.assertThat(actuaCurrentCurrency)
                .as("The selected currency is not the US dollar")
                .isEqualTo(expectedCurrentCurrency);

        String expectedIphoneDollarPrice = "$123.20";
        String actualIphoneDollarPrice = mainPage
                .selectDollarAsCurrentCurrency()
                .ClickIphone()
                .getIPhonePrice();

        Assertions.assertThat(actualIphoneDollarPrice)
                .as("The price in dollars is not correct")
                .isEqualTo(expectedIphoneDollarPrice);

        String expectedIphoneEuroPrice = "106.04€";
        String actualIphoneEuroPrice = iPhonePage
                .selectEuroAsCurrentCurrency()
                .getIPhonePrice();

        Assertions.assertThat(actualIphoneEuroPrice)
                .as("The price in Euro is not correct")
                .isEqualTo(expectedIphoneEuroPrice);

        String expectedIphonePoundSterlingPrice = "£95.32";
        String actualIphonePoundSterlingPrice = iPhonePage
                .selectPoundSterlingAsCurrentCurrency()
                .getIPhonePrice();

        Assertions.assertThat(actualIphonePoundSterlingPrice)
                .as("The price in Euro is not correct")
                .isEqualTo(expectedIphonePoundSterlingPrice);


    }
}






