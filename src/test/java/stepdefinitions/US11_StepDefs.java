package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.ViceDean_LessonManagementPage;
import utilities.ActionUtils;
import utilities.MediaUtils;
import utilities.WaitUtils;
import java.io.IOException;
public class US11_StepDefs {
    ViceDean_LessonManagementPage viceDean_lessonManagementPage = new ViceDean_LessonManagementPage();

    //US11_TC01
    @When("Management page loads up")
    public void management_page_loads_up() {
        Assert.assertTrue(viceDean_lessonManagementPage.lessonProgram.isDisplayed());
        WaitUtils.waitFor(1);
    }
    @Then("click Lesson Program")
    public void click_lesson_program() {
        viceDean_lessonManagementPage.lessonProgram.click();
        WaitUtils.waitFor(3);
    }
    @Then("scroll down until see Lesson Program")
    public void scroll_down_until_see_lesson_program() {
        ActionUtils.scrollDownActions();
        WaitUtils.waitForVisibility(viceDean_lessonManagementPage.lessonProgram, 1);
        Assert.assertTrue(viceDean_lessonManagementPage.lessonProgram.isDisplayed());
        WaitUtils.waitFor(3);

    @When("enter password {string}")
    public void enter_password(String string) {loginPage.password.sendKeys(string);
    }
    @When("click on login button")
    public void click_on_login_button() { loginPage.loginButton.click();
    }
    @When("click on Menu button")
    public void click_on_menu_button() { commonLocator.menuButton.click();
    }
    @When("click on Lesson Management Link")
    public void click_on_lesson_management_link() { viceDean_adminManagementPage.toggleMenu_adminManagement.click();
    }
    @When("click Lesson Program")
    public void click_lesson_program() {viceDean_lessonManagementPage.lessonProgram.click();
    }
    @When("select lesson type {string}")
    public void select_lesson_type(String lessonType) {
        WaitUtils.waitFor(10);
       new Select(viceDean_lessonManagementPage.getSelectionChooseLesson1).selectByVisibleText(lessonType);
        // viceDean_lessonManagementPage.lessonProgram.click();
    }
    @When("select day type {string}")
    public void select_day_tupe(String dayType) {
        new Select (viceDean_lessonManagementPage.getSelectionChooseDay).selectByValue(dayType);

    }
    @When("choose Education Term")
    public void choose_education_term() {
      //  viceDean_lessonManagementPage.getSelectionChooseLesson.sele;click();

    }
    //@When("enter Start Time")
    //public void enter_start_time() {

    //}
    //@When("enter Stop Time")
    //public void enter_stop_time() {

    //}
    @When("user clicks Submit button")
    public void user_clicks_submit_button() {

    }
    @Then("verify {string} message is appear")
    public void verify_message_is_appear(String string) {


    }
    @Then("verify Lesson, Day, Start Time and Stop Time created are visible")
    public void verifyLessonDayStartTimeAndStopTimeCreatedAreVisible() {
        Assert.assertTrue(viceDean_lessonManagementPage.lessonsTab.isDisplayed());
        Assert.assertTrue(viceDean_lessonManagementPage.stopTime.isDisplayed());
        Assert.assertTrue(viceDean_lessonManagementPage.startTime.isDisplayed());
        Assert.assertTrue(viceDean_lessonManagementPage.getSelectionChooseDay.isDisplayed());
        WaitUtils.waitFor(1);
    }
    //US11_TC02
    @And("verify update Button exists")
    public void verifyUpdateButtonExists() {
        try {
            MediaUtils.takeScreenshotOfTheEntirePage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    //US11_TC03
    @Then("verify Delete button is visible")
    public void verifyDeleteButtonIsVisible() {

            try {
                MediaUtils.takeScreenshotOfTheEntirePage();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
















