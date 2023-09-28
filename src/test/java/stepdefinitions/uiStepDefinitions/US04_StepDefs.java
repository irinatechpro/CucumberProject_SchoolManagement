package stepdefinitions.uiStepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import pages.CommonLocator;
import pages.DeanCreatePage;
import utilities.JSUtils;
import utilities.WaitUtils;

import java.util.List;

import static base_url.BaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class US04_StepDefs {

    Faker faker = new Faker();
    CommonLocator commonLocator = new CommonLocator();

    DeanCreatePage deanCreatePage=new DeanCreatePage();

    Response response;

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

    @Given("send get All dean request on API")
    public void send_get_all_dean_request_on_api() {
        spec.pathParams("first", "dean","second","getAll");
        response = given(spec).get("{first}/{second}");
        response.prettyPrint();
    }
    @Then("validate that dean created")
    public void validate_that_dean_created() {
        JsonPath jsonPath = response.jsonPath();
        List<String> deanData = jsonPath.getList("findAll{it.username=='dierdre.graham'}");
        String actUsername = jsonPath.getList("findAll{it.username=='dierdre.graham'}.username").get(0).toString();
        System.out.println("deanData = " + deanData);
        assertEquals("dierdre.graham", actUsername);


    }

    }



