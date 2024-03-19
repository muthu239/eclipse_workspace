package com.selenium.master2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MultiSelectDropDown {
WebDriver driver = null;
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "E:\\eclipse_workspace\\selenium_workspace\\firstSelenium\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	
	@Test
	public void selectMultipleDropDown() {
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select_multiple");
		
		driver.switchTo().frame("iframeResult");
		WebElement multiSelect = driver.findElement(By.name("cars"));
		
		Select select = new Select(multiSelect);
		
		//isMultiple()
		System.out.println(select.isMultiple());
		
		//to select two values
		select.selectByIndex(1);
		select.selectByIndex(3);
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//getFirstSelectedOption()
		System.out.println(select.getFirstSelectedOption().getText());
		System.out.println("***************");
		
		
		//getAllSelectedOption()
		List<WebElement> selectedOptions = select.getAllSelectedOptions();
		for(WebElement selectValue : selectedOptions) {
			System.out.println(selectValue.getText());
		}
		
		//deselectAll()
		select.deselectAll();
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}

}
