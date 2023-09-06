package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utilities.Driver;
import utilities.WaitUtils;

public class CommonStepDefs {

    @Then("close the application")
    public void close_the_application() throws InterruptedException {

        Thread.sleep(1000);
        Driver.closeDriver();
    }

    @Given("user navigates to {string}")
    public void userNavigatesTo(String url) {
        WaitUtils.waitFor(2);
        Driver.getDriver().get(url);

    }


}
