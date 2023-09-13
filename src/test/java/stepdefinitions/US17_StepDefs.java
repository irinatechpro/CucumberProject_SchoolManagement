package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.CommonLocator;
import pages.LoginPage;
import pages.StudentInfoManagement;
import utilities.BrowserUtils;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.WaitUtils;

public class US17_StepDefs {
    LoginPage loginPage = new LoginPage();
    StudentInfoManagement studentInfoManagement = new StudentInfoManagement();
    CommonLocator commonLocator = new CommonLocator();


    @Given("user navigates to")
    public void user_navigates_to() {
        Driver.getDriver().get(ConfigReader.getProperty("ms_url"));

    }
    @Given("user clicks on the login link")
    public void user_clicks_on_the_login_link() {
        loginPage.loginLink.click();
        WaitUtils.waitFor(2);
    }
    @Given("user enters username")
    public void user_enters_username() {
        loginPage.userName.sendKeys("philips");
    }
    @Given("user enters password")
    public void user_enters_password() {
        loginPage.password.sendKeys("Philips#5678");
    }
    @Given("user click on login button")
    public void user_click_on_login_button() {
        loginPage.loginButton.click();
        WaitUtils.waitFor(2);
    }
    @Given("user chooses the lesson")
    public void user_chooses_the_lesson() {
        BrowserUtils.selectByValue(studentInfoManagement.chooseLesson,"1");
        WaitUtils.waitFor(2);
    }
    @Given("user chooses the student")
    public void user_chooses_the_student() {
        BrowserUtils.selectByValue(studentInfoManagement.chooseStudent,"594");
        WaitUtils.waitFor(2);
    }
    @Given("user choose education term")
    public void user_choose_education_term() {
        BrowserUtils.selectByValue(studentInfoManagement.chooseEducationTerm,"2");
        WaitUtils.waitFor(2);
    }
    @Given("user enters Absentee")
    public void user_enters_absentee() {
        studentInfoManagement.absentee.sendKeys("17");
        WaitUtils.waitFor(2);
    }
    @Given("user enters Midterm exam grade")
    public void user_enters_midterm_exam_grade() {
        studentInfoManagement.midtermExam.sendKeys("90");
        WaitUtils.waitFor(2);
    }
    @Given("user enters final exam grade")
    public void user_enters_final_exam_grade() {
        studentInfoManagement.finalExam.sendKeys("93");
        WaitUtils.waitFor(2);
    }
    @Given("user enters info note")
    public void user_enters_info_note() {
        studentInfoManagement.infoNote.sendKeys("completed term");
        WaitUtils.waitFor(2);
    }
    @Given("user user clicks on submit button")
    public void user_user_clicks_on_submit_button() {
        studentInfoManagement.submitButton1.click();
        WaitUtils.waitFor(2);
    }
    @Then("verify student info added successfully ont the list")
    public void verify_student_info_added_successfully_ont_the_list() {
        Assert.assertTrue(studentInfoManagement.studentInfoList.isDisplayed());
        WaitUtils.waitFor(3);
        Driver.closeDriver();

    }



}
