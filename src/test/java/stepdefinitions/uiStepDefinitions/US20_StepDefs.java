package stepdefinitions.uiStepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.TeacherMeetManagementPage;
import utilities.BrowserUtils;
import utilities.Driver;
import utilities.JSUtils;
import utilities.WaitUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static utilities.WaitUtils.waitFor;

public class US20_StepDefs {

      TeacherMeetManagementPage teacherMeetManagementPage = new TeacherMeetManagementPage();
//
//    @And("Verify the date is visible")
//    public void verifyTheDateIsVisible() {
//    }
//
//    @And("Verify the start time is visible")
//    public void verifyTheStartTimeIsVisible() {
//    }
//
//    @And("Verify the stop time is visible")
//    public void verifyTheStopTimeIsVisible() {
//    }
//
//    @And("Verify the description is visible")
//    public void verifyTheDescriptionIsVisible() {
//    }

    @And("select Student")
    public void selectStudent() {
        waitFor(4);
        teacherMeetManagementPage.chooseStudentsArea.sendKeys("Adam Wiegand", Keys.ENTER);
    }
//String[] args)
    @And("enter Start Time")
    public void enterStartTime() {

                Faker faker = new Faker();

                // Saati 10 ile 11 arasında rastgele seçin
                int hour = faker.number().numberBetween(9, 11);

                // Dakikayı 0 ile 59 arasında rastgele seçin
                int minute = faker.number().numberBetween(0, 59);

                // AM'i belirtin
                String amPm = "AM";

                // Saat ve dakika değerlerini "hours:minAM" formatında birleştirin
                String randomTime = String.format("%02d:%02d%s", hour, minute, amPm);

                teacherMeetManagementPage.startTimeArea.sendKeys(randomTime);
            }


    @And("enter Stop Time")
    public void enterStopTime() {
        waitFor(2);
        teacherMeetManagementPage.stopTimeArea.sendKeys("11:30AM");
    }

    @And("enter Description of meet")
    public void enterDescriptionOfMeet() {
        waitFor(2);
        teacherMeetManagementPage.descriptionArea.sendKeys("Test Results");
    }

    @And("Verify the date is visible")
    public void verifyTheDateIsVisible() {
        WaitUtils.waitFor(1);
        BrowserUtils.verifyElementDisplayed(teacherMeetManagementPage.verifyMeetDateIsVisible);
    }

    @And("select Date Of Meeting")
    public void selectDateOfMeeting() {

        // 2023 Ekim'den sonraki bir tarih üretebilmek için özelleştirilmiş bir tarih üretme işlevi
        Date randomDate = generateFutureDate(2023, 10);

        // Tarihi "day/month/year" formatına dönüştürün
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String randomDateStr = dateFormat.format(randomDate);

        teacherMeetManagementPage.dateOfMeetArea.sendKeys(randomDateStr);

    }

    private static Date generateFutureDate(int year, int month) {
        Calendar calendar = Calendar.getInstance();

        // 2023 Ekim'den sonrası için özelleştirilmiş tarih üretme
        while (true) {
            int randomYear = Faker.instance().random().nextInt(year, year + 10); // 2023'den sonraki 10 yıl aralığı
            int randomMonth = Faker.instance().random().nextInt(1, 13); // 1 ile 12 arasında rastgele bir ay

            if (randomYear > year || (randomYear == year && randomMonth >= month)) {
                // Belirtilen tarihten sonra bir tarih bulundu
                calendar.set(Calendar.YEAR, randomYear);
                calendar.set(Calendar.MONTH, randomMonth - 1); // Calendar sıfır tabanlıdır, bu nedenle 1 eksiltiyoruz
                calendar.set(Calendar.DAY_OF_MONTH, 1); // İlk günü kullanabilirsiniz veya rastgele bir gün seçebilirsiniz
                break;
            }
        }

        return calendar.getTime();
    }

    @And("Verify the start time is visible")
    public void verifyTheStartTimeIsVisible() {
        BrowserUtils.verifyElementDisplayed(teacherMeetManagementPage.verifyStartTimeIsVisible);
    }

    @And("Verify the stop time is visible")
    public void verifyTheStopTimeIsVisible() {
        BrowserUtils.verifyElementDisplayed(teacherMeetManagementPage.verifyStopTimeIsVisible);
    }

    @And("Verify the description is visible")
    public void verifyTheDescriptionIsVisible() {
        BrowserUtils.verifyElementDisplayed(teacherMeetManagementPage.verifyDescriptionIsVisible);
    }

    @And("click on edit button")
    public void clickOnEditButton() {
        teacherMeetManagementPage.editButton.click();
    }

    @And("update description")
    public void updateDescription() {
       BrowserUtils.switchToWindow(0);
       WaitUtils.waitFor(1);
        Actions actions=new Actions(Driver.getDriver());
        actions.click(teacherMeetManagementPage.descriptionUpdateField).sendKeys("Alida Borer",Keys.ENTER).perform();
//       teacherMeetManagementPage.descriptionUpdateField.clear();
//        WaitUtils.waitFor(2);
//        teacherMeetManagementPage.descriptionUpdateField.sendKeys("Report meet2");
    }



    @And("user click on submit button")
    public void userClickOnSubmitButton() {
        teacherMeetManagementPage.updateSubmitButton.click();
    }

    @And("Verify meet is successfully updated")
    public void verifyMeetIsSuccessfullyUpdated() {
        BrowserUtils.verifyExpectedAndActualTextMatch("Meet Updated Successfully", teacherMeetManagementPage.verifyMeetUpdatedMessage);
    }

    @And("click on delete button")
    public void clickOnDeleteButton() {
        teacherMeetManagementPage.deleteMeetButton.click();
    }

    @And("Verify meet is successfully deleted")
    public void verifyMeetIsSuccessfullyDeleted() {
        BrowserUtils.verifyExpectedAndActualTextMatch("Meet deleted successfully", teacherMeetManagementPage.verifyMeetDeletedMessage);
    }
}



