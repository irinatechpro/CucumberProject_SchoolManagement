package stepdefinitions.uiStepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.ViceDean_LessonManagementPage;
import utilities.Driver;
import utilities.JSUtils;
import utilities.WaitUtils;

import java.util.List;

public class US09_StepDefs {

    ViceDean_LessonManagementPage lessonManagement = new ViceDean_LessonManagementPage();

    @Then("Vice Dean adds lesson to the lesson list")
    public void vice_dean_adds_lesson_to_the_lesson_list() {
        //Check if submit button is ready to be clicked
        //then click the submit button to create the lesson
        WaitUtils.waitForClickablility(lessonManagement.lessonsAddLessonSubmitButton, 15);
        lessonManagement.lessonsAddLessonSubmitButton.click();
        WaitUtils.waitFor(1);
    }

    @And("Vice Dean checks the created fields")
    public void viceDeanChecksTheCreatedFields() {

        //scroll to page pagination buttons for table
        JSUtils.scrollToElementThenScrollByAmount(lessonManagement.lessonListFinalPage, -500);

        //click the >> arrows in pagination for table to go to last part of table
        lessonManagement.lessonListFinalPage.click();
        WaitUtils.waitFor(1);

        //scroll to lesson in the table
        JSUtils.scrollIntoViewJS(lessonManagement.lessonListFinalPage);
        //Then scroll up a certain amount to bring into view
        WaitUtils.waitFor(1);
        JSUtils.scrollByAmount(-300);
        WaitUtils.waitFor(1);


        Assert.assertTrue(
                lessonManagement.findLessonInLessonList(US08_StepDefs.lessonNameTrack).isDisplayed()
        );
    }

    @Then("Vice Dean clicks on the Delete icon to delete Lesson")
    public void vice_dean_clicks_on_the_delete_icon_to_delete_lesson() {
        List<WebElement> tableRows = Driver.getDriver().findElements(By.xpath(
                "(//table)[2]//tbody//tr"
        ));

        for (WebElement tr : tableRows) {
            List<WebElement> tds = tr.findElements(By.tagName("td"));
            if (tds.get(0).getText().contains(US08_StepDefs.lessonNameTrack)) {
                WebElement deleteRow = tds.get(tds.size() - 1).findElement(By.cssSelector(".fa-trash"));
                deleteRow.click();
            }
        }

        //assert that the row is deleted
        WebElement deletedNotification = Driver.getDriver().findElement(By.xpath(
                "//div[@role='alert']//div[.='Lesson Deleted']"
        ));
        WaitUtils.waitForVisibility(deletedNotification, 15);
        Assert.assertTrue(deletedNotification.isDisplayed());
    }
}
