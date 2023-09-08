package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class RegisterPage {
    public RegisterPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//*[@href='/register']")
    public WebElement registerLink;

    @FindBy(xpath = "(//input)[2]")
    public WebElement surname;

    @FindBy(xpath = "(//input)[3]")
    public WebElement birthPlace;

    @FindBy(xpath = "(//input)[4]")
    public WebElement phoneNumber;

    @FindBy(xpath = "(//input)[5]")
    public WebElement femaleRadioButton;

    @FindBy(xpath = "(//input)[7]")
    public WebElement dateOfBirth;

    @FindBy(xpath = "(//input)[8]")
    public WebElement ssn;

    @FindBy(xpath = "(//button)[3]")
    public WebElement registerButton;

}
