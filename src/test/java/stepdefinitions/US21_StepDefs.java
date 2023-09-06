package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.LoginPage;
import pages.StudentChooseLessonPage;
import utilities.ActionUtils;
import utilities.BrowserUtils;
import utilities.JSUtils;
import utilities.WaitUtils;

import static org.junit.Assert.assertTrue;

public class US21_StepDefs {
    StudentChooseLessonPage studentChooseLessonPage = new StudentChooseLessonPage();
    LoginPage loginPage = new LoginPage();

    @Given("user clicks on login link")
    public void user_clicks_on_login_link() {
        loginPage.loginLink.click();
    }

    @Given("user enters username {string}")
    public void user_enters_username(String string) {
        WaitUtils.waitFor(2);
        loginPage.userName.sendKeys(string);
    }
    @Given("user enters password {string}")
    public void user_enters_password(String string) {

        loginPage.password.sendKeys(string);
    }
    @Given("user clicks on login button")
    public void user_clicks_on_login_button() {
        loginPage.loginButton.click();
    }
    @Then("verify Teacher, Day, Start Time and Stop Time are visible")
    public void verify_teacher_day_start_time_and_stop_time_are_visible() {
        assertTrue(studentChooseLessonPage.teacherHeader.isDisplayed());
    }
    @Then("user selects a lesson")
    public void user_selects_a_lesson() {
        WaitUtils.waitFor(2);
        JSUtils.scrollIntoViewJS(studentChooseLessonPage.selectedLessonCheckBox1);
        JSUtils.clickWithTimeoutByJS(studentChooseLessonPage.selectedLessonCheckBox1);
    }
    @Then("user clicks on submit button")
    public void user_clicks_on_submit_button() {
        JSUtils.clickWithTimeoutByJS(studentChooseLessonPage.submitButton);
    }
    //TC01 FIX!!!!!!!!!!!!!!
    @Then("verify lesson added to student message appear")
    public void verify_lesson_added_to_student_message_appear() {
        //WaitUtils.waitForVisibility(studentChooseLessonPage.lessonAddedToStudentAlertMessage,5);
        assertTrue(studentChooseLessonPage.lessonAddedToStudentAlertMessage.getText().contains("Lesson added to student"));
    }
    //COMPLETE!!!!!!!!
    @Then("verify selected courses are visible in lesson program")
    public void verify_selected_courses_are_visible_in_lesson_program() {

    }

    //TC02
    @Then("verify course schedule cannot be selected for the same hour and day")
    public void verify_course_schedule_cannot_be_selected_for_the_same_hour_and_day() {
        WaitUtils.waitForVisibility(studentChooseLessonPage.collisionErrorAlertMessage,5);
        assertTrue(studentChooseLessonPage.collisionErrorAlertMessage.getText().contains("Course schedule cannot be selected for the same hour and day"));
    }

    //TC03

}
