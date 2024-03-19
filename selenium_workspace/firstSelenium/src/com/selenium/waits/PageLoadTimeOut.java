package com.selenium.waits;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class PageLoadTimeOut {
	@Test
	public void pageLoadTimeOutTest() {
		System.setProperty("webdriver.chrome.driver", "E:\\eclipse_workspace\\selenium_workspace\\firstSelenium\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://edition.cnn.com/");
		
		//one time putting wait is enough here as long as driver is not killed 
		//if the page did not load in the given time it throws exception
		// if the pageload timeout in -ve it means giving infinite time
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		driver.quit();
	}

}
