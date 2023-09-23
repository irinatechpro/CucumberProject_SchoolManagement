package stepdefinitions.apiStepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import pojos.LessonManagementLessonName;
import pojos.LessonManagementLessonPost;
import pojos.LessonManagementObjectPojo;
import pojos.LessonManagementPojo;
import utilities.JsonUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static base_url.BaseUrl.spec;
import static base_url.BaseUrl.viceDeanSetUp;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
public class Api_US11_ViceDeanLessonScheduleUpdate {
      LessonManagementLessonPost objectPost;
    LessonManagementObjectPojo object;
    LessonManagementPojo expectedData;
    LessonManagementLessonName lessonName;
    Response response;
    static int createdId;
  //-----------------------------TC01--------------------------------
    @When("send get request for viewing lesson Program")

    public void send_get_request_for_viewing_lesson_program() {
                viceDeanSetUp();
        spec.pathParams("first", "lessonPrograms", "second","getAll");
        response= given(spec).when().get("{first}/{second}");
       // response.prettyPrint();
    }
    @Then("validate that response data includes the lesson program")

    public void validate_that_response_data_includes_the_lesson_program() {
        response.then().statusCode(200);
        JsonPath jsonPath = response.jsonPath();

        List<String> lessonNames = jsonPath.getList("lessonName.lessonName");
        List<Integer> lessonIds = jsonPath.getList("lessonName.lessonId");
        List<Integer> lessonProgramIds = jsonPath.getList("lessonProgramId");
        List<String> startTimes = jsonPath.getList("startTime");
        List<String> stopTimes = jsonPath.getList("stopTime");
        List<String> days = jsonPath.getList("day");
        System.out.println("lessonNames = " + lessonNames );
        System.out.println("lessonIds = " + lessonIds);
        System.out.println("lessonProgramIds = " + lessonProgramIds);
        System.out.println("startTimes= "+ startTimes);
        System.out.println("stopTimes= "+ stopTimes);
        System.out.println("days= "+ days);

        ArrayList<String> lesson = new ArrayList<>();
         lesson.add("Selenium");
        assertTrue(lessonNames.contains(lesson));

        ArrayList<Integer> lessonId = new ArrayList<>();
        lessonId.add(39);
        assertTrue(lessonIds.contains(lessonId));
    }
    //------------------------------TC02----------------------------------------
    @When ("Vice Dean sends post request for lesson program")
    public void viceDeanSendsPutRequestForLessonProgram() {
        viceDeanSetUp();
        spec.pathParams("first","lessonPrograms", "second", "save");

        ArrayList<Integer> lessonId = new ArrayList<>();
        lessonId.add(2);
        objectPost =new LessonManagementLessonPost(
                "MONDAY",
                Faker.instance().number().numberBetween(1,6),
                lessonId,
                "13:00","22:00");

        lessonName = new LessonManagementLessonName(2,"Java",10,true);

//                "lessonId": 2,
//                "lessonName": "Java",
//                "creditScore": 10,
//                "compulsory": true

        ArrayList<LessonManagementLessonName> lessonNames=new ArrayList<>();
        lessonNames.add(lessonName);
        object = new LessonManagementObjectPojo(1728,"13:00","22:00",lessonNames,"MONDAY");

    /*
    "object": {
        "lessonProgramId": 1728,
                "startTime": "13:00:00",
                "stopTime": "22:00:00",
                "lessonName": [
        {
            "lessonId": 2,
                "lessonName": "Java",
                "creditScore": 10,
                "compulsory": true
        }
        ],
        "day": "MONDAY"
      */
        expectedData = new LessonManagementPojo(object,"Created Lesson Program","CREATED");
        response= given(spec).body(objectPost).post("{first}/{second}");

        System.out.println("objectPost = " + objectPost);
        System.out.println("expectedData = " + expectedData);
        response.prettyPrint();

        JsonPath jsonPath = response.jsonPath();
        createdId = (Integer.parseInt(jsonPath.getString("object.lessonProgramId")) - 1);

        System.out.println("createdId = " + createdId);

    }
    @Then("Vice Dean update the lesson program and assert")
    public void viceDeanUpdateTheLessonProgramAndAssert() {

         // HashMap actualData= JsonUtils.convertJsonToJava(response.asString(),HashMap.class);
         HashMap actualData = response.as(HashMap.class);
       // LessonManagementPojo actualData = response.as(LessonManagementPojo.class);
       System.out.println("actualData = " + actualData);

    //   assertEquals(expectedData,actualData);
       // assertEquals(expectedData.getObject(),actualData.getClass());
      //assertEquals(expectedData.getObject().getDay(),actualData.getObject().
    // assertEquals(expectedData.getObject().getStopTime(),actualData.get(object.getStopTime().substring(0,5)));
       // assertEquals(expectedData.getObject().getStartTime(),actualData.getObject().getStartTime().substring(0,5));

    }
//-----------------------------------TC03--------------------------------------------
    @Then("send delete request for deleting lesson Program")
    public void sendDeleteRequestForDeletingLessonProgram() {
        viceDeanSetUp();
        System.out.println("createdId = " + createdId);
        spec.pathParams("first","lessonPrograms","second","delete", "third",createdId);

        Map<String,String> expectedData = new HashMap<>();
        expectedData.put("message","Lesson Program Deleted");
        expectedData.put("httpStatus","OK");

       Response response=given(spec).delete("{first}/{second}/{third}");
        response.prettyPrint();
       HashMap actualData= JsonUtils.convertJsonToJava(response.asString(),HashMap.class);

        assertEquals(200,response.getStatusCode());
        assertEquals(expectedData,actualData);
        System.out.println("actualData = " + actualData);
        System.out.println("expectedData = " + expectedData);

    }
}
