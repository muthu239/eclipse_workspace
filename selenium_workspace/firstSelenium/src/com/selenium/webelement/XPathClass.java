package com.selenium.webelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class XPathClass {
	@Test
	public void absoluteXpath() {
		System.setProperty("webdriver.chrome.driver", "E:\\eclipse_workspace\\selenium_workspace\\firstSelenium\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.rediff.com/");
		driver.findElement(By.linkText("Sign in")).click();
		
		driver.findElement(By.id("login1")).sendKeys("newUser");
		driver.findElement(By.name("passwd")).sendKeys("aqwer1234");
		
		driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/div[1]/a")).click();
		
		Assert.assertEquals(driver.getTitle(),"Rediff.com: News | Rediffmail | Stock Quotes | Shopping");
		
		
		driver.quit();
		
	}

}
