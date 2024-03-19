package suiteA;

import org.testng.annotations.Test;

public class TestClassA {
	
	@Test
	public void testA() throws InterruptedException {
		
		System.out.println("Starting Test A");
		Thread.sleep(5000);
		System.out.println("Ending test A");
	}

}
