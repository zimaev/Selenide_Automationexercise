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

@Epic("Allure examples")
public class testUser extends BaseTest {
    @Epic("Allure examples")
    @DisplayName("Test Case 2: Login User with correct email and password")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    void registerUser() {
        step("Открыть главную акторизации", () -> mainPage.openSingupLoginPage());
        step("Открыть страницу регистрации и авторизации", () -> mainPage.openSingupLoginPage());
        step("Ввести email", () -> loginPage.setEmail_address("admin@example.com"));
        step("Ввести пароль", () -> loginPage.setPassword("admin"));
        step("Кажать кнопку Login", () -> loginPage.clickLoginBtn());

    }
}
