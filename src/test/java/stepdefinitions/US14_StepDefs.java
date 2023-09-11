package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.ViceDeanTeacherManagementPage;
import pages.ViceDean_AdminManagementPage;
import utilities.Driver;
import utilities.JSUtils;
import utilities.WaitUtils;

public class US14_StepDefs {

    ViceDean_AdminManagementPage viceDeanAdminManagementPage = new ViceDean_AdminManagementPage();
    ViceDeanTeacherManagementPage viceDeanTeacherManagementPage = new ViceDeanTeacherManagementPage();

    /**
     * ====================================================================
     *                         TC_01
     * ====================================================================
     */
    @Then("Vice Dean clicks on Teacher Management menu link")
    public void vice_dean_clicks_on_teacher_management_menu_link() {
        viceDeanAdminManagementPage.navMenuButton.click();

        WaitUtils.waitFor(2);
        Assert.assertEquals("Teacher Management", viceDeanAdminManagementPage.toggleMenu_deanManagement.getText());
        viceDeanAdminManagementPage.toggleMenu_deanManagement.click();
        WaitUtils.waitForPageToLoad(15);
    }
    @When("the Teacher Information page loads")
    public void the_teacher_information_page_loads() {
        Assert.assertEquals(
                Driver.getDriver().getCurrentUrl(),
                "https://managementonschools.com/teacher"
        );
    }
    @Then("Vice Dean should see teacher information")
    public void vice_dean_should_see_teacher_information() {
        viceDeanTeacherManagementPage.checkTeacherInformationInTable();
    }

    /**
     * ====================================================================
     *                         TC_02
     * ====================================================================
     */
    @And("Vice Dean should be able to update teacher information")
    public void viceDeanShouldBeAbleToUpdateTeacherInformation() {
        viceDeanTeacherManagementPage.createTeacher();
        viceDeanTeacherManagementPage.updateTeacherInformationAndCheckUpdate();
    }
}
