package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.DeanContactGetAll;
import utilities.ActionUtils;
import utilities.BrowserUtils;
import utilities.Driver;
import utilities.MediaUtils;

import java.io.IOException;

import static utilities.WaitUtils.waitFor;

public class US07_StepDefs {
    DeanContactGetAll deanContactGetAll = new DeanContactGetAll();
    @And("login as a Dean")
    public void loginAsADean() {
        waitFor(2);
        deanContactGetAll.homepageLoginIcon.click();
        waitFor(2);
        deanContactGetAll.usernameField.sendKeys("DeanVena");
        waitFor(2);
        deanContactGetAll.passwordField.sendKeys("DeanVena11");
        waitFor(2);
        Actions actions = new Actions(Driver.getDriver());
        actions.scrollByAmount(0,250);
        deanContactGetAll.loginButton.click();

    }

    @And("click Menu button")
    public void clickMenuButton() {
        waitFor(2);
        deanContactGetAll.menuButton.click();
    }

    @And("click Contact Get All button")
    public void clickContactGetAllButton() {
        waitFor(2);
        deanContactGetAll.contactGetAllButton.click();
        waitFor(2);
    }

    @Then("verify delete button is seen")
    public void verifyDeleteButtonIsSeen() {
        try {
            MediaUtils.takeScreenshotOfTheEntirePage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("verify message is seen")
    public void verifyMessageIsSeen() {
        waitFor(2);
        BrowserUtils.verifyElementDisplayed(deanContactGetAll.verifyMessageIsSeen);
    }

    @Then("verify Name is seen")
    public void verifyNameIsSeen() {
        waitFor(2);
        BrowserUtils.verifyElementDisplayed(deanContactGetAll.verifyNameIsSeen);
    }

    @Then("verify Email is seen")
    public void verifyEmailIsSeen() {
        waitFor(2);
        BrowserUtils.verifyElementDisplayed(deanContactGetAll.verifyEmailIsSeen);
    }

    @Then("verify Date is seen")
    public void verifyDateIsSeen() {
        waitFor(2);
        BrowserUtils.verifyElementDisplayed(deanContactGetAll.verifyDateIsSeen);
    }

    @Then("verify Subject is seen")
    public void verifySubjectIsSeen() {
        waitFor(2);
        BrowserUtils.verifyElementDisplayed(deanContactGetAll.verifySubjectIsSeen);
        waitFor(2);
    }

    @Then("verify message is deleted")
    public void verifyMessageIsDeleted() {
        try {
            MediaUtils.takeScreenshotOfTheEntirePage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
