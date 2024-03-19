package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src\\main\\java\\features\\Application.feature", //the path of the feature files
		glue={"stepdefinitions"}, //the path of the step definition files
		plugin= {"pretty","html:report_html/test-output.html", "json:report_json/cucumber.json", "junit:report_xml/cucumber.xml"},
		dryRun = false,
		monochrome = true,
		strict = true
		//tags = {"@Smoke, @E2E"}
		)

public class TestRunner {

}



//OR condition in tags : {"@Smoke, @E2E"} - Execute tests that contain either any one of the tags mentioned
//And condition in tags : {"@Smoke", "@E2E"} - Execute tests that contains both the tags together