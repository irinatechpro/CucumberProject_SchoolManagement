package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.interactions.Actions;
import pages.CommonLocator;
import pages.RegisterPage;
import utilities.BrowserUtils;
import utilities.Driver;
import utilities.JSUtils;

import static utilities.WaitUtils.waitFor;

public class US01_StepDefs {
    RegisterPage registerPage = new RegisterPage();
    CommonLocator commonLocator = new CommonLocator();
    @And("user clicks on register link")
    public void userClicksOnRegisterLink() {
        JSUtils.clickWithTimeoutByJS(registerPage.registerLink);
    }


    @And("user enters surname {string}")
    public void userEntersSurname(String arg0) {
        waitFor(2);
        registerPage.surname.sendKeys(arg0);
    }

    @And("user enters birthplace {string}")
    public void userEntersBirthplace(String arg0) {
        waitFor(2);
        registerPage.birthPlace.sendKeys(arg0);
    }

    @And("user enters phone number {string}")
    public void userEntersPhoneNumber(String arg0) {
        waitFor(2);
        registerPage.phoneNumber.sendKeys(arg0);
    }

    @And("user clicks on radio button")
    public void userClicksOnRadioButton() {
       waitFor(2);
        Actions actions = new Actions(Driver.getDriver());
        actions.scrollByAmount(0,250);
        actions.perform();
        waitFor(2);
       registerPage.femaleRadioButton.click();
    }

    @And("user enter date of birth {string}")
    public void userEnterDateOfBirth(String arg0) {
        waitFor(2);
        registerPage.dateOfBirth.sendKeys(arg0);
    }

    @And("user enters ssn {string}")
    public void userEntersSsn(String arg0) {
        waitFor(2);
        Actions actions = new Actions(Driver.getDriver());
        actions.scrollByAmount(0,250);
        actions.perform();
        waitFor(2);
        registerPage.ssn.sendKeys(arg0);
    }

    @And("user clicks on register button")
    public void userClicksOnRegisterButton() {
        waitFor(2);
        registerPage.registerButton.click();
    }

    @Then("verify Guest User registered alert is seen")
    public void verifyGuestUserRegisteredAlertIsSeen() {
        waitFor(1);
        BrowserUtils.verifyElementDisplayed(commonLocator.confirmationMessage);
    }
}
