package stepdefinitions.uiStepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.StudentChooseLessonPage;
import utilities.JSUtils;
import utilities.WaitUtils;

import java.util.List;

import static org.junit.Assert.*;

public class US21_StepDefs {
    StudentChooseLessonPage studentChooseLessonPage = new StudentChooseLessonPage();

    @Then("verify Teacher, Day, Start Time and Stop Time are visible")
    public void verify_teacher_day_start_time_and_stop_time_are_visible() {
        assertTrue(studentChooseLessonPage.teacherHeader.isDisplayed());
        assertTrue(studentChooseLessonPage.dayHeader.isDisplayed());
        assertTrue(studentChooseLessonPage.startTimeHeader.isDisplayed());
        assertTrue(studentChooseLessonPage.stopTimeHeader.isDisplayed());
    }
    // Get list of lessons before adding new one
    List<WebElement> allAddedLessons = studentChooseLessonPage.addedlessonsList.findElements(By.xpath("(//tbody)[2]/tr/td[1]"));
    int originalCount = allAddedLessons.size();

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

    //-------------------- TC01 -----------------------
    @Then("verify lesson added to student message appear")
    public void verify_lesson_added_to_student_message_appear() {
        WaitUtils.waitForVisibility(studentChooseLessonPage.lessonAddedToStudentAlertMessage, 2);
        assertTrue(studentChooseLessonPage.lessonAddedToStudentAlertMessage.isDisplayed());
    }

    @Then("verify selected courses are visible in lesson program")
    public void verify_selected_courses_are_visible_in_lesson_program() {

        // Get updated lessons list
        List<WebElement> updatedLessons = studentChooseLessonPage.addedlessonsList.findElements(By.xpath("(//tbody)[2]/tr/td[1]"));
        // Assert list size increased
        int updatedCount = updatedLessons.size();
        assertEquals(updatedCount, originalCount + 1);
    }

    //-------------------- TC02 -----------------------
    @Then("verify course schedule cannot be selected for the same hour and day")
    public void verify_course_schedule_cannot_be_selected_for_the_same_hour_and_day() {
        WaitUtils.waitForVisibility(studentChooseLessonPage.collisionErrorAlertMessage,5);
        assertTrue(studentChooseLessonPage.collisionErrorAlertMessage.getText().contains("Course schedule cannot be selected for the same hour and day"));
    }

    //-------------------- TC03 -----------------------
    @Given("verify added lesson still visible in the list")
    public void verify_added_lesson_still_visible_in_the_list() {
        //The added lesson still visible in the list
       assertTrue(studentChooseLessonPage.addedLesson.isDisplayed());
    }

    //-------------------- TC04 -----------------------
    @Given("user clicks on menu button")
    public void user_clicks_on_menu_button() {
        JSUtils.clickWithTimeoutByJS(studentChooseLessonPage.menuButton);
    }
    @Given("user clicks on grades and announcements")
    public void user_clicks_on_grades_and_announcements() {
        JSUtils.clickWithTimeoutByJS(studentChooseLessonPage.gradesAndAnnouncementsLink);
    }
    @Then("verify exam grades are visible")
    public void verify_exam_grades_are_visible() {
        //Find table body
        WebElement tableBody1 = studentChooseLessonPage.studentGradeList;
        assertTrue(tableBody1.isDisplayed());
    }
    @Then("verify meetings created by advisor is empty")
    public void verify_meetings_created_by_advisor_is_empty() {
        //Find table body
        WebElement tableBody2 = studentChooseLessonPage.studentMeetingList;

        //Assert table body text is empty
        assertTrue(tableBody2.getText().isEmpty());
    }

}
