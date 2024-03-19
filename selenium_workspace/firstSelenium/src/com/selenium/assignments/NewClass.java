package com.selenium.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.Select;

public class NewClass {
	
	
		public static void main(String[] args) throws InterruptedException
		{
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\chromedriver.exe");
			WebDriver Driver= new ChromeDriver();
			Driver.manage().window().maximize();
			
			//url of the given Link or the given Test case
			Driver.get("https://www.emicalculator.net");
			Driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
			
			//Calculator been selected from the Menu Bar
			Driver.findElement(By.xpath("//a[normalize-space()='Calculators']")).click();
			
			//Loan Calculator has been selected
			Driver.findElement(By.xpath("//a[@title='Loan Calculator']")).click();
			
			//Loan amount ,Interest Rate and Loan tenure values are entered
			Driver.findElement(By.xpath("//input[@id='loanamount']")).sendKeys("1000000");
			
			Driver.findElement(By.xpath("//input[@id='loaninterest']")).sendKeys("8.5");
			
			Driver.findElement(By.xpath("//input[@id='loanterm']")).sendKeys("3");
			
			Driver.findElement(By.xpath("//input[@id='loanfees']")).sendKeys("10000");

			Driver.close();
		}



}
