package tests.user;

import MODEL.User;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
        step("Нажать кнопку LogOut", () -> mainPage.clicklLogOut());

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
