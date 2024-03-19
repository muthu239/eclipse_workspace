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

public class HandleIframes {
	
WebDriver driver = null;
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "E:\\eclipse_workspace\\selenium_workspace\\firstSelenium\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://jqueryui.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
	}
	
	@Test
	public void getIframe() {
		
		driver.findElement(By.linkText("Button")).click();
		
		WebElement pageTitle = driver.findElement(By.className("entry-title"));
		Assert.assertEquals(pageTitle.getText(), "Button");
		
		//this will throw error as coz it belongs to different iframe that is why we use driver.switchTo()
		
		//if frame has name or id 
		// driver.switchTo().frame("//iframe[@id = 'id_value']");
		
		//if frame does not have id or name we use xpath as follows
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class = 'demo-frame']")));
		WebElement frstBtn = driver.findElement(By.xpath("//*[@class = 'widget']/button"));
		Assert.assertEquals(frstBtn.getText(), "A button element");
		
		//if we want to get element from main frame we need to switch back the frame
		driver.switchTo().parentFrame();
		
		WebElement exmpBtn = driver.findElement(By.xpath("//div[@class = 'demo-list']/h2"));
		Assert.assertEquals(exmpBtn.getText(), "Examples");

		
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
	
	

}



