package POM;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class ProductsPage {

    SelenideElement searchProduct = $x("//input[@id='search_product']");
    SelenideElement searchBtn = $x("//button[@id='submit_search']");
    SelenideElement prodictNameInCard = $x("//*[@class='productinfo text-center']//p");
    ElementsCollection productCart = $$x("//*[@class='product-image-wrapper']");



    public void setSearchProduct(String productName){
        searchProduct.setValue(productName);
    }

    public void clickSearchBtn(){
        searchBtn.click();
    }

    public void assertProductName(String name){
        prodictNameInCard.shouldHave(text(name));
    }

    public void assertCountProdictCart(){
        productCart.shouldBe(CollectionCondition.sizeGreaterThan(10));
    }

    public void selectProduct(int number){
        productCart.get(number).$(".choose").click();
    }


}
