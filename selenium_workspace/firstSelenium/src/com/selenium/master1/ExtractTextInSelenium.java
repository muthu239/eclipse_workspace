package com.selenium.master1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ExtractTextInSelenium {
	
	@Test
	public void textExtract() {
		System.setProperty("webdriver.chrome.driver", "E:\\eclipse_workspace\\selenium_workspace\\firstSelenium\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com");
		
		//NO need to call each time like sleep
		//throws exception if the process times out 
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		// to get the text on the page
		System.out.println(driver.findElement(By.xpath("//h2[@class='_8eso']")).getText());
		
		//to get the text of button
		System.out.println(driver.findElement(By.xpath("//button[@name = 'login']")).getText());
		
		//to get a placeholder text //get attribute works on webElement
		System.out.println(driver.findElement(By.xpath("//input[@id = 'pass']")).getAttribute("placeholder"));
		
		driver.quit();
		
	}

}
