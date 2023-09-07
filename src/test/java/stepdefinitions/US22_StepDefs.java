package stepdefinitions;

import io.cucumber.java.en.Given;
import utilities.WaitUtils;
import pages.CommonLocator;


import static org.junit.Assert.assertTrue;

public class US22_StepDefs {
    CommonLocator commonLocator =new CommonLocator();

    @Given("verify admin created successfully confirmation message")
    public void verify_admin_created_successfully_confirmation_message() {
        WaitUtils.waitForVisibility(commonLocator.confirmationMessage, 5);
        assertTrue(commonLocator.confirmationMessage.getText().contains("Admin saved"));
    }
}
