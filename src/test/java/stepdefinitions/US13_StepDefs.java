package stepdefinitions;

import io.cucumber.java.en.Given;
import pages.CommonLocator;
import utilities.WaitUtils;

import static org.junit.Assert.assertTrue;

public class US13_StepDefs {
    CommonLocator commonLocator = new CommonLocator();

    @Given("verify teacher created successfully confirmation message")
    public void verify_teacher_created_successfully_confirmation_message() {
        WaitUtils.waitForVisibility(commonLocator.confirmationMessage, 5);
        assertTrue(commonLocator.confirmationMessage.getText().contains("Teacher saved"));
    }
}
