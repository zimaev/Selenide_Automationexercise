package POM;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class AccountCreated {

    //Селекторы
    SelenideElement continueBtn = $x("//*[@data-qa='continue-button']");


    //Методы работы с элементами
    public void clickContinueBtn(){
        continueBtn.click();
    }
}
