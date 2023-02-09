package Test;

import main.MainPage;

public class LoginTest extends BaseTest {

    private MainPage mainPage;

    @Test
    public void registrationWithValidCredentials() {
        mainPage = new MainPage();
        mainPage.openMainPage();
    }

}