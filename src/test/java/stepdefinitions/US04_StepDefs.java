package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.interactions.Actions;
import pages.CommonLocator;
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
    }




    @Given("verify dean created successfully confirmation message")
    public void verify_dean_created_successfully_confirmation_message() {
        WaitUtils.waitForVisibility(commonLocator.confirmationMessage, 5);
        assertTrue(commonLocator.confirmationMessage.getText().contains("Dean saved"));
    }



    @And("enter username {string}")
    public void enterUsername(String username) {
        commonLocator.usernameField.sendKeys(faker.name().firstName());
    }

    @And("enter password {string}")
    public void enterPassword(String password) {
        commonLocator.passwordField.sendKeys(password);
    }

}


