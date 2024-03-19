package com.selenium.webelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FindElementClass {
	
	@Test
	public void findElementTest() {
		System.setProperty("webdriver.chrome.driver", "E:\\eclipse_workspace\\selenium_workspace\\firstSelenium\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://classic.crmpro.com/index.html");
		
		driver.findElement(By.className("form-control")).sendKeys("newUser");
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		driver.findElement(By.className("form-control")).clear();
		
		//password field having same calss name as username field
		driver.findElement(By.className("form-control")).sendKeys("aqwer1234");
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//throws an exception if the class is not found
		//driver.findElement(By.className("muithu")).sendKeys("newValue");
		driver.quit();
		
	}

}
