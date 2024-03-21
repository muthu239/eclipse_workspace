package com.selenium.master3;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ManageJavaScriptExecutor {
WebDriver driver = null;
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "E:\\eclipse_workspace\\selenium_workspace\\firstSelenium\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
	
	@Test
	public void testJavaScriptExecutor() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.location = 'https://www.rediff.com/'");
		
		String pageTitle = (String)js.executeScript("return document.title");
		Assert.assertEquals(pageTitle, "Rediff.com: News | Rediffmail | Stock Quotes | Shopping");
		
		js.executeScript("window.scrollBy(0,3000)");
		
		WebElement signinBtn = driver.findElement(By.linkText("Sign in"));
		js.executeScript("arguments[0].click()", signinBtn);
		
		WebElement userName = driver.findElement(By.id("login1"));
		js.executeScript("arguments[0].value = 'abc@xyz.com'", userName);
		
		
//	 Scrolling down the page till the element is found		
//        js.executeScript("arguments[0].scrollIntoView();", Element);
		
//	  Scroll down to the bottom of the webpage
//		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}

}
