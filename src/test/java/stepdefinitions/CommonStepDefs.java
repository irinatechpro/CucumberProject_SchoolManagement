package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.CommonLocator;
import pages.LoginPage;
import utilities.Driver;
import utilities.JSUtils;
import utilities.WaitUtils;

import static org.junit.Assert.assertTrue;

public class CommonStepDefs {
    private String valid_ssn;

    LoginPage loginPage = new LoginPage();
    CommonLocator commonLocator = new CommonLocator();

    Faker faker = new Faker();

    @Then("close the application")
    public void close_the_application() throws InterruptedException {

        Thread.sleep(1000);
        Driver.closeDriver();
    }

    @Given("user navigates to {string}")
    public void userNavigatesTo(String url) {
        WaitUtils.waitFor(2);
        Driver.getDriver().get(url);

    }

    @Given("user clicks on login link")
    public void user_clicks_on_login_link() {
        loginPage.loginLink.click();
    }

    @Given("user enters username {string}")
    public void user_enters_username(String string) {
        WaitUtils.waitFor(2);
        loginPage.userName.sendKeys(string);
    }

    @Given("user enters password {string}")
    public void user_enters_password(String string) {
        loginPage.password.sendKeys(string);
    }

    @Given("user clicks on login button")
    public void user_clicks_on_login_button() {
        JSUtils.clickWithTimeoutByJS(loginPage.loginButton);
    }

    @Then("enter date of birth")
    public void enter_date_of_birth() {
       commonLocator.dateOfBirth.sendKeys("01/05/1990");
    }

    public static String formatPhoneNumber(String phoneNumber) {
        // Remove any non-numeric characters from the phone number
        String numericPhoneNumber = phoneNumber.replaceAll("[^0-9]", "");

        // Format as XXX-XXX-XXXX
        return String.format("%s-%s-%s",
                numericPhoneNumber.substring(0, 3),
                numericPhoneNumber.substring(3, 6),
                numericPhoneNumber.substring(6, 10));
    }

    @Then("enter valid phone number")
    public void enter_valid_phone_number() {
        // Generate a fake phone number as a string
        String phoneNumber = faker.phoneNumber().phoneNumber();

        // Format the phone number as XXX-XXX-XXXX
        String formattedPhoneNumber = formatPhoneNumber(phoneNumber);

        System.out.println("Generated Phone Number: " + phoneNumber);
        System.out.println("Formatted Phone Number: " + formattedPhoneNumber);

        commonLocator.phoneNumberField.sendKeys(formattedPhoneNumber);
    }

    @Then("enter valid SSN")
    public void enter_valid_ssn() {
        valid_ssn= faker.idNumber().ssnValid().toString();
        commonLocator.ssnField.sendKeys(valid_ssn);
    }

    @Then("enter username")
    public void enter_username() {
        commonLocator.usernameField.sendKeys(faker.name().username());
    }

    @Given("click menu button")
    public void click_menu_button() {
        commonLocator.menuButton.click();
    }

    @Given("enter Name")
    public void enter_Name() {
        commonLocator.name.sendKeys(faker.name().firstName());
    }

    @Given("enter Surname")
    public void enter_Surname() {
        commonLocator.surname.sendKeys(faker.name().lastName());
    }

    @Given("enter Birth Place")
    public void enter_Birth_Place() {
        commonLocator.birthplace.sendKeys(faker.country().capital());
    }

    @Given("select Male Gender")
    public void select_Gender_Male() {
        commonLocator.genderMale.click();
    }

    @Given("select Female Gender")
    public void select_Gender_Female() {
        JSUtils.clickWithTimeoutByJS(commonLocator.genderFemale);
    }

    @Given("enter password")
    public void enter_password() {
        commonLocator.passwordField.sendKeys("Testpw12");
    }

    @Given("enter password with only seven chars")
    public void enter_password_with_only_seven_chars() {
        commonLocator.passwordField.sendKeys("Testpw1");
    }

    @Given("enter password without lowercase chars")
    public void enter_password_without_lowercase_chars() {
        commonLocator.passwordField.sendKeys("TESTPW12");
    }

    @Given("enter password without uppercase chars")
    public void enter_password_without_uppercase_chars() {
        commonLocator.passwordField.sendKeys("testpw12");
    }

    @Given("enter password without numbers")
    public void enter_password_without_numbers() {
        commonLocator.passwordField.sendKeys("testpwtest");
    }

    @Given("click submit button")
    public void click_submit_Button() {
        JSUtils.clickWithTimeoutByJS(commonLocator.submitButton);
    }

    @Given("verify Admin created successfully confirmation message")
    public void verify_admin_created_successfully_confirmation_message() {
        WaitUtils.waitForVisibility(commonLocator.confirmationMessage, 5);
        assertTrue(commonLocator.confirmationMessage.getText().contains("Admin Saved"));
    }

    @Given("verify Admin created successfully confirmation message does not appears")
    public void verify_admin_created_successfully_confirmation_message_does_not_appears() {
        WaitUtils.waitForVisibility(commonLocator.confirmationMessage, 5);
        assert(commonLocator.confirmationMessage.getText().contains("Admin Saved"));
    }

    @Then("click last page button")
    public void click_last_page_button(){
        commonLocator.goLastPageButton.click();
    }

}
