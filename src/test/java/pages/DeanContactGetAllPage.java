package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class DeanContactGetAllPage {
    public DeanContactGetAllPage() {
        PageFactory.initElements(Driver.getDriver(), this);}

    @FindBy(xpath = "//a[.='Contact Get All']")
    public WebElement contactGetAllButton;

    @FindBy(xpath = "(//tbody)[1]//tr[1]//td[5]")
    public WebElement verifyMessageIsSeen;

    @FindBy(xpath = "(//tbody)[1]//tr[1]//td[1]")
    public WebElement verifyNameIsSeen;

    @FindBy(xpath = "(//tbody)[1]//tr[1]//td[2]")
    public WebElement verifyEmailIsSeen;

    @FindBy(xpath = "(//tbody)[1]//tr[1]//td[3]")
    public WebElement verifyDateIsSeen;

    @FindBy(xpath = "(//tbody)[1]//tr[1]//td[4]")
    public WebElement verifySubjectIsSeen;


}