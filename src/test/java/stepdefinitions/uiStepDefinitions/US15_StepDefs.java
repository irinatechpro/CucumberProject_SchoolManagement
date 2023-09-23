package stepdefinitions.uiStepDefinitions;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import pages.CommonLocator;
import pages.CreateStudentPage;
import utilities.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import static base_url.BaseUrl.spec;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.replaceFiltersWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static stepdefinitions.uiStepDefinitions.CommonStepDefs.*;

public class US15_StepDefs {
    private static String StudentUserName;
    private static String advisorTeacher;
    private static String studentEmail;
    private static String studentFatherName;
    private static String studentMotherName;
    private static String numberText;
    private static Integer studentID;
    CreateStudentPage createStudentPage = new CreateStudentPage();
    CommonLocator commonLocator = new CommonLocator();
    Response response;
    ResultSet resultSet;
    Faker faker = new Faker();

    @Given("choose Advisor Teacher")
    public void choose_advisor_teacher() throws Exception {

        BrowserUtils.selectByIndex(createStudentPage.advisorTeacherDropBox, 4);
    }

    @Given("enter email")
    public void enter_email() {
        studentEmail = faker.internet().emailAddress();
        createStudentPage.emailField.sendKeys(studentEmail);
    }

    @Then("enter father name")
    public void enter_father_name() {
        studentFatherName = faker.name().firstName();
        createStudentPage.fatherNameField.sendKeys(studentFatherName);
    }

    @Then("enter mother name")
    public void enter_mother_name() {
        studentMotherName = faker.name().firstName();
        createStudentPage.motherNameField.sendKeys(studentMotherName);
    }

    @Given("click Student Management Link")
    public void click_student_management_link() {
        commonLocator.studentManagementLink.click();
        JSUtils.scrollAllTheWayUpJS();
        WaitUtils.waitFor(3);
    }

    @Given("verify student created successfully confirmation message")
    public void verify_student_created_successfully_confirmation_message() {
        WaitUtils.waitForVisibility(commonLocator.confirmationMessage, 2);
        assertTrue(commonLocator.confirmationMessage.getText().contains("Student saved"));
    }

    @Then("enter student username")
    public void enter_student_username() {
        StudentUserName = faker.name().username();
        commonLocator.usernameField.sendKeys(StudentUserName);
        WaitUtils.waitFor(2);
    }

    @Then("verify student number created automatically")
    public void verify_student_number_created_automatically() {
        WaitUtils.waitFor(5);
        JSUtils.scrollIntoViewJS(createStudentPage.lastRow);
        WaitUtils.waitFor(5);
        String lastRow = createStudentPage.lastRow.getText();
        System.out.println("lastRow = " + lastRow);
        Assert.assertTrue(lastRow.contains(StudentUserName));
        numberText = CreateStudentPage.firstColumnInLastRow.getText();
        System.out.println("numberText = " + numberText);
        // Perform assertion to check if it's a 4-digit number
        if (numberText.matches("\\d{4}")) {
            System.out.println("Assertion passed: The number is a 4-digit number");
        } else {
            System.out.println("Assertion failed: The number is not a 4-digit number");
        }
    }

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
        assertEquals(formattedDate, actBirthDay);
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

    @Given("get Student Data by username")
    public void get_Student_Data_by_username() throws SQLException {
        String query = "select * from student where username = '" + StudentUserName + "'";
        resultSet = DBUtils.executeQuery(query);
        resultSet.next();
    }

    @Then("validate  username")
    public void validate_username() throws SQLException {
        String actualUsername = resultSet.getString("username");
        assertEquals(StudentUserName, actualUsername);
    }
    @Then("validate Student data")
    public void validate_Student_data () throws SQLException {
        String actualUsername = resultSet.getString("username");
        String actualName = resultSet.getString("name");
        String actualSurname = resultSet.getString("surname");
        String actualSSN = resultSet.getString("ssn");
        String actualBirthDate = resultSet.getString("birth_day");
        String actualBirthPlace = resultSet.getString("birth_place");
        String actualPhoneNumber = resultSet.getString("phone_number");
        String actualGender = resultSet.getString("gender");
        String actualMotherName = resultSet.getString("mother_name");
        String actualFatherName = resultSet.getString("father_name");
        String actualStudentNumber = resultSet.getString("student_number");
        assertEquals(StudentUserName, actualUsername);
        assertEquals(fakeSsn, actualSSN);
        assertEquals(fakerName, actualName);
        assertEquals(fakerSurname, actualSurname);
        assertEquals(formattedDate, actualBirthDate);
        assertEquals(fakerBirthPlace, actualBirthPlace);
        assertEquals(fakerFormattedPhoneNumber, actualPhoneNumber);
        assertEquals("0", actualGender);
        assertEquals(studentMotherName, actualMotherName);
        assertEquals(studentFatherName, actualFatherName);
        assertEquals(numberText, actualStudentNumber);

    }
}
