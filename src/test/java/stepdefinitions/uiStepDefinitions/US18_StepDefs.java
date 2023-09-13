package stepdefinitions.uiStepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;
import pages.LoginPage;
import pages.TeacherManageStudentsPage;
import utilities.Driver;
import utilities.JSUtils;
import utilities.WaitUtils;

public class US18_StepDefs {

    /**
     * ====================================================================
     *                         Background
     * ====================================================================
     */
    public LoginPage loginPage;
    public TeacherManageStudentsPage teacher;

    @Given("logged in as Teacher and viewing student info page")
    public void logged_in_as_teacher_and_viewing_student_info_page() {
        loginPage = new LoginPage();
        teacher = new TeacherManageStudentsPage();

        Driver.getDriver().get("https://managementonschools.com/login");

        //Assert URL is correct
        WaitUtils.waitForPageToLoad(15);
        Assert.assertEquals(
                "https://managementonschools.com/login",
                Driver.getDriver().getCurrentUrl()
        );

        //username and password to login
        loginPage.userName.sendKeys("w.dunk");
        loginPage.password.sendKeys("!Teacher.123");

        //click login button
        loginPage.loginButton.click();

        //wait for page to load again and assert URL
        WaitUtils.waitForVisibility(teacher.checkUsernameDisplayed, 15);
        Assert.assertEquals(
                "https://managementonschools.com/studentInfo",
                Driver.getDriver().getCurrentUrl()
        );

        //Scroll to table heading
        JSUtils.scrollToElementThenScrollByAmount(teacher.studentInfoListHeading, -202);
        WaitUtils.waitFor(1);
    }

    /**
     * ====================================================================
     *                         TC_01
     * ====================================================================
     */
    @Then("teacher can see student information")
    public void teacher_can_see_student_information() {

        //Check that data about student is visible
        Assert.assertTrue(
                teacher.tableRowAndData(2, "Elif Cakmak").isDisplayed()
        );
        System.out.println(
                "Table Data returned: " + teacher.tableRowAndData(2, "Elif Cakmak").getText()
        );
    }

    /**
     * ====================================================================
     *                         TC_02
     * ====================================================================
     */
    @Then("teacher clicks the edit button")
    public void teacher_clicks_the_edit_button() {
        //table//tr[1]//td[.='']
        teacher.tableRowAndData(2, 9).click();
        WaitUtils.waitForVisibility(teacher.editStudentInfoHeading, 15);

        Assert.assertEquals(
                "Edit Student Info",
                teacher.editStudentInfoHeading.getText()
        );
    }

    @Then("teacher is able to update student grade information")
    public void teacher_is_able_to_update_student_grade_information() {

        //Type student grade data
        teacher.midTermGrade.sendKeys(Keys.COMMAND + "a");
        teacher.midTermGrade.sendKeys(Keys.DELETE);

        String newGrade = "8";
        teacher.midTermGrade.sendKeys(newGrade);

        //Submit and update student data
        teacher.submitAndUpdateStudentInfo.click();

        //close student update modal
        teacher.closeStudentUpdateModal.click();

        //Wait for student data to show in table
        WaitUtils.waitForVisibility(teacher.tableRowAndData(2, 4), 15);

        //Verify student grade is updated
        Assert.assertEquals(
                teacher.tableRowAndData(2, 4).getText(),
                newGrade
        );
    }

    /**
     * ====================================================================
     *                         TC_03
     * ====================================================================
     */
    @Then("teacher clicks on the delete button to delete student grade information")
    public void teacher_clicks_on_the_delete_button_to_delete_student_grade_information() {
        teacher.tableRowAndData(1, "").click();

        WaitUtils.waitFor(1);
        Assert.assertEquals("Elif Cakmak", teacher.tableRowAndData(1, 1).getText());
    }
}
