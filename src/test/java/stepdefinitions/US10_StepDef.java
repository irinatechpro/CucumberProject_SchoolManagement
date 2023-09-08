package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import pages.CommonLocator;
import pages.ViceDeanLessonProgram;
import pages.ViceDean_AdminManagementPage;
import pages.ViceDean_LessonManagementPage;
import utilities.BrowserUtils;
import utilities.Driver;
import utilities.JSUtils;
import utilities.WaitUtils;

import static org.junit.Assert.assertTrue;

public class US10_StepDef {
    ViceDeanLessonProgram viceDeanLessonProgram = new ViceDeanLessonProgram();
    ViceDean_LessonManagementPage viceDeanLessonManagementPage = new ViceDean_LessonManagementPage();
    ViceDean_AdminManagementPage viceDeanAdminManagementPage=new ViceDean_AdminManagementPage();
    CommonLocator commonLocator=new CommonLocator();
    Faker faker = new Faker();

    @Given("click lesson management")
    public void click_lesson_management() {
        JSUtils.clickWithTimeoutByJS(commonLocator.lessonManagementLink);
    }
    @Given("click lesson program last")
    public void click_lesson_program_last(){
        JSUtils.clickWithTimeoutByJS(viceDeanLessonProgram.fakingbutton);
    }
    @Given("choose Lesson")
    public void choose_lesson(){

       viceDeanLessonManagementPage.getSelectionChooseLesson.sendKeys("Selenium"+ Keys.ENTER);
        WaitUtils.waitFor(5);


        }
    @Given("choose education term")
    public void choose_education_term() {
     BrowserUtils.selectByVisibleText(viceDeanLessonManagementPage.getSelectionChooseEducationTerm,"FALL_SEMESTER");
     WaitUtils.waitFor(3);
    }

    @Given("chose day")
    public void chose_day() {
    BrowserUtils.selectByVisibleText(viceDeanLessonManagementPage.getSelectionChooseDay,"MONDAY");
        WaitUtils.waitFor(3);
    }
    @Given("choose start time")
    public void choose_start_time() {

      viceDeanLessonManagementPage.startTime.sendKeys("13:00");

    }
    @Given("choose stop time")
    public void choose_stop_time() {

        viceDeanLessonManagementPage.stopTime.sendKeys("14:00");
    }
    @Given("user clicks submit button")
    public void user_clicks_submit_button() {
WaitUtils.waitForVisibility(viceDeanAdminManagementPage.toggleMenu_viceDeanManagement,2);


        }
    @Then("verify lesson  is created")
    public void verify_lesson_is_created() {
        WaitUtils.waitForVisibility(viceDeanLessonProgram.createdLessonVisible,5);
    }
    @Then("verify selected courses are visible in lesson program ")
    public void verify_selected_courses_are_visible_in_lesson_program() {
       assertTrue(viceDeanLessonProgram.createdLessonVisible.isDisplayed());

    }



}









