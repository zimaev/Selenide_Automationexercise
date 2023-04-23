package tests.user;

import MODEL.User;
import POM.AccountCreated;
import POM.LoginPage;
import POM.MainPage;
import POM.SignupPage;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.javafaker.Faker;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.*;

public class BaseTest  {
    Faker faker = new Faker();
    User user = new User();

    MainPage mainPage = new MainPage();
    LoginPage loginPage = new LoginPage();
    SignupPage signupPage = new SignupPage();
    AccountCreated accountCreated = new AccountCreated();

    @BeforeEach
    void setUp() {
        user.name = faker.funnyName().name();
        user.email = faker.internet().emailAddress();
        user.password = faker.internet().password();
        user.firstName = faker.name().firstName();
        user.lastName = faker.name().lastName();
        user.company = faker.company().name();
        user.address = faker.address().fullAddress();
        user.address2 = faker.address().fullAddress();
        user.dateOfBirth = faker.date().birthday().toString();
        user.state = faker.address().state();
        user.city = faker.address().city();
        user.zipCode = faker.address().zipCode();
        user.mobileNumber = faker.phoneNumber().phoneNumber();


        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(false)
                .savePageSource(true)
        );


        Configuration.browserSize = "1900x1080";
        Configuration.pageLoadStrategy = "none";
        Configuration.baseUrl ="https://www.automationexercise.com";
        mainPage.openMainPage();



    }

    @AfterEach
    void tearDown() {
        closeWindow();
        closeWebDriver();
    }
}
