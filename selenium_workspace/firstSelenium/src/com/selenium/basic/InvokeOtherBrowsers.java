package com.selenium.basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InvokeOtherBrowsers {
	@Test
	public void verifyLinkedinHomePage() {
		String URL = "https://in.linkedin.com/";
		
		//open the url with selenium
		System.setProperty("webdriver.chrome.driver", "E:\\eclipse_workspace\\selenium_workspace\\firstSelenium\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
//    using fire fox driver for using mozilla firefox
//       System.setProperty("webdriver.gecko.driver", "E:\\eclipse_workspace\\selenium_workspace\\firstSelenium\\drivers\\geckodriver.exe");
//	    WebDriver driver = new FirefoxDriver();
		
//		using opera driver for using opera
//		System.setProperty("webdriver.opera.driver", "D:\\java_eclipse_workspace\\firstSelenium\\drivers\\opera.exe");
//		WebDriver driver = new OperaDriver();
	
		
		driver.manage().window().maximize();
		driver.get(URL);
		
		
		//verify homepage title
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
		Assert.assertEquals(pageTitle, "LinkedIn India: Log In or Sign Up");
		
		//close the browser
		driver.quit();
		
	}


}

