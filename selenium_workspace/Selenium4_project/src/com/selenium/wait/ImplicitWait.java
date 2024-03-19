package com.selenium.wait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ImplicitWait {
	
	@Test
	public void implicitWaitTest() {
		System.setProperty("webdriver.chrome.driver", "E:\\eclipse_workspace\\selenium_workspace\\Selenium4_project\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		
		//NO need to call each time like sleep
		//throws exception if the process times out 
//		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);   ---> selenium 3
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));    // ---> selenium 4
		
		WebElement searchBox = driver.findElement(By.xpath("//textarea[@name = 'q' and @title = 'Search']"));
		searchBox.sendKeys("Selenium-webdriver");
		
		WebElement searchResult = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[2]/div[4]/div[2]/div[1]/div/ul/li[5]/div/div[2]"));
		searchResult.click();
		
		driver.quit();
		
	}

}
