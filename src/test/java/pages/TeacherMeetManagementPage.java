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

    @FindBy(xpath = "//a[.='Teacher Management']")
    public WebElement teacherManagementLInk;

    @FindBy(id="isAdvisorTeacher")
    public WebElement isAdvisorTeacher;

    @FindBy(id="password")
    public WebElement teacherPassword;

}
