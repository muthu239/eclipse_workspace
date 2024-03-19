package apachePOIBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTestForm {
	
	public static WebDriver driver ;
	
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", "E:\\eclipse_workspace\\apachePOIBasics\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	public void testSeleniumForm() {
		try {
			String[] customerData = new String[5];
			customerData = CusRegExcel.readExcelData("sampleTest.xlsx");
			driver.get(" http://webapps.tekstac.com/CustomerRegistration/");
			for(int i=0;i<5;i++) {
				System.out.println(customerData[i]);
				driver.findElement(By.xpath("//*[@id=\"agent-form\"]/table/tbody/tr["+(i+1)+"]/td[2]/input")).sendKeys(customerData[i]);
			}
			driver.findElement(By.id("submit")).click();
		}catch(Exception e) { 
			e.printStackTrace();
		}
	}
	
	
	public void closeBrowser() {
		driver.quit();
	}
	
	public static void main(String[] args) {
		CusRegExcel customer = new CusRegExcel();
		SeleniumTestForm tst = new SeleniumTestForm();
		tst.createDriver();
		tst.testSeleniumForm();
		tst.closeBrowser();
	}

}
