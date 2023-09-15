package stepdefinitions.uiStepDefinitions;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.AdminManagementPage;

public class US25_StepDefs {

    AdminManagementPage adminManagementPage = new AdminManagementPage();

    @Then("user sees title {string}")
    public void user_sees_title(String string) {
        Assert.assertTrue(adminManagementPage.adminManagementTitle.getText().contains("Admin Management"));
    }


}
