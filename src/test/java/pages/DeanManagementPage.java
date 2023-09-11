package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class DeanManagementPage {

    public DeanManagementPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//span[text()='TeamProject']")
    public WebElement name;

    @FindBy(xpath = "(//span[text()='MALE'])[1]")
    public WebElement gender;

    @FindBy(xpath = "//span[text()='444-444-4444']")
    public WebElement phoneNumber;

    @FindBy(xpath = "//span[text()='444-44-4444']")
    public WebElement ssn;

    @FindBy(xpath = "//span[text()='DeanTeam01']")
    public WebElement userName;

    @FindBy(xpath = "//h5[text()='Dean List']")
    public WebElement deanList;

    @FindBy(xpath = "//h5[text()='Add Dean']")
    public WebElement addDean;

    @FindBy(xpath = "//input[@id='name']")
    public WebElement deanName;

    @FindBy(xpath = "//input[@id='surname']")
    public WebElement deanSurname;

    @FindBy(xpath = "//input[@id='birthPlace']")
    public WebElement deanBirthPlace;

    @FindBy(xpath = "//input[@value='MALE']")
    public WebElement deanGender;

    @FindBy(xpath = "//input[@id='birthDay']")
    public WebElement deanBirthDay;

    @FindBy(xpath = "//input[@id='phoneNumber']")
    public WebElement deanPhoneNumber;

    @FindBy(xpath = "//input[@id='ssn']")
    public WebElement deanSsnNumber;

    @FindBy(xpath = "//input[@id='username']")
    public WebElement deanUsername;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement deanPassword;

    @FindBy(xpath = "//button[text()='Submit']")
    public WebElement addDeanSubmit;

    @FindBy(xpath = "(//span[@aria-hidden='true'])[4]")
    public WebElement lastPageButton;

    @FindBy(xpath = "//*[.='Dean Saved']")
    public WebElement deanSavedText;
    //div[.="Guest User registered"


















}
