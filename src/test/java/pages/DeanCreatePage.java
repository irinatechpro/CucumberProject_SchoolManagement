package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class DeanCreatePage {

    public DeanCreatePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(linkText = "Dean Management")
    public WebElement deanManagementLink;

    @FindBy(xpath = "//div[@id='h10-page-widget']")
    public WebElement advisorDeanDropBox;

//    @FindBy(id="advisorDeanId")
//    public WebElement advisorDeanDropBox;

    @FindBy(xpath = "//div[@class='table-responsive']")
    public WebElement deanListTable;

    @FindBy(xpath = "//table//tbody//tr[last()]")
    public WebElement lastRow;

    @FindBy(xpath = "//tr[last()]/td[1]")
    public static WebElement firstColumnInLastRow;
}
