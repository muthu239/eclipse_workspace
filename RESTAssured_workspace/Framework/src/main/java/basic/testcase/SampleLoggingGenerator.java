package basic.testcase;

import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.Test;

import utility.RestFrameworkLogger;

public class SampleLoggingGenerator {
	
	@Test
	public void rest_test01() {
		
		PropertyConfigurator.configure("log4j.properties");
		RestFrameworkLogger.startTestCase("REST_TEST01");
		RestFrameworkLogger.info("ABCD");
		RestFrameworkLogger.info("CSDF");
		RestFrameworkLogger.info("12451");
		RestFrameworkLogger.info("51241");
		RestFrameworkLogger.info("ABCD");
		RestFrameworkLogger.endTestCase();
		
	}
	
	
	@Test
	public void rest_test02() {
		
		PropertyConfigurator.configure("log4j.properties");
		RestFrameworkLogger.startTestCase("REST_TEST02");
		RestFrameworkLogger.info("ABCD");
		RestFrameworkLogger.info("CSDF");
		RestFrameworkLogger.info("12451");
		RestFrameworkLogger.info("51241");
		RestFrameworkLogger.info("ABCD");
		RestFrameworkLogger.endTestCase();
		
	}

}
