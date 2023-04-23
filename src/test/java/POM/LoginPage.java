package POM;

import MODEL.User;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

// page_url = https://www.automationexercise.com/login
public class LoginPage {

    //Форма авторизации
    SelenideElement login_email_address =$x("//input[@data-qa='login-email']");
    SelenideElement login_password =$x("//input[@type='password']");
    SelenideElement login_btn  =$x("//button[@data-qa='login-button']");
    SelenideElement loginErrorMsg  =$x("//*[@class='login-form']//p");

    //Форма регистрации
    SelenideElement singup_name =$x("//input[@data-qa='signup-name']");
    SelenideElement signup_email_address  =$x("//input[@data-qa='signup-email']");
    SelenideElement signup_btn  =$x("//button[@data-qa='signup-button']");
    SelenideElement signupErrorMsg  =$x("//*[@class='signup-form']//p");



    public void setLogin_email_address(String email) {
        login_email_address.setValue(email);
    }

    public void setLogin_password(String pass) {
        login_password.setValue(pass);
    }

    public void clickLoginBtn(){
        login_btn.click();
    }

    public void assertLoginErrorMsg(){
        loginErrorMsg.shouldBe(visible);
        loginErrorMsg.shouldHave(text("Your email or password is incorrect!"));
    }

    public void setName(String user) {
        singup_name.setValue(user);
    }

    public void setSignupEmailAddress(String email){
        signup_email_address.setValue(email);
    }

    public void clickSignupBtn(){
        signup_btn.click();
    }

    public void assrtSingUpErrorMsg(){
        signupErrorMsg.shouldBe(visible);
        signupErrorMsg.shouldHave(text("Email Address already exist!"));
    }

}