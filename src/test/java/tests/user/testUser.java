package tests.user;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.codeborne.selenide.WebDriverRunner;
import io.restassured.http.ContentType;
import org.openqa.selenium.Cookie;

import java.util.Date;
import static io.restassured.RestAssured.*;
import static com.codeborne.selenide.Selenide.*;

import static com.codeborne.selenide.Selenide.sleep;
import static io.qameta.allure.Allure.step;


public class testUser extends BaseTest {

    @DisplayName("Test Case 1: Register User")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    void testRegisterUse() {
        step("Открыть страницу регистрации и авторизации", () -> mainPage.openSingupLoginPage());
        step("Ввести имя в поле создания нового прользователя", () -> loginPage.setName(user.name));
        step("Ввести пароль в поле создания нового прользователя", () -> loginPage.setSignupEmailAddress(user.email));
        step("Нажать кнопку Signup", () -> loginPage.clickSignupBtn());
        step("Заполню персональные данные", () -> signupPage.setUserData(user));
        step("Клик на кнопку - Создать аккаунт", () -> signupPage.clickCreateAccount());
        step("Клик на кнопку Continue", () -> accountCreated.clickContinueBtn());
        sleep(300);
    }

    @DisplayName("Test Case 2: Login User with correct email and password")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    void testLoginUser() {
        step("Открыть страницу регистрации и авторизации", () -> mainPage.openSingupLoginPage());
        step("Ввести email", () -> loginPage.setLogin_email_address(System.getProperty("email")));
        step("Ввести пароль", () -> loginPage.setLogin_password(System.getProperty("password")));
        step("Кажать кнопку Login", () -> loginPage.clickLoginBtn());
        step("В футере отображается что авторизован", () -> mainPage.asserLogginedAs("admin"));

    }


    @DisplayName("Test Case 2: Login User with correct email and password -- PROP")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    void testLoginUserProp() {
        step("Открыть страницу регистрации и авторизации", () -> mainPage.openSingupLoginPage());
        step("Ввести email", () -> loginPage.setLogin_email_address("admin@example.com"));
        step("Ввести пароль", () -> loginPage.setLogin_password("admin"));
        step("Кажать кнопку Login", () -> loginPage.clickLoginBtn());
        step("В футере отображается что авторизован", () -> mainPage.asserLogginedAs("admin"));

    }

    @DisplayName("Test Case 3: Login User with incorrect email and password")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    void testLoginUserIncorrectCredential() {
        step("Открыть страницу регистрации и авторизации", () -> mainPage.openSingupLoginPage());
        step("Ввести email", () -> loginPage.setLogin_email_address("admin@example.com"));
        step("Ввести некорректный пароль ", () -> loginPage.setLogin_password("worongpassword"));
        step("Нажать кнопку Login", () -> loginPage.clickLoginBtn());
        step("Сообщение об ошики отображается и сожержит текст", () -> loginPage.assertLoginErrorMsg());
    }

    @DisplayName("Test Case 4: Logout User")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    void testLogoutUser() {
        step("Открыть страницу регистрации и авторизации", () -> mainPage.openSingupLoginPage());
        step("Ввести email", () -> loginPage.setLogin_email_address("admin@example.com"));
        step("Ввести пароль", () -> loginPage.setLogin_password("admin"));
        step("Нажать кнопку Login", () -> loginPage.clickLoginBtn());
        step("В футере отображается что авторизован", () -> mainPage.asserLogginedAs("admin"));
        step("Нажать кнопку LogOut", () -> mainPage.clickLogOut());

    }


    @DisplayName("Test Case 4: Logout User-REST")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    void testLogoutUserREST() {
        step("Открыть страницу регистрации и авторизации", () -> mainPage.openMainPage());
        String csrfToken = WebDriverRunner.getWebDriver().manage().getCookieNamed("csrftoken").getValue();
        System.out.println(csrfToken);

        String sessionId =
                given().contentType(ContentType.MULTIPART).cookie("csrftoken", csrfToken)
                        .header("referer","https://www.automationexercise.com/login")
                        .multiPart("email", "admin@example.com")
                        .multiPart("password", "admin")
                        .multiPart("csrfmiddlewaretoken", csrfToken)
                        .post("https://www.automationexercise.com/login")
                        .then()
                        .log().all()
                        .extract().cookie("sessionid");

        Date expDate = new Date();
        expDate.setTime(expDate.getTime() + (10000 * 10000));
        Cookie cookie = new Cookie("sessionid",sessionId,"automationexercise.com","/", expDate);
        WebDriverRunner.getWebDriver().manage().addCookie(cookie);
        refresh();
        step("В футере отображается что авторизован", () -> mainPage.asserLogginedAs("admin"));
        step("Нажать кнопку LogOut", () -> mainPage.clickLogOut());



    }



    @DisplayName("Test Case 5: Register User with existing email")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    void testRegisterUserWithExistingEmail() {
        step("Открыть страницу регистрации и авторизации", () -> mainPage.openSingupLoginPage());
        step("Ввести имя в поле создания нового прользователя", () -> loginPage.setName("randomname"));
        step("Ввести пароль в поле создания нового прользователя", () -> loginPage.setSignupEmailAddress("admin@example.com"));
        step("Нажать кнопку Signup", () -> loginPage.clickSignupBtn());
        step("Сообщение об ошики отображается и сожержит текст", () -> loginPage.assrtSingUpErrorMsg());


    }

}
