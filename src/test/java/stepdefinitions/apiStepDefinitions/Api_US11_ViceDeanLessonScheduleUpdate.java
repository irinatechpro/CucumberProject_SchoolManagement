package stepdefinitions.apiStepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.List;

import static base_url.BaseUrl.spec;
import static base_url.BaseUrl.viceDeanSetUp;
import static io.restassured.RestAssured.given;

public class Api_US11_ViceDeanLessonScheduleUpdate {
    Response response;
    @When("send get request for viewing lesson Program")
    public void send_get_request_for_viewing_lesson_program() {
        //Set the url
        // https://managementonschools.com/app/lessonPrograms/getAll
        viceDeanSetUp();
        spec.pathParams("first", "lessonPrograms", "second","getAll");

        //Send the request and get the response
        response= given(spec).get("{first}/{second}");
      // response.prettyPrint();

    }
    @Then("validate that response data includes the lesson program")
    public void validate_that_response_data_includes_the_lesson_program() {
       //Do assertion
        response.then().statusCode(200);

        JsonPath jsonPath = response.jsonPath();//"lessonProgramId": 3
       // System.out.println(jsonPath.getList("content.findAll{it.lessonProgramId=='3'}"));
      //  List<String> lessonNames= jsonPath.getList("lessonName.lessonName");
    }
}
