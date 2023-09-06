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

}
