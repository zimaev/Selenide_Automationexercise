package POM;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class AccountCreated {

    SelenideElement continueBtn = $x("//*[@data-qa='continue-button']");

    public void clickContinueBtn(){
        continueBtn.click();
    }
}
