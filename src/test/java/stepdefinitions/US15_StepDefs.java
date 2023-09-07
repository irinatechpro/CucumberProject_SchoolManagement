package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.support.ui.Select;
import pages.CommonLocator;
import pages.CreateStudentPage;
import utilities.BrowserUtils;
import utilities.WaitUtils;

import static org.junit.Assert.assertTrue;

public class US15_StepDefs {
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
    }

    @Given("verify student created successfully confirmation message")
    public void verify_student_created_successfully_confirmation_message() {
        WaitUtils.waitForVisibility(commonLocator.confirmationMessage, 5);
        assertTrue(commonLocator.confirmationMessage.getText().contains("Student saved"));
    }

    @Then("verify submit fails")
    public void verify_submit_fails() {
       BrowserUtils.verifyElementNotDisplayed(commonLocator.confirmationMessage);
    }

}
