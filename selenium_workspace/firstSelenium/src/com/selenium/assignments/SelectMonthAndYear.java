package com.selenium.assignments;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SelectMonthAndYear {

	WebDriver driver = null;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"E:\\eclipse_workspace\\CalculateInterest\\src\\test\\resources\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Test
	public void addStockTest() {
		driver.get("https://emicalculator.net/home-loan-emi-calculator/");
		driver.findElement(By.id("startmonthyear")).click();
		selectDateInCalendar("May 2025");
//		driver.quit();
	}

	public void selectDateInCalendar(String monthAndYear) {
		String[] words = monthAndYear.split(" ");
		int expectedYear = Integer.parseInt(words[1]);
		GregorianCalendar date = new GregorianCalendar();
		int month = date.get(Calendar.MONTH);
		int year = date.get(Calendar.YEAR);
		String monthName = "";
		switch (month) {
		case 0:
			monthName = "Jan";
			break;
		case 1:
			monthName = "Feb";
			break;
		case 2:
			monthName = "Mar";
			break;
		case 3:
			monthName = "Apr";
			break;
		case 4:
			monthName = "May";
			break;
		case 5:
			monthName = "Jun";
			break;
		case 6:
			monthName = "Jul";
			break;
		case 7:
			monthName = "Aug";
			break;
		case 8:
			monthName = "Sep";
			break;
		case 9:
			monthName = "Oct";
			break;
		case 10:
			monthName = "Nov";
			break;
		case 11:
			monthName = "Dec";
			break;
		}
		if (expectedYear < year) {
			for (int i = 0; i < (year - expectedYear); i++) {
				driver.findElement(By.xpath("/html/body/div[3]/div[2]/table/thead/tr[2]/th[1]")).click();
			}

		} else if (expectedYear > year) {
			for (int i = 0; i < (expectedYear - year); i++) {
				driver.findElement(By.xpath("/html/body/div[3]/div[2]/table/thead/tr[2]/th[3]")).click();

			}

		}

		if (words[0].equalsIgnoreCase(monthName)) {
			driver.findElement(By.xpath("/html/body/div[3]/div[2]/table/tbody/tr/td/span[" + (month + 1) + "]"))
					.click();

		} else {
			driver.findElement(By.xpath("//span[contains(text(),'" + words[0] + "')]")).click();
		}

	}

}
