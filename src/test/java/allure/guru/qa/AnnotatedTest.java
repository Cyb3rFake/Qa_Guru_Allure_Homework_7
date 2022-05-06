package allure.guru.qa;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AnnotatedTest {

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final String TITLE = "с днем археолога!";

    @Test
    @DisplayName("Проверка для Issue на GitHub")

    public void tetGithubIssue() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        Steps steps = new Steps();

        steps.openMainPage();
        steps.searchRepository(REPOSITORY);
        steps.openRepository(REPOSITORY);
        steps.clickOnTab();
        steps.searchByTitle(TITLE);
        steps.resultTest(TITLE);
    }

}
