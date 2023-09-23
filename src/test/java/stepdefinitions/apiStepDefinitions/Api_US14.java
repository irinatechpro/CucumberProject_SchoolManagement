package stepdefinitions.apiStepDefinitions;

import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import pojos.CreateTeacherPojo;

import io.restassured.response.Response;
import static base_url.BaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class Api_US14 {

    CreateTeacherPojo createTeacherPojo;
    Response response;

    int userId;
    @Then("create teacher with valid information")
    public void create_teacher_with_valid_information() {
        createTeacherPojo = new CreateTeacherPojo();
        createTeacherPojo.createTeacher();

        //https://managementonschools.com/app/teachers/save
         response = given(spec)
                 .pathParams("first", "teachers", "second", "save")
                 .body(createTeacherPojo.createTeacherPayLoad() )
                 .post("/{first}/{second}")
                 .then()
                 .statusCode(200)
                 .body("object.username", equalTo(createTeacherPojo.getUsername() ) )
                 .body("object.name", equalTo(createTeacherPojo.getName() ) )
                 .body("object.surname", equalTo(createTeacherPojo.getSurname() ) )
                 .body("object.birthDay", equalTo(createTeacherPojo.getBirthday() ) )
                 .body("object.email", equalTo(createTeacherPojo.getEmail() ) )
                 .body("message", equalTo("Teacher saved successfully") )
                 .contentType(ContentType.JSON)
                 .extract().response();

        System.out.println(response.asString());

        //Update userId field global scope
         userId = response.jsonPath().getInt("object.userId");
         System.out.println("userId: " + userId);
    }
}
