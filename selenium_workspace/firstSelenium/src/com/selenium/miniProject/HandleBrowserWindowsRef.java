package com.selenium.miniProject;


import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HandleBrowserWindowsRef {
	
	public WebDriver driverSetupMethod() {
		System.setProperty("webdriver.chrome.driver", "E:\\eclipse_workspace\\firstSelenium\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
	}
	
	public void waitMethod() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void findWindow() {
		
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
		
	/*	Iterator<String> iterator = childWindows.iterator();
        // Here we will check if child window has other child windows and will fetch the heading of the child window
        while (iterator.hasNext()) {
            String str = iterator.next();
            System.out.println(str);
                if (!parent.equalsIgnoreCase(str)) {
                driver.switchTo().window(str);
                String text = driver.getTitle();
                if(text.equalsIgnoreCase("Visit us")) {
                	flag = 1;
                	break;
                }
            }
        } */ 
			for (String str: childWindows){
	        		// switching to each window
	        		driver.switchTo().window(str);
	        		String s= driver.getTitle();
	        		// checking specific window title
	        		if(s.equalsIgnoreCase("Visit us")){
	        			System.out.println("Window title "+ driver.getTitle()+" is found");
	        			driver.close();
	        		}
	        	}
			
	        
	        	driver.switchTo().window(parent);
	        	obj.waitMethod();
	        	
	        	try {
	        	for (String str: childWindows){
	        		// switching to each window
	        		driver.switchTo().window(str);
	        		String s= driver.getTitle();
	        		// checking specific window title
	        		if(s.equalsIgnoreCase("Visit us")){
	        			System.out.println("Window title "+ driver.getTitle()+" is found");
	        			driver.close();
	        		}
	        	}
	        	}
	        	catch(NoSuchWindowException e) {
	        		System.out.println("already closed");
	        	}
       
        driver.quit();
	}
}
