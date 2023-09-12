package stepdefinitions.uiStepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pages.CommonLocator;
import pages.CreateViceDeanPage;
import pages.DeanCreatePage;
import utilities.JSUtils;
import utilities.WaitUtils;

import static org.junit.Assert.assertTrue;

public class US23_StepDefs {

    Faker faker = new Faker();
    CommonLocator commonLocator = new CommonLocator();

    CreateViceDeanPage createViceDeanPage=new CreateViceDeanPage();


    @Given("click Vice Dean Management Link")
    public void click_vice_dean_management_Link() {
        JSUtils.clickWithTimeoutByJS(createViceDeanPage.ViceDeanManagementLink);
    }


    @Given("verify Vice Dean created successfully confirmation message")
    public void verify_vice_dean_created_successfully_confirmation_message() {
        WaitUtils.waitForVisibility(commonLocator.confirmationMessage, 1000);
        assertTrue(commonLocator.confirmationMessage.getText().contains("Vice dean Saved"));
    }


}
