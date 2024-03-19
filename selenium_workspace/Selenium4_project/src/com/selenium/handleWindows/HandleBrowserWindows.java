package com.selenium.handleWindows;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HandleBrowserWindows {
	
WebDriver driver = null;
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "E:\\eclipse_workspace\\selenium_workspace\\firstSelenium\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
	}
//	
//	@Test
	public void handleFacebook() {
		driver.get("https://en-gb.facebook.com/");
		String mainPage = driver.getWindowHandle();
		System.out.println("Main page id :"+mainPage);
		
		driver.findElement(By.partialLinkText("Forgotten password?")).click();
		String refreshPage = driver.getWindowHandle();
		System.out.println("forgot pwd page id : "+refreshPage);
	}
	
	@Test
	public void handleMultipleTabs() {
		driver.get("https://www.w3schools.com/tags/att_select_multiple.asp");
		String mainPageWindow = driver.getWindowHandle();
		System.out.println("Main page id"+mainPageWindow);
		
		driver.findElement(By.linkText("Try it Yourself »")).click();
		
		Set<String> windowId = driver.getWindowHandles();
		
		Iterator<String> itr = windowId.iterator();
		
		String mainPageId = itr.next();
		String secondPageId = itr.next();
		System.out.println(mainPageId);
		System.out.println(secondPageId);
		
		
		//Switching to the second page
		driver.switchTo().window(secondPageId);
		
//		driver.switchTo().newWindow(WindowType.TAB);
		
		driver.findElement(By.id("tryhome")).click();
		
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
	
}
