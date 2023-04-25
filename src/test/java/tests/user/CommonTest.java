package tests.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class CommonTest extends BaseTest{

    @DisplayName("Test Case 6: Contact Us Form")
    @Test
    void testContactUsForm() {
        step("Открыть стартовую страницу", () -> mainPage.openMainPage());
        step("Открыть страницу Contact Us", () -> mainPage.clickContactUs());
        step("Проверка отображения сообщения - GET IN TOUCH", () -> contactUsPage.assertGetInTouch());
        step("Ввести имя", () -> contactUsPage.setName(user));
        step("Ввести email", () -> contactUsPage.setEmail(user));
        step("Ввести название сообщения", () -> contactUsPage.setSubject("Тестовое сообщение"));
        step("Ввести текст сообщения", () -> contactUsPage.setTextAreaMessage("Текст сообщения"));
        step("Загрузить сообщение", () -> contactUsPage.setInpunUploadFile("user.properties"));
        step("Загрузить сообщение", () -> contactUsPage.clickBtnSubmit());
        step("Проврека сообщения об успешной отправке сообщения", () -> contactUsPage.assertSuccsessMsg());

    }
}
