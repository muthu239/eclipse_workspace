package com.selenium.master2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HandleMouseHover {
WebDriver driver = null;
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "E:\\eclipse_workspace\\selenium_workspace\\firstSelenium\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
	
	@Test
	public void handleMouseHoverOnClick() {
		
		driver.get("https://www.americangolf.com/");
		
		WebElement courseLink = driver.findElement(By.xpath("//*[@id=\"navbar-collapse\"]/nav/ul/li[3]/a[1]"));
		
		
		Actions action = new Actions(driver);
		action.moveToElement(courseLink).build().perform();
		
		//after hovering of mouse if we want to click a link
		//press ctrl+shift+c while keeping the mouse over that element to inspect the element
		WebElement countryClublink = driver.findElement(By.xpath("//*[@id=\"navbar-collapse\"]/nav/ul/li[3]/ul/ul/li[2]/a"));
		countryClublink.click();
		
		Assert.assertEquals("Country Club Weddings, Events and Golf Memberships", driver.getTitle());
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}

}
