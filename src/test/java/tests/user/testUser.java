package tests.user;

import POM.LoginPage;
import POM.MainPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

@Epic("Регистрация и авторизация")
public class testUser extends BaseTest {

    @DisplayName("Test Case 2: Login User with correct email and password")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    void loginUser() {
        step("Открыть главную акторизации", () -> mainPage.openSingupLoginPage());
        step("Открыть страницу регистрации и авторизации", () -> mainPage.openSingupLoginPage());
        step("Ввести email", () -> loginPage.setEmail_address("admin@example.com"));
        step("Ввести пароль", () -> loginPage.setPassword("admin"));
        step("Кажать кнопку Login", () -> loginPage.clickLoginBtn());
        step("В футере отображается что авторизован", () -> mainPage.asserLogginedAs("admin"));

    }

    @DisplayName("Test Case 3: Login User with incorrect email and password")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    void loginUserIncorrectCredential() {
        step("Открыть главную акторизации", () -> mainPage.openSingupLoginPage());
        step("Открыть страницу регистрации и авторизации", () -> mainPage.openSingupLoginPage());
        step("Ввести email", () -> loginPage.setEmail_address("admin@example.com"));
        step("Ввести некорректный пароль ", () -> loginPage.setPassword("worongpassword"));
        step("Кажать кнопку Login", () -> loginPage.clickLoginBtn());
        step("Сообщение об ошики отображается и содирчит текст", () -> loginPage.assertErrorMsg());
    }
}
