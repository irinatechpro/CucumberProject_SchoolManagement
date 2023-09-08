package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.DeanContactGetAllPage;
import pages.ViceDean_AdminManagementPage;
import pages.ViceDean_LessonManagementPage;

import static utilities.WaitUtils.waitFor;

public class US16_StepDefs {
    ViceDean_AdminManagementPage viceDeanAdminManagementPage= new ViceDean_AdminManagementPage();
   ViceDean_LessonManagementPage viceDean_lessonManagementPage = new ViceDean_LessonManagementPage();
    DeanContactGetAllPage deanContactGetAllPage = new DeanContactGetAllPage();
   @And("click Menu button")
   public void clickMenuButton() {
      waitFor(2);
      viceDeanAdminManagementPage.navMenuButton.click();
      waitFor(2);
  }
    @And("click Contact Get All button")
    public void click_contact_get_all_button() {
        waitFor(2);
        de
        waitFor(2);

   }
    @Then("Verify Delete button is visible")
    public void verify_delete_button_is_visible() {

    }

    @Then("verify message is seen")
    public void verify_message_is_seen() {

    }
    @Then("verify Name is seen")
    public void verify_name_is_seen() {

    }
    @Then("verify Email is seen")
    public void verify_email_is_seen() {

    }
    @Then("verify Date is seen")
    public void verify_date_is_seen() {

    }
    @Then("verify Subject is seen")
    public void verify_subject_is_seen() {

    }

    @Then("verify message is deleted")
    public void verify_message_is_deleted() {

    }



}
