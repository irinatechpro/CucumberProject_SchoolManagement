package stepdefinitions.apiStepDefinitions;

import base_url.BaseUrl;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import pojos.AddMeetExpectedPojo;
import pojos.AddMeetResponsePojo;
import pojos.ContactMessageResponsePojo;
import utils.ObjectMapperUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class Api_US19StepDefs extends BaseUrl {
    Response response;
    AddMeetExpectedPojo expectedData;
    @Given("send post request for add meet")
    public void sendPostRequestForAddMeet() {
        teacherSetUp();
        spec.pathParams("first","meet","second","save");

        List<Integer> studentIds = new ArrayList<>();
        studentIds.add(5);
        LocalDate current = LocalDate.now().plusMonths(1);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String validDate = dtf.format(current);
        expectedData = new AddMeetExpectedPojo(validDate,"Vocabulary","11:00","11:00",studentIds);

        response = given(spec).body(expectedData).post("{first}/{second}");
        response.prettyPrint();
    }

    @Then("verify meet could not created.")
    public void verifyMeetCouldNotCreated() {
        AddMeetResponsePojo actualData = ObjectMapperUtils.convertJsonToJava(response.asString(), AddMeetResponsePojo.class);
        assertEquals(500, response.statusCode());
        assertEquals("d != java.lang.String",actualData.getMessage());
    }
}
