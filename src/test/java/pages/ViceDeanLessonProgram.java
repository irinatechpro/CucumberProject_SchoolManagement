package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ViceDeanLessonProgram {
    public ViceDeanLessonProgram(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    // to check if the Education Term Management is displayed on the page
    @FindBy(xpath = "//h3[.='Education Term Management']")
    public WebElement educationTermManagement;

    //in lesson program page to see Lesson Program Assignment field is in there
    @FindBy(xpath = "//h5[.='Lesson Program Assignment']")
    public WebElement lessonProgramAssignment;
    //if the created lesson is visible

    @FindBy(xpath = "(//td//span[.='English'])[2]")
    public WebElement createdLessonVisible;

    @FindBy(xpath = "(//input[@id='lessonProgramId'])[2]")
    public WebElement chooseLesson;

    @FindBy(xpath = "//select[@id='teacherId']")
    public WebElement chooseTeacher;
    @FindBy(xpath = "(//button[.='Submit'])[4]")
    public WebElement submitButton;
    @FindBy(xpath = "//div[@role='alert']")
    public WebElement successMessage;
    @FindBy(xpath = "//*[@data-rr-ui-event-key='lessonProgram']")
    public WebElement lessonProgramSeccion;
    @FindBy(xpath = "(//button[.='Submit'])[3]")
    public WebElement addLessonProgSubmitButton;









}
