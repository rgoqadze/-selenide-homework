import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByAttribute;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class SelenideTests {

    public SelenideTests() {
        Configuration.timeout = 2000;
        Configuration.browser = "Chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "http://the-internet.herokuapp.com";
    }

    @Test
    public void CheckBox() {
        Configuration.timeout = 2000;
        Configuration.browser = "Chrome";
        Configuration.browserSize = "1920x1080";
        open("/checkboxes");
        $("input[type=checkbox]",0).setSelected(true);
        $("input[type=checkbox]",0).shouldBe(type("checkbox"));
        $("input[type=checkbox]",1).shouldBe(type("checkbox"));

    }

    @Test
    public void Option() {
        open("/dropdown");
        SelenideElement option = $(By.id("dropdown"));
        option.selectOption(2);
        option.getSelectedOption().shouldHave(text("Option 2"));
    }

    @Test
    public void TextBox() {
        open("https://demoqa.com/text-box");
        $(byAttribute("placeholder","Full Name")).sendKeys("Full Name");
        $(byId("userEmail")).sendKeys("birav62937@dilanfa.com");
        $(".form-control",2).sendKeys("Agmashenebeli Avenue");
        $(byXpath("//*[@id=\"permanentAddress\"]")).sendKeys("Chavchavadze Avenue");
        $(byId("submit")).click();
        $$(byClassName("mb-1")).shouldHave(exactTexts("Name:Full Name", "Email:birav62937@dilanfa.com", "Current Address :Agmashenebeli Avenue", "Permananet Address :Chavchavadze Avenue"));
    }
}
