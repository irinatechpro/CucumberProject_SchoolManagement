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

    @FindBy(id= "lessonProgramId")
    public WebElement lessonPrgramId;

    @FindBy(xpath = "//button[.='Submit']")
    public WebElement submitButton;

    @FindBy(xpath = "(//tbody)[2]/tr/td[1]")
    public WebElement lessonsListColumn;


}