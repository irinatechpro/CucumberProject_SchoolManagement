package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class CommonLocator {
    // this page is created for common locators for teacher creation, student creation, dean creation
    public CommonLocator(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//input[@id='phoneNumber']")
    public WebElement phoneNumberField;

    @FindBy(xpath = "//input[@id='ssn']")
    public WebElement ssnField;

    @FindBy(xpath = "//input[@id='username']")
    public WebElement usernameField;

    @FindBy (xpath = "//input[@id='birthDay']")
    public WebElement dateOfBirth;

    @FindBy(linkText = "Student Management")
    public WebElement studentManagementLink;

    @FindBy(xpath = "//button[(text()='Menu')]")
    public WebElement menuButton;

    @FindBy(xpath = "//*[@id='offcanvasNavbar-expand-lg']/div[2]/div/a[11]")
    public WebElement guestUser;

    @FindBy(xpath = "//*[@class='fw-bold p-3 card-header']")
    public WebElement guestUserList;

    @FindBy(xpath = "//*[@class='fa-solid fa-trash']")
    public WebElement deleteUserGuest;

    @FindBy(xpath = "//*[@id='root']/div/main/div/div[1]/div/div/div/div[1]/table/tbody/tr[2]/td[5]/span/button")
    public WebElement getDeleteUserGuestSuccessfully;



}
