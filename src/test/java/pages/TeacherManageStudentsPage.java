package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TeacherManageStudentsPage {

    public TeacherManageStudentsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//nav//span[.='w.dunk']")
    public WebElement checkUsernameDisplayed;

    @FindBy(xpath = "//h5[.='Student Info List']")
    public WebElement studentInfoListHeading;

    @FindBy(xpath = "(//div[.='Edit Student Info'])[2]")
    public WebElement editStudentInfoHeading;

    @FindBy(xpath = "(//input[@id='midtermExam'])[2]")
    public WebElement midTermGrade;

    @FindBy(xpath = "(//button[.='Submit'])[2]")
    public WebElement submitAndUpdateStudentInfo;

    @FindBy(xpath = "(//button[@class='btn-close'])[3]")
    public WebElement closeStudentUpdateModal;

    /**
     *
     * @param tableRow -> provide row number
     * @param tableData -> provide column number which will give the data contained at that point
     * e.g. tableRow = 1, and tableData = 1 -> returns a reference to the first data point as WebElement
     */
    public WebElement tableRowAndData(int tableRow, int tableData) {

        return Driver.getDriver().findElement(
                //   (//table//tr)[2]//td[2]
                By.xpath("//table//tr["+tableRow+"]//td["+tableData+"]")
        );
    }

    public WebElement tableRowAndData(int tableRow, String tableData) {
        return Driver.getDriver().findElement(
                //   (//table//tr)[2]
                By.xpath("//table//tr[" + tableRow + "]//td[.='" + tableData + "']")
        );
    }

}
