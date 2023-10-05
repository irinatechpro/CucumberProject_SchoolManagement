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
    public static String StudentUserName;

    private static String advisorTeacher;
    public static String studentEmail;
    public static String studentFatherName;
    public static String studentMotherName;
    public static String numberText;
    CreateStudentPage createStudentPage = new CreateStudentPage();
    CommonLocator commonLocator = new CommonLocator();
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

}
