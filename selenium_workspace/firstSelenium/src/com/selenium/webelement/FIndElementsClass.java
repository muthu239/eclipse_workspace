package com.selenium.webelement;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FIndElementsClass {
	
	@Test
	public void findElementsTest() {
		
		System.setProperty("webdriver.chrome.driver", "E:\\eclipse_workspace\\selenium_workspace\\firstSelenium\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://classic.crmpro.com/index.html");
		
		List<WebElement> textFields = driver.findElements(By.className("form-control"));
		
		textFields.get(0).sendKeys("newUser");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		textFields.get(1).sendKeys("aqwer1234");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
	}

}
