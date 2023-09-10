package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.interactions.Actions;
import pages.CommonLocator;
import pages.RegisterPage;
import utilities.BrowserUtils;
import utilities.Driver;
import utilities.JSUtils;
import utilities.MediaUtils;

import java.io.IOException;

import static utilities.WaitUtils.waitFor;

public class US01_StepDefs {
    RegisterPage registerPage = new RegisterPage();
    CommonLocator commonLocator = new CommonLocator();
    Faker faker = new Faker();
    @And("user clicks on register link")
    public void userClicksOnRegisterLink() {
        JSUtils.clickWithTimeoutByJS(registerPage.registerLink);
    }


    @And("user enters surname {string}")
    public void userEntersSurname(String arg0) {
        waitFor(2);
        registerPage.surname.sendKeys(faker.name().firstName());
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

//    @And("user enters ssn {string}")
//    public void userEntersSsn(String arg0) {
//        waitFor(2);
//        Actions actions = new Actions(Driver.getDriver());
//        actions.scrollByAmount(0,250);
//        actions.perform();
//        waitFor(2);
//        registerPage.ssn.sendKeys(arg0);
//    }

    @And("user clicks on register button")
    public void userClicksOnRegisterButton() {
        waitFor(2);
        Actions actions = new Actions(Driver.getDriver());
        actions.scrollByAmount(0,250);
        actions.perform();
        registerPage.registerButton.click();
    }

    @Then("verify Guest User registered alert is seen")
    public void verifyGuestUserRegisteredAlertIsSeen() throws IOException {
        waitFor(1);
        BrowserUtils.verifyExpectedAndActualTextMatch("Guest User registered.",registerPage.userRegisteredText);
       //BrowserUtils.verifyElementDisplayed(commonLocator.confirmationMessage);
        //MediaUtils.takeScreenshotOfThisElement(commonLocator.confirmationMessage);

    }

    @And("user enters user name {string}")
    public void userEntersUserName(String arg0) {
        waitFor(2);
        registerPage.userName.sendKeys(faker.name().firstName());
    }

    @Then("verify blank field required message")
    public void verifyBlankFieldRequiredMessage() {
        BrowserUtils.verifyExpectedAndActualTextMatch("Required",registerPage.requiredMessage);
    }


    @And("enter invalid phone number")
    public void enterInvalidPhoneNumber() {
        registerPage.phoneNumber.sendKeys("------------");
    }

    @Then("verify Invalid phone number alert is seen")
    public void verifyInvalidPhoneNumberAlertIsSeen() {
        BrowserUtils.verifyExpectedAndActualTextMatch("Please enter valid phone number",registerPage.invalidPhoneNumberMessage);
    }

    @And("enter invalid ssn number")
    public void enterInvalidSsnNumber() {
        registerPage.ssn.sendKeys("-----------");
    }

    @Then("verify Invalid SSN number alert is seen")
    public void verifyInvalidSSNNumberAlertIsSeen() {
        BrowserUtils.verifyExpectedAndActualTextMatch("Please enter valid SSN number",registerPage.invalidSSNNumberMessage);
    }

    @Then("verify invalid password message seen")
    public void verifyInvalidPasswordMessageSeen() {
        BrowserUtils.verifyExpectedAndActualTextMatch("At least 8 characters",registerPage.invalidPassword);
    }
}
