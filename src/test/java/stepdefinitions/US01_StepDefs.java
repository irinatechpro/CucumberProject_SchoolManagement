package stepdefinitions;

import io.cucumber.java.en.And;
import pages.RegisterPage;

public class US01_StepDefs {
    RegisterPage registerPage = new RegisterPage();
    @And("user clicks on register link")
    public void userClicksOnRegisterLink() {
        registerPage.registerLink.submit();
    }

    @And("user enters surname {string}")
    public void userEntersSurname(String arg0) {
        registerPage.surname.sendKeys(arg0);
    }

    @And("user enters birthplace {string}")
    public void userEntersBirthplace(String arg0) {
        registerPage.birthplace.sendKeys(arg0);
    }

    @And("user enters phone number {string}")
    public void userEntersPhoneNumber(String arg0) {
        registerPage.phoneNumber.sendKeys(arg0);
    }

    @And("user clicks on radio button")
    public void userClicksOnRadioButton() {
        registerPage.radioButtonFemale.click();
    }
}
