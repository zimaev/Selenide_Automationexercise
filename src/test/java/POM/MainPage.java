package POM;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

// page_url = https://www.automationexercise.com/
public class MainPage {

    SelenideElement login = $x("//a[@href='/login']");
    SelenideElement loginnedAs = $x("//*[@id='header']//li[10]");


    public void openSingupLoginPage(){
        login.click();
    }

    public void asserLogginedAs(String username){
        loginnedAs.shouldBe(visible);
        loginnedAs.shouldHave(text(username));
    }


}