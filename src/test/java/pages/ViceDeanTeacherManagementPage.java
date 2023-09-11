package pages;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import utilities.JSUtils;
import utilities.WaitUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ViceDeanTeacherManagementPage {
    public ViceDeanTeacherManagementPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(linkText = "Teacher Management")
    public WebElement teacherManagementLink;
    @FindBy(xpath = "//h5[.='Add Teacher']")
    public WebElement addTeacherHeading;

    @FindBy(xpath = "//input[@role='combobox']")
    public WebElement chooseLesson;
    @FindBy(id="name")
    public WebElement teacherName;
    @FindBy(id="surname")
    public WebElement teacherSurname;
    @FindBy(id="birthPlace")
    public WebElement teacherBirthPlace;
    @FindBy(id="email")
    public WebElement teacherEmail;
    @FindBy(id="phoneNumber")
    public WebElement teacherPhoneNumber;

    @FindBy(css = "input#isAdvisorTeacher")
    public WebElement advisoryRole;

    @FindBy(xpath = "//input[@type='radio' and @value='FEMALE']")
    public WebElement teacherFemale;

    @FindBy(xpath = "//input[@type='radio' and @value='MALE']")
    public WebElement teacherMale;

    @FindBy(xpath = "//input[@id='birthDay']")
    public WebElement teacherBirthDate;

    @FindBy(xpath = "//input[@id='ssn']")
    public WebElement teacherSSN;

    @FindBy(xpath = "//input[@id='username']")
    public WebElement teacherUserName;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement teacherPassword;

    @FindBy(xpath = "//button[.='Submit']")
    public WebElement teacherSubmitInfo;

    @FindBy(xpath = "//div[.='Required']")
    public WebElement failRequired;
    @FindBy(xpath = "//div[.='At least 8 characters']")
    public WebElement failAtLeast8Characters;

    @FindBy(xpath = "//h5[.='Teacher List']")
    public WebElement teacherTableHeading;

    @FindBy(xpath = "//div[@role]//div[.='Teacher saved successfully']")
    public WebElement teacherSavedNotification;

    @FindBy(css = "div.modal-title")
    public WebElement edit_ModalHeading;
    @FindBy(xpath = "(//div[@class=' css-19bb58m'])[2]")
    public WebElement edit_chooseLesson;

    @FindBy(xpath = "(//input[@id='name'])[2]")
    public WebElement edit_name;

    @FindBy(xpath = "(//input[@id='surname'])[2]")
    public WebElement edit_surname;

    @FindBy(xpath = "(//input[@id='birthPlace'])[2]")
    public WebElement edit_birthPlace;

    @FindBy(xpath = "(//input[@id='email'])[2]")
    public WebElement edit_email;

    @FindBy(xpath = "(//input[@id='phoneNumber'])[2]")
    public WebElement edit_phoneNumber;

    @FindBy(xpath = "(//input[@id='ssn'])[2]")
    public WebElement edit_ssn;

    @FindBy(xpath = "(//input[@id='isAdvisorTeacher'])[2]")
    public WebElement edit_isAdvisorTeacher;

    @FindBy(xpath = "(//input[@type='radio' and @value='FEMALE'])[2]")
    public WebElement edit_femaleRadioButton;

    @FindBy(xpath = "(//input[@type='radio' and @value='MALE'])[2]")
    public WebElement edit_maleRadioButton;

    @FindBy(xpath = "(//input[@id='birthDay'])[2]")
    public WebElement edit_birthDay;

    @FindBy(xpath = "(//input[@id='username'])[2]")
    public WebElement edit_username;

    @FindBy(xpath = "(//input[@id='password'])[2]")
    public WebElement edit_password;

    @FindBy(xpath = "(//button[.='Submit'])[2]")
    public WebElement edit_submitAndUpdateFields;

    @FindBy(xpath = "(//a//span[.='»'])[1]")
    public WebElement goToLastPage;

    @FindBy(css = ".modal-content .btn-close")
    public WebElement closeModal;

    public String usernameGlobal;
    public String passwordGlobal;

    public String nameGlobal;
    public String surnameGlobal;
    public String ssnGlobal;

    Faker faker = new Faker();

    public void checkTeacherInformationInTable() {
        //Scroll down to table

        JSUtils.scrollToElementThenScrollByAmount(teacherTableHeading, -200);
        WaitUtils.waitFor(2);

        List <WebElement> getAllTableData = Driver.getDriver().findElements(By.xpath(
           "(//table)[1]//td"
        ));

        for (int i = 0; i <= 10; i+=5) {
            if (getAllTableData.size() > 10) {

                Assert.assertTrue(
                    getAllTableData.get(i).isDisplayed()
                );
                System.out.println("Data exists: " + getAllTableData.get(i).getText());
            } else {
                Assert.assertFalse(getAllTableData.get(0).getText().isBlank());
                System.out.println("Table contains information about Teacher(s)");
                break;
            }
        }
    }

            /* ======================================================
                          CREATE NEW TEACHER DATA
               ====================================================== */
    public void createTeacher() {

        JSUtils.scrollToElementThenScrollByAmount(teacherTableHeading, -700);
        WaitUtils.waitFor(5);

        //lesson
        chooseLesson.sendKeys("English", Keys.ENTER);

        //Creates name and surname
        generateNameSurname();

        //birthPlace
        generateBirthPlace();

        //scroll down
        JSUtils.scrollByAmount(200);
        WaitUtils.waitFor(1);

        //Email
        //Phone
        generateEmailAndPhone();

        //select isAdvisory and Gender
        checkboxAndRadio();

        //DOB and SSN
        dateOfBirthAndSsn();

        //username
        generateUsername();

        //password
        passwordGlobal = "Admin123";
        teacherPassword.sendKeys(passwordGlobal);

        WaitUtils.waitFor(1);
        teacherSubmitInfo.click();

        //Assert that teacher notification is displayed
        //And teacher is created
        WaitUtils.waitForVisibility(teacherSavedNotification, 15);
        Assert.assertTrue(teacherSavedNotification.isDisplayed() );
    }

            /* ======================================================
                       METHODS FOR createTeacher()
               ====================================================== */
    private void generateNameSurname() {

        //name and surname
        nameGlobal = faker.name().firstName();
        teacherName.sendKeys(nameGlobal);

        surnameGlobal = faker.name().lastName();
        teacherSurname.sendKeys(surnameGlobal);
    }

    private void generateBirthPlace() {
        teacherBirthPlace.sendKeys("Turkey");
    }

    private void generateEmailAndPhone() {
        String email = nameGlobal.charAt(0)
                + "" + surnameGlobal.charAt(0)
                + faker.number().numberBetween(100, 999)
                + "@gmail.com";
        teacherEmail.sendKeys(email);

        //Add phone number
        teacherPhoneNumber.sendKeys(
                faker.number().numberBetween(100,999) + "-"
                        + faker.number().numberBetween(100,999) + "-"
                        + faker.number().numberBetween(1000, 9999)
        );
    }

    private void checkboxAndRadio() {
        advisoryRole.click();
        teacherMale.click();
    }

    private void dateOfBirthAndSsn() {
        //date of birth
        String dateDay = String.valueOf(faker.number().numberBetween(1,20));
        String dateMonth = String.valueOf(faker.number().numberBetween(1,12));
        String dateYear = String.valueOf(faker.number().numberBetween(1950,2000));
        teacherBirthDate.sendKeys(dateDay + dateMonth + dateYear);

        //Add SSN
        ssnGlobal = faker.number().numberBetween(100,999) + "-"
                + faker.number().numberBetween(10,99) + "-"
                + faker.number().numberBetween(1000, 9999);

        teacherSSN.sendKeys(ssnGlobal);
    }

    private void generateUsername() {
        /**
         * Create array for name and surname to split the words
         * These arrays will contain the individual characters
         */
        String[] nameArray = nameGlobal.split("");
        String[] surnameArray = surnameGlobal.split("");

        /**
         * Combine the arrays above into a single CombinedList <List>
         */
        List<String> combinedList = new ArrayList<>();
        combinedList.addAll(Arrays.asList(nameArray));
        combinedList.addAll(Arrays.asList(surnameArray));

        /**
         * <StringBuilder> is used here for multiple string concatenations
         * Note: <concat> can also be used here (but may cause issues if null value
         *                + creates new string object each time
         */
        StringBuilder usernameSb = new StringBuilder();
        int count = 0;

        //Should end up with something like: abc.
        for (String s : combinedList) {

            if (count == 8) {
                break;
            }  else if (count == 4) {
                usernameSb.append(".");
            } else {
                usernameSb.append(s);
            }
            count++;
        }

        usernameGlobal = usernameSb.toString();
        teacherUserName.sendKeys(usernameGlobal);
    }

                /* ======================================================
                          UPDATE TEACHER INFORMATION METHOD
               ====================================================== */

    public void updateTeacherInformationAndCheckUpdate() {
        //click to last page
        JSUtils.scrollToElementThenScrollByAmount(goToLastPage, -180);
        goToLastPage.click();
        WaitUtils.waitFor(1);

        //get all elements from table
        List <WebElement> tableData = Driver.getDriver().findElements(By.xpath(
                "(//table)[1]//td"
        ));

        //Data looking for
        WebElement data = Driver.getDriver().findElement(By.xpath(
                "(//table)[1]//td[.='"+ssnGlobal+"']"
        ));

        //if match
        //find index
        int index = tableData.indexOf(data);

        //Assert that the name, ssn and username are all correctly displayed
        Assert.assertEquals(nameGlobal + " " + surnameGlobal, tableData.get(index - 2).getText());
        System.out.println(tableData.get(index - 2).getText());

        Assert.assertEquals(ssnGlobal, tableData.get(index).getText());
        System.out.println(tableData.get(index).getText());

        Assert.assertEquals(usernameGlobal, tableData.get(index + 1).getText());
        System.out.println(tableData.get(index + 1).getText());

        //click edit
        JSUtils.scrollToElementThenScrollByAmount(tableData.get(index), -180);
        WaitUtils.waitFor(1);

        tableData.get(index + 2).click();
        WaitUtils.waitForVisibility(edit_ModalHeading, 15);
        Assert.assertTrue(edit_ModalHeading.isDisplayed() );

//        change lesson
        WaitUtils.waitFor(2);
        // Instantiate Actions class
        Actions actions = new Actions(Driver.getDriver());

// Move to the dropdown and click it to open
        actions.moveToElement(edit_chooseLesson).click().perform();

// Send the keys to the active element (the open dropdown)
        actions.sendKeys("Selenium").perform();
        actions.sendKeys(Keys.ENTER).perform();


        //change Name
        nameGlobal = faker.name().firstName();

        edit_name.sendKeys(Keys.COMMAND + "a");
        edit_name.sendKeys(Keys.DELETE);

        edit_name.sendKeys(nameGlobal);

        WaitUtils.waitFor(3);

        //uncheck Is Advisory Teacher
        if (edit_isAdvisorTeacher.isSelected()) {
            edit_isAdvisorTeacher.click();
        }

        //Choose Gender, Randomise
        int random = faker.number().numberBetween(1, 2);

        switch (random) {
            case 1:
                edit_femaleRadioButton.click();
                break;

            case 2:
                edit_maleRadioButton.click();
                break;

            default:
                System.out.println("Error selecting gender radio button");
        }

        //check username is correctly displayed
        Assert.assertEquals(
                usernameGlobal,
                edit_username.getAttribute("value")
        );

        //enter password
        edit_password.sendKeys(passwordGlobal);

        //click submit
        edit_submitAndUpdateFields.click();
        WaitUtils.waitFor(5);

        //close the modal once update is done
        closeModal.click();
        WaitUtils.waitForPageToLoad(15);

        WaitUtils.waitFor(2);
        //Assert name field is updated
        Assert.assertEquals(
                nameGlobal + " " + surnameGlobal,
                tableData.get(index - 2).getText()
        );
    }
}
