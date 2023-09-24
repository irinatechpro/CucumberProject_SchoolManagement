package stepdefinitions.uiStepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import pages.CommonLocator;
import pages.DeanCreatePage;
import utilities.DBUtils;
import utilities.JSUtils;
import utilities.WaitUtils;

import java.sql.*;
import java.util.List;

import static base_url.BaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static stepdefinitions.uiStepDefinitions.CommonStepDefs.*;


public class US04_StepDefs {


    public Statement statement;
    Connection connection;

    Response response;
    ResultSet resultSet;

    Faker faker = new Faker();
    CommonLocator commonLocator = new CommonLocator();

    DeanCreatePage deanCreatePage = new DeanCreatePage();

    public US04_StepDefs() throws SQLException {
    }


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


    //DB

    @Given("connect to dean database")
    public void connect_to_dean_database() throws SQLException {

        connection = DriverManager.getConnection("jdbc:postgresql://managementonschools.com:5432/school_management", "select_user", "43w5ijfso");
    }


    @Given("get dean Data by username")
    public void get_dean_Data_by_username() throws SQLException {
        String query = "select * from dean where username = '" + fakerUsername + "'";
        // String query = "select * from dean where username = '" + username + "'";
        resultSet = DBUtils.executeQuery(query);
        resultSet.next();

    }

    @Then("validate dean created on db")
    public void validate_dean_created_on_db() throws SQLException {

        String actualUsername = resultSet.getString("username");
        String actualSSN = resultSet.getString("ssn");
        String actualBirth_day = resultSet.getString("birth_day");
        String actualBirth_place = resultSet.getString("birth_place");
        String actualGender = resultSet.getString("gender");
        String actualName = resultSet.getString("name");
        String actualSurname = resultSet.getString("surname");
        String actualPhoneNumber = resultSet.getString("phone_number");


        assertEquals(fakerUsername, actualUsername);
        assertEquals(fakeSsn, actualSSN);
        assertEquals(fakerName, actualName);
        assertEquals(fakerSurname, actualSurname);
        assertEquals(formattedDate, actualBirth_day);
        assertEquals(fakerBirthPlace, actualBirth_place);
        assertEquals(fakerFormattedPhoneNumber, actualPhoneNumber);
        assertEquals("1", actualGender);


    }


//API


    @Given("send get All dean request on API")
    public void send_get_All_dean_request_on_API() {
        https://managementonschools.com/app/dean/getAll
        spec.pathParams("first", "dean", "second", "getAll");
        response = given(spec).get("{first}/{second}");
        response.prettyPrint();
    }

    @Then("validate that dean created")
    public void validate_that_dean_created() {


//  JsonPath jsonPath = response.jsonPath();
//        List<String> deanData = jsonPath.getList("findAll{it.username=='dierdre.graham'}");
//        String actUsername = jsonPath.getList("findAll{it.username=='dierdre.graham'}.username").get(0).toString();
//        System.out.println("deanData = " + deanData);
//        assertEquals("dierdre.graham", actUsername);


        JsonPath jsonPath = response.jsonPath();
        List<String> deanData = jsonPath.getList("findAll{it.username=='" + fakerUsername + "'}");
        System.out.println("deanData = " + deanData);
        String actUsername = jsonPath.getList("findAll{it.username=='" + fakerUsername + "'}.username").get(0).toString();
        String actName = jsonPath.getList("findAll{it.username=='"+fakerUsername+"'}.name").get(0).toString();
        String actSurname = jsonPath.getList("findAll{it.username=='"+fakerUsername+"'}.surname").get(0).toString();
        String actBirthDay = jsonPath.getList("findAll{it.username=='"+fakerUsername+"'}.birthDay").get(0).toString();
        String actBirthPlace = jsonPath.getList("findAll{it.username=='"+fakerUsername+"'}.birthPlace").get(0).toString();
        String actPhoneNumber = jsonPath.getList("findAll{it.username=='"+fakerUsername+"'}.phoneNumber").get(0).toString();
        String actGender = jsonPath.getList("findAll{it.username=='"+fakerUsername+"'}.gender").get(0).toString();
        String actSsn = jsonPath.getList("findAll{it.username=='"+fakerUsername+"'}.ssn").get(0).toString();

        assertEquals(200, response.statusCode());
        assertEquals(fakerUsername, actUsername);
        assertEquals(fakeSsn, actSsn);
        assertEquals(fakerName, actName);
        assertEquals(fakerSurname, actSurname);
        assertEquals(formattedDate, actBirthDay);
        assertEquals(fakerBirthPlace, actBirthPlace);
        assertEquals(fakerFormattedPhoneNumber, actPhoneNumber);
        assertEquals("FEMALE", actGender);



//    @Then("get deanID from API")
//    public void get_dean_id_from_api() {
//        String deanID_String = response.jsonPath().getList("findAll{it.username=='" + deanUserName + "'}.id").get(0).toString();
//        userId = Integer.parseInt(deanID_String);
//        System.out.println("deanID = " + userId);
//    }

//
//    @And("enter username for dean")
//    public void enterUsernameForDean() {
//        do {
//            fakeUsername = faker.name().username();
//        } while (fakeUsername.length() <= 4);
//
//        commonLocator.usernameField.sendKeys(fakeUsername);
//        WaitUtils.waitFor(2);
//        System.out.println("fakeUsername = " + fakeUsername);
//    }


    }
}




