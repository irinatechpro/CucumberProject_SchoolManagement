package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.Select;
import pages.CommonLocator;
import pages.LoginPage;
import pages.ViceDean_AdminManagementPage;
import pages.ViceDean_LessonManagementPage;
import utilities.WaitUtils;

public class US11_StepDefs {

    LoginPage loginPage = new LoginPage();
    CommonLocator commonLocator = new CommonLocator();
    ViceDean_LessonManagementPage viceDean_lessonManagementPage = new ViceDean_LessonManagementPage ();
    ViceDean_AdminManagementPage viceDean_adminManagementPage = new ViceDean_AdminManagementPage();
    @When("click on login link")
    public void click_on_login_link() { loginPage.loginLink.click();
    }
    @When("enter username {string}")
    public void enter_username(String string) { WaitUtils.waitFor(2);
        loginPage.userName.sendKeys(string);
    }
    @When("enter password {string}")
    public void enter_password(String string) {loginPage.password.sendKeys(string);
    }
    @When("click on login button")
    public void click_on_login_button() { loginPage.loginButton.click();
    }
    @When("click on Menu button")
    public void click_on_menu_button() { commonLocator.menuButton.click();
    }
    @When("click on Lesson Management Link")
    public void click_on_lesson_management_link() { viceDean_adminManagementPage.toggleMenu_adminManagement.click();
    }
    @When("click Lesson Program")
    public void click_lesson_program() {viceDean_lessonManagementPage.lessonProgram.click();
    }
    @When("select lesson type {string}")
    public void select_lesson_type(String lessonType) {
        WaitUtils.waitFor(10);
       new Select(viceDean_lessonManagementPage.getSelectionChooseLesson1).selectByVisibleText(lessonType);
        // viceDean_lessonManagementPage.lessonProgram.click();
    }
    @When("select day type {string}")
    public void select_day_tupe(String dayType) {
        new Select (viceDean_lessonManagementPage.getSelectionChooseDay).selectByValue(dayType);

    }
    @When("choose Education Term")
    public void choose_education_term() {
      //  viceDean_lessonManagementPage.getSelectionChooseLesson.sele;click();

    }
    //@When("enter Start Time")
    //public void enter_start_time() {

    //}
    //@When("enter Stop Time")
    //public void enter_stop_time() {

    //}
    @When("user clicks Submit button")
    public void user_clicks_submit_button() {

    }
    @Then("verify {string} message is appear")
    public void verify_message_is_appear(String string) {

    }
    @Then("verify Lesson, Day, Start Time and Stop Time created are visible")
    public void verify_lesson_day_start_time_and_stop_time_created_are_visible() {

    }




//    @FindBy(xpath = "//*[@class='header_link me-2']")
//    public WebElement registerLink;
//    @FindBy(xpath = "//*[@class='header_link ms-2']")
//    public WebElement loginLink;
//    @FindBy(id = "name")
//    public WebElement name;
//    @FindBy(id = "surname")
//    public WebElement surname;
//    @FindBy(id = "birthPlace")
//    public WebElement birthplace;
//    @FindBy(id = "phoneNumber")
//    public WebElement phoneNumber;
//    @FindBy(xpath = "//*[(text()='Female')]")
//    public WebElement radioButtonFemale;
//    @FindBy(xpath = "//*[(text()='Male')]")
//    public WebElement radioButtonMale;
//    @FindBy(id = "birthDay")
//    public WebElement birthDay;
//    @FindBy(id = "ssn")
//    public WebElement ssn;
//    @FindBy(id = "username")
//    public WebElement username;
//    @FindBy(id = "password")
//    public WebElement password;
//    @FindBy(xpath = "//button[(text()='Register')]")
//    public WebElement registerButton;
}
