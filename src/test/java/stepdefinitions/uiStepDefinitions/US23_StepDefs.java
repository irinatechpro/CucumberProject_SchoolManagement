package stepdefinitions.uiStepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import pages.CommonLocator;
import pages.CreateViceDeanPage;
import pages.DeanCreatePage;
import utilities.JSUtils;
import utilities.WaitUtils;

import java.util.List;

import static base_url.BaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static stepdefinitions.uiStepDefinitions.CommonStepDefs.*;
import static stepdefinitions.uiStepDefinitions.CommonStepDefs.fakerFormattedPhoneNumber;

public class US23_StepDefs {

    private static String vice_deanUserName;
    private static String vice_dean;
    private static String vice_dean_data;

    Response response;

    Faker faker = new Faker();
    CommonLocator commonLocator = new CommonLocator();

    CreateViceDeanPage createViceDeanPage=new CreateViceDeanPage();


    @Given("click Vice Dean Management Link")
    public void click_vice_dean_management_Link() {
        JSUtils.clickWithTimeoutByJS(createViceDeanPage.ViceDeanManagementLink);
    }


    @Given("verify Vice Dean created successfully confirmation message")
    public void verify_vice_dean_created_successfully_confirmation_message() {
        WaitUtils.waitForVisibility(commonLocator.confirmationMessage, 15);
        assertTrue(commonLocator.confirmationMessage.getText().contains("Vice dean Saved"));
    }

    @Given("send get All vice dean request on API")
    public void send_get_All_vice_dean_request_on_API() {
        spec.pathParams("first", "vice_dean", "second", "getAll");
        response = given(spec).get("{first}/{second}");
    }

    @Then("filter vice_dean Data using username and validate")
    public void filter_vice_dean_Data_using_username_and_validate(){
        JsonPath jsonPath = response.jsonPath();
        List<String> vice_deanData = jsonPath.getList("findAll{it.username=='"+vice_deanUserName+"'}");
        System.out.println("vice_deanData = " + vice_dean_data);
        String actUsername = jsonPath.getList("findAll{it.username=='"+vice_deanUserName+"'}.username").get(0).toString();
        String actName = jsonPath.getList("findAll{it.username=='"+vice_deanUserName+"'}.name").get(0).toString();
        String actSurname = jsonPath.getList("findAll{it.username=='"+vice_deanUserName+"'}.surname").get(0).toString();
        String actBirthDay = jsonPath.getList("findAll{it.username=='"+vice_deanUserName+"'}.birthDay").get(0).toString();
        String actBirthPlace = jsonPath.getList("findAll{it.username=='"+vice_deanUserName+"'}.birthPlace").get(0).toString();
        String actPhoneNumber = jsonPath.getList("findAll{it.username=='"+vice_deanUserName+"'}.phoneNumber").get(0).toString();
        String actGender = jsonPath.getList("findAll{it.username=='"+vice_deanUserName+"'}.gender").get(0).toString();

        String actSsn = jsonPath.getList("findAll{it.username=='"+vice_deanUserName+"'}.ssn").get(0).toString();

        assertEquals(200, response.statusCode());
        assertEquals(vice_deanUserName, actUsername);
        assertEquals(fakeSsn, actSsn);
        assertEquals(fakerName, actName);
        assertEquals(fakerSurname, actSurname);
        assertEquals(formattedDate, actBirthDay);
        assertEquals(fakerBirthPlace, actBirthPlace);
        assertEquals(fakerFormattedPhoneNumber, actPhoneNumber);
        assertEquals("MALE", actGender);

    }



}
