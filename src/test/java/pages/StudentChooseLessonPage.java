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

    @FindBy(xpath = "//input[@value='335']")
    public WebElement selectedLessonCheckBox1;

    @FindBy(xpath = "//button[.='Submit']")
    public WebElement submitButton;

    @FindBy(xpath = "(//tbody)[2]/tr/td[1]")
    public WebElement addedlessonsList;

    @FindBy(xpath = "//div[@role='alert']")
    public WebElement lessonAddedToStudentAlertMessage;

    @FindBy(xpath = "//div[@role='alert']")
    public WebElement collisionErrorAlertMessage;

    @FindBy(xpath = "(//tbody)[2]/tr/td[1]/*[.='Cypress']")
    public WebElement addedLesson;

    @FindBy(xpath = "//*[.='Menu']")
    public WebElement menuButton;

    @FindBy(xpath = "//*[.='Grades and Announcements']")
    public WebElement gradesAndAnnouncementsLink;

    @FindBy(xpath = "(//tbody[@class='table-group-divider'])[1]")
    public WebElement studentGradeList;

    @FindBy(xpath = "(//tbody[@class='table-group-divider'])[2]")
    public WebElement studentMeetingList;

}