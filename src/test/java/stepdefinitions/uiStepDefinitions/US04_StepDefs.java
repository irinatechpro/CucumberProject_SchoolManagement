package stepdefinitions.uiStepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import pages.CommonLocator;
import pages.CreateStudentPage;
import pages.DeanCreatePage;
import utilities.DBUtils;
import utilities.Driver;
import utilities.JSUtils;
import utilities.WaitUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import static base_url.BaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static stepdefinitions.uiStepDefinitions.CommonStepDefs.*;
import static stepdefinitions.uiStepDefinitions.CommonStepDefs.fakerFormattedPhoneNumber;
public class US04_StepDefs {

    private static String deanUserName;
    private static String dean;
    private static String deanData;
    public static String id;

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

    @Given("send get All dean request on API")
    public void send_get_All_dean_request_on_API() {
        https://managementonschools.com/app/dean/getAll
        spec.pathParams("first","dean","second","getAll");
        response = given(spec).get("{first}/{second}");
        response.prettyPrint();
    }

    @Then("validate that dean created")
    //public void filter_dean_Data_using_username_and_validate() {
    public void validate_that_dean_created() {
        JsonPath jsonPath = response.jsonPath();
        List<String> deanData = jsonPath.getList("findAll{it.username=='" + fakerUsername + "'}");
        System.out.println("deanData = " + deanData);

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
        String actBirthDay=resultSet.getString("birth_day");
        String actBirth_place = resultSet.getString("birth_place");
        String actGender = resultSet.getString("gender");
        String actName = resultSet.getString("name");
        String actPhone_number = resultSet.getString("phone_number");
        String actSsn = resultSet.getString("ssn");
        String actSurname = resultSet.getString("surname");
        String actId = resultSet.getString("userId");
        SimpleDateFormat expectedDateFormat= new SimpleDateFormat("dd-MM-yyyy");
        String formattedExpectedDate = expectedDateFormat.format(expectedDateFormat.parse("25-05-1988"));
        String formattedActualDate= new SimpleDateFormat("dd-MM-yyyy").format(new SimpleDateFormat("yyyy-MM-dd").parse(actBirthDay));
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

