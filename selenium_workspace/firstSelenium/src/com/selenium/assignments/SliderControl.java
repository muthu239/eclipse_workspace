package com.selenium.assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SliderControl {
	WebDriver driver = null;
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "E:\\eclipse_workspace\\firstSelenium\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
	//@Test
	public void test() {
		driver.get("https://emicalculator.net/loan-calculator/");
		WebElement slider = driver.findElement(By.xpath("//*[@id='loanamountslider']/span"));
		
		String value = driver.findElement(By.cssSelector("#loanamount")).getAttribute("value");

		 for (int i = 1; i <= 5 ; i++) {
         slider.sendKeys(Keys.ARROW_RIGHT);
		     }
		 driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		 String rightSideVal = driver.findElement(By.cssSelector("#loanamount")).getAttribute("value");
		 
		 for (int i = 3; i > 0 ; i--) {
	         slider.sendKeys(Keys.ARROW_LEFT);
			     }
		 driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		 String leftSideVal = driver.findElement(By.cssSelector("#loanamount")).getAttribute("value");
		 
		 System.out.println(value);
		 System.out.println(rightSideVal);
		 System.out.println(leftSideVal);
	}
	
	@DataProvider(name = "new")
	public String[][] getTest() {
		return new String[][]{ {"John" ,"986","02","male","mumbai"}}; 
	}
	
	@Test(dataProvider = "new")
	public void ready(String name,String name1,String name2,String name3,String name4) {
		driver.get("https://webapps.tekstac.com/CustomerRegistration_4284/");
		driver.findElement(By.id("name")).sendKeys(name);
		driver.findElement(By.id("mobile")).sendKeys(name1);
		driver.findElement(By.id("dob")).sendKeys(name2);
		if(name3.equalsIgnoreCase("male"))
		driver.findElement(By.id("male")).click();
		driver.findElement(By.id("address")).sendKeys(name);
		driver.findElement(By.id("register")).click();
		SliderControl sc= new SliderControl();
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id = 'errorMessage']/table/tbody/tr[1]/td[2]")).getText(),sc.getTest()[0][0],"msg0" );
	}

}
//public class TestClass 
//{
// public static void main(String[] args) {         
// File file = new File("D:\\Driver\\IEDriverServer.exe");
// System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
// WebDriver driver = new InternetExplorerDriver();
// driver.get("http://jqueryui.com/slider/");
//
// WebElement slider = driver.findElement(By.xpath("//div[@id='slider']/a"));
//
// for (int i = 1; i <= "how many times you want" ; i++) {
//         slider.sendKeys(Keys.ARROW_RIGHT);
//     }
//
//}