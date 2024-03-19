package com.liveProject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class AddDeleteStockInPortfolio {
	
WebDriver driver = null;
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "E:\\eclipse_workspace\\selenium_workspace\\firstSelenium\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
	
	@Test
	public void addStockTest() {
		driver.get("https://www.rediff.com/");
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/a[2]")).click();
		driver.findElement(By.linkText("Sign In")).click();
		driver.findElement(By.id("useremail")).sendKeys("muthun0203@rediffmail.com");
		driver.findElement(By.id("userpass")).sendKeys("P@&&w0rd");
		driver.findElement(By.id("userpass")).sendKeys(Keys.ENTER);
		
		
		// selecting the portfolio
		WebElement dropdown = driver.findElement(By.id("portfolioid"));
		Select select = new Select(dropdown);
		select.selectByVisibleText("Test portfolio");
		
		//Test case 1
		//Add stock 
		//directly sending values
	/*	driver.findElement(By.id("addStock")).click();
		driver.findElement(By.id("addstockname")).sendKeys("Nestle India Ltd.");
		driver.findElement(By.id("stockAddDate")).sendKeys("07-05-2021");
		driver.findElement(By.id("addstockqty")).sendKeys("100");
		driver.findElement(By.id("addstockprice")).sendKeys("150");
		driver.findElement(By.id("addStockButton")).click(); */
		
		
		//Test case 2
		//Add stock
		//selecting using the dropdown and other ui
		driver.findElement(By.id("addStock")).click();
		driver.findElement(By.id("addstockname")).sendKeys("Ne");
		
		waitForPageLoad();
		
		List<WebElement> autoSuggests = driver.findElements(By.xpath("//*[@id=\'ajax_listOfOptions\']/div"));
		String str = autoSuggests.get(1).getText();
		autoSuggests.get(1).click();
		System.out.println("the stock name selected is : "+str);
		driver.findElement(By.xpath("//*[@id=\'stockPurchaseDate\']")).click();
		selectDateInCalendar("12/03/2020");
		
		driver.findElement(By.id("addstockqty")).sendKeys("100");
		driver.findElement(By.id("addstockprice")).sendKeys("15000");
		
		driver.findElement(By.xpath("//*[@id=\'addStockButton\']")).click();
		
		waitForPageLoad();
		
		int stockRowNumber = getStockRowNumber("Network 18 Media & I");
		System.out.println("Row Number is : "+ stockRowNumber);
		
		if(stockRowNumber == -1) {
			Assert.fail("String Not found");
		}
		
		deleteStock();
	}
	
	//This function is for both pageload and js load to put wait 
	public void waitForPageLoad() {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		int i = 0;
		while(i != 180) {
			String pageState = (String) js.executeScript("return document.readyState;");
			
			if(pageState.equals("complete")) {
				break;
			}else {
				waitLoad(4);
			}
		}
		waitLoad(4);
		//to wait until the js of the page loads
		//180 is optional we can give any amount seconds we prefer like 60
		i = 0;
		while(i!=180) {
			Boolean jsState = (Boolean) js.executeScript("return window.jQuery != undefined && jQuery.active ==0;");
			if(jsState) {
				break;
			}else {
				waitLoad(4);
			}
		
		}
	}
	
	
	public void waitLoad(int i) {
		try {
			Thread.sleep(i*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteStock() {
		int stockRowNumber = getStockRowNumber("Network 18 Media & I");
		driver.findElement(By.xpath("//*[@id='stock']/tbody/tr["+(stockRowNumber-1)+"]/td[1]")).click();
		
		waitForPageLoad();
		
		driver.findElements(By.xpath("//input[@name = 'Delete']")).get(stockRowNumber-2).click();
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
		
		waitForPageLoad();
		
		//to check whether the code run perfectly and stock got deleted
		int stockRowNumberAfterDelete = getStockRowNumber("Network 18 Media & I");
		Assert.assertEquals(stockRowNumberAfterDelete, -1,"Row is deleted");
		

	}
	
	
	public int getStockRowNumber(String stockName) {
		
		List<WebElement> totalRows = driver.findElements(By.xpath("//*[@id='stock']/tbody/tr"));
		
		int rowNum = 1;
		for(WebElement row: totalRows) {
			List<WebElement> rowCells = row.findElements(By.tagName("td"));
			rowNum++;
			
			for(WebElement cell : rowCells) {
				String cellData = cell.getText();
				System.out.println(cellData);
				if(!cellData.isEmpty() && cellData.contains(stockName)) {
					return rowNum;
				}
			}
		}
		
		return -1;
	}
	
	public void selectDateInCalendar(String date) {
		Date currentDate = new Date();
		
		//to convert the current date to a certain format
		//MM should be in caps
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Date expectedDate = dateFormat.parse(date);
			
			//To get day,month,year separately
			String day = new SimpleDateFormat("dd").format(expectedDate);
			String month = new SimpleDateFormat("MMMM").format(expectedDate);
			String year = new SimpleDateFormat("yyyy").format(expectedDate);
			
			System.out.println(day+"************"+month+"*************"+year);
		
		//same format as in the website calendar	
			String expectedMonthyear = month + " " + year;
			
		while(true) {
				String displayDate = driver.findElement(By.className("dpTitleText")).getText();
				
				if(expectedMonthyear.equals(displayDate)) {
					
					//select the date when month and year are equal
					driver.findElement(By.xpath("//td[text() ='"+day+"']")).click();
					break;
				}
				//if the expected date is greater than current date it returns a value grater than 0
				else if(expectedDate.compareTo(currentDate)>0) {
					driver.findElement(By.xpath("//*[@id=\'datepicker\']/table/tbody/tr[1]/td[4]/button")).click();
				}
				else {
					driver.findElement(By.xpath("//*[@id=\'datepicker\']/table/tbody/tr[1]/td[2]/button")).click();
				}
			}
		
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}  
	
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
		

}
