package com.selenium.master1;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FindBrokenLinks {
	
	@Test
	public void findBrokenLinks() {
		System.setProperty("webdriver.chrome.driver", "E:\\eclipse_workspace\\selenium_workspace\\firstSelenium\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://edition.cnn.com/");
		
		//NO need to call each time like sleep
		//throws exception if the process times out 
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		// to find the number of links
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		
		// to get text of each link
		for(WebElement link : links) {
			String URL = link.getAttribute("href");
			GetLinkStatus.verifyLink(URL);
		}
		
		System.out.println("Total no of broken links");
		GetLinkStatus.getInvalidLinkCount();
		
		driver.quit();
		
	}

}
