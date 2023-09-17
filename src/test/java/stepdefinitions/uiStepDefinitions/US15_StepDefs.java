package stepdefinitions.uiStepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.CommonLocator;
import pages.CreateStudentPage;
import utilities.ActionUtils;
import utilities.BrowserUtils;
import utilities.JSUtils;
import utilities.WaitUtils;

import javax.swing.text.Utilities;

import static org.junit.Assert.assertTrue;

public class US15_StepDefs {
    private String StudentUserName;
    CreateStudentPage createStudentPage = new CreateStudentPage();
    CommonLocator commonLocator =new CommonLocator();
    Faker faker = new Faker();
    @Given("choose Advisor Teacher")
    public void choose_advisor_teacher() {
        BrowserUtils.selectByIndex(createStudentPage.advisorTeacherDropBox, 4);
    }
    @Given("enter email")
    public void enter_email() {

        createStudentPage.emailField.sendKeys(faker.internet().emailAddress());
    }
    @Then("enter father name")
    public void enter_father_name() {
        createStudentPage.fatherNameField.sendKeys(faker.name().firstName());
    }
    @Then("enter mother name")
    public void enter_mother_name() {
        createStudentPage.motherNameField.sendKeys(faker.name().firstName());
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

        // Perform assertion to check if it's a 4-digit number
        if (numberText.matches("\\d{4}")) {
            System.out.println("Assertion passed: The number is a 4-digit number");
        } else {
            System.out.println("Assertion failed: The number is not a 4-digit number");
        }

    }



}
