package executionOrder;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class SampleTesting {
	
	@BeforeTest
	public void beforeTest() {
		
		System.out.println("Executed from BeforeTest annotation");
		
	}
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Executed from  BeforeSuite annotation");
	}

}
