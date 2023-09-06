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
    @Then("user selects Java and API")
    public void user_selects_java_and_api() {
        JSUtils.clickWithTimeoutByJS(studentChooseLessonPage.lessonsListColumnEnglish);
    }
    @Then("user clicks on submit button")
    public void user_clicks_on_submit_button() {
        studentChooseLessonPage.submitButton.click();
    }
    @Then("verify lesson added to student message appear")
    public void verify_lesson_added_to_student_message_appear() {

    }
    @Then("verify selected courses are visible in lesson program")
    public void verify_selected_courses_are_visible_in_lesson_program() {

    }

}
