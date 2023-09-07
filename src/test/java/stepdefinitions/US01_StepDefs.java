package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.CommonLocator;
import pages.LoginPage;

public class US01_StepDefs {
    LoginPage loginPage = new LoginPage();

    @And("user clicks on register link")
    public void user_clicks_on_register_link() {
        loginPage.registerLink.click();
    }
}
