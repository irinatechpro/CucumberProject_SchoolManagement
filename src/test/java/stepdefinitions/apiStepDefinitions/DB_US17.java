package stepdefinitions.apiStepDefinitions;

import base_url.BaseUrl;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import pages.CommonLocator;
import pages.LoginPage;
import pages.StudentInfoManagement;
import utilities.*;
import utilities.Driver;

import java.sql.*;

import static base_url.BaseUrl.spec;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DB_US17  {

    LoginPage loginPage = new LoginPage();
    StudentInfoManagement studentInfoManagement = new StudentInfoManagement();
    CommonLocator commonLocator = new CommonLocator();
    Connection connection;
    ResultSet resultSet;


    @Given("user navigate to {string}")
    public void user_navigate_to(String string) {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
    }
    @Given("click on Login link")
    public void click_on_login_link() {
        loginPage.loginLink.click();
        WaitUtils.waitFor(2);
    }
    @Given("user enter username {string}")
    public void user_enter_username(String string) {
        loginPage.userName.sendKeys("philips");
    }
    @Given("user enter password {string}")
    public void user_enter_password(String string) {
        loginPage.password.sendKeys("Philips#5678");
    }
    @Given("user clicks on login button on login button")
    public void user_clicks_on_login_button_on_login_button() {
        loginPage.loginButton.click();
        WaitUtils.waitFor(2);
    }
    @Given("user clicks Menu button")
    public void user_clicks_menu_button() {
        studentInfoManagement.menuButton.click();
        WaitUtils.waitFor(3);
    }
    @Given("user selects student info management")
    public void user_selects_student_info_management() {
        studentInfoManagement.studentInfoManagementButton.click();
        WaitUtils.waitFor(3);
    }
    @Given("user chooses the lesson Lesson")
    public void user_chooses_the_lesson_lesson() {
        BrowserUtils.selectByIndex(studentInfoManagement.chooseLesson,1);
        WaitUtils.waitFor(2);
    }
    @Given("user chooses the student student")
    public void user_chooses_the_student_student() {
        BrowserUtils.selectByValue(studentInfoManagement.chooseStudent,"594");
        WaitUtils.waitFor(2);
    }
    @Given("user chooses education term")
    public void user_chooses_education_term() {
        BrowserUtils.selectByValue(studentInfoManagement.chooseEducationTerm,"2");
        WaitUtils.waitFor(2);
    }
    @Given("user enter Absentee")
    public void user_enter_absentee() {
        studentInfoManagement.absentee.sendKeys("17");
        WaitUtils.waitFor(2);
    }
    @Given("user enter Midterm exam grade")
    public void user_enter_midterm_exam_grade() {
        studentInfoManagement.midtermExam.sendKeys("90");
        WaitUtils.waitFor(2);
    }
    @Given("user enter final exam grade")
    public void user_enter_final_exam_grade() {
        studentInfoManagement.finalExam.sendKeys("93");
        WaitUtils.waitFor(2);
    }
    @Given("user enter info note")
    public void user_enter_info_note() {
        studentInfoManagement.infoNote.sendKeys("completed term");
        WaitUtils.waitFor(2);
    }
    @Given("user clicks on submit buttons")
    public void user_clicks_on_submit_buttons() {
        studentInfoManagement.submitButton1.click();
        WaitUtils.waitFor(2);
    }

    @Then("verify student info saved successfully")
    public void verify_student_info_saved_successfully() {
        //WaitUtils.waitForVisibility(commonLocator.confirmationMessage,2);
        //assertTrue(commonLocator.confirmationMessage.getText().contains("Student Info saved Successfully"));
        assertTrue(studentInfoManagement.studentInfoList.getText().contains("Student Info List"));
        WaitUtils.waitFor(2);
    }

    @Given("connect to the database")
    public void connect_to_the_database() throws SQLException {
        //connection = DriverManager.getConnection("jdbc:postgresql://managementonschools.com:5432/school_management" , "select_user" , "43w5ijfso");


    }
    @When("get student_info via username {string}")
    public void get_student_info_via_username(String username) throws SQLException {
        //Statement statement = connection.createStatement();
        String query = "select * from \"public\".student_info where absentee = 17";
         resultSet = DBUtils.executeQuery(query);
        resultSet.next();//To move the pointer to the records, we need to call next()


    }
    @Then("validate Lesson {string} Student {string} Education_Term {string} absentee {string} midterm_exam {string} final_exam {string} info_note {string}")
    public void validate_lesson_student_education_term_absentee_midterm_exam_final_exam_info_note(String lesson, String student, String education_term, String absentee, String midterm_exam, String final_exam, String info_note) throws SQLException {
        String actualMidtermExam = resultSet.getString("midterm_exam");
        String actualAbsentee = resultSet.getString("absentee");
        String actualFinalExam = resultSet.getString("final_exam");
        String actualInfoNote = resultSet.getString("info_note");
       //String actualLesson = resultSet.getString("Lesson");
        //String actualStudent = resultSet.getString("Student");
        //String actualEducationTerm = resultSet.getString("Education_Term");

        assertEquals(midterm_exam, actualMidtermExam);
        assertEquals(absentee, actualAbsentee);
        assertEquals(final_exam, actualFinalExam);
        assertEquals(info_note,actualInfoNote);
        //assertEquals(lesson, actualLesson);
        //assertEquals(student,actualStudent);
        //assertEquals(education_term,actualEducationTerm);

    }
    @Then("close the connection")
    public void close_the_connection() throws SQLException {
        DBUtils.closeConnection();

    }

    @Given("send get request to get student info")
    public void send_get_request_to_get_student_info() {
       //String Url = "https://managementonschools.com/app/studentInfo/getAllForTeacher?page=0&size=10000";

        spec.pathParams("first","studentInfo","second","getAllForTeacher").queryParams("size","10000");
        Response response = given(spec)
                .header("Authorization","Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJwaGlsaXBzIiwiaWF0IjoxNjk1NDY0MjQyLCJleHAiOjE2OTU0NzI4ODJ9.z-ae5x0PiGcs4VBbLiWUsJW93gUfjNjy1LjL9djU7fSz7uwYO7VK3Gxg8R8o8SF4YevoFEmXTN1DeUHwSVjGGA")
                .get("{first}/{second}");
        response.prettyPrint();

    }
    @Then("validate lessonName {string} Student {string} Education_Term {string} absentee {string} midterm_exam {string} final_exam {string} info_note {string} by API")
    public void validate_lesson_name_student_education_term_absentee_midterm_exam_final_exam_info_note_by_api(String string, String string2, String string3, String string4, String string5, String string6, String string7) {

    }

}
