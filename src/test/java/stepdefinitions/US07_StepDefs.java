package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.Keys;
import pages.DeanContactGetAll;
import utilities.BrowserUtils;
import utilities.MediaUtils;

import java.io.IOException;

public class US07_StepDefs {
    DeanContactGetAll deanContactGetAll = new DeanContactGetAll();
    @And("login as a Dean")
    public void loginAsADean() {
        deanContactGetAll.homepageLoginIcon.click();
        deanContactGetAll.usernameField.sendKeys("DeanVena");
        deanContactGetAll.passwordField.sendKeys("DeanVena11"+ Keys.ENTER);
    }

    @And("click Menu button")
    public void clickMenuButton() {
        deanContactGetAll.menuButton.click();
    }

    @And("click Contact Get All button")
    public void clickContactGetAllButton() {
        deanContactGetAll.contactGetAllButton.click();
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
        BrowserUtils.verifyElementDisplayed(deanContactGetAll.verifyMessageIsSeen);
    }

    @Then("verify Name is seen")
    public void verifyNameIsSeen() {
        BrowserUtils.verifyElementDisplayed(deanContactGetAll.verifyNameIsSeen);
    }

    @Then("verify Email is seen")
    public void verifyEmailIsSeen() {
        BrowserUtils.verifyElementDisplayed(deanContactGetAll.verifyEmailIsSeen);
    }

    @Then("verify Date is seen")
    public void verifyDateIsSeen() {
        BrowserUtils.verifyElementDisplayed(deanContactGetAll.verifyDateIsSeen);
    }

    @Then("verify Subject is seen")
    public void verifySubjectIsSeen() {
        BrowserUtils.verifyElementDisplayed(deanContactGetAll.verifySubjectIsSeen);
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
