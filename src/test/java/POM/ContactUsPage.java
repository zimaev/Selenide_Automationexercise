package POM;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ElementsCollection;
import MODEL.User;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

// page_url = https://www.automationexercise.com/contact_us
public class ContactUsPage {

    //Селекторы
    SelenideElement getInTouch = $x("//div[@class='contact-form']//h2");
    SelenideElement inpunName = $x("//input[@name='name']");
    SelenideElement inpunEmail = $x("//input[@name='email']");
    SelenideElement inpunSubject = $x("//input[@name='subject']");
    SelenideElement textAreaMessage = $x("//textarea[@id='message']");
    SelenideElement inpunUploadFile = $x("//input[@name='upload_file']");
    SelenideElement btnSubmit = $x("//input[@name='submit']");
    SelenideElement successMsg = $x("//div[@class='status alert alert-success']");



    //Методы работы с элементами
    public void assertGetInTouch(){
        getInTouch.shouldBe(visible);
    }

    public void setName(User user){
        inpunName.setValue(user.name);
    }

    public void setEmail(User user){
        inpunEmail.setValue(user.email);
    }

    public void setSubject(String subject){
        inpunSubject.setValue(subject);
    }

    public void setTextAreaMessage(String message){
        textAreaMessage.setValue(message);
    }

    public void setInpunUploadFile(String path){
       inpunUploadFile.uploadFromClasspath(path);
    }

    public void clickBtnSubmit(){
        btnSubmit.click();
        confirm();
    }

    public void assertSuccsessMsg(){
        successMsg.shouldBe(visible);
        successMsg.shouldHave(text("Success! Your details have been submitted successfully."));
    }




}