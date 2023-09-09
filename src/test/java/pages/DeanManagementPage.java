package pages;

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


}
