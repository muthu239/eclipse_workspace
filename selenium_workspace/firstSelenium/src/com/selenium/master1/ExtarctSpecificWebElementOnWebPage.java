package com.selenium.master1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExtarctSpecificWebElementOnWebPage {
WebDriver driver = null;
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "E:\\eclipse_workspace\\selenium_workspace\\firstSelenium\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	
	@Test
	public void getElements() {
		driver.get("https://edition.cnn.com/");
		WebElement topStories = driver.findElement(By.xpath("//*[@id=\'intl_homepage1-zone-1\']/div[2]/div/div[2]"));
		
		
		//we can use findElement and findElements along with the the object of a webelement
		List<WebElement> topStoriesLink = topStories.findElements(By.tagName("a"));
		System.out.println("Number of top stories "+topStoriesLink.size());
		
		for(WebElement topLink : topStoriesLink) {
			String topLinkText = topLink.getText();
			
			if(!topLinkText.isEmpty())
				System.out.println(topLinkText);
		}
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}

}
