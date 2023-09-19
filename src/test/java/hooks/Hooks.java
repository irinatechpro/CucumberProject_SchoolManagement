package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Driver;




import static base_url.BaseUrl.*;


public class Hooks {

        /*
        Hooks is used to run before or after each scenario
        this class should only have @Before or @After annotations
        by default these methods runs for all scenarios automatically
        but conditional hooks can be used for running specific tags @Before("@smoke")
        Note : we should include this hooks class in the runner
         */
        @Before("@Api_admin")
        public void beforeApi_admin() {
            adminSetUp();
        }

        @Before("@Api_dean")
        public void beforeApi_dean() {
            deanSetUp();
        }

        @Before("@Api_viceDean")
        public void beforeApi_viceDean() {
            viceDeanSetUp();
        }

        @Before("@Api_teacher")
        public void beforeApi_teacher() {
            teacherSetUp();
        }

        @Before("@Api_student")
        public void beforeApi_student() {
            studentSetUp();
        }

        @After
        public void tearDown(Scenario scenario) {
        /*
        capturing screenshot and attaching to the cucumber html report when a test case fails
         */
            if (scenario.isFailed()) {
                final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", "failed_screenshot");
                Driver.closeDriver();
            }
        }
    }
