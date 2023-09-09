package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.TeacherMeetManagementPage;
import utilities.JSUtils;

public class US24_StepDefs {
    TeacherMeetManagementPage teacherMeetManagementPage=new TeacherMeetManagementPage();
    @Given("click Teacher Management Link")
    public void click_teacher_management_link() {
        JSUtils.clickWithTimeoutByJS(teacherMeetManagementPage.teacherManagementLInk);
    }
    @Then("select is Advisor Teacher")
    public void select_is_Advisor_Teacher(){
        JSUtils.clickWithTimeoutByJS(teacherMeetManagementPage.isAdvisorTeacher);
    }
@Given("enter Invalid Password")
    public void enter_Invalid_Password(){

}
}
