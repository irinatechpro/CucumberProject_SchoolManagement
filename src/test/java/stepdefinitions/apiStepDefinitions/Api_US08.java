package stepdefinitions.apiStepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static base_url.BaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Api_US08 {
    Response response;
    int lessonId; //null
    String lessonName = "BioInformatics";

    @Then("check lesson names all show up")
    public void check_lesson_names_all_show_up() {


        //validates that response body is greater than 0
        //so lessons are show
        response = given(spec)
                .pathParams("first", "lessons", "second", "getAll")
                .when()
                .get("/{first}/{second}")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .assertThat()
                .body("lessons.size()", greaterThan(0)).extract().response();

        System.out.println(response.asString());
    }

    @And("show a specific lesson by name")
    public void showASpecificLessonByName() {
        response = given(spec)
                .pathParams("first", "lessons", "second", "getLessonByName")
                .queryParam("lessonName", lessonName)
                .get("/{first}/{second}");

        response.prettyPrint();

        //validate the response
        response.then()
                .contentType(ContentType.JSON)
                .body("object.lessonId", equalTo(469))
                .body("object.lessonName", equalTo(lessonName))
                .body("object.creditScore", equalTo(60))
                .body("object.compulsory", equalTo(true));

        //assign the lesson id in global scope for reuse
        lessonId = response.jsonPath().getInt("object.lessonId");
        System.out.println("Lesson id is: " + lessonId);
    }

    @And("find the lesson by its id")
    public void findTheLessonByItsId() {

        //  -> /lessons/getAllLessonByLessonId?lessonId=45
        response = given(spec)
                .pathParams("first", "lessons", "second", "getAllLessonByLessonId")
                .queryParam("lessonId", lessonId)
                .get("/{first}/{second}");

        response.prettyPrint();

        //validate that lesson id matches with correct lessonName and credit score + compulsory
        response.then()
                .body(
                        "lessonName", hasItem("BioInformatics"),
                        "creditScore", hasItem(60),
                        "compulsory", hasItem(true)
                );
    }
}
