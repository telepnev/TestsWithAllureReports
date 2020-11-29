package github.creatIssue;

import com.codeborne.selenide.logevents.SelenideLogger;
import credentials.Properties;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

@Feature("Issues")
public class CreatIssueWithCleanSelenide {
    Properties cred = new Properties();
    String REPOSITORY = "TestsWithAllureReports";
    String USER = "telepnev";

    @BeforeEach
    public void initLogger() {
        SelenideLogger.addListener("allure", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true));
    }

    @Test
    @DisplayName("Создание теста на чистом Selenide")
    @Story("Пользователь может создать, назначить и добавить Лейблы в Issue")
    @Link(url = "https://github.com/telepnev/TestsWithAllureReports", name = "TestsWithAllureReports")
    @Owner("Telepnev")
    @Severity(SeverityLevel.CRITICAL)

    public void creatIssueOnlySelenide() {

        open("https://github.com/");
        $(byText("Sign in")).click();
        $("#login_field").val(cred.getEMAIL());
        $("#password").val(cred.getPASS());
        $(byName("commit")).click();
        $(".header-search-input").val(REPOSITORY).submit();
        $x("//a[@href='/telepnev/TestsWithAllureReports']").click();
        $("h1").shouldHave(text(REPOSITORY));
        $x("//span[@data-content='Issues']").click();
        $x("//a[@role='button']").click();
        $("#issue_title").val("First title from intellij idea !");
        $("#assignees-select-menu").click();
        $x("//span[text()='telepnev']").click();
        $("#assignees-select-menu").click();
        $("#labels-select-menu").click();
        $x("//span[text()='question']").click();
        $x("//span[text()='good first issue']").click();
        $("#labels-select-menu").click();
        $(byText("Submit new issue")).click();
        $("#partial-discussion-header").shouldHave(text("First title from intellij idea !"));
    }

}
