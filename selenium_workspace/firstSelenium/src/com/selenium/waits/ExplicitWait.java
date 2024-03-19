package com.selenium.waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExplicitWait {
	WebDriver driver = null;
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "E:\\eclipse_workspace\\selenium_workspace\\firstSelenium\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///E:/eclipse_workspace/selenium_utils/ExplicitWait.html");
	}	
	
	@Test
	public void verifyAlert() {
		
		WebElement alertBtn = driver.findElement(By.xpath("//button[@id = 'alert']"));
		alertBtn.click();
		
		//explicit wait is like sleep 
		//we have to put each time
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.alertIsPresent());
		
		driver.switchTo().alert().accept();
	}
	
	@Test
	public void verifyElementClickable() {
		//first we will perform action
		//put wait and call expected condition
		//perform action on expected element
		driver.findElement(By.id("display-other-button")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("hidden")));
	}
	
	@Test
	public void verifyElementSelected() {
		driver.findElement(By.id("checkbox")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeSelected(driver.findElement(By.xpath("//input[@id = 'ch']"))));
	}
	
	@Test
	public void verifyPresentText() {
		driver.findElement(By.id("populate-text")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath("//h2[@class = 'target-text']")), "Selenium Webdriver"));
		
	}
	
	@Test
	public void verifyElementVisibility() {
		driver.findElement(By.id("display-other-button")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hidden")));
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}

}

