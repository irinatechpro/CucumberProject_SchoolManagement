package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TeacherMeetManagementPage {
    public TeacherMeetManagementPage(){PageFactory.initElements(Driver.getDriver(),this);}

    @FindBy(xpath = "//a[.='Meet Management']")
    public WebElement meetManagementButton;

    @FindBy(xpath = "(//input)[1]")
    public WebElement chooseStudentsArea;

    @FindBy(xpath = "//*[@type='date']")
    public WebElement dateOfMeetArea;

    @FindBy(xpath = "(//*[@type='time'])[1]")
    public WebElement startTimeArea;

    @FindBy(xpath = "(//*[@type='time'])[2]")
    public WebElement stopTimeArea;

    @FindBy(xpath = "//*[@placeholder='Description']")
    public WebElement descriptionArea;

    @FindBy(xpath = "//*[@role='alert']")
    public WebElement ileriBirTarihOlmalıAlert;

    @FindBy(xpath = "//form")
    public WebElement verifyElementsAtAddMeetAreEdited;

    @FindBy(xpath = "//table//tr[1]/td[2]")
    public WebElement verifyMeetDateIsVisible;
    @FindBy(xpath = "//table//tr[1]/td[3]")
    public WebElement verifyStartTimeIsVisible;
    @FindBy(xpath = "//table//tr[1]/td[4]")
    public WebElement verifyStopTimeIsVisible;
    @FindBy(xpath = "//table//tr[1]/td[5]")
    public WebElement verifyDescriptionIsVisible;
    @FindBy(xpath = "//table//tr[1]/td[6]")
    public WebElement editButton;
    @FindBy(id = "description")
    public WebElement descriptionUpdateField;
//"(//input[@class='form-control'])[4]"
    @FindBy(xpath = "(//button[@class='fw-semibold btn btn-primary btn-lg'])[2]")
    public WebElement updateSubmitButton;

    @FindBy(xpath = "/html/body/div[4]/div/div/div[2]/div[1]/div/div/form/div/div[1]/div/div/div[1]/div[2]")
    public WebElement updateStudentField;

    @FindBy(xpath = "//div[contains(text(), 'Meet Updated Successfully')]")
    public WebElement verifyMeetUpdatedMessage;

    @FindBy(xpath = "//table//tr[1]/td[7]")
    public WebElement deleteMeetButton;

    @FindBy(xpath = "//div[contains(text(), 'Meet deleted successfully')]")
    public WebElement verifyMeetDeletedMessage;

    @FindBy(xpath = "//a[.='Teacher Management']")
    public WebElement teacherManagementLInk;

    @FindBy(id="isAdvisorTeacher")
    public WebElement isAdvisorTeacher;

    @FindBy(id="password")
    public WebElement lastTeacherPassword;

}
