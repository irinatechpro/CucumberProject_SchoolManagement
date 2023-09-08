package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.DeanContactGetAllPage;
import utilities.BrowserUtils;
import utilities.MediaUtils;

import java.io.IOException;

import static utilities.WaitUtils.waitFor;

public class US07_StepDefs {
    DeanContactGetAllPage deanContactGetAllPage = new DeanContactGetAllPage();
    @And("click Contact Get All button")
    public void clickContactGetAllButton() {
        waitFor(2);
        deanContactGetAllPage.contactGetAllButton.click();
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
        BrowserUtils.verifyElementDisplayed(deanContactGetAllPage.verifyMessageIsSeen);
    }

    @Then("verify Name is seen")
    public void verifyNameIsSeen() {
        waitFor(2);
        BrowserUtils.verifyElementDisplayed(deanContactGetAllPage.verifyNameIsSeen);
    }

    @Then("verify Email is seen")
    public void verifyEmailIsSeen() {
        waitFor(2);
        BrowserUtils.verifyElementDisplayed(deanContactGetAllPage.verifyEmailIsSeen);
    }

    @Then("verify Date is seen")
    public void verifyDateIsSeen() {
        waitFor(2);
        BrowserUtils.verifyElementDisplayed(deanContactGetAllPage.verifyDateIsSeen);
    }

    @Then("verify Subject is seen")
    public void verifySubjectIsSeen() {
        waitFor(2);
        BrowserUtils.verifyElementDisplayed(deanContactGetAllPage.verifySubjectIsSeen);
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
