package com.selenium.assignments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class NameLocator {
	static String page1,page2,page3,page4,page5,baseUrl;
	static WebDriver driver;
	
	public WebDriver setUpDriver() {
		System.setProperty("webdriver.chrome.driver", "E:\\eclipse_workspace\\firstSelenium\\drivers\\chromedriver.exe");
		WebDriver driver1 = new ChromeDriver();
		driver1.manage().window().maximize();
		return(driver1);
	}
	
	public void navigate1() {
		baseUrl = "https://selenium.dev/";
		driver.get(baseUrl);
	}
	
	public void getPageTitle1() {
		page1 = driver.getTitle();
	}
	
	public void navigate2() {
		driver.get("https://www.google.co.in/");
	}
	
	public void getPageTitle2() {
		page2 = driver.getTitle();
	}
	
	public void navigateBack() {
		driver.navigate().back();
	}
	
	public void getPageTitle3() {
		page3 = driver.getTitle();
	}
	
	public void navigateForward() {
		driver.navigate().forward();
	}
	
	public void getPageTitle4() {
		page4 = driver.getTitle();
	}
	
	public void refreshPage() {
		driver.navigate().refresh();
	}
	
	public void getPageTitle5() {
		page5 = driver.getTitle();
	}
	
	@Test
	public void method() {
		NameLocator obj = new NameLocator();
		driver = obj.setUpDriver();
		obj.navigate1();
		obj.getPageTitle1();
		obj.navigate2();
		obj.getPageTitle2();
		obj.navigateBack();
		obj.getPageTitle3();
		obj.navigateForward();
		obj.getPageTitle4();
		obj.refreshPage();
		obj.getPageTitle5();
		
		System.out.println(page1+" "+page2+" "+page3+" "+page4+" "+page5);
		driver.quit();
	}

}

