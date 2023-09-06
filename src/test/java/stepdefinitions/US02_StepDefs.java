package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import pages.Homepage;
import pages.Homepage;
import utilities.ConfigReader;
import utilities.Driver;

public class US02_StepDefs {
    //Homepage homepage = new Homepage();

    @Given("user goes to url")
    public void user_goes_to_url() {
        Driver.getDriver().get(ConfigReader.getProperty("ms_url"));
    }
    @When("User clicks on the login link")
    public void user_clicks_on_the_login_link() {
    }
    @When("User sends the user name")
    public void user_sends_the_user_name() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("User sends the password")
    public void user_sends_the_password() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("User clicks on the login button")
    public void user_clicks_on_the_login_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("Verify if the user logged in")
    public void verify_if_the_user_logged_in() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}