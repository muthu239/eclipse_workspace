package com.selenium.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NameLocator1 {
	
	public static String baseUrl = "http://webapps.tekstac.com/Handling_Regular_Expression/";
	public static WebDriver driver;
	
	public WebDriver createDriver() {
		System.setProperty("webdriver.chrome.driver", "E:\\eclipse_workspace\\firstSelenium\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
	}
	
	public void navigate(WebDriver driver) {
		driver.get(baseUrl);
	}
	
	public void setFormValues(WebDriver driver) {
		driver.findElement(By.id("userId")).sendKeys("Shamili");
		driver.findElement(By.id("track")).click();
		
	}
	
	public WebElement getNameResultElement(WebDriver driver) {
		return driver.findElement(By.xpath("//td[contains(text(),'Shamili')]"));
	}
	
	public WebElement getShipmentResultElement(WebDriver driver) {
		return driver.findElement(By.xpath("//div[@id = 'shipment']"));
	}
	
	public WebElement getEmailResultElement(WebDriver driver) {
		return driver.findElement(By.xpath("//div[@id = 'e- mail']"));
	}
	
	public boolean validateEmail(String eMailId) {
		if (eMailId.matches("\\b[A-Z0-9a-z-]+@[a-z]+\\.[a-z]{2,4}\\b"))
			return true;
		else
			return false;
	}
	
	public boolean validateShipmentId(String shipmentId) {
		if (shipmentId.matches("[A-Z0-9]{8}"))
			return true;
		else
			return false;
	}
	
	public static void main(String[] args) {
		NameLocator1 reg = new NameLocator1();
		
		driver = reg.createDriver();
		reg.navigate(driver);
		reg.setFormValues(driver);
		WebElement e1 = reg.getEmailResultElement(driver);
		//WebElement e2 = reg.getNameResultElement(driver);
		WebElement e3 = reg.getShipmentResultElement(driver);
		
		String email = e1.getText();
		String ship = e3.getText();
		
		System.out.println(reg.validateEmail(email));
		System.out.println(reg.validateShipmentId(ship));
	}

}
