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

    @DisplayName("Test Case 7: Verify Test Cases Page")
    @Test
    void testVerifyTestCasesPage() {
        step("Открыть стартовую страницу", () -> mainPage.openMainPage());
        step("Открыть страницу c тест-кейсами", () -> mainPage.openTestCasePage());
        step("Проверка отображения сообщение, что это страница с тест кейсами", () -> testCasesPage.assertTitleTestCasePage());
    }

    @DisplayName("Test Case 10: Verify Subscription in home page")
    @Test
    void testVerifySubscriptionHomePage() {
        step("Открыть стартовую страницу", () -> mainPage.openMainPage());
        step("Проверка отображения секции подписки", () -> mainPage.assertSubscriptionSection());
        step("Ввести email в поле ввода", () -> mainPage.setEmailInSubscribeInput("tan_haltermangb4@noticed.gn"));
        step("Нажать на кнопку подписаться ", () -> mainPage.clickSubscribeBtn());
        step("Проверека отображения сообщения о успещной подписке", () -> mainPage.assertAllertSuccessSubscribe());

    }

    @DisplayName("Test Case 11: Verify Subscription in Cart page")
    @Test
    void testVerifySubscriptionCartPage() {
        step("Открыть стартовую страницу", () -> mainPage.openMainPage());
        step("Открыть страницу Shopping Cart", () -> mainPage.clickViewCart());
        step("Ввести email в поле ввода", () -> mainPage.setEmailInSubscribeInput("tan_haltermangb4@noticed.gn"));
        step("Нажать на кнопку подписаться ", () -> mainPage.clickSubscribeBtn());
        step("Проверека отображения сообщения о успещной подписке", () -> mainPage.assertAllertSuccessSubscribe());


    }


}
