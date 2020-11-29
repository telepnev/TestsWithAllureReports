package github.creatIssue;


import BaseTest.BaseSteps;
import credentials.Properties;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Feature("Issues")
public class CreatIssueBySteps  {

    Properties cred = new Properties();
    String REPOSITORY = "TestsWithAllureReports";
    String ISSUE_TITLE = "First title from intellij idea !";
    String USER = "telepnev";
    String LABEL = "good first issue";

    @Test
    @DisplayName("Создание Issue с помощью Шагов")
    @Story("User логинется на сайт и создает задачу")
    @Link(url = "https://github.com/telepnev/TestsWithAllureReports/issues", name = "issues")
    @Owner("telepnev")
    @Severity(SeverityLevel.NORMAL)

    public void creatIssueWithSteps() {
        BaseSteps steps = new BaseSteps();

        steps.goToGitHub();
        steps.enterLoginAndPass(cred.getEMAIL(),cred.getPASS());
        steps.searchForRepository(REPOSITORY);
        steps.goToRepo(REPOSITORY);
        steps.checkRepository(REPOSITORY);
        steps.creatIssue();
        steps.printIssueTitle(ISSUE_TITLE);
        steps.assignIssue(USER);
        steps.fillLabelsIssue(LABEL);
        steps.submitNewIssue();
        steps.checkRepository(REPOSITORY);
        steps.deletIssue();
    }

}
