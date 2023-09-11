package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.AdminManagementPage;
import pages.DeanManagementPage;
import pages.LoginPage;
import utilities.*;

import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class US05_StepDefs {

    LoginPage loginPage = new LoginPage();
    AdminManagementPage adminManagementPage = new AdminManagementPage();

    DeanManagementPage deanManagementPage = new DeanManagementPage();

    Faker faker = new Faker();

    @Given("Admin user is on The Managementon Schools website")
    public void admin_user_is_on_the_managementon_schools_website() {
        Driver.getDriver().get(ConfigReader.getProperty("ms_url"));
    }
    @Given("clicks on Login link")
    public void clicks_on_login_link() {
        loginPage.loginLink.click();

    }
    @Given("assserts that the page has Login title")
    public void assserts_that_the_page_has_login_title() {
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("login"));
    }
    @When("enters username {string}")
    public void enters_username(String string) {
        loginPage.userName.sendKeys("AdminProjectDot");
    }
    @When("password {string}")
    public void password(String string) {
        loginPage.password.sendKeys("Project11+");
    }
    @When("Admin user clicks on login button")
    public void admin_user_clicks_on_login_button() {
        loginPage.loginButton.click();
    }
    @Then("asserts that page has {string} title")
    public void asserts_that_page_has_a_title(String string) {
        Assert.assertTrue(adminManagementPage.adminManagementTitle.getText().contains("Admin Management"));
    }

    @Given("Admin user clicks on menu button")
    public void admin_user_clicks_on_menu_button() {
        adminManagementPage.menuButton.click();
    }

    @Given("Menu list is visible on the left hand side")
    public void menu_list_is_visible_on_the_left_hand_side() {
        Assert.assertTrue(adminManagementPage.buttonClose.isDisplayed());
    }
    @When("user clicks on {string} link")
    public void user_clicks_on_link(String string) {
        adminManagementPage.deanManagementLink.click();
    }
    @Then("asserts that Deans information can be seen")
    public void assertsThatDeansInformationCanBeSeen() {
        JSUtils.scrollIntoViewJS(deanManagementPage.deanList);
        Assert.assertTrue(deanManagementPage.name.getText().contains("TeamProject") | deanManagementPage.gender.getText().contains("MALE") |
                deanManagementPage.phoneNumber.getText().contains("444-444-4444") | deanManagementPage.ssn.getText().contains("444-44-4444") |
                deanManagementPage.userName.getText().contains("DeanTeam01"));
    }

    @When("goes to Add Dean")
    public void goes_to_add_dean() {
        Assert.assertTrue(deanManagementPage.addDean.getText().contains("Add Dean"));
    }
    @When("enters name")
    public void enters_name(String string) {
        String nameDean = faker.name().firstName();
        deanManagementPage.deanName.sendKeys(nameDean);
    }
    @When("enters surname")
    public void enters_surname(String string) {
        deanManagementPage.deanSurname.sendKeys(faker.name().lastName());
    }
    @When("enters birthplace")
    public void enters_birthplace(String string) {
        deanManagementPage.deanBirthPlace.sendKeys(faker.country().capital());
    }
    @When("clicks on Male for gender")
    public void clicks_on_male_for_gender() {
        deanManagementPage.deanGender.click();
    }

    @And("enters Date of Birth")
    public void entersDateOfBirth(String arg0) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        String dob = sdf.format(faker.date().birthday());
        deanManagementPage.deanBirthDay.sendKeys(dob);
    }
    @When("enters Phone number")
    public void enters_phone_number(String string) {

        String phoneNumber = faker.phoneNumber().phoneNumber();

        String formattedPhoneNumber = BrowserUtils.formatPhoneNumber(phoneNumber);

        deanManagementPage.deanPhoneNumber.sendKeys(formattedPhoneNumber);

    }
    @When("enters ssn number")
    public void enters_ssn_number(String string) {
        WaitUtils.waitFor(10);
        deanManagementPage.deanSsnNumber.sendKeys(faker.idNumber().ssnValid().toString());
    }
    @When("admin user enters username")
    public void admin_user_enters_username(String string) {
        WaitUtils.waitFor(10);
        deanManagementPage.deanUsername.sendKeys(faker.name().username());

    }
    @When("admin user enters password {string}")
    public void admin_user_enters_password(String string) {
        deanManagementPage.deanPassword.sendKeys("Istabul1");
    }
    @When("user clicks on submit")
    public void user_clicks_on_submit() {
        WaitUtils.waitFor(10);
        deanManagementPage.addDeanSubmit.click();
    }


    @And("user scrolls down to to click last page button")
    public void userScrollsDownToToClickLastPageButton() {
        JSUtils.clickWithTimeoutByJS(deanManagementPage.lastPageButton);
        WaitUtils.waitFor(10);

    }

    @And("user scrolls up to verify the dean created")
    public void userScrollsUpToVerifyLastCreatedDeanIsMrBuyukersen() {
        JSUtils.clickWithTimeoutByJS(deanManagementPage.verifyDean);
        WaitUtils.waitFor(10);

    }

}
