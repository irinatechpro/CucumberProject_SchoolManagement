package stepdefinitions.apiStepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import pojos.CreateNewLessonPojo;

import static base_url.BaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;

public class Api_US09 {

    Faker faker;
    Response response;
    CreateNewLessonPojo newLesson = new CreateNewLessonPojo();
    int lessonId;
    @Then("create a new lesson")
    public void create_a_new_lesson() {
        faker = new Faker();
        //https://managementonschools.com/app/lessons/save
        response = given(spec)
                .pathParams("first", "lessons", "second", "save")
                .body(newLesson.createLesson(
                        true,
                        faker.number().numberBetween(20,100),
                        faker.name().firstName() + faker.number().numberBetween(1, 99)
                    )
                ).post("/{first}/{second}")
                .then()
                .statusCode(200)
                .body("object.compulsory", equalTo(newLesson.isCompulsory() ) )
                .body("object.creditScore", equalTo(newLesson.getCreditScore() ) )
                .body("object.lessonName", equalTo(newLesson.getLessonName() ) )
                .extract().response();

        lessonId = response.jsonPath().getInt("object.lessonId");
        response.prettyPrint();

        //set lessonId on the object
        newLesson.setLessonId(lessonId);
    }
    @Then("view the new lesson created")
    public void view_the_new_lesson_created() {
        //https://managementonschools.com/app/lessons/getAllLessonByLessonId?lessonId=45
        response = given(spec)
                .pathParams("first", "lessons", "second", "getAllLessonByLessonId")
                .queryParam("lessonId", newLesson.getLessonId() )
                .get("/{first}/{second}")
                .then()
                .assertThat()
                .statusCode(200)
                .body("compulsory", hasItem(newLesson.isCompulsory() ) )
                .body("creditScore", hasItem(newLesson.getCreditScore() ) )
                .body("lessonId", hasItem(newLesson.getLessonId() ) )
                .body("lessonName", hasItem(newLesson.getLessonName() ) )
                .extract().response();

        //show what is stored for the lesson object
        System.out.println(newLesson.getLessonInfo() );
    }

    @And("delete the created lesson")
    public void deleteTheCreatedLesson() {
        //https://managementonschools.com/app/lessons/delete/{id}
        response = given(spec)
                .pathParams(
                        "first", "lessons",
                        "second", "delete",
                        "third", lessonId)
                .delete("{first}/{second}/{third}")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("message", equalTo("Lesson Deleted"))
                .body("httpStatus", equalTo("OK"))
                .extract().response();

        response.prettyPrint();
    }
}
