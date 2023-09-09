package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import pages.CommonLocator;
import pages.CreateStudentPage;
import pages.DeanCreatePage;
import utilities.Driver;
import utilities.JSUtils;
import utilities.WaitUtils;

import static org.junit.Assert.assertTrue;

public class US04_StepDefs {

    Faker faker = new Faker();
    CommonLocator commonLocator = new CommonLocator();

    DeanCreatePage deanCreatePage=new DeanCreatePage();



    @Given("click Dean Management Link")
    public void click_Dean_Management_Link() {
        JSUtils.clickWithTimeoutByJS(deanCreatePage.deanManagementLink);
        JSUtils.scrollAllTheWayUpJS();
    }


    @Given("verify dean created successfully confirmation message")
    public void verify_dean_created_successfully_confirmation_message() {
        WaitUtils.waitForVisibility(commonLocator.confirmationMessage, 2);
        assertTrue(commonLocator.confirmationMessage.getText().contains("Dean Saved"));
    }

    @Given("verify dean created unsuccessfully confirmation message")
    public void verify_dean_created_unsuccessfully_confirmation_message() {
        WaitUtils.waitForVisibility(commonLocator.confirmationMessage, 5);
        assertTrue(commonLocator.confirmationMessage.getText().contains("Dean saved"));
    }

    @And("verify dean number created automatically")
    public void verifyDeanNumberCreatedAutomatically() {
    }


    @And("verify dean number uncreated automatically")
    public void verifyDeanNumberUnCreatedAutomatically() {
    }

//    @And("enter username {string}")
//    public void enterUsername(String username) {
//        commonLocator.usernameField.sendKeys(faker.name().firstName());
//    }

//   ?? @Then("enter dean username")
//    public void enter_dean_username() {
//        DeanUserName = faker.name().username();
//        commonLocator.usernameField.sendKeysDeanUserName);
//        WaitUtils.waitFor(2);
//    }
//
//    @And("enter password {string}")
//    public void enterPassword(String password) {
//        commonLocator.passwordField.sendKeys(password);
//    }


//    @Then("verify dean number created automatically")
//    public void verify_dean_number_created_automatically() {
//        WaitUtils.waitFor(5);
//        JSUtils.scrollIntoViewJS(deanCreatePage.lastRow);
//        WaitUtils.waitFor(5);
//        String lastRow = deanCreatePage.lastRow.getText();
//        System.out.println("lastRow = " + lastRow);
//        Assert.assertTrue(lastRow.contains(DeanUserName));
//        String numberText = CreateStudentPage.firstColumnInLastRow.getText();
//
//        // Perform assertion to check if it's a 4-digit number
//        if (numberText.matches("\\d{4}")) {
//            System.out.println("Assertion passed: The number is a 4-digit number");
//        } else {
//            System.out.println("Assertion failed: The number is not a 4-digit number");
//        }
//
//    }


    }



