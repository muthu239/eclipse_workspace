package com.selenium.webelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RediffSignIntest {
	
	@Test
	public void testRediffSignIn() {
		System.setProperty("webdriver.chrome.driver", "E:\\eclipse_workspace\\selenium_workspace\\firstSelenium\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		
		
		//steps to proceed
		//open the rediff.com page
		driver.get("https://www.rediff.com/");
		//verify page title 
		String pageTitle = driver.getTitle();
		Assert.assertEquals(pageTitle, "Rediff.com: News | Rediffmail | Stock Quotes | Shopping");
		//click sign in button
		WebElement signInLink = driver.findElement(By.linkText("Sign in"));
		signInLink.click();
		//verify sign in page title
		Assert.assertEquals(driver.getTitle(), "Rediffmail"); 
		//Insert username & password
		WebElement userName = driver.findElement(By.id("login1"));
		WebElement password = driver.findElement(By.name("passwd"));
		userName.sendKeys("newUser");
		// thread.sleep() is to create a delay
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		password.sendKeys("aqwer1234");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//click submit button
		WebElement submit = driver.findElement(By.name("proceed"));
		submit.click();
		// verify the profile title
		// Assert.assertEquals(driver.getTitle(),"profile page");
		driver.quit();
	}

}
