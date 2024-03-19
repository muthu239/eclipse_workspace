package com.selenium.assignments;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WriteInExcelFile {
	
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
	public void writeSheet() throws IOException {
		driver.get("https://emicalculator.net/home-loan-emi-calculator/");
		
		List<WebElement> approxRows =driver.findElements(By.xpath("//*[@id='paymentschedule']/table/tbody/tr"));
		int actualRows = approxRows.size() - 1 ;
		
		List<WebElement> cols = driver.findElements(By.xpath("//*[@id='paymentschedule']/table/tbody/tr[2]/td"));
		int actualCols = cols.size();
		
        //creating workbook instance that refers to .xlsx file
       
		XSSFWorkbook wb=new XSSFWorkbook();
        //creating a Sheet object using the sheet Name
        XSSFSheet sheet = wb.createSheet("Sheet1");
        
       XSSFRow row0 =  sheet.createRow(0);
       
       List<WebElement> heads = driver.findElements(By.xpath("//*[@id='paymentschedule']/table/tbody/tr[1]/th"));
		int actualHeads = heads.size();
		for(int i = 1;i<=actualHeads;i++) {
    	 String heading = driver.findElement(By.xpath("//*[@id='paymentschedule']/table/tbody/tr[1]/th["+i+"]")).getText();
    	 row0.createCell(i-1).setCellValue(heading);
		}
		
		for(int i = 2, rowNo =1 ; i<=actualRows && rowNo <= actualRows; i = i+2,rowNo++) {
			XSSFRow row = sheet.createRow(rowNo);
			for(int j = 1 ; j<=actualCols ; j++) {
				String value = driver.findElement(By.xpath("//*[@id='paymentschedule']/table/tbody/tr["+i+"]/td["+j+"]")).getText();
				row.createCell(j-1).setCellValue(value);
				System.out.println(value);
			}
		}
		
		try {
			FileOutputStream writeFile = new FileOutputStream("sampleTest.xlsx");
			
			//C:Test//Sample//...//fileName
			
			wb.write(writeFile);
			//closing the file
			writeFile.close();
			System.out.println("The sample xl file is created");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
