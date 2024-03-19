package com.selenium.basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstSeleniumTest {
	
	@Test
	public void verifyLinkedinHomePage() {
		String URL = "https://in.linkedin.com/";
		
		//open the url with selenium
		System.setProperty("webdriver.chrome.driver", "E:\\eclipse_workspace\\selenium_workspace\\firstSelenium\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//To maximize the browser
		driver.manage().window().maximize();
		driver.get(URL);
		
		
		//verify homepage title
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
		Assert.assertEquals(pageTitle, "LinkedIn India: Log In or Sign Up");
		
		//close the browser
		driver.close();
		
	}

}

