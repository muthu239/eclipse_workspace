package com.selenium.master3;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HandleWebTable {
WebDriver driver = null;
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "E:\\eclipse_workspace\\selenium_workspace\\firstSelenium\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
	
	@Test
	public void manageWebTable() {
		driver.get("https://www.rediff.com/");
		driver.findElement(By.linkText("Money")).click();
		driver.findElement(By.linkText("Indices")).click();
		driver.findElement(By.linkText("Show More >>")).click();
		
		//get total rows
		List<WebElement> totalRows = driver.findElements(By.xpath("//*[@id = 'dataTable']/tbody/tr"));
		System.out.println("total no of rows :"+totalRows.size());
		System.out.println("*********************************************");
		//get total column
		List<WebElement> totalCol = driver.findElements(By.xpath("//*[@id = 'dataTable']/tbody/tr/td"));
		System.out.println("total no of columns :"+totalCol.size());
		System.out.println("*********************************************");
		//get data from a specific row
		List<WebElement> columns = driver.findElements(By.xpath("//*[@id = 'dataTable']/tbody/tr[1]/td"));
		System.out.println("********************Data of row 1*************************");
		for(WebElement column : columns) {
			System.out.println(column.getText());
		}
		
		//get data of a specific column
		List<WebElement> column = driver.findElements(By.xpath("//*[@id = 'dataTable']/tbody/tr/td[1]"));
		System.out.println("**********************Data of column 1***********************");
		for(WebElement col : column) {
			System.out.println(col.getText());
		}
		
		//print data of a complete table
		System.out.println("*********************************************");
		for(WebElement row : totalRows) {
			System.out.println(row.getText());
		}
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}

}
