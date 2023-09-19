package stepdefinitions.uiStepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.CommonLocator;
import pages.CreateStudentPage;
import pages.ViceDeanTeacherManagementPage;
import utilities.*;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class US13_StepDefs {
    CommonLocator commonLocator = new CommonLocator();
    CreateStudentPage createStudentPage = new CreateStudentPage();
    ViceDeanTeacherManagementPage viceDeanTeacherManagementPage = new ViceDeanTeacherManagementPage();
    Faker faker = new Faker();
    public static String fakeUsername;
    public static String fakeName;
    public static String fakeSurname;
    private static String fakeBirthPlace;
    public static String fakeEmail;
    public static String formattedPhoneNumber;
    public static String fakeSsn;
    public static String gender;
    Connection connection;
    public static String birth_day;
    public Statement statement;
    public ResultSet resultSet;

    @Given("click TeacherManagementLink")
    public void click_teacher_management_link() {
        WaitUtils.waitFor(2);
        JSUtils.clickWithTimeoutByJS(viceDeanTeacherManagementPage.teacherManagementLink);
    }

    @Given("select lesson from choose lesson")
    public void select_lesson_from_choose_lesson() {
        WaitUtils.waitFor(2);
        ActionUtils.doubleClick(viceDeanTeacherManagementPage.chooseLesson);
        viceDeanTeacherManagementPage.chooseLesson.sendKeys("Java", Keys.ENTER);
        WaitUtils.waitFor(3);

    }

    @Given("select teacher has advisory role")
    public void select_teacher_has_advisory_role() {
        viceDeanTeacherManagementPage.advisoryRole.click();
        WaitUtils.waitFor(3);

    }

    @Given("verify teacher created successfully confirmation message")
    public void verify_teacher_created_successfully_confirmation_message() {
        WaitUtils.waitForVisibility(commonLocator.confirmationMessage, 5);
        assertTrue(commonLocator.confirmationMessage.getText().contains("Teacher saved"));
        WaitUtils.waitFor(3);
    }

    @And("enter username for teacher")
    public void enterUsernameForTeacher() {
        do {
            fakeUsername = faker.name().username();
        } while (fakeUsername.length() <= 4);

        commonLocator.usernameField.sendKeys(fakeUsername);
        WaitUtils.waitFor(2);
        System.out.println("fakeUsername = " + fakeUsername);
    }

    @Given("enter Teacher Name")
    public void enter_teacher_name() {
        fakeName = faker.name().firstName();
        viceDeanTeacherManagementPage.teacherName.sendKeys(fakeName);
        WaitUtils.waitFor(2);
    }

    @Given("enter Teacher Surname")
    public void enter_teacher_surname() {
        fakeSurname = faker.name().lastName();
        commonLocator.surname.sendKeys(fakeSurname);
        WaitUtils.waitFor(2);
    }

    @Given("enter Teacher Birth Place")
    public void enter_teacher_birth_place() {
        fakeBirthPlace = faker.address().city();
        commonLocator.birthplace.sendKeys(fakeBirthPlace);
        WaitUtils.waitFor(2);
    }

    @Given("enter Teacher email")
    public void enter_teacher_email() {
        fakeEmail = faker.internet().emailAddress();
        createStudentPage.emailField.sendKeys(fakeEmail);
        WaitUtils.waitFor(2);
    }

    @Given("enter Teacher valid phone number")
    public void enter_teacher_valid_phone_number() {
        // Generate a fake phone number as a string
       String fakePhoneNumber = faker.phoneNumber().phoneNumber();

        // Format the phone number as XXX-XXX-XXXX
         formattedPhoneNumber = BrowserUtils.formatPhoneNumber(fakePhoneNumber);

        commonLocator.phoneNumberField.sendKeys(formattedPhoneNumber);
        WaitUtils.waitFor(3);
    }

    @Given("select Teacher Male Gender")
    public void select_teacher_male_gender() {
        gender = "0";
        commonLocator.genderMale.click();
        WaitUtils.waitFor(2);

    }

    @Then("enter Teacher date of birth")
    public void enter_teacher_date_of_birth() {

        birth_day = "25-05-1988";
        commonLocator.dateOfBirth.sendKeys(birth_day);

        WaitUtils.waitFor(3);
    }

    @Then("enter Teacher valid SSN")
    public void enter_teacher_valid_ssn() {
        fakeSsn = faker.idNumber().ssnValid();
        commonLocator.ssnField.sendKeys(fakeSsn);


        WaitUtils.waitFor(2);

    }


    @Then("verify fails Required")
    public void verifyFailsRequired() {
        assertTrue(viceDeanTeacherManagementPage.failRequired.isDisplayed());
    }

    @Then("verify fails At Least {int} Characters")
    public void verifyFailsAtLeastCharacters(int arg0) {
        assertTrue(commonLocator.passwordLessCharErrorMessage.isDisplayed());
    }

    @Then("verify submit fails for gender")
    public void verifySubmitFailsForGender() {
        assertTrue(viceDeanTeacherManagementPage.failForGender.isDisplayed());
    }

    @Given("connect to database")
    public void connect_to_database() throws SQLException {
        connection = DriverManager.getConnection("jdbc:postgresql://managementonschools.com:5432/school_management", "select_user", "43w5ijfso");

    }

    @When("get teacher user via username {string}")
    public void get_teacher_user_via_username(String string) throws SQLException {
        statement = connection.createStatement();
        String sqlQuery = "select * from \"public\".teacher where username='"+fakeUsername+"'";
        System.out.println(sqlQuery);
        resultSet=statement.executeQuery(sqlQuery);
    }

    @Then("validate the credentials for teacher")
    public void validateTheCredentialsForTeacher() throws SQLException, ParseException {


        resultSet.next();
            String actUsername = resultSet.getString("username");
            String actBirthDay=resultSet.getString("birth_day");
            String actBirth_place = resultSet.getString("birth_place");
            String actGender = resultSet.getString("gender");
            String actName = resultSet.getString("name");
            String actPhone_number = resultSet.getString("phone_number");
            String actSsn = resultSet.getString("ssn");
            String actSurname = resultSet.getString("surname");
            String actEmail = resultSet.getString("email");
            String actIsAdvisor = resultSet.getString("is_advisor");

           SimpleDateFormat expectedDateFormat= new SimpleDateFormat("dd-MM-yyyy");
        String formattedExpectedDate = expectedDateFormat.format(expectedDateFormat.parse("25-05-1988"));
        String formattedActualDate= new SimpleDateFormat("dd-MM-yyyy").format(new SimpleDateFormat("yyyy-MM-dd").parse(actBirthDay));
        assertEquals(formattedExpectedDate, formattedActualDate);
            assertEquals(fakeBirthPlace, actBirth_place);
            assertEquals(gender, actGender);
            assertEquals(fakeName, actName);
            assertEquals(formattedPhoneNumber, actPhone_number);
            assertEquals(fakeSsn, actSsn);
            assertEquals(fakeSurname, actSurname);
            assertEquals(fakeUsername, actUsername);
            assertEquals(fakeEmail, actEmail);
            assertTrue(actIsAdvisor, true);
       }

    @Then("close the connection")
    public void close_the_connection() {


    }



}

