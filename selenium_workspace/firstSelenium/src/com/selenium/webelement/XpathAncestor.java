package com.selenium.webelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathAncestor {
	
	static String fName;
	static WebDriver driver;
	
	public WebDriver setupDriver() {
	System.setProperty("webdriver.chrome.driver", "E:\\eclipse_workspace\\selenium_workspace\\firstSelenium\\drivers\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://webapps.tekstac.com/AddressBook/");
	return driver;
	}
	
	public String getNameLocator() {
		WebElement element = driver.findElement(By.xpath("//input[@id='nickname']/ancestor::div"));
		return element.getAttribute("id");
	}
	
	public static void main(String args[]) {
		XpathAncestor xobj = new XpathAncestor();
		driver = xobj.setupDriver();
		fName = xobj.getNameLocator();
		System.out.println(fName);
	}

}
