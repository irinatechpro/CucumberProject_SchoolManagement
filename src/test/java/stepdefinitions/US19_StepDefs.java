package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import pages.TeacherMeetManagementPage;
import utilities.BrowserUtils;
import utilities.JSUtils;
import utilities.MediaUtils;
import utilities.WaitUtils;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static utilities.WaitUtils.waitFor;

public class US19_StepDefs {
    TeacherMeetManagementPage teacherMeetManagementPage= new TeacherMeetManagementPage();
    @And("click Meet Management button")
    public void clickMeetManagementButton() {
        waitFor(2);
        teacherMeetManagementPage.meetManagementButton.click();
    }


    @And("select Student from Choose Students DDM")
    public void selectStudentFromChooseStudentsDDM() {
        waitFor(4);
        teacherMeetManagementPage.chooseStudentsArea.sendKeys("Bruce Lee",Keys.ENTER);
    }

    @Then("verify Choose Students is selected")
    public void verifyChooseStudentsIsSelected() {
        waitFor(2);
        try {
            MediaUtils.takeScreenshotOfThisElement(teacherMeetManagementPage.verifyElementsAtAddMeetAreEdited);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @And("enter Start Time")
    public void enterStartTime() {
        waitFor(2);
        teacherMeetManagementPage.startTimeArea.sendKeys("11:00");
    }

    @Then("verify Start Time is entered")
    public void verifyStartTimeIsEntered() {
        waitFor(2);
        try {
            MediaUtils.takeScreenshotOfThisElement(teacherMeetManagementPage.verifyElementsAtAddMeetAreEdited);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @And("enter Stop Time")
    public void enterStopTime() {
        waitFor(2);
        teacherMeetManagementPage.stopTimeArea.sendKeys("12:00");
    }

    @Then("verify Stop Time is entered")
    public void verifyStopTimeIsEntered() {
        waitFor(2);
        try {
            MediaUtils.takeScreenshotOfThisElement(teacherMeetManagementPage.verifyElementsAtAddMeetAreEdited);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @And("enter Description")
    public void enterDescription() {
        waitFor(2);
        teacherMeetManagementPage.descriptionArea.sendKeys("Vocabulary");
    }

    @Then("verify Description is entered")
    public void verifyDescriptionIsEntered() {
        waitFor(2);
        try {
            MediaUtils.takeScreenshotOfThisElement(teacherMeetManagementPage.verifyElementsAtAddMeetAreEdited);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @And("select Date Of Meet meeting time")
    public void selectDateOfMeetMeetingTime() {
        waitFor(2);
        LocalDate current = LocalDate.now().plusMonths(1);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String validDate = dtf.format(current);
        teacherMeetManagementPage.dateOfMeetArea.sendKeys(validDate);
    }

    @Then("verify Date of Meet meeting time is selected")
    public void verifyDateOfMeetMeetingTimeIsSelected() {
        waitFor(2);
        try {
            MediaUtils.takeScreenshotOfThisElement(teacherMeetManagementPage.verifyElementsAtAddMeetAreEdited);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @And("select Date Of Meet meeting time with past date")
    public void selectDateOfMeetMeetingTimeWithPastDate() {
        waitFor(2);
        LocalDate current = LocalDate.now().minusMonths(1);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String pastDate = dtf.format(current);
        teacherMeetManagementPage.dateOfMeetArea.sendKeys(pastDate);
    }

    @And("click on Submit button")
    public void clickOnSubmitButton() {
        waitFor(2);
        teacherMeetManagementPage.submitButtonAddMeet.click();
    }

    @Then("verify İleri bir tarih olmalı alert is seen")
    public void verifyİleriBirTarihOlmalıAlertIsSeen() {
        waitFor(1);
        BrowserUtils.verifyElementDisplayed(teacherMeetManagementPage.ileriBirTarihOlmalıAlert);
    }

    @Then("verify meeting is not created")
    public void verifyMeetingIsNotCreated() {
        waitFor(2);
        try {
            MediaUtils.takeScreenshotOfTheEntirePage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
