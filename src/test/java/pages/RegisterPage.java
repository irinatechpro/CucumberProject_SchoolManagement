package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class RegisterPage {

    public RegisterPage() {PageFactory.initElements(Driver.getDriver(), this);}

    @FindBy(xpath = "//a[contains(text(),'Register')]")
    public WebElement registerLink;
//    @FindBy(xpath = "//*[@href='/register']")
//    public WebElement registerLink;
    @FindBy(xpath = "//*[@class='header_link ms-2']")
    public WebElement loginLink;
    @FindBy(id = "name")
    public WebElement name;
    @FindBy(id = "surname")
    public WebElement surname;
    @FindBy(id = "birthPlace")
    public WebElement birthplace;
    @FindBy(id = "phoneNumber")
    public WebElement phoneNumber;
    @FindBy(xpath = "//*[(text()='Female')]")
    public WebElement radioButtonFemale;
    @FindBy(xpath = "//*[(text()='Male')]")
    public WebElement radioButtonMale;
    @FindBy(id = "birthDay")
    public WebElement birthDay;
    @FindBy(id = "ssn")
    public WebElement ssn;
    @FindBy(id = "username")
    public WebElement username;
    @FindBy(id = "password")
    public WebElement password;
    @FindBy(xpath = "//button[(text()='Register')]")
    public WebElement registerButton;
    @FindBy(className = "fa fa-registered")
    public WebElement userRegisteredMessage;
}