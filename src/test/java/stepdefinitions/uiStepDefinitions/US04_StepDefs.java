package stepdefinitions.uiStepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import pages.CommonLocator;
import pages.CreateStudentPage;
import pages.DeanCreatePage;
import utilities.Driver;
import utilities.JSUtils;
import utilities.WaitUtils;

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

    Response response;

    Faker faker = new Faker();
    CommonLocator commonLocator = new CommonLocator();

    DeanCreatePage deanCreatePage=new DeanCreatePage();




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
        spec.pathParams("first", "dean", "second", "getAll");
        response = given(spec).get("{first}/{second}");
    }

    @Then("filter dean Data using username and validate")
    public void filter_dean_Data_using_username_and_validate(){
        JsonPath jsonPath = response.jsonPath();
        List<String> studentData = jsonPath.getList("findAll{it.username=='"+deanUserName+"'}");
        System.out.println("studentData = " + studentData);
        String actUsername = jsonPath.getList("findAll{it.username=='"+deanUserName+"'}.username").get(0).toString();
        String actName = jsonPath.getList("findAll{it.username=='"+deanUserName+"'}.name").get(0).toString();
        String actSurname = jsonPath.getList("findAll{it.username=='"+deanUserName+"'}.surname").get(0).toString();
        String actBirthDay = jsonPath.getList("findAll{it.username=='"+deanUserName+"'}.birthDay").get(0).toString();
        String actBirthPlace = jsonPath.getList("findAll{it.username=='"+deanUserName+"'}.birthPlace").get(0).toString();
        String actPhoneNumber = jsonPath.getList("findAll{it.username=='"+deanUserName+"'}.phoneNumber").get(0).toString();
        String actGender = jsonPath.getList("findAll{it.username=='"+deanUserName+"'}.gender").get(0).toString();

        String actSsn = jsonPath.getList("findAll{it.username=='"+deanUserName+"'}.ssn").get(0).toString();

        assertEquals(200, response.statusCode());
        assertEquals(deanUserName, actUsername);
        assertEquals(fakeSsn, actSsn);
        assertEquals(fakerName, actName);
        assertEquals(fakerSurname, actSurname);
        assertEquals(formattedDate, actBirthDay);
        assertEquals(fakerBirthPlace, actBirthPlace);
        assertEquals(fakerFormattedPhoneNumber, actPhoneNumber);
        assertEquals("MALE", actGender);

    }

//    @And("enter username {string}")
//    public void enterUsername(String username) {
//        commonLocator.usernameField.sendKeys(faker.name().firstName());
//    }

//   ?? @Then("enter dean username")
//    public void enter_dean_username() {
//        DeanUserName = faker.name().username();
//        commonLocator.usernameField.sendKeysDeanUserName);
//        WaitUtils.waitFor(2);
//    }
//
//    @And("enter password {string}")
//    public void enterPassword(String password) {
//        commonLocator.passwordField.sendKeys(password);
//    }


//    @Then("verify dean number created automatically")
//    public void verify_dean_number_created_automatically() {
//        WaitUtils.waitFor(5);
//        JSUtils.scrollIntoViewJS(deanCreatePage.lastRow);
//        WaitUtils.waitFor(5);
//        String lastRow = deanCreatePage.lastRow.getText();
//        System.out.println("lastRow = " + lastRow);
//        Assert.assertTrue(lastRow.contains(DeanUserName));
//        String numberText = CreateStudentPage.firstColumnInLastRow.getText();
//
//        // Perform assertion to check if it's a 4-digit number
//        if (numberText.matches("\\d{4}")) {
//            System.out.println("Assertion passed: The number is a 4-digit number");
//        } else {
//            System.out.println("Assertion failed: The number is not a 4-digit number");
//        }
//
//    }


    }



