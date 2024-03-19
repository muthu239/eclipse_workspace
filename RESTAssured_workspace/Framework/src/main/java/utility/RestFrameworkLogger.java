package utility;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class RestFrameworkLogger {
	
	
	//initialize log4j logs
	private static Logger log = Logger.getLogger(RestFrameworkLogger.class.getName());
	
	public static void initLogger() {
		PropertyConfigurator.configure("log4j.properties");
	}
	//this is to print log for the beginning of the test case
	public static void startTestCase(String testCaseName) {
		log.info("**********************************************");
		log.info("**********************************************");
		log.info("$$$$$$$$$    " + testCaseName + "     $$$$$$$$$$$$$$");
		log.info("**********************************************");
		log.info("**********************************************");
	}
	
	public static void endTestCase() {
		log.info("XXXXXXXXX    " + "---E----N---D---" + "     xxxxxxxxxx");
		log.info("**********************************************");
		log.info("**********************************************");
		log.info("X");
		log.info("X");
		log.info("X");
		log.info("X");
		log.info("X");
	}
	
	//Need to create these methods so they can be called
	public static void info(String message) {
		log.info(message);
	}
	
	public static void warn(String message) {
		log.warn(message);
	}
	
	public static void error(String message) {
		log.error(message);
	}
	
	public static void fatal(String message) {
		log.fatal(message);
	}
	
	public static void debug(String message) {
		log.debug(message);
	}
	
	

}
