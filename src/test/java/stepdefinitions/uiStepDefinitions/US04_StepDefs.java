package stepdefinitions.uiStepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import pages.CommonLocator;
import pages.DeanCreatePage;
import utilities.DBUtils;
import utilities.JSUtils;
import utilities.WaitUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static base_url.BaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static stepdefinitions.uiStepDefinitions.CommonStepDefs.*;

public class US04_StepDefs {

    private static String deanUserName;
    private static String deanName;
    private static String dean;
    private static String deanData;
    public static String id;
    //   public static String genderDB;
    //   public static String genderAPI;
//    public static String birth_day;

    public Statement statement;
    Connection connection;


    private static Integer deanID;

    Response response;
    ResultSet resultSet;

    Faker faker = new Faker();
    CommonLocator commonLocator = new CommonLocator();

    DeanCreatePage deanCreatePage = new DeanCreatePage();


    @Given("click Dean Management Link")
    public void click_Dean_Management_Link() {
        JSUtils.clickWithTimeoutByJS(deanCreatePage.deanManagementLink);
        JSUtils.scrollAllTheWayUpJS();
    }


    @Given("verify dean created successfully confirmation message")
    public void verify_dean_created_successfully_confirmation_message() {
        WaitUtils.waitForVisibility(commonLocator.confirmationMessage, 2);
        assertTrue(commonLocator.confirmationMessage.getText().contains("Dean Saved"));
    }

    @Given("verify dean created unsuccessfully confirmation message")
    public void verify_dean_created_unsuccessfully_confirmation_message() {
        WaitUtils.waitForVisibility(commonLocator.confirmationMessage, 5);
        assertTrue(commonLocator.confirmationMessage.getText().contains("Dean saved"));
    }

    @And("verify dean number created automatically")
    public void verifyDeanNumberCreatedAutomatically() {
    }


    @And("verify dean number uncreated automatically")
    public void verifyDeanNumberUnCreatedAutomatically() {

    }
//API
//@And("enter username for dean")
//public void enterUsernameForDean() {
//    do {
//        fakerUsername = faker.name().username();
//    } while (fakerUsername.length() <= 4);
//
//    commonLocator.usernameField.sendKeys(fakerUsername);
//    WaitUtils.waitFor(2);
//    System.out.println("fakerUsername = " + fakerUsername);
//}

//    @Given("enter Dean Name")
//    public void enter_dean_name() {
//        fakerName = faker.name().firstName();
//        deanCreatePage.deanManagementLink.sendKeys(fakerName);
//        WaitUtils.waitFor(2);
//    }

//    @Given("enter Dean Surname")
//    public void enter_dean_surname() {
//        fakerSurname = faker.name().lastName();
//        commonLocator.surname.sendKeys(fakerSurname);
//        WaitUtils.waitFor(2);
//    }

//    @Given("enter Dean Birth Place")
//    public void enter_teacher_birth_place() {
//        fakerBirthPlace = faker.address().city();
//        commonLocator.birthplace.sendKeys(fakerBirthPlace);
//        WaitUtils.waitFor(2);
//    }


//    @Given("enter Dean valid phone number")
//    public void enter_dean_valid_phone_number() {
//        // Generate a fake phone number as a string
//        String fakerPhoneNumber = faker.phoneNumber().phoneNumber();
//
//    }
//
//    @Given("select dean Male Gender")
//    public void select_dean_male_gender() {
//        genderDB= "0";
//        genderAPI="MALE";
//        commonLocator.genderMale.click();
//        WaitUtils.waitFor(2);
//
//    }
//
//    @Then("enter Teacher date of birth")
//    public void enter_teacher_date_of_birth() {
//
//        birth_day = "25-05-1988";
//        commonLocator.dateOfBirth.sendKeys(birth_day);
//
//        WaitUtils.waitFor(3);
//    }
//
//    @Then("enter dean valid SSN")
//    public void enter_dean_valid_ssn() {
//        fakeSsn = faker.idNumber().ssnValid();
//        commonLocator.ssnField.sendKeys(fakeSsn);
//
//
//        WaitUtils.waitFor(2);
//
//    }


//    @Given("connect to DataBase")
//    public void connect_to_database() throws SQLException {
//        connection = DriverManager.getConnection("jdbc:postgresql://managementonschools.com:5432/school_management", "select_user", "43w5ijfso");
//
//    }

    @Given("send get All dean request on API")
    public void send_get_All_dean_request_on_API() {
        https://managementonschools.com/app/teachers/getAll
        spec.pathParams("first", "dean", "second", "getAll").queryParams("size", "10000");
        response = given(spec).get("{first}/{second}");
        response.prettyPrint();
    }

    @Then("validate that dean created")
    //public void filter_dean_Data_using_username_and_validate() {
    public void validate_that_dean_created() {
        JsonPath jsonPath = response.jsonPath();
//        List<String> deanData = jsonPath.getList("findAll{it.username=='" + fakerUsername + "'}");
//        System.out.println("deanData = " + deanData);
        String actId = jsonPath.getList("findAll{it.username=='" + fakerUsername + "'}.id").get(0).toString();
        String actUsername = jsonPath.getList("findAll{it.username=='" + fakerUsername + "'}.username").get(0).toString();
        String actName = jsonPath.getList("findAll{it.username=='" + fakerUsername + "'}.name").get(0).toString();
        String actSurname = jsonPath.getList("findAll{it.username=='" + fakerUsername + "'}.surname").get(0).toString();
        String actBirthDay = jsonPath.getList("findAll{it.username=='" + fakerUsername + "'}.birthDay").get(0).toString();
        String actSsn = jsonPath.getList("findAll{it.username=='" + fakerUsername + "'}.ssn").get(0).toString();
        String actBirthPlace = jsonPath.getList("findAll{it.username=='" + fakerUsername + "'}.birthPlace").get(0).toString();
        String actPhoneNumber = jsonPath.getList("findAll{it.username=='" + fakerUsername + "'}.phoneNumber").get(0).toString();
        String actGender = jsonPath.getList("findAll{it.username=='" + fakerUsername + "'}.gender").get(0).toString();
        // String actPassword = jsonPath.getList("findAll{it.username=='" + fakerUsername + "'}.password").get(0).toString();


        assertEquals(200, response.statusCode());
        assertEquals(fakerName, actName);
        assertEquals(fakerSurname, actSurname);
        assertEquals(fakeSsn, actSsn);
        assertEquals(formattedDate, actBirthDay);
        assertEquals(fakerBirthPlace, actBirthPlace);
        assertEquals(fakerFormattedPhoneNumber, actPhoneNumber);
        assertEquals("Female", actGender);
        assertEquals(fakerUsername, actUsername);
        //assertEquals(fakerPassword, actPassword);
        assertEquals(id, actId);

    }

    @Then("get deanID from API")
    public void get_dean_id_from_api() {
        String deanID_String = response.jsonPath().getList("findAll{it.username=='" + deanUserName + "'}.id").get(0).toString();
        deanID = Integer.parseInt(deanID_String);
        System.out.println("deanID = " + deanID);
    }

    @Given("get dean Data by username")
    public void get_dean_Data_by_username() throws SQLException {
        String query = "select * from dean where username = '" + deanUserName + "'";
        resultSet = DBUtils.executeQuery(query);
        resultSet.next();
    }

    @Then("filter  username")
    public void filter_username() throws SQLException {
        String actualUsername = resultSet.getString("username");
        assertEquals(deanUserName, actualUsername);
    }


//DB


@When("get dean user via username {string}")
public void get_dean_user_via_username(String string) throws SQLException {
    statement = connection.createStatement();
    String sqlQuery = "select * from \"public\".dean where username='" + fakerUsername + "'";
    System.out.println(sqlQuery);
    resultSet = statement.executeQuery(sqlQuery);
}

    @Then("validate the credentials for dean")
    public void validateTheCredentialsFordean() throws SQLException, ParseException {

        resultSet.next();
        String actUsername = resultSet.getString("username");
        String actBirthDay = resultSet.getString("birth_day");
        String actBirth_place = resultSet.getString("birth_place");
        String actGender = resultSet.getString("gender");
        String actName = resultSet.getString("name");
        String actPhone_number = resultSet.getString("phone_number");
        String actSsn = resultSet.getString("ssn");
        String actSurname = resultSet.getString("surname");
        String actId = resultSet.getString("userId");
        SimpleDateFormat expectedDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String formattedExpectedDate = expectedDateFormat.format(expectedDateFormat.parse("25-05-1988"));
        String formattedActualDate = new SimpleDateFormat("dd-MM-yyyy").format(new SimpleDateFormat("yyyy-MM-dd").parse(actBirthDay));


        assertEquals(formattedExpectedDate, formattedActualDate);
        assertEquals(fakerBirthPlace, actBirth_place);
        assertEquals("Female", actGender);
        assertEquals(fakerName, actName);
        assertEquals(fakerFormattedPhoneNumber, actPhone_number);
        assertEquals(fakeSsn, actSsn);
        assertEquals(fakerSurname, actSurname);
        assertEquals(fakerUsername, actUsername);
        assertTrue(actId, true);
    }
}

