package com.selenium.miniProject;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HandleBrowserWindows {
	public WebDriver driverSetupMethod() {
		System.setProperty("webdriver.chrome.driver", "E:\\eclipse_workspace\\firstSelenium\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
	}
	
	public void waitMethod() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void mainMethod() {
		
		HandleBrowserWindows obj = new HandleBrowserWindows();
		
		WebDriver driver = obj.driverSetupMethod();
		//get the URL
		driver.get("http://cookbook.seleniumacademy.com/Config.html");
		//get the main window as parent
		String parent = driver.getWindowHandle();
				
		//open the child windows
		driver.findElement(By.id("helpbutton")).click();
		obj.waitMethod();
	
		driver.findElement(By.id("chatbutton")).click();
		obj.waitMethod();
		
		driver.findElement(By.id("visitbutton")).click();
		obj.waitMethod();
		
		Set<String> childWindows = driver.getWindowHandles();
		System.out.println("Number of browser windows opened : "+childWindows.size());
        
		for (String str: childWindows){
    			// switching to each window
    			driver.switchTo().window(str);
    			String s= driver.getTitle();
    			// comparing and closing the window with title "visit us"
    			if(s.equalsIgnoreCase("Visit us")){
    				System.out.println("Window with title '"+ driver.getTitle()+"' is found");
    				driver.close();
    			}
		}
		
		//switching back to the main parent window
    	driver.switchTo().window(parent);
    	childWindows = driver.getWindowHandles();
    	obj.waitMethod();        
    	
    	
    	//if the window is already closed and the childWindows is not updated then this exception works
    	//Here the childWIndows set is updated so there is no exception
    	for (String str: childWindows){
    		try {
    			// switching to each window and closing
    			driver.switchTo().window(str);
    			driver.close();
    			}
    		catch(NoSuchWindowException e) {   
            	System.out.println("This is the output of exception");
            }
    	}
    	

        driver.quit();
        	
      	}

}
