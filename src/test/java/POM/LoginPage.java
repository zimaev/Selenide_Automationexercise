package POM;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import org.junit.jupiter.api.*;
// page_url = https://www.automationexercise.com/login
public class LoginPage {
    SelenideElement email_address =$x("//input[@data-qa='login-email']");
    SelenideElement password  =$x("//input[@type='password']");
    SelenideElement login_btn  =$x("//button[@data-qa='login-button']");
    SelenideElement loginErrorMsg  =$x("//*[@class='login-form']//p");


    public void setEmail_address(String email) {
        email_address.setValue(email);
    }

    public void setPassword(String pass) {
        password.setValue(pass);
    }

    public void clickLoginBtn(){
        login_btn.click();
    }

    public void assertErrorMsg(){
        loginErrorMsg.shouldBe(visible);
        loginErrorMsg.shouldHave(text("Your email or password is incorrect!"));
    }
}