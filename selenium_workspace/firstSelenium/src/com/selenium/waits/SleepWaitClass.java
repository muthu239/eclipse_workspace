package com.selenium.waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SleepWaitClass {
	@Test
	public void googleSearch() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\eclipse_workspace\\selenium_workspace\\firstSelenium\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		
		WebElement searchBox = driver.findElement(By.xpath("//textarea[@name = 'q' and @title = 'Search']"));
		searchBox.sendKeys("Selenium-webdriver");
		
		Thread.sleep(3000);
		
		WebElement searchResult = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[2]/div[4]/div[2]/div[1]/div/ul/li[5]/div/div[2]"));
		searchResult.click();
		
		driver.quit();
	}

}
