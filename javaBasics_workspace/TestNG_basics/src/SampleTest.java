import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class SampleTest {
	
	@BeforeSuite
	public void beforeSuiteMethod() {
		System.out.println("Executing before the test suite");
	}
	
	@AfterSuite
	public void afterSuiteMethod() {
		System.out.println("Executing after the test suite");
	}
	
	


}
