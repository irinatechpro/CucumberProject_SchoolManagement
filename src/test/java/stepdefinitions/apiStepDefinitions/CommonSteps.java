package stepdefinitions.apiStepDefinitions;

import io.cucumber.java.en.Given;
import io.restassured.response.Response;
import utilities.ConfigReader;

import static base_url.BaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class CommonSteps {


    //checks if logged in as ViceDean is successful on API
    @Given("login as vice dean is authorized on api")
    public void login_as_vice_dean_is_authorized_on_api() {

        //send a POST request payload to check for ViceDean
        //Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJBZ2VudDA3IiwiaWF0IjoxNjk1MTQ3NjU5LCJleHAiOjE2OTUxNTYyOTl9.aHvJsHz6tnZ8wK5zuvISSQ-0CIiWiPOfSh6R3y4YPGYna5J4aURBc0uVJPb16kUDGsnwFsi1dlWkOpgp2GFpFg
        String payLoad = "{" +
                "\"username\": \"" + ConfigReader.getProperty("viceDeanUserName") + "\"," +
                "\"password\": \"" + ConfigReader.getProperty("viceDeanPassword") + "\"}";

        Response response = given(spec)
                .pathParams("first", "auth", "second", "login")
                .body(payLoad)
                .post("/{first}/{second}");

        response.prettyPrint();

        //verify response body fields
        response.then().assertThat()
                .body("username", equalTo("Agent07"))
                .body("role", equalTo("ASSISTANTMANAGER"))
                .body("name", equalTo("Agent07"))
                .body("token", containsString("Bearer"));
    }
}
