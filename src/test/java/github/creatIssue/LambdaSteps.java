package github.creatIssue;

import credentials.Properties;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

@Feature("Issues")
public class LambdaSteps {

    Properties cred = new Properties();
    String pass = cred.getPASS();
    String email = cred.getEMAIL();
    String REPOSITORY = "TestsWithAllureReports";
    String USER = "telepnev";
    String ISSUE_TITLE = "First title from intellij idea !";

    @Test
    @DisplayName("Создание Issue с помощью Lambda")
    @Story("User логинется на сайт и создает задачу")
    @Link(url = "https://github.com/telepnev/TestsWithAllureReports/issues", name = "issues")
    @Owner("telepnev")
    @Severity(SeverityLevel.NORMAL)
    public void creatIssueUseLambdaSteps() {
        Allure.feature("Issues");
        Allure.story("Пользователь создает Issue ");
        Allure.parameter("Repository", REPOSITORY);

        step("Открываем GitHub", () -> {
            open("https://github.com/");
        });
        step("Логинемся на сайт", () -> {
            $(byText("Sign in")).click();
            $("#login_field").val(email);
            $("#password").val(pass);
            $(byName("commit")).click();
        });
        step("Ищем репозиторий" + REPOSITORY, () -> {
            $(".header-search-input").val(REPOSITORY).submit();
        });
        step("Переходим в репозиторий", () -> {
            $x("//a[@href='/telepnev/TestsWithAllureReports']").click();

        });
        step("проверяем правильность выбранного репозитория", () -> {
            $("h1").shouldHave(text(REPOSITORY));

        });
        step("Создаем Issues", () -> {
            $x("//span[@data-content='Issues']").click();
            $x("//a[@role='button']").click();
        });
        step("Заполняем Title", () -> {
            $("#issue_title").val(ISSUE_TITLE);
        });
        step("Асайним на " + USER, () -> {
            $("#assignees-select-menu").click();
            $x("//span[text()='telepnev']").click();
            $("#assignees-select-menu").click();
        });
        step("Устанавливаем Labels 'question', 'good first issue'", () -> {
            $("#labels-select-menu").click();
            $x("//span[text()='question']").click();
            $x("//span[text()='good first issue']").click();
            $("#labels-select-menu").click();
        });
        step("Кликаем 'Submit new issue'", () -> {
            $(byText("Submit new issue")).click();
        });
        step("Проверяем созданое Issue" + ISSUE_TITLE, () -> {
            $("#partial-discussion-header").shouldHave(text(ISSUE_TITLE));
        });
    }
}
