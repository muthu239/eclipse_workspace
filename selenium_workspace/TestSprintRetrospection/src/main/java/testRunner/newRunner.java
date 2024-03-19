package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "E:\\eclipse_workspace\\TestSprintRetrospection\\src\\main\\resources\\Features\\project.feature", //the path of the feature files
		glue={"stepDefinitions"}, //the path of the step definition files
		//format= {"pretty","html:test-outout", "json:report_json/cucumber.json", "junit:report_xml/cucumber.xml"},
		dryRun = false,
		monochrome = true,
		strict = true
		//tags = {"@Smoke"}
		)
public class newRunner {

}
