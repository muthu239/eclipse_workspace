package com.liveProject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAndVerifyPortfolio {
	WebDriver driver = null;
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "E:\\eclipse_workspace\\selenium_workspace\\firstSelenium\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
	
	@Test
	public void testCreatePortfolio() {
		driver.get("https://www.rediff.com/");
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/a[2]")).click();
		driver.findElement(By.linkText("Sign In")).click();
		driver.findElement(By.id("useremail")).sendKeys("muthun0203@rediffmail.com");
		driver.findElement(By.id("userpass")).sendKeys("P@&&w0rd");
		driver.findElement(By.id("userpass")).sendKeys(Keys.ENTER);
		
		driver.findElement(By.id("createPortfolio")).click();
		driver.findElement(By.id("create")).clear();
		driver.findElement(By.id("create")).sendKeys("Test portfolio");
		driver.findElement(By.id("createPortfolioButton")).click();
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.findElement(By.xpath("//*[@id=\"username\"]/a")).isDisplayed();
		
		
		//validating the portfolio
		waitForElement("//*[@id=\'portfolioid\']", "Test portfolio");
		
		//Deleting the portfolio
		deletePortfolio();
		
	}
	
	public void waitForElement(String xpath, String elementValue) {
		
		int i = 0;
		while(i!=10){
			WebElement portfolioDropDown = driver.findElement(By.xpath(xpath));
			Select select = new Select(portfolioDropDown);
			String portfolioName = select.getFirstSelectedOption().getText();
			
			if(portfolioName.equalsIgnoreCase(elementValue)) {
				return;
			}
			else{
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				i++;
			}
			
		}
		Assert.assertTrue( false, "The given text "+ elementValue + " is not present in the dropdown");
			
	}
	
	public void deletePortfolio() {
		driver.findElement(By.id("deletePortfolio")).click();
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}  
	

}
