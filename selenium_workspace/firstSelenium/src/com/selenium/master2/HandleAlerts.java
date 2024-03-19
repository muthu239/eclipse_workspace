package com.selenium.master2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HandleAlerts {
	WebDriver driver = null;
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "E:\\eclipse_workspace\\selenium_workspace\\firstSelenium\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Test
	public void handleJavaScriptAlerts() {
		driver.get("https://www.rediff.com/");
		driver.findElement(By.xpath("//a[contains(text(),'Rediffmail')]")).click();
		driver.findElement(By.xpath("//input[@class = 'signinbtn']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.alertIsPresent());
		
		//To click ok on the popup
		Alert alt = driver.switchTo().alert();
		alt.accept();
		
		// if to click cancel on the popup
		//driver.switchTo().alert().dismiss();
		
		//if to get the text on the popup
		//driver.switchTo().alert().getText();
		// if to send the value to the popup
		//driver.switchTo().alert().sendKeys("value");
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}


}
