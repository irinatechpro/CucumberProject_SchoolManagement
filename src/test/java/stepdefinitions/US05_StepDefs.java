package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.AdminManagementPage;
import pages.DeanManagementPage;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.JSUtils;
import utilities.WaitUtils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class US05_StepDefs {

    LoginPage loginPage = new LoginPage();
    AdminManagementPage adminManagementPage = new AdminManagementPage();

    DeanManagementPage deanManagementPage = new DeanManagementPage();

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
        Assert.assertTrue(deanManagementPage.name.getText().contains("TeamProject")|deanManagementPage.gender.getText().contains("MALE")|
                deanManagementPage.phoneNumber.getText().contains("444-444-4444")|deanManagementPage.ssn.getText().contains("444-44-4444")|
                deanManagementPage.userName.getText().contains("DeanTeam01"));

    }
}
