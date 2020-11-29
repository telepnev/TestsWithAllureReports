package github.creatIssue;

import credentials.Properties;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class CreatIssueGitHub {
    Properties cred = new Properties();
    String pass = cred.getPASS();
    String email = cred.getEMAIL();
    String REPOSITORY = "TestsWithAllureReports";
    String USER = "telepnev";

    @Test
    @DisplayName("Тест создание Issue через WEB")
    @Feature("Issues")
    @Story("Пользователь может создать, назначить, и изменить Issue")
    @Link(url = "https://github.com/telepnev/TestsWithAllureReports", name = "TestsWithAllureReports")
    @Owner("Telepnev")
    @Severity(SeverityLevel.CRITICAL)

    public void creatIssueOnlySelenide() {

        open("https://github.com/");
        $(byText("Sign in")).click();
        $("#login_field").val(email);
        $("#password").val(pass);
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
