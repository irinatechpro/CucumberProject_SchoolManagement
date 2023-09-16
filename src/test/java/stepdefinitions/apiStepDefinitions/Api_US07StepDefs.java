package stepdefinitions.apiStepDefinitions;

import base_url.BaseUrl;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import pojos.DeanContactGetAllPojos.ContactPojo;

import static io.restassured.RestAssured.given;

public class Api_US07StepDefs extends BaseUrl {
    ContactPojo expectedData;
    @Given("send get request for messages")
    public void sendGetRequestForMessages() {
        deanSetUp();
        spec.pathParams("first","contactMessages","second","getAll").queryParams("page",0, "size", 10, "sort", "date", "type", "desc");
        Response response = given(spec).when().get("{first}/{second}");

    }
    @Then("verify message, Name, Email, Date, Subject is seen")
    public void verifyMessageNameEmailDateSubjectIsSeen() {
    }
}
