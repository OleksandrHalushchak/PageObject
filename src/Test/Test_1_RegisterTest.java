package Test;

import main.MainPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class Test_1_RegisterTest extends BaseTest {
    private MainPage mainPage = new MainPage();

    @Test
    public void checkNewPageTitle() {

        String  actualNewPageTitle = mainPage
                .clickAccountDropdownLocator()
                .clickRegisterDropdownLocator()
                .enterFirstName("Oleksandr")
                .enterLastName("Gal")
                .enterEmail("111qww@gmail.com")
                .enterPassword("qweerQ122")
                .subscribeYesRadioButton()
                .clickCheckbox()
                .clickContinueButton()
                .getPageTitle();


        Assertions.assertThat(actualNewPageTitle)
                .as("New page did'n open")
                .isEqualTo(
                        "Welcome");
    }




}
