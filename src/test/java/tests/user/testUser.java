package tests.user;

import POM.LoginPage;
import POM.MainPage;
import org.junit.jupiter.api.Test;

public class testUser extends BaseTest {

    @Test
    void registerUser() {

        MainPage mainPage = new MainPage();
        LoginPage loginPage = new LoginPage();
        mainPage.openSingupLoginPage();




    }
}
