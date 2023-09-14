package stepdefinitions.uiStepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.AdminManagementPage;
import pages.DeanManagementPage;
import pages.LoginPage;
import utilities.*;

import java.io.IOException;

public class US05_StepDefs {

    LoginPage loginPage = new LoginPage();
    AdminManagementPage adminManagementPage = new AdminManagementPage();

    DeanManagementPage deanManagementPage = new DeanManagementPage();

    Faker faker = new Faker();

    private String nameDean;
    private String nameDeanUpdate;

    @Given("Admin user is on The Managementon Schools website")
    public void admin_user_is_on_the_managementon_schools_website() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        WaitUtils.waitFor(1);
    }

    @And("clicks on Login link")
    public void clicksOnLoginLink() {
        loginPage.loginLink.click();
        WaitUtils.waitFor(1);
    }


    @And("sees the page has Login title")
    public void sees_the_page_has_login_title() {
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("login"));
        WaitUtils.waitFor(1);
    }

    @When("Admin user enters username on Login page {string}")
    public void admin_user_enters_usename_on_login_page(String string) {
        loginPage.userName.sendKeys("AdminProjectDot");

    }

    @And("enters password on Login page {string}")
    public void entersPasswordOnLoginPage(String string) {
        loginPage.password.sendKeys("Project11+");

    }

    @And("Admin user clicks on login button")
    public void admin_user_clicks_on_login_button() {
        loginPage.loginButton.click();
        WaitUtils.waitFor(1);
    }

    @Then("sees the {string} title")
    public void sees_the_title(String string) {
        Assert.assertTrue(adminManagementPage.adminManagementTitle.getText().contains("Admin Management"));
        WaitUtils.waitFor(1);
    }

    @Given("Admin user clicks on menu button")
    public void admin_user_clicks_on_menu_button() {
        adminManagementPage.menuButton.click();
        WaitUtils.waitFor(1);
    }

    @And("sees the menu list on the left hand side")
    public void sees_the_menu_list_on_the_left_hand_side() {
        Assert.assertTrue(adminManagementPage.buttonClose.isDisplayed());
        WaitUtils.waitFor(1);
    }

    @When("user clicks on {string} link")
    public void user_clicks_on_link(String string) {
        adminManagementPage.deanManagementLink.click();
        WaitUtils.waitFor(1);
    }

    @Then("sees the Deans information")
    public void sees_the_Deans_information() {
        JSUtils.scrollIntoViewJS(deanManagementPage.deanList);
        Assert.assertTrue(deanManagementPage.name.getText().contains("TeamProject") | deanManagementPage.gender.getText().contains("MALE") |
                deanManagementPage.phoneNumber.getText().contains("444-444-4444") | deanManagementPage.ssn.getText().contains("444-44-4444") |
                deanManagementPage.userName.getText().contains("DeanTeam01"));
        WaitUtils.waitFor(1);
    }

    @And("goes to Add Dean section")
    public void goes_to_add_dean_section() {
        Assert.assertTrue(deanManagementPage.addDean.getText().contains("Add Dean"));
        WaitUtils.waitFor(1);
    }

    @And("enters name {string} on Add Dean section")
    public void enters_name_on_add_dean_section(String string) {
        nameDean = faker.name().firstName();
        deanManagementPage.deanName.sendKeys(nameDean);
        WaitUtils.waitFor(1);
    }

    @And("enters surname {string} on Add Dean section")
    public void enters_surname_on_add_dean_section(String string) {
        deanManagementPage.deanSurname.sendKeys(faker.name().lastName());
        WaitUtils.waitFor(1);
    }

    @And("enters birthplace {string} on Add Dean section")
    public void enters_birthplace_on_add_dean_cection(String string) {
        deanManagementPage.deanBirthPlace.sendKeys("Istanbul");
        WaitUtils.waitFor(1);
    }

    @And("clicks on Female for gender on Add Dean section")
    public void clicks_on_female_for_gender_on_add_dean_section() {
        deanManagementPage.deanGender.click();
        WaitUtils.waitFor(1);
    }

    @And("enters Date of Birth on Add Dean section")
    public void entersDateOfBirthonAddDeanSection() {
        deanManagementPage.deanBirthDay.sendKeys("11/11/1234");
        WaitUtils.waitFor(1);
    }

    @And("enters Phone number {string} on Add Dean section")
    public void enters_phone_number_on_Add_Dean_Section(String string) {

        String phoneNumber = faker.phoneNumber().phoneNumber();

        String formattedPhoneNumber = BrowserUtils.formatPhoneNumber(phoneNumber);

        deanManagementPage.deanPhoneNumber.sendKeys(formattedPhoneNumber);
        WaitUtils.waitFor(1);

    }

    @And("enters ssn number {string} on Add Dean section")
    public void enters_ssn_number_on_add_dean_ssection(String string) {
        deanManagementPage.deanSsnNumber.sendKeys(faker.idNumber().ssnValid().toString());
        WaitUtils.waitFor(1);
    }

    @And("Admin user enters a new username {string} on Add Dean section")
    public void adminUserEntersANewUsernameOnAddDeanSection(String string) {
        deanManagementPage.deanUsername.sendKeys(faker.bothify("????##"));
        WaitUtils.waitFor(1);

    }

    @And("enters the password {string} on Add Dean section")
    public void entersThePasswordOnAddDeanSection(String string) {
        deanManagementPage.deanPassword.sendKeys("Istanbul1");
        WaitUtils.waitFor(1);
    }

    @And("user clicks on submit on Add Dean section")
    public void userClicksOnSubmitOnAddDeanSection() {
        deanManagementPage.addDeanSubmit.click();
        WaitUtils.waitFor(1);
    }

    @Then("sees the Dean Saved alert")
    public void seesTheDeanSavedalert() throws IOException {
        BrowserUtils.verifyExpectedAndActualTextMatch("Dean Saved", deanManagementPage.deanSavedText);
        WaitUtils.waitFor(1);

    }

    @And("Admin user goes to the last page of the dean list")
    public void adminUserGoesToTheLastPageOfTheDeanList() {
        JSUtils.clickWithTimeoutByJS(deanManagementPage.lastPageButton);
        WaitUtils.waitFor(1);
    }

    @And("goes to the last Dean created")
    public void goesToTheLastDeanCreated() {
        String nameOfCreatedDean = deanManagementPage.deanName.getText();
        JSUtils.scrollIntoViewJS(deanManagementPage.lastRowDeanList);
        WaitUtils.waitFor(1);
        String lastRow = deanManagementPage.lastRowDeanList.getText();
        System.out.println("lastRow = " + lastRow);
        Assert.assertTrue(lastRow.contains(nameOfCreatedDean));
        WaitUtils.waitFor(1);
    }

    @And("clicks on Edit button on the Dean List")
    public void clicksOnEditButtonOntheDeanList() {
        WaitUtils.waitFor(2);
        JSUtils.clickWithTimeoutByJS(deanManagementPage.lastColumnDeanList);
        WaitUtils.waitFor(2);
    }

    @And("enters a new Dean name {string}")
    public void entersANewDeanName(String string) {
        WaitUtils.waitFor(2);
        //BrowserUtils.switchIframeByIndex(1);
        nameDeanUpdate = faker.name().firstName();
        deanManagementPage.updateDeanName.sendKeys(nameDeanUpdate);
        WaitUtils.waitFor(3);
    }


    @And("enters the password on the edit box {string}")
    public void entersThePasswordOnTheEditBox(String string) {
        WaitUtils.waitFor(1);
        deanManagementPage.deanPasswordEditBox.sendKeys("Istanbul1");
        WaitUtils.waitFor(1);
    }

    @And("clicks on Female for gender on the edit box")
    public void clicksOnFemaleForGenderOnTheEditBox() {
        deanManagementPage.femaleGenderButtonEditBox.click();
    }

    @And("Admin user clicks Submit button on the edit box")
    public void adminUserClicksSubmitButtonOnTheEditBox() {
        deanManagementPage.submitButtonEditBox.click();
    }


    @Then("sees the Dean updated Successful alert")
    public void seesTheDeanUpdatedSuccessfulAlert() throws IOException {
        WaitUtils.waitFor(1);
        BrowserUtils.verifyExpectedAndActualTextMatch("Dean updated Successful", deanManagementPage.deanUpdatedSuccessfulText);
        WaitUtils.waitFor(1);
    }

}