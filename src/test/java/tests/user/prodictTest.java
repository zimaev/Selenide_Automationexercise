package tests.user;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;
import static io.qameta.allure.Allure.step;

public class prodictTest extends BaseTest {

    @DisplayName("Test Case 8: Verify All Products and product detail page")
    @Severity(SeverityLevel.NORMAL)
    @Test
    void testVerifyAllProductsAndProductDetailPage() {
        step("Открыть страницу c продуктами", () -> mainPage.clickProducts());
        step("Открыть страницу c продуктами", () -> productsPage.assertCountProdictCart());
        step("Открыть карточку продукта", () -> productsPage.selectProduct(2));
    }


    @DisplayName("Test Case 9: Search Product")
    @Severity(SeverityLevel.NORMAL)
    @Test
    void testSearchProduct() {
        step("Открыть страницу c продуктами", () -> mainPage.clickProducts());
        step("Ввести в строку поиска имя товара", () -> productsPage.setSearchProduct("Pure Cotton Neon Green Tshirt"));
        step("Начать на конопку поиска", () -> productsPage.clickSearchBtn());
        step("Проверка имени товара в поисковой выдаче", () -> productsPage.assertProductName("Pure Cotton Neon Green Tshirt"));
    }
}
