package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.CommonLocator;
import pages.CreateStudentPage;
import pages.ViceDeanTeacherManagementPage;
import utilities.*;

import static org.junit.Assert.assertTrue;

public class US13_StepDefs {
    CommonLocator commonLocator = new CommonLocator();
    CreateStudentPage createStudentPage=new CreateStudentPage();
    ViceDeanTeacherManagementPage viceDeanTeacherManagementPage=new ViceDeanTeacherManagementPage();
    Faker faker=new Faker();
    @Given("click TeacherManagementLink")
    public void click_teacher_management_link() {
        WaitUtils.waitFor(2);
        JSUtils.clickWithTimeoutByJS(viceDeanTeacherManagementPage.teacherManagementLink);
    }
    @Given("select lesson from choose lesson")
    public void select_lesson_from_choose_lesson() {
        WaitUtils.waitFor(2);
        ActionUtils.doubleClick(viceDeanTeacherManagementPage.chooseLesson);
 //       JSUtils.setValueByJS(viceDeanTeacherManagementPage.chooseLesson, "Java");
       viceDeanTeacherManagementPage.chooseLesson.sendKeys("Java",Keys.ENTER);
        WaitUtils.waitFor(3);

    }
    @Given("select teacher has advisory role")
    public void select_teacher_has_advisory_role() {
        viceDeanTeacherManagementPage.advisoryRole.click();
        WaitUtils.waitFor(3);

    }

    @Given("verify teacher created successfully confirmation message")
    public void verify_teacher_created_successfully_confirmation_message() {
        WaitUtils.waitForVisibility(commonLocator.confirmationMessage, 5);
        assertTrue(commonLocator.confirmationMessage.getText().contains("Teacher saved"));
        WaitUtils.waitFor(3);
    }

    @And("enter username for teacher")
    public void enterUsernameForTeacher() {
        String generatedUsername;
        do {
            generatedUsername = faker.name().username();
        } while (generatedUsername.length() <= 4);

        commonLocator.usernameField.sendKeys(generatedUsername);
        WaitUtils.waitFor(2);
    }
    @Given("enter Teacher Name")
    public void enter_teacher_name() {
        viceDeanTeacherManagementPage.teacherName.sendKeys(faker.name().firstName());
        WaitUtils.waitFor(2);
    }
    @Given("enter Teacher Surname")
    public void enter_teacher_surname() {
      commonLocator.surname.sendKeys(faker.name().lastName());
      WaitUtils.waitFor(2);
    }
    @Given("enter Teacher Birth Place")
    public void enter_teacher_birth_place() {
       commonLocator.birthplace.sendKeys(faker.country().capital());
       WaitUtils.waitFor(2);
    }
    @Given("enter Teacher email")
    public void enter_teacher_email() {
        createStudentPage.emailField.sendKeys(faker.internet().emailAddress());
        WaitUtils.waitFor(2);
    }
    @Given("enter Teacher valid phone number")
    public void enter_teacher_valid_phone_number() {
        // Generate a fake phone number as a string
        String phoneNumber = faker.phoneNumber().phoneNumber();

        // Format the phone number as XXX-XXX-XXXX
        String formattedPhoneNumber = BrowserUtils.formatPhoneNumber(phoneNumber);

        commonLocator.phoneNumberField.sendKeys(formattedPhoneNumber);
        WaitUtils.waitFor(3);
    }
    @Given("select Teacher Male Gender")
    public void select_teacher_male_gender() {
        commonLocator.genderMale.click();
        WaitUtils.waitFor(2);

    }
    @Then("enter Teacher date of birth")
    public void enter_teacher_date_of_birth() {
        commonLocator.dateOfBirth.sendKeys("25/05/1988");
        WaitUtils.waitFor(3);
    }
    @Then("enter Teacher valid SSN")
    public void enter_teacher_valid_ssn() {
        commonLocator.ssnField.sendKeys(faker.idNumber().ssnValid().toString());
        WaitUtils.waitFor(2);

    }


    @Then("verify fails Required")
    public void verifyFailsRequired() {
        assertTrue(viceDeanTeacherManagementPage.failRequired.isDisplayed());
    }

    @Then("verify fails At Least {int} Characters")
    public void verifyFailsAtLeastCharacters(int arg0) {
      assertTrue(commonLocator.passwordLessCharErrorMessage.isDisplayed());
    }

    @Then("verify submit fails for gender")
    public void verifySubmitFailsForGender() {
        assertTrue(viceDeanTeacherManagementPage.failForGender.isDisplayed());
    }
}
