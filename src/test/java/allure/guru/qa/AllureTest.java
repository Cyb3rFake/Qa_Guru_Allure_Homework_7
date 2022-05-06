package allure.guru.qa;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class AllureTest {


    @DisplayName("Проверка для Issue на github")
    @Test
    public void SelenideTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        Selenide.open("https://github.com/");
        $(".header-search-input").click();
        $(".header-search-input").setValue("eroshenkoam/allure-example");
        $(".header-search-input").pressEnter();
        $(linkText("eroshenkoam/allure-example")).click();
        $(partialLinkText("Issue")).click();
        $(partialLinkText("с днем археолога!")).click();

        $(".markdown-title").shouldHave(text("с днем археолога!"));
    }
}

