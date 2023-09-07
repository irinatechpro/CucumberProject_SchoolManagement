package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class CreateStudentPage {

    public CreateStudentPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "fatherName")
    public WebElement fatherNameField;

    @FindBy(id="motherName")
    public WebElement motherNameField;

    @FindBy(id="advisorTeacherId")
    public WebElement advisorTeacherDropBox;

    @FindBy(id = "email")
    public WebElement emailField;
}
