package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class StudentChooseLessonPage {
    public StudentChooseLessonPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//th[.='Teacher']")
    public WebElement teacherHeader;

    @FindBy(xpath = "(//th[.='Day'])[1]")
    public WebElement dayHeader;

    @FindBy(xpath = "(//th[.='Start Time'])[1]")
    public WebElement startTimeHeader;

    @FindBy(xpath = "(//th[.='Stop Time'])[1]")
    public WebElement stopTimeHeader;

    @FindBy(xpath = "//input[@value='130']")
    public WebElement selectedLessonCheckBox1;

    @FindBy(xpath = "//button[.='Submit']")
    public WebElement submitButton;

    @FindBy(xpath = "(//tbody)[2]/tr/td[1]")
    public WebElement lessonsProgramListColumn;

    @FindBy(xpath = "//div[@role='alert']")
    public WebElement lessonAddedToStudentAlertMessage;

    @FindBy(xpath = "//div[@role='alert']")
    public WebElement collisionErrorAlertMessage;

    @FindBy(xpath = "//*[@id='lessonId']/option[8]")
    public WebElement selectLesson;

}