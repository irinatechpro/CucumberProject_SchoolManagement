package stepdefinitions.apiStepDefinitions;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import java.sql.ResultSet;
import java.util.List;
import static base_url.BaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static stepdefinitions.uiStepDefinitions.CommonStepDefs.*;
import static stepdefinitions.uiStepDefinitions.US15_StepDefs.*;

public class Api_US15StepDefs {
    private static Integer studentID;
    Response response;
    Faker faker = new Faker();

    @Given("send get All Student request on API")
    public void send_get_All_Student_request_on_API() {
        spec.pathParams("first", "students", "second", "getAll");
        response = given(spec).get("{first}/{second}");
    }

    @Then("filter Student Data using username and validate")
    public void filter_Student_Data_using_username_and_validate() {
        JsonPath jsonPath = response.jsonPath();
        List<String> studentData = jsonPath.getList("findAll{it.username=='" + StudentUserName + "'}");
        System.out.println("studentData = " + studentData);
        String actUsername = jsonPath.getList("findAll{it.username=='" + StudentUserName + "'}.username").get(0).toString();
        String actName = jsonPath.getList("findAll{it.username=='" + StudentUserName + "'}.name").get(0).toString();
        String actSurname = jsonPath.getList("findAll{it.username=='" + StudentUserName + "'}.surname").get(0).toString();
        String actBirthDay = jsonPath.getList("findAll{it.username=='" + StudentUserName + "'}.birthDay").get(0).toString();
        String actBirthPlace = jsonPath.getList("findAll{it.username=='" + StudentUserName + "'}.birthPlace").get(0).toString();
        String actPhoneNumber = jsonPath.getList("findAll{it.username=='" + StudentUserName + "'}.phoneNumber").get(0).toString();
        String actGender = jsonPath.getList("findAll{it.username=='" + StudentUserName + "'}.gender").get(0).toString();
        String actmotherName = jsonPath.getList("findAll{it.username=='" + StudentUserName + "'}.motherName").get(0).toString();
        String actfatherName = jsonPath.getList("findAll{it.username=='" + StudentUserName + "'}.fatherName").get(0).toString();
        String actstudentNumber = jsonPath.getList("findAll{it.username=='" + StudentUserName + "'}.studentNumber").get(0).toString();
        String actSsn = jsonPath.getList("findAll{it.username=='" + StudentUserName + "'}.ssn").get(0).toString();

        assertEquals(200, response.statusCode());
        assertEquals(StudentUserName, actUsername);
        assertEquals(fakeSsn, actSsn);
        assertEquals(fakerName, actName);
        assertEquals(fakerSurname, actSurname);
        assertEquals(fakerDateOfBirth, actBirthDay);
        assertEquals(fakerBirthPlace, actBirthPlace);
        assertEquals(fakerFormattedPhoneNumber, actPhoneNumber);
        assertEquals("MALE", actGender);
        assertEquals(studentMotherName, actmotherName);
        assertEquals(studentFatherName, actfatherName);
        assertEquals(numberText, actstudentNumber);
    }

    @Then("get studentID from API")
    public void get_student_id_from_api() {
        String studentID_String = response.jsonPath().getList("findAll{it.username=='" + StudentUserName + "'}.id").get(0).toString();
        studentID = Integer.parseInt(studentID_String);
        System.out.println("studentID = " + studentID);
    }

    @Then("delete student using studentID")
    public void delete_student_using_student_id() {
        spec.pathParams("first", "students", "second", "delete", "third", studentID);
        response = given(spec).delete("{first}/{second}/{third}");
    }

    @Then("validate student data deleted")
    public void validate_student_data_deleted() {
        System.out.println("response.statusCode() = " + response.statusCode());
        assertEquals(200, response.statusCode());
        assertTrue(response.asString().contains("Student Deleted"));
    }
}

