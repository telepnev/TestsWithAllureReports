package github.creatIssue;

import BaseTest.BaseSteps;
import credentials.Properties;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GitHubApiAndWeb {

    private final BaseSteps webSteps = new BaseSteps();
    private final ApiSteps apiSteps = new ApiSteps();
    Properties cred = new Properties();

    private final String REPOSITORY = "TestsWithAllureReports";
    private final String TITLE_ISSUE = "Hello from API !!!";

    @Test
    @DisplayName("Hello from API !!!")
    @Story("Пользователь создает Issue через API и проверяет ее создание в WEB")
    @Owner("Telepnev")
    public void creatIssueByApi() {

       final Issue created = apiSteps.creatIssue(TITLE_ISSUE);

        webSteps.goToGitHub();
        webSteps.enterLoginAndPass(cred.getEMAIL(),cred.getPASS());
        webSteps.searchForRepository(REPOSITORY);
        webSteps.goToRepo(REPOSITORY);
        webSteps.clickToIssue();
        webSteps.shouldBeSeeTitleIssue(TITLE_ISSUE);


        }
    }

