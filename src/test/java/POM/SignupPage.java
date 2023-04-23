package POM;

import MODEL.User;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class SignupPage {
    SelenideElement password = $x("//input[@id='password']");
    SelenideElement firstName = $x("//input[@id='first_name']");
    SelenideElement lastName = $x("//input[@id='last_name']");
    SelenideElement company = $x("//input[@id='company']");
    SelenideElement address = $x("//input[@id='address1']");
    SelenideElement createAccountBtn = $(byTagAndText("button","Create Account"));
    SelenideElement days = $x("//select[@id='days']");
    SelenideElement months = $x("//select[@id='months']");
    SelenideElement years = $x("//select[@id='years']");
    SelenideElement country = $x("//select[@id='country']");
    SelenideElement state = $x("//input[@id='state']");
    SelenideElement city = $x("//input[@id='city']");
    SelenideElement zipcode = $x("//input[@id='zipcode']");
    SelenideElement mobile_number = $x("//input[@id='mobile_number']");



    public void setUserData(User user){
        this.password.setValue(user.password);
        System.out.println(user.dateOfBirth);
        days.selectOption(1);
        months.selectOption(2);
        years.selectOption(1);
        country.selectOption(3);
        this.firstName.setValue(user.firstName);
        this.lastName.setValue(user.lastName);
        this.company.setValue(user.company);
        this.address.setValue(user.address);
        this.state.setValue(user.state);
        this.city.setValue(user.city);
        this.zipcode.setValue(user.zipCode);
        this.mobile_number.setValue(user.mobileNumber);


    }

    public void clickCreateAccount(){
        createAccountBtn.click();
    }

}
