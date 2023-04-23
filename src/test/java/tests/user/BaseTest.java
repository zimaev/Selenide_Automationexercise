package tests.user;

import POM.LoginPage;
import POM.MainPage;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;

public class BaseTest  {

    MainPage mainPage = new MainPage();
    LoginPage loginPage = new LoginPage();

    @BeforeEach
    void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(false)
                .savePageSource(true)
        );


        Configuration.browserSize = "1900x1080";
        Configuration.pageLoadStrategy = "eager";
        open("https://www.automationexercise.com/");


    }
}
