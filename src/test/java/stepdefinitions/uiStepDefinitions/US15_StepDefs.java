package stepdefinitions.uiStepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.CommonLocator;
import pages.CreateStudentPage;
import utilities.*;

import javax.swing.text.Utilities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static base_url.BaseUrl.spec;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.replaceFiltersWith;
import static org.junit.Assert.assertTrue;

public class US15_StepDefs {
    private static String StudentUserName;
    private static String advisorTeacher;
    private static String studentEmail;
    private static String studentFatherName;
    private static String studentMotherName;
    CreateStudentPage createStudentPage = new CreateStudentPage();
    CommonLocator commonLocator =new CommonLocator();
    Response response;
    ResultSet resultSet;
    Faker faker = new Faker();
    @Given("choose Advisor Teacher")
    public void choose_advisor_teacher() throws Exception {

        BrowserUtils.selectByIndex(createStudentPage.advisorTeacherDropBox, 4);
        //advisorTeacher = BrowserUtils.getDropdownSelectedOptions(createStudentPage.advisorTeacherDropBox).get(4);
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
        String numberText = CreateStudentPage.firstColumnInLastRow.getText();
        System.out.println("numberText = " + numberText);
        // Perform assertion to check if it's a 4-digit number
        if (numberText.matches("\\d{4}")) {
            System.out.println("Assertion passed: The number is a 4-digit number");
        } else {
            System.out.println("Assertion failed: The number is not a 4-digit number");
        }
    }
    @Given("send get All Student request")
    public void send_get_All_Student_request() {
        spec.pathParams("first", "students", "second", "getAll");
        response = given(spec).get("{first}/{second}");
        response.prettyPrint();
    }
    @Then("filter Student Data using username")
    public void filter_Student_Data_using_username(){
        JsonPath jsonPath = response.jsonPath();
        List<String> actUsername = jsonPath.getList("findAll{it.username=='"+StudentUserName+"'}.username");
        System.out.println("actUsername = " + actUsername);
    }
    @Then("validate response data is the same with created Student Credentials")
    public void validate_response_data_is_the_same_with_created_student_credentials() {
    }
    @Given("get Student Data by username")
    public void get_Student_Data_by_username() throws SQLException {
        String query = "select * from student where username = '"+StudentUserName+"'";
        resultSet = DBUtils.executeQuery(query);
        resultSet.next();//To move the pointer to the records, we need to call next()
    }







}
