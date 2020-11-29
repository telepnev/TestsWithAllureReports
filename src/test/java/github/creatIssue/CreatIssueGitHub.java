package github.creatIssue;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors;
import credentials.Properties;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class CreatIssueGitHub {
    Properties cred = new Properties();
    String pass = cred.getPASS();
    String email = cred.getEMAIL();

    @Test
    public void creatIssue() {

        open("https://github.com/");
        $(byText("Sign in")).click();
        $("#login_field").val(email);
        $("#password").val(pass);

        sleep(3000);
    }
}
