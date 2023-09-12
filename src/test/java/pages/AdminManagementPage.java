package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AdminManagementPage {

    public AdminManagementPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//h3[@bg='primary']")
    public WebElement adminManagementTitle;

    @FindBy(xpath = "//*[(text()='Menu')]")
    public WebElement menuButton;

    @FindBy(xpath = "(//button[@class='btn-close'])[2]")
    public WebElement buttonClose;

    @FindBy(xpath = "//*[(text()='Dean Management')]")
    public WebElement deanManagementLink;

}
