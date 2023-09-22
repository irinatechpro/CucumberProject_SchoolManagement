package stepdefinitions.apiStepDefinitions;

import base_url.BaseUrl;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class Api_US07StepDefs extends BaseUrl {
    Response response;
    @Given("send get request for messages")
    public void sendGetRequestForMessages() {
        //set the url
        spec.pathParams("first","contactMessages","second","getAll").queryParams("page",0, "size", 10, "sort", "date", "type", "desc");


        //Send the request and get the response
        response = given(spec).get("{first}/{second}");
        response.prettyPrint();

    }
    @Then("verify message, Name, Email, Date, Subject is seen")
    public void verifyMessageNameEmailDateSubjectIsSeen() {
        //Do Assertion
        assertEquals(200, response.statusCode());

        JsonPath jsonPath = response.jsonPath();


        String actualMessage = jsonPath.getList("content.findAll{it.message}.message").get(0).toString();
        String actualName = jsonPath.getList("content.findAll{it.name}.name").get(0).toString();
        String actualEmail = jsonPath.getList("content.findAll{it.email}.email").get(0).toString();
        String actualDate = jsonPath.getList("content.findAll{it.date}.date").get(0).toString();
        String actualSubject = jsonPath.getList("content.findAll{it.subject}.subject").get(0).toString();

        assertFalse(actualMessage.isEmpty());
        assertFalse(actualName.isEmpty());
        assertFalse(actualEmail.isEmpty());
        assertFalse(actualDate.isEmpty());
        assertFalse(actualSubject.isEmpty());
    }
}
