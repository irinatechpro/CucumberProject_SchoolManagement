package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.*;
import utilities.JSUtils;
import utilities.WaitUtils;

import static org.junit.Assert.assertTrue;

public class US24_StepDefs {
    TeacherMeetManagementPage teacherMeetManagementPage = new TeacherMeetManagementPage();
    ViceDean_AdminManagementPage viceDeanAdminManagementPage = new ViceDean_AdminManagementPage();

    ViceDean_LessonManagementPage viceDeanLessonManagementPage=new ViceDean_LessonManagementPage();
    CommonLocator commonLocator =new CommonLocator();

//    @Given("click Teacher Management Link")
//    public void click_teacher_management_link() {
//        JSUtils.clickWithTimeoutByJS(teacherMeetManagementPage.teacherManagementLInk);
//    }

    @Then("select is Advisor Teacher")
    public void select_is_Advisor_Teacher() {
        JSUtils.clickWithTimeoutByJS(teacherMeetManagementPage.isAdvisorTeacher);
    }

    @Given("enter Invalid Password")
    public void enter_Invalid_Password() {
        teacherMeetManagementPage.lastTeacherPassword.sendKeys("abcd1234");
        WaitUtils.waitFor(3);

    }


    @Then("verify passwordWithoutUpperCaseErrorMessage")
    public void verify_password_without_upper_case_error_message() {
        WaitUtils.waitForVisibility(commonLocator.passwordWithoutUpperCaseErrorMessage, 5);
        assertTrue(commonLocator.passwordWithoutUpperCaseErrorMessage.isDisplayed());
        WaitUtils.waitFor(3);

    }
    ContactPage contactPage=new ContactPage();
    @Given("enter existing email")
    public void enter_existing_email() {
        contactPage.email.sendKeys("yaseen.beckhem@feerock.com");

    }
    @Then("verify existingEmailMasage")
    public void verify_existing_email_masage() {
        WaitUtils.waitForVisibility(commonLocator.existingEmailMasage, 5);
        assertTrue(commonLocator.existingEmailMasage.isDisplayed());
        WaitUtils.waitFor(3);

    }








}





