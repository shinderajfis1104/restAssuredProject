package api.testrunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/java/api/features",
		glue={"api.stepdefinition"},
		dryRun = false,
		monochrome = true,
		tags = "@Smoke",
		plugin = {"pretty","html:target/cucumber-reports/report.html","json:target/jsonReports/cucumber-report.json"
				},
		publish = true
)
public class TestRunner {

}
