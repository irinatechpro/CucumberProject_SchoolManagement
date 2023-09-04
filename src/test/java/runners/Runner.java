package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {//report plugins
                "pretty",//generates reports on the console
                "html:target/default-cucumber-reports.html",
                "json:target/json-reports/cucumber.json",
                "junit:target/xml-report/cucumber.xml",
                "rerun:target/failedRerun.txt",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        monochrome = true,//makes reports more readable in the console
        features = "./src/test/resources/features",//path of feature file
        glue = {"stepdefinitions","hooks"}, //path of the step definitions
        tags = "@US01",
        dryRun = false//executes to generate missing step definitions
)
public class Runner {
}
