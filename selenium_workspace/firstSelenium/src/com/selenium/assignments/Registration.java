package com.selenium.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Registration {
	static String baseUrl = "";
	
	public WebDriver createDriver() {
		System.setProperty("webdriver.chrome.driver", "E:\\eclipse_workspace\\firstSelenium\\drivers\\chromedriver.exe");
		WebDriver driver1 = new ChromeDriver();
		driver1.manage().window().maximize();
		return driver1;
	}
	
	public void navigate(WebDriver driver) {
		baseUrl = "http://webapps.tekstac.com/InvoiceUpdates/";
		driver.get(baseUrl);
	}
	
	public Select getCategoryElement(WebDriver driver) {
		WebElement element = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/form/table/tbody/tr[5]/td[2]/select"));
		Select drpdown = new Select(element);
		return(drpdown);
	}
	
	public void setFormValues(WebDriver driver) {
		driver.findElement(By.id("name")).sendKeys("rakesh");
		driver.findElement(By.id("number")).sendKeys("1234");
		driver.findElement(By.id("newuser")).click();
		getCategoryElement(driver).selectByVisibleText("Utility Invoice");
		driver.findElement(By.name("amount")).sendKeys("1000");
		driver.findElement(By.name("num")).sendKeys("9876543210");
		driver.findElement(By.name("comments")).sendKeys("new user Utility Invoice");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.id("submit")).click();
	}
	
	public WebElement getSuccessMessageElement(WebDriver driver) {
		WebElement element = driver.findElement(By.id("result"));
		return element;
	}
	
	public String getSuccessMessage(WebElement element) {
		String msg = element.getText();
		return msg;
	}
	
	@Test
	public void mainMethod() {
		Registration reg = new Registration();
		WebDriver driver = reg.createDriver();
		reg.navigate(driver);
		reg.setFormValues(driver);
		WebElement element = reg.getSuccessMessageElement(driver);
		System.out.println(reg.getSuccessMessage(element));
		driver.quit();
		
	}

}

