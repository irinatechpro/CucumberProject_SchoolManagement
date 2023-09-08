package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import pages.ViceDeanLessonProgram;
import pages.ViceDean_AdminManagementPage;
import pages.ViceDean_LessonManagementPage;
import utilities.BrowserUtils;
import utilities.Driver;
import utilities.JSUtils;
import utilities.WaitUtils;

public class US10_StepDef {
    ViceDeanLessonProgram viceDeanLessonProgram = new ViceDeanLessonProgram();
    ViceDean_LessonManagementPage viceDeanLessonManagementPage = new ViceDean_LessonManagementPage();
    ViceDean_AdminManagementPage viceDeanAdminManagementPage=new ViceDean_AdminManagementPage();
    Faker faker = new Faker();

    @Given("click Lesson Management")
    public void click_lesson_menagement() {

           JSUtils.clickWithTimeoutByJS(viceDeanAdminManagementPage.toggleMenu_lessonManagement);



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
      BrowserUtils.selectByVisibleText(viceDeanLessonManagementPage.startTime,"13:00");
        WaitUtils.waitFor(3);
    }
    @Given("choose stop time")
    public void choose_stop_time() {
   BrowserUtils.selectByVisibleText(viceDeanLessonManagementPage.stopTime,"14:00");
    }
    @Given("user clicks submit button")
    public void user_clicks_submit_button() {
        WaitUtils.waitFor(2);

        JSUtils.clickWithTimeoutByJS(viceDeanLessonManagementPage.lessonsAddLessonSubmitButton);

    }






}


