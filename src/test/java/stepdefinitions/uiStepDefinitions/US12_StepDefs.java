package stepdefinitions.uiStepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.CommonLocator;
import pages.ViceDeanLessonProgram;
import pages.ViceDean_LessonManagementPage;
import utilities.*;

import java.util.List;

import static base_url.BaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class US12_StepDefs {
    ViceDeanLessonProgram viceDeanLessonProgram=new ViceDeanLessonProgram();
    ViceDean_LessonManagementPage viceDean_lessonManagementPage=new ViceDean_LessonManagementPage();
    CommonLocator commonLocator=new CommonLocator();
    Faker faker=new Faker();
    Response response;
    public Integer teacherId;
    public Integer lessonId;
    @When("the Education Term Management page loads up")
    public void the_education_term_management_page_loads_up() {
        WaitUtils.waitForVisibility(viceDeanLessonProgram.educationTermManagement,3);
        Assert.assertTrue(viceDeanLessonProgram.educationTermManagement.isDisplayed());
        WaitUtils.waitFor(3);

    }
    @Then("Vice Dean click on Lesson Program")
    public void vice_dean_click_on_lesson_program() {
      JSUtils.clickWithTimeoutByJS(viceDean_lessonManagementPage.lessonProgram);
      WaitUtils.waitFor(3);

    }
    @Then("Vice Dean scroll down until see Lesson Program Assignment")
    public void vice_dean_scroll_down_until_see_lesson_program_assignment() {
        ActionUtils.scrollDownActions();
        WaitUtils.waitForVisibility(viceDeanLessonProgram.lessonProgramAssignment,2);
        Assert.assertTrue(viceDeanLessonProgram.lessonProgramAssignment.isDisplayed());
        WaitUtils.waitFor(3);
    }
    @Then("Vice Dean should see the created lesson")
    public void vice_dean_should_see_the_created_lesson() {
        WaitUtils.waitForVisibility(viceDeanLessonProgram.createdLessonVisible,3);
       Assert.assertTrue(viceDeanLessonProgram.createdLessonVisible.isDisplayed());


    }
    @Then("Vice Dean  tick to choose lesson")
    public void vice_dean_tick_to_choose_lesson() {
        JSUtils.scrollIntoViewJS(viceDeanLessonProgram.chooseLesson);
        lessonId=faker.number().numberBetween(1,100);

       JSUtils.clickWithTimeoutByJS (viceDeanLessonProgram.chooseLesson.findElement(By.xpath("(//input[@id='lessonProgramId'])["+lessonId+"]")));

    }
    @Then("Vice Dean should scroll down until see the Choose Teacher")
    public void vice_dean_should_scroll_down_until_see_the_choose_teacher() {
      //  ActionUtils.scrollDownActions();
        JSUtils.scrollIntoViewJS(viceDeanLessonProgram.chooseTeacher);
        Assert.assertTrue(viceDeanLessonProgram.chooseTeacher.isDisplayed());

    }
    @Then("Vice Dean click on Choose Teacher")
    public void vice_dean_click_on_choose_teacher() {
        JSUtils.clickWithTimeoutByJS(viceDeanLessonProgram.chooseTeacher);
        WaitUtils.waitFor(3);

    }
    @Then("Vice Dean select teacher")
    public void vice_dean_select_teacher() {
        teacherId= faker.number().numberBetween(1,100);
    viceDeanLessonProgram.chooseTeacher.findElement(By.xpath("//select[@id='teacherId']//option[@value='"+teacherId+"']")).click();
        WaitUtils.waitFor(3);

    }
    @Then("Vice Dean click on submit button")
    public void vice_dean_click_on_submit_button() {
        JSUtils.clickWithTimeoutByJS(viceDeanLessonProgram.submitButton);

    }
    @Then("Vice Dean should see Lesson added to Teacher")
    public void vice_dean_should_see_lesson_added_to_teacher() {

        WaitUtils.waitForVisibility(viceDeanLessonProgram.successMessage,5);
        assertTrue(viceDeanLessonProgram.successMessage.getText().contains("Lesson added to"));

    }


    @Given("send GET request to lesson programs with getAllAssigned")
    public void sendGETRequestToLessonProgramsWithGetAllAssigned() {
        //https://managementonschools.com/app/lessonPrograms/getAllAssigned
        spec.pathParams("first","lessonPrograms","second","getAllAssigned");
        response=given(spec).get("{first}/{second}");
        response.prettyPrint();
        
    }

    @Then("validate that teacher is assign to lesson")
    public void validateThatTeacherIsAssignToLesson() {
        JsonPath jsonPath=response.jsonPath();
        String actTeacherName=jsonPath.getList("teachers.findAll{it.lessonProgramId=='Lincoln McDermott'}.name").get(0).toString();
      assertEquals(200,response.statusCode());
        assertEquals(teacherId,actTeacherName);
    }
}
