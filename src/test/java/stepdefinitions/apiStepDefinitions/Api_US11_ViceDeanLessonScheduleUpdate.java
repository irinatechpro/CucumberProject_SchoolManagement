package stepdefinitions.apiStepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import pojos.LessonManagementLessonName;
import pojos.LessonManagementLessonPost;
import pojos.LessonManagementObjectPojo;
import pojos.LessonManagementPojo;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

import static base_url.BaseUrl.spec;
import static base_url.BaseUrl.viceDeanSetUp;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Api_US11_ViceDeanLessonScheduleUpdate {
    Response response;

    LessonManagementLessonPost objectPost;
    LessonManagementObjectPojo object;
    LessonManagementPojo expectedData;
    LessonManagementLessonName lessonName;

    static int createdId;
    @When("send get request for viewing lesson Program")
    public void send_get_request_for_viewing_lesson_program() {
        //Set the url
        // https://managementonschools.com/app/lessonPrograms/getAll
        viceDeanSetUp();
        spec.pathParams("first", "lessonPrograms", "second","getAll");
        //Send the request and get the response
        response= given(spec).get("{first}/{second}");
       // response.prettyPrint();
    }
    @Then("validate that response data includes the lesson program")
    //validate that response data includes the lesson program
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
       // List<String> lesson = new ArrayList<>();
       // lesson.add("Selenium");
        //List<Integer> lessonId = new ArrayList<>();
       // lessonId.add(2);
        //List<Integer> lessonProgramId= new ArrayList<>();
       // lessonProgramId.add(951);
        // List<String> startTimes = jsonPath.getList("startTime");
    }


        //String actstartTime = jsonPath.getList("content.findAll{it.startTime=='3'}").get(0).toString();
        //        "lessonProgramId": 127,
//                "startTime": "13:31:00",
//                "stopTime": "13:32:00",
//                "lessonName": [
//        {
//            "lessonId": 6,
//                "lessonName": "JavaScript",
//                "creditScore": 8,
//                "compulsory": true
//        }
//        ],
//        "day": "FRIDAY"



    //Do assertion
      // response.then().statusCode(200);






        //"lessonProgramId": 3
       // System.out.println(jsonPath.getList("content.findAll{it.lessonProgramId=='33'}"));
       // List<String> lessonNames= jsonPath.getList("lessonName.lessonName");
       // List<Integer> lessonProgramIds = jsonPath.getList("lessonProgramId.lessonProgramId");



       // assertTrue(lessonNames.contains(lesson));
        //assertTrue(lessonIds.contains(lessonId));
  //  }


    @Given("Vice Dean sends post request for lesson program")
    public void viceDeanSendsPutRequestForLessonProgram() {
        viceDeanSetUp();
        spec.pathParams("first","lessonPrograms", "second", "save");

        ArrayList<Integer> lessonId = new ArrayList<>();
        lessonId.add(2);
        objectPost =new LessonManagementLessonPost(
                "MONDAY",
                Faker.instance().number().numberBetween(1,10),
                lessonId,
                "13:00","22:00");

        lessonName = new LessonManagementLessonName(2,"Java",10,true);
//        LessonManagementLessonName
//                "lessonId": 2,
//                "lessonName": "Java",
//                "creditScore": 10,
//                "compulsory": true

        ArrayList<LessonManagementLessonName> lessonNames=new ArrayList<>();
        lessonNames.add(lessonName);
        object = new LessonManagementObjectPojo(1728,"13:00","22:00",lessonNames,"MONDAY");
       // LessonManagementObjectPojo {
    /*
    "object": {
        "lessonProgramId": 1612,
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
    },
     */


        expectedData = new LessonManagementPojo(object,"Created Lesson Program","CREATED");
        response= given(spec).body(objectPost).post("{first}/{second}");

        System.out.println("objectPost = " + objectPost);
        System.out.println("expectedData = " + expectedData);
        response.prettyPrint();

        JsonPath jsonPath = response.jsonPath();
        createdId = (Integer.parseInt(jsonPath.getString("object.lessonProgramId")) - 1);

        System.out.println("createdId = " + createdId);
        //ReusableMethods.waitFor(3);
        
    }

    @Then("Vice Dean update the lesson program and assert")
    public void viceDeanUpdateTheLessonProgramAndAssert() {

        LessonManagementPojo actualData = response.as(LessonManagementPojo.class);
                //as(LessonManagementPojo.class);
        assertEquals(expectedData.getObject().getDay(),actualData.getObject().getDay());
        assertEquals(expectedData.getObject().getStopTime(),actualData.getObject().getStopTime().substring(0,5));
        assertEquals(expectedData.getObject().getStartTime(),actualData.getObject().getStartTime().substring(0,5));
        
    }

    @Then("send delete request for deleting lesson Program")
    public void sendDeleteRequestForDeletingLessonProgram() {
    }



}
