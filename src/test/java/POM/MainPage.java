package POM;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

// page_url = https://www.automationexercise.com/
public class MainPage {

    //Селекторы
    SelenideElement products = $x("//a[@href='/products']");
    SelenideElement logIn = $x("//a[@href='/login']");
    SelenideElement logOut = $x("//a[@href='/logout']");
    SelenideElement contactUs = $x("//a[@href='/contact_us']");
    SelenideElement loginnedAs = $x("//*[@id='header']//li[10]");


    //Методы работы с элементами
    public void openMainPage(){
        open("/");
    }

    public void openSingupLoginPage(){
        logIn.click();
    }

    public void asserLogginedAs(String username){
        loginnedAs.shouldBe(visible);
        loginnedAs.shouldHave(text(username));
    }

    public void clicklLogOut(){
        logOut.click();
    }

    public void clickProducts(){
        products.click();
    }

    public void  clickContactUs(){
        contactUs.click();
    }

}