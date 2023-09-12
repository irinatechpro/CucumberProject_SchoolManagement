package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import pages.AdminManagementPage;
import pages.DeanContactGetAllPage;
import pages.DeanManagementPage;
import pages.LoginPage;
import runners.Runner;
import utilities.*;

import javax.swing.text.Utilities;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static utilities.WaitUtils.waitFor;

public class US05_StepDefs {

    LoginPage loginPage = new LoginPage();
    AdminManagementPage adminManagementPage = new AdminManagementPage();

    DeanManagementPage deanManagementPage = new DeanManagementPage();

    Faker faker = new Faker();

    private String nameDean;
    private String nameDeanUpdate;

    @Given("Admin user is on The Managementon Schools website")
    public void admin_user_is_on_the_managementon_schools_website() {
        Driver.getDriver().get(ConfigReader.getProperty("ms_url"));
        WaitUtils.waitFor(1);
    }

    @Given("clicks on Login link")
    public void clicks_on_login_link() {
        loginPage.loginLink.click();
        WaitUtils.waitFor(1);

    }

    @Given("assserts that the page has Login title")
    public void assserts_that_the_page_has_login_title() {
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("login"));
        WaitUtils.waitFor(1);
    }

    @When("enters username {string}")
    public void enters_username(String string) {
        loginPage.userName.sendKeys("AdminProjectDot");
        WaitUtils.waitFor(1);
    }

    @When("password {string}")
    public void password(String string) {
        loginPage.password.sendKeys("Project11+");
        WaitUtils.waitFor(1);
    }

    @When("Admin user clicks on login button")
    public void admin_user_clicks_on_login_button() {
        loginPage.loginButton.click();
        WaitUtils.waitFor(1);
    }

    @Then("asserts that page has {string} title")
    public void asserts_that_page_has_a_title(String string) {
        Assert.assertTrue(adminManagementPage.adminManagementTitle.getText().contains("Admin Management"));
        WaitUtils.waitFor(1);
    }

    @Given("Admin user clicks on menu button")
    public void admin_user_clicks_on_menu_button() {
        adminManagementPage.menuButton.click();
        WaitUtils.waitFor(1);
    }

    @Given("Menu list is visible on the left hand side")
    public void menu_list_is_visible_on_the_left_hand_side() {
        Assert.assertTrue(adminManagementPage.buttonClose.isDisplayed());
        WaitUtils.waitFor(1);
    }

    @When("user clicks on {string} link")
    public void user_clicks_on_link(String string) {
        adminManagementPage.deanManagementLink.click();
        WaitUtils.waitFor(1);
    }

    @Then("asserts that Deans information can be seen")
    public void assertsThatDeansInformationCanBeSeen() {
        JSUtils.scrollIntoViewJS(deanManagementPage.deanList);
        Assert.assertTrue(deanManagementPage.name.getText().contains("TeamProject") | deanManagementPage.gender.getText().contains("MALE") |
                deanManagementPage.phoneNumber.getText().contains("444-444-4444") | deanManagementPage.ssn.getText().contains("444-44-4444") |
                deanManagementPage.userName.getText().contains("DeanTeam01"));
        WaitUtils.waitFor(1);
    }

    @When("goes to Add Dean")
    public void goes_to_add_dean() {
        Assert.assertTrue(deanManagementPage.addDean.getText().contains("Add Dean"));
        WaitUtils.waitFor(1);
    }

    @When("enters name {string}")
    public void enters_name(String string) {
        nameDean = faker.name().firstName();
        deanManagementPage.deanName.sendKeys(nameDean);
        WaitUtils.waitFor(1);
    }

    @When("enters surname {string}")
    public void enters_surname(String string) {
        deanManagementPage.deanSurname.sendKeys(faker.name().lastName());
        WaitUtils.waitFor(1);
    }

    @When("enters birthplace {string}")
    public void enters_birthplace(String string) {
        deanManagementPage.deanBirthPlace.sendKeys(faker.country().capital());
        WaitUtils.waitFor(1);
    }

    @When("clicks on Female for gender")
    public void clicks_on_female_for_gender() {
        deanManagementPage.deanGender.click();
        WaitUtils.waitFor(1);
    }

    @And("enters Date of Birth")
    public void entersDateOfBirth() {
        deanManagementPage.deanBirthDay.sendKeys("11/11/1234");
        WaitUtils.waitFor(1);
    }

    @When("enters Phone number {string}")
    public void enters_phone_number(String string) {

        String phoneNumber = faker.phoneNumber().phoneNumber();

        String formattedPhoneNumber = BrowserUtils.formatPhoneNumber(phoneNumber);

        deanManagementPage.deanPhoneNumber.sendKeys(formattedPhoneNumber);
        WaitUtils.waitFor(1);

    }

    @When("enters ssn number {string}")
    public void enters_ssn_number(String string) {
        deanManagementPage.deanSsnNumber.sendKeys(faker.idNumber().ssnValid().toString());
        WaitUtils.waitFor(1);
    }

    @When("admin user enters username {string}")
    public void admin_user_enters_username(String string) {
        deanManagementPage.deanUsername.sendKeys(faker.name().username());
        WaitUtils.waitFor(1);

    }

    @When("admin user enters password {string}")
    public void admin_user_enters_password(String string) {
        deanManagementPage.deanPassword.sendKeys("Istabul1");
        WaitUtils.waitFor(1);
    }

    @When("user clicks on submit")
    public void user_clicks_on_submit() {
        deanManagementPage.addDeanSubmit.click();
        WaitUtils.waitFor(1);
    }

    @Then("assert that Dean Saved alert is seen")
    public void assertThatDeanSavedAlertIsSeen() throws IOException {
            BrowserUtils.verifyExpectedAndActualTextMatch("Dean Saved", deanManagementPage.deanSavedText);
            WaitUtils.waitFor(1);

    }

    @And("user goes to the last page of the dean list")
    public void userGoesToTheLastPageOfTheDeanList() {
        JSUtils.clickWithTimeoutByJS(deanManagementPage.lastPageButton);
        WaitUtils.waitFor(1);
    }

    @And("goes to the Dean created")
    public void goesToTheDeanCreated() {
        String nameOfCreatedDean = deanManagementPage.deanName.getText();
        JSUtils.scrollIntoViewJS(deanManagementPage.lastRowDeanList);
        WaitUtils.waitFor(1);
        String lastRow = deanManagementPage.lastRowDeanList.getText();
        System.out.println("lastRow = " + lastRow);
        Assert.assertTrue(lastRow.contains(nameOfCreatedDean));
        WaitUtils.waitFor(1);
    }

    @And("user clicks on Edit button")
    public void userClicksOnEditButton() {
        WaitUtils.waitFor(2);
        JSUtils.clickWithTimeoutByJS(deanManagementPage.lastColumnDeanList);
        WaitUtils.waitFor(2);
    }

    @And("user enters a new name {string}")
    public void userEntersANewName(String string) {
        WaitUtils.waitFor(2);
        //BrowserUtils.switchIframeByIndex(1);
        nameDeanUpdate = faker.name().firstName();
        deanManagementPage.updateDeanName.sendKeys(nameDeanUpdate);
        WaitUtils.waitFor(1);
    }

}
