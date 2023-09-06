package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.CommonLocator;
import pages.LoginPage;
import utilities.Driver;
import utilities.WaitUtils;

public class CommonStepDefs {

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

    //@Then("enter date of birth")
    //public void enter_date_of_birth() {
    //   commonLocator.dateOfBirth.sendKeys(faker.date().birthday().toString());

//    }
    //@Then("enter valid phone number")
    //public void enter_valid_phone_number() {
    //    commonLocator.phoneNumberField.sendKeys(faker.phoneNumber().phoneNumber().toString());
//
    //}
    @Then("enter valid SSN")
    public void enter_valid_ssn() {
        commonLocator.ssnField.sendKeys(faker.idNumber().ssnValid().toString());

    }
    @Then("enter username")
    public void enter_username() {
        commonLocator.usernameField.sendKeys(faker.name().username());
    }

    @Given("click menu button")
    public void click_menu_button() {
        commonLocator.menuButton.click();
    }
    @Given("click Student Management Link")
    public void click_student_management_link() {
        commonLocator.studentManagementLink.click();
    }






}
