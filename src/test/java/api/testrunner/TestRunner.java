package api.testrunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/java/api/features",
		glue={"src/test/java/api/stepdefinition"},
		dryRun = false,
		monochrome = true,
		tags = "@Create_Order2",
		plugin = {"pretty","html:target/cucumber-reports","json:target/jsonReports/cucumber-report.json"
				},
		publish = true
)
public class TestRunner {

}
