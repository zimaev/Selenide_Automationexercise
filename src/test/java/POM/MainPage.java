package POM;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

// page_url = https://www.automationexercise.com/
public class MainPage {

    SelenideElement login = $x("//a[@href='/login']");


    public void openSingupLoginPage(){
        login.click();
    }


}