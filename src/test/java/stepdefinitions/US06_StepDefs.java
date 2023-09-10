package stepdefinitions;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.CommonLocator;
import utilities.*;
import static org.junit.Assert.assertTrue;
public class US06_StepDefs {
    CommonLocator commonLocator =new CommonLocator();
    @Then("verify Vice Dean created successfully confirmation message")
    public void verifyViceDeanCreatedSuccessfullyConfirmationMessage() {
        WaitUtils.waitForVisibility(commonLocator.confirmationMessage, 5);
        assertTrue(commonLocator.confirmationMessage.getText().contains("Vice dean Saved"));
    }

    @Then("verify user name should contains at least four characters")
    public void verifyUserNameShouldContainsAtLeastFourCharacters() {
        WaitUtils.waitFor(3);
        try{
            Assert.assertTrue(BrowserUtils.alertText().contains("at least 4 characters"));
        }catch (Exception e){
            //exception handling
        }
    }
}




