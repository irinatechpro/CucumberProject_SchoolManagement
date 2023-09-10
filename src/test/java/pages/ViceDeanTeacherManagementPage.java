package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import utilities.WaitUtils;

public class ViceDeanTeacherManagementPage {
    public ViceDeanTeacherManagementPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(linkText = "Teacher Management")
    public WebElement teacherManagementLink;
    @FindBy(xpath = "//input[@role='combobox']")
    public WebElement chooseLesson;

    @FindBy(id = "isAdvisorTeacher")
    public WebElement advisoryRole;
    @FindBy(id="name")
    public WebElement teacherName;
    @FindBy(xpath = "//div[.='Required']")
    public WebElement failRequired;
    @FindBy(xpath = "//div[.='At least 8 characters']")
    public WebElement failAtLeast8Characters;
}
