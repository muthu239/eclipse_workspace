package seleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestRadioBtn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String URL = "https://www.seleniumeasy.com/test/basic-radiobutton-demo.html";
		
		//open the url with selenium
		System.setProperty("webdriver.chrome.driver", "E:\\eclipse_workspace\\javaBasic\\src\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//To maximize the browser
		driver.manage().window().maximize();
		driver.get(URL);
		
		driver.findElement(By.name("optradio")).click();
		driver.findElement(By.id("buttoncheck")).click();
		System.out.println(driver.findElement(By.className("radiobutton")).getText());
		String txt = driver.findElement(By.className("radiobutton")).getText();
		if(txt.equalsIgnoreCase("Radio button 'Male' is checked"))
			System.out.println("The check box is correctly selected");
		
		driver.findElement(By.xpath("//div[@class='col-md-6 text-left']/div[2]//input[@value='Female']")).click();
		driver.findElement(By.xpath("//div[@class='col-md-6 text-left']/div[2]//input[@value='5 - 15']")).click();
		driver.findElement(By.xpath("//div[@class='col-md-6 text-left']/div[2]//button")).click();
		System.out.println(driver.findElement(By.className("groupradiobutton")).getText());
		
		driver.quit();
	}

}
