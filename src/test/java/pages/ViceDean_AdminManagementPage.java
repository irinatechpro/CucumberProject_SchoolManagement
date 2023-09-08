package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ViceDean_AdminManagementPage {

    public ViceDean_AdminManagementPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //This is the menu button on the admin-management page
    @FindBy(xpath = "//header//button[.='Menu']")
    public WebElement navMenuButton;

    //1. Left-Side toggled menu links. This is for Teacher Management
    @FindBy(css = "div[role='dialog'] a:nth-child(1)")
    public WebElement toggleMenu_adminManagement;

    //2. Left-Side toggled menu links. This is for Dean Management
    @FindBy(css = "div[role='dialog'] a:nth-child(2)")
    public WebElement toggleMenu_deanManagement;

    //3. Left-Side toggled menu links. This is for Vice Dean Management
    @FindBy(css = "div[role='dialog'] a:nth-child(3)")
    public WebElement toggleMenu_viceDeanManagement;

    //4. Left-Side toggled menu links. This is for Lesson Management
    @FindBy(css = "div[role='dialog'] a:nth-child(4)")
    public WebElement toggleMenu_lessonManagement;

    //5. Left-Side toggled menu links. This is for Teacher Management
    @FindBy(css = "div[role='dialog'] a:nth-child(5)")
    public WebElement toggleMenu_teacherManagement;

    //6. Left-Side toggled menu links. This is for Student Management
    @FindBy(css = "div[role='dialog'] a:nth-child(6)")
    public WebElement toggleMenu_studentManagement;

    //7. Left-Side toggled menu links. This is for Student Info Management
    @FindBy(css = "div[role='dialog'] a:nth-child(7)")
    public WebElement toggleMenu_studentInfoManagement;

    //8. Left-Side toggled menu links. This is for Meet Management
    @FindBy(css = "div[role='dialog'] a:nth-child(8)")
    public WebElement toggleMenu_meetManagement;

    //9. Left-Side toggled menu links. This is for Choose Lesson
    @FindBy(css = "div[role='dialog'] a:nth-child(9)")
    public WebElement toggleMenu_chooseLesson;

    //10. Left-Side toggled menu links. This is for Contact Get All
    @FindBy(css = "div[role='dialog'] a:nth-child(10)")
    public WebElement toggleMenu_contactGetAll;

    //11. Left-Side toggled menu links. This is for Guest User
    @FindBy(css = "div[role='dialog'] a:nth-child(11)")
    public WebElement toggleMenu_guestUser;

    //12. Left-Side toggled menu links. This is for Guest User
    @FindBy(css = "div[role='dialog'] a:nth-child(12)")
    public WebElement toggleMenu_logout;


}
