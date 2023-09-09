package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import pages.ViceDean_LessonManagementPage;
import utilities.Driver;
import utilities.JSUtils;
import utilities.WaitUtils;

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
        String lessonName = lessonManagement.lessonName.getText();

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

        System.out.println(lessonManagement.findLessonInLessonList(lessonName).getText());

        Assert.assertTrue(
                lessonManagement.findLessonInLessonList(lessonName).getText().contains(lessonName)
        );
    }

    @Then("Vice Dean clicks on the Delete icon to delete Lesson")
    public void vice_dean_clicks_on_the_delete_icon_to_delete_lesson() {
        lessonManagement.
    }
}
