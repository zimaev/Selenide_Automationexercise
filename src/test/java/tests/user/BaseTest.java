package tests.user;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;

public class BaseTest  {

    @BeforeEach
    void setUp() {
        Configuration.browserSize = "1900x1080";
        open("https://www.automationexercise.com/");
    }
}
