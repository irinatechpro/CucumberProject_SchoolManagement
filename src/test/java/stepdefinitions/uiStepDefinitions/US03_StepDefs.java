package stepdefinitions.uiStepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.ContactPage;
import utilities.JSUtils;
import utilities.WaitUtils;
import static org.junit.Assert.assertTrue;

public class US03_StepDefs {
    ContactPage contactPage = new ContactPage();

    @Given("user clicks on contact link")
    public void user_clicks_on_contact_link() {

        JSUtils.clickWithTimeoutByJS(contactPage.contactLink);
    }
    @Given("user enters name {string}")
    public void user_enters_name(String string) {
        WaitUtils.waitFor(2);
        contactPage.name.sendKeys(string);
    }
    @Given("user enters valid email address {string}")
    public void user_enters_valid_email_address(String string) {
        contactPage.email.sendKeys(string);
    }
    @Given("user enters subject {string}")
    public void user_enters_subject(String string) {
        contactPage.subject.sendKeys(string);
    }
    @Given("user enters message {string}")
    public void user_enters_message(String string) {
        contactPage.message.sendKeys(string);
    }
    @Given("user clicks on send message button")
    public void user_clicks_on_send_message_button() {
        JSUtils.clickWithTimeoutByJS(contactPage.sendMessageButton);
    }

    //-------------------- TC01 -----------------------
    @Then("verify contact message created successfully confirmation appear")
    public void verify_contact_message_created_successfully_confirmation_appear() {
        WaitUtils.waitForVisibility(contactPage.contactCreatedAlertMessage,5);
        assertTrue(contactPage.contactCreatedAlertMessage.getText().contains("Contact Message Created Successfully"));
    }

    //-------------------- TC02 -----------------------
    @Then("verify the required message is visible")
    public void verify_the_required_message_is_visible() {
        assertTrue(contactPage.requiredTextMessage.isDisplayed());
    }

    //-------------------- TC03 -----------------------
    @Then("verify please enter valid email message will appear")
    public void verify_please_enter_valid_email_message_will_appear() {
        WaitUtils.waitForVisibility(contactPage.invalidEmailAlertMessage,5);
        assertTrue(contactPage.invalidEmailAlertMessage.getText().contains("Please enter valid email"));
    }
}
