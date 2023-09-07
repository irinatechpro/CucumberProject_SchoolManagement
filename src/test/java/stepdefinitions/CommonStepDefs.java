package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.CommonLocator;
import pages.LoginPage;
import utilities.ConfigReader;
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
        loginPage.loginButton.click();
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
    public void enter_valid_ssn(String valid_ssn) {
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
        commonLocator.genderFemale.click();
    }

    @Given("enter password")
    public void enter_password() {
        commonLocator.passwordField.sendKeys("Testpw12");
    }

    @Given("click submit button")
    public void click_submit_Button() {
        commonLocator.submitButton.click();
    }

    @Given("verify Admin created successfully confirmation message")
    public void verify_admin_created_successfully_confirmation_message() {
        WaitUtils.waitForVisibility(commonLocator.confirmationMessage, 5);
        assertTrue(commonLocator.confirmationMessage.getText().contains("Admin Saved"));
    }

    @Then("click last page button")
    public void click_last_page_button(){
        commonLocator.goLastPageButton.click();
    }

    //use this if you want to do the entire operation of going to site
    //and logging in as Vice Dean
    //If you need to reuse for each scenario, then use this in Background
    @Given("login as vice dean {string} {string}")
    public void loginAsViceDean(String username, String password) {

        //go to url
        Driver.getDriver().get(ConfigReader.getProperty("ms_url"));

        //Wait for the page to load - throw exception if not load in 15s
        WaitUtils.waitForPageToLoad(15);

        //Find login element and click
        WaitUtils.waitForClickablility(loginPage.loginLink, 15);
        loginPage.loginLink.click();

        //Wait for page load + assert correct page has loaded
        WaitUtils.waitForPageToLoad(15);
        Assert.assertEquals(
                Driver.getDriver().getCurrentUrl(),
                "https://managementonschools.com/login"
        );

        //Now use credentials for logging in
        //username
        WaitUtils.waitForClickablility(loginPage.userName, 15);
        loginPage.userName.sendKeys(username);

        //password
        WaitUtils.waitForClickablility(loginPage.password, 15);
        loginPage.password.sendKeys(password);

        //login button click
        WaitUtils.waitForClickablility(loginPage.loginButton, 15);
        loginPage.loginButton.click();

        //Wait for next page load correctly + with username
        //page correction
        WaitUtils.waitFor(2);
        Assert.assertEquals(
                Driver.getDriver().getCurrentUrl(),
                "https://managementonschools.com/lesson"
        );

        //username correction
        WebElement getUsernameLabel = Driver.getDriver().findElement(By.cssSelector(
                ".navbar span > span:nth-child(2)"
        ));

        WaitUtils.waitForVisibility(getUsernameLabel, 15);
        Assert.assertEquals(
                username,
                getUsernameLabel.getText()
        );

        System.out.println("Complete...");
    }
}
