package MyTestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
	@CucumberOptions(
			features = "E:\\eclipse_workspace\\BDDCucumberFramework\\src\\main\\java\\Features\\Login.feature",
			glue={"StepDefinitions"} ,//the path of the step definition files
			//format= {"pretty","html:test-output“}	
			dryRun = false ,
			monochrome = true
			
			)


public class TestRunner {

}
