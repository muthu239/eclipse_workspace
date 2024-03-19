package com.selenium.master1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VerifyWebElementPresence {
WebDriver driver = null;
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "E:\\eclipse_workspace\\selenium_workspace\\firstSelenium\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	
	@Test(priority = 1)
	public void verifyElementDisplay() {
		driver.get("https://jqueryui.com/");
		driver.findElement(By.linkText("Toggle")).click();
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class = 'demo-frame']")));
		WebElement toggleBtn = driver.findElement(By.xpath("//div[@id = 'effect']/h3"));
		Assert.assertTrue(toggleBtn.isDisplayed());
		System.out.println("Displayed status: "+toggleBtn.isDisplayed());
	}
	
	@Test(priority = 2)
	public void verifyElementisEnabled() {
		driver.get("https://jqueryui.com/");
		WebElement resizableLink = driver.findElement(By.linkText("Resizable"));
		System.out.println("link is enabled "+resizableLink.isEnabled());
	}
	
	@Test(priority = 3)
	public void verifyisSelected() {
		driver.get("https://www.facebook.com/");
		driver.findElement(By.linkText("Create new account")).click();
		WebElement radioBtn = driver.findElement(By.xpath("//input[@name = 'sex' and @value = '1']"));
		System.out.println("Female radio button status "+radioBtn.isSelected());
		
		radioBtn.click();
		System.out.println("Female radio button status "+radioBtn.isSelected());
		
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}


}
