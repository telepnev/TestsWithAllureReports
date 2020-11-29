package github.creatIssue;

import credentials.Properties;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class ApiSteps {

    private final Properties token = new Properties();

    public Issue creatIssue(String title) {

        final Issue toCreat = new Issue();
        toCreat.setTitle(title);

        // @formatter:off
        given()
                .header("Authorization","token " +token.getTOKEN())
                .baseUri("https://api.github.com")
                .body(toCreat)
        .when()
                 .post("/repos/telepnev/TestsWithAllureReports/issues")
        .then()
                .statusCode(201);
        // @formatter:on
        return null;
    }
}
