package stepdefinitions.apiStepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import pojos.LessonManagementLessonName;
import pojos.LessonManagementObjectPojo;

import java.util.ArrayList;
import java.util.List;

import static base_url.BaseUrl.spec;
import static base_url.BaseUrl.viceDeanSetUp;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;

public class Api_US11_ViceDeanLessonScheduleUpdate {
    Response response;
    //LessonManagementLessonPost objectPost;
    LessonManagementObjectPojo object;
   // LessonManagementPojo expectedData;
    LessonManagementLessonName lessonName;
    @When("send get request for viewing lesson Program")
    public void send_get_request_for_viewing_lesson_program() {
        //Set the url
        // https://managementonschools.com/app/lessonPrograms/getAll
        viceDeanSetUp();
        spec.pathParams("first", "lessonPrograms", "second","getAll");

        //Send the request and get the response
        response= given(spec).get("{first}/{second}");
        response.prettyPrint();

    }
    @Then("validate that response data includes the lesson program")
    public void validate_that_response_data_includes_the_lesson_program() {
       //Do assertion
        response.then().statusCode(200);
        JsonPath jsonPath = response.jsonPath();

        //"lessonProgramId": 3
       // System.out.println(jsonPath.getList("content.findAll{it.lessonProgramId=='33'}"));
        List<String> lessonNames= jsonPath.getList("lessonName.lessonName");
       // List<Integer> lessonProgramIds = jsonPath.getList("lessonProgramId.lessonProgramId");
        System.out.println("lessonNames = " + lessonNames);
     // System.out.println("lessonProgramIds = " + lessonProgramIds);
        List<String> lesson = new ArrayList<>();
        lesson.add("Selenium");
        List<Integer> lessonId = new ArrayList<>();
       // lessonIds.add(2);

        assertTrue(lessonNames.contains(lesson));
        //assertTrue(lessonIds.contains(lessonId));
    }








    @Given("Vice Dean sends put request for lesson program")
    public void viceDeanSendsPutRequestForLessonProgram() {
        
    }

    @Then("Vice Dean update the lesson program and assert")
    public void viceDeanUpdateTheLessonProgramAndAssert() {
        
    }

    @Then("send delete request for deleting lesson Program")
    public void sendDeleteRequestForDeletingLessonProgram() {
    }
}
