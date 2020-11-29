package BaseTest;


import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class BaseSteps {


    @Step("Открываем GitHup")
    public void goToGitHub() {
        open("https://github.com/");
    }

    @Step("Логинемся на сайт")
    public void enterLoginAndPass(String email, String pass) {
        $(byText("Sign in")).click();
        $("#login_field").val(email);
        $("#password").val(pass);
        $(byName("commit")).click();
    }

    @Step("Ищем репозиторий")
    public void searchForRepository(String repository) {
        $(".header-search-input").val(repository).submit();
    }

    @Step("Переходим в репозиторий")
    public void goToRepo(String repository) {
        $(".repo-list").$(withText(repository)).click();
    }

    @Step("проверяем правильность выбранного репозитория")
    public void checkRepository(String repository) {
        $("h1").shouldHave(text(repository));
    }

    @Step("Создаем Issues")
    public void creatIssue() {
        $x("//span[@data-content='Issues']").click();
        $x("//a[@role='button']").click();
    }

    @Step("Заполняем Title")
        public void printIssueTitle(String issue_title) {
            $("#issue_title").val(issue_title);
        }

    @Step("Назначаем задачу")
    public void assignIssue(String user) {
        $(withText("Assignees")).click();
        $("#assignee-filter-field").val(user).pressEnter();
        $(withText("Assignees")).click();
    }

    @Step("Заполняем Labels в Create New Issue")
    public void fillLabelsIssue(String labelIssues) {
        $(withText("Labels")).click();
        $(".js-filterable-issue-labels").$(byText(labelIssues)).click();
        $(withText("Labels")).click();
    }

    @Step("Кликаем 'Submit new issue'")
    public void submitNewIssue() {
        $(byText("Submit new issue")).click();
    }

    @Step("Проверяем что нужное Issue созданно")
    public void checkCreatedIssue(String issue_title, String user, String label) {
        $("#partial-discussion-header").shouldHave(text(issue_title));
        $(".TimelineItem-body").shouldHave(text(user));
        $(".TimelineItem-body").shouldHave(text(label));
    }

    @Step("Удаление Issue")
    public void deletIssue() {
        $(withText("Delete issue")).click();
    }

    @Step("Клик Issue")
    public void clickToIssue() {

        $(withText("Issues")).click();
    }

    @Step("Проверка Tetile Issue")
    public void shouldBeSeeTitleIssue(String issue_title) {
        $("#js-pjax-container").shouldHave(text(issue_title));
    }

    }

