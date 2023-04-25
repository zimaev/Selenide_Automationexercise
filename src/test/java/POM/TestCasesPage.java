package POM;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class TestCasesPage {
    //*[@id="form"]//h2
    SelenideElement titleTestCasesPage = $x("//*[@id='form']//h2");

    public void assertTitleTestCasePage(){
        titleTestCasesPage.shouldBe(visible);
        titleTestCasesPage.shouldHave(text("TEST CASES"));
    }
}
