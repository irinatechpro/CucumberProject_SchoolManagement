package pages;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
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

    public String usernameGlobal;
    public String passwordGlobal;

    public String nameGlobal;
    public String surnameGlobal;
    public void createTeacher() {
        Faker faker = new Faker();

        JSUtils.scrollToElementThenScrollByAmount(teacherTableHeading, -700);
        WaitUtils.waitFor(5);

        //lesson
        chooseLesson.sendKeys("English", Keys.ENTER);

        //name and surname
        teacherName.sendKeys(faker.name().firstName());
        nameGlobal = teacherName.getText();

        teacherSurname.sendKeys(faker.name().lastName());
        surnameGlobal = teacherSurname.getText();

        System.out.println(surnameGlobal);

        //birthPlace
        teacherBirthPlace.sendKeys("Turkey");

        //scroll down
        JSUtils.scrollByAmount(200);
        WaitUtils.waitFor(1);

        //email
//        String email = teacherName.getText().charAt(0) + teacherSurname.getText().charAt(0) + faker.number().numberBetween(100, 999)
//                + "@gmail.com";
//
//        edit_email.sendKeys(email);

        //Add phone number
        teacherPhoneNumber.sendKeys(
                faker.number().numberBetween(100,999) + "-"
                        + faker.number().numberBetween(100,999) + "-"
                        + faker.number().numberBetween(1000, 9999)
        );

        //select isAdvisory
        advisoryRole.click();

        //gender select
        teacherMale.click();

        //date of birth
        teacherBirthDate.sendKeys(
                String.valueOf(faker.number().numberBetween(1, 21) +
                        faker.number().numberBetween(1, 12) +
                        faker.number().numberBetween(1950, 2000))
        );



        //Add SSN
        teacherSSN.sendKeys(
                faker.number().numberBetween(100,999) + "-"
                        + faker.number().numberBetween(10,99) + "-"
                        + faker.number().numberBetween(1000, 9999)
        );

        //username
        /**
         * Create array for name and surname to split the words
         * These arrays will contain the individual characters
         */
        String[] nameArray = teacherName.getText().split("");
        String[] surnameArray = teacherSurname.getText().split("");

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
        for (String s : combinedList) {
            if (count == 4) {
                break;
            } else {
                usernameSb.append(s);
            }

            count++;
        }

        teacherUserName.sendKeys(usernameSb);
        usernameGlobal = teacherUserName.getText();

        //password
        String password = "Admin1234";
        teacherPassword.sendKeys(password);

        passwordGlobal = password;
    }

    public void updateTeacherInformationAndCheckUpdate(String username, String password) {
        Faker faker = new Faker();

        //Add lesson
        edit_chooseLesson.sendKeys("Java", Keys.ENTER);

        //Add random Name
        edit_name.sendKeys(faker.name().firstName());

        //Add random Surname
        edit_surname.sendKeys(faker.name().lastName());

        //Add BirthPlace
        edit_birthPlace.sendKeys(faker.country().toString());

        //Add email
        JSUtils.scrollByAmount(200);
        WaitUtils.waitFor(2);

        String[] nameChars = edit_name.getText().split("");
        edit_email.sendKeys(
                nameChars[0] + nameChars[1] + nameChars[2] + faker.number().numberBetween(100, 999)
                        + "@gmail.com"
        );

        //Add phone number
        edit_phoneNumber.sendKeys(
                faker.number().numberBetween(100,999) + "-"
                + faker.number().numberBetween(100,999) + "-"
                + faker.number().numberBetween(1000, 9999)
        );

        //Add SSN
        edit_ssn.sendKeys(
                faker.number().numberBetween(100,999) + "-"
                + faker.number().numberBetween(10,99) + "-"
                + faker.number().numberBetween(1000, 9999)
        );

        //check Advisor teacher
        edit_isAdvisorTeacher.click();

        //check role
        WebElement[] randomiseGender = new WebElement[2];
        randomiseGender[0] = edit_femaleRadioButton;
        randomiseGender[1] = edit_maleRadioButton;

        randomiseGender[faker.number().numberBetween(1, 2)].click();

        //Add Date of Birth
        JSUtils.scrollByAmount(200);
        WaitUtils.waitFor(2);

        //add birthDay
        edit_birthDay.sendKeys(
                String.valueOf(faker.number().numberBetween(1, 21) +
                        faker.number().numberBetween(1, 12) +
                        faker.number().numberBetween(1950, 2000))
        );

        //add username
        edit_username.sendKeys(username);

        //add password
        edit_password.sendKeys(password);

        //click submit to update fields
        edit_submitAndUpdateFields.click();

        //Wait page load
        WaitUtils.waitForPageToLoad(15);


    }
}
