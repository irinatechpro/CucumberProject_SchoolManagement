package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class CreateViceDeanPage {

        public CreateViceDeanPage(){
                PageFactory.initElements(Driver.getDriver(),this);
        }


        @FindBy(linkText = "Vice Dean Management")
        public WebElement ViceDeanManagementLink;

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

