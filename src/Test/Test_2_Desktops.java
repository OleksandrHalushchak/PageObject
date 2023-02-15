package Test;

import main.MainPage;
import org.assertj.core.api.AbstractBigDecimalAssert;
import org.assertj.core.api.AbstractIntegerAssert;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import static org.assertj.core.api.BDDAssertions.as;

public class Test_2_Desktops extends BaseTest {
    private final MainPage mainPage = new MainPage();

        @Test
    // Check that value in Show dropdown is 10
    public void checkShownValueDrodown() {

        String actualShownValueDrodown = mainPage
                .moveToDesktopsTopMenu()
                .clickShowAllDesktopsDropdown()
                .getnumberValueProductsOnPage();


        Assertions.assertThat(actualShownValueDrodown)
                .as("expected valua 10")
                .isEqualTo(
                        "https://demo.opencart.com/index.php?route=product/category&language=en-gb&path=20&limit=10");
    }
    @Test
    // Check that value in Sort By is Default
    public void checkSortValueDrodown() {

        String actualSortValueDrodown = mainPage
                .moveToDesktopsTopMenu()
                .clickShowAllDesktopsDropdown()
                        .getSortValueOnPage();


        Assertions.assertThat(actualSortValueDrodown)
                .as("expected valua Default")
                .isEqualTo(
                        "https://demo.opencart.com/index.php?route=product/category&language=en-gb&path=20&sort=p.sort_order&order=ASC");
    }
    @Test
    // Check that 10 products display on page
    public void checkProductsDisplayOnPage() {

        int actualNumberProductsDisplayOnPage = mainPage
                .moveToDesktopsTopMenu()
                .clickShowAllDesktopsDropdown()
                .getnumberProductsOnPage();
        int expectedShownValueDrodown = 10;
        Assertions.assertThat(actualNumberProductsDisplayOnPage)
                .as("expected value 10")
                .isEqualTo(expectedShownValueDrodown);
    }


    @Test
    // Check that 12 products now dispayed
    public void checkProductsDisplayOnPage25() {

        int actualNumberProductsDisplayOnPage25 = mainPage
                .moveToDesktopsTopMenu()
                .clickShowAllDesktopsDropdown()
                .selectNumberValueProductsOnPage()
                .getnumberProductsOnPage();
        int expectedShownValueDrodown = 12;
        Assertions.assertThat(actualNumberProductsDisplayOnPage25)
                .as("expected value 12")
                .isEqualTo(expectedShownValueDrodown);
    }
    @Test
    // Check that text 'Showing 1 to 12 of 12 (1 Pages)' displays on the bottom of the page
    public void checkTextBottomPage() {

        String actualTextBottomPage = mainPage
                .moveToDesktopsTopMenu()
                .clickShowAllDesktopsDropdown()
                .selectNumberValueProductsOnPage()
                .getBottomPageText();


        Assertions.assertThat(actualTextBottomPage)
                .as("expected Showing 1 to 12 of 12 (1 Pages)")
                .isEqualTo(
                        "Showing 1 to 12 of 12 (1 Pages)");
    }


}