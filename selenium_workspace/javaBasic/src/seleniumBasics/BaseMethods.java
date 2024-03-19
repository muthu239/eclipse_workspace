package seleniumBasics;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseMethods {
	public static Properties prop;
	public static WebDriver driver;
	public static void invokeBrowser(String URL) {
		System.setProperty("webdriver.chrome.driver", "E:\\eclipse_workspace\\javaBasic\\src\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		
		//To maximize the browser
		driver.manage().window().maximize();
		driver.get(URL);
	}
	
	public static void loadPropertiesFile(String filePath) {
		if (prop == null) {
			prop = new Properties();
			try {
				FileInputStream file = new FileInputStream(filePath);
				prop.load(file);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void clickOnMenu(String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	}
	
	public static void getTextFromLocator(String xpath) {
		System.out.println(driver.findElement(By.xpath(xpath)).getText());
		
	}
//	
//	public void compareText() {
//		
//	}

}
