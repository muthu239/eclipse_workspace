package InterestCalaculator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.asserts.SoftAssert;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import utilities.DateUtils;
import utilities.ExtentReportManager;

public class BaseUI {
	
	public WebDriver driver;
	public Properties prop;
	public ExtentReports report = ExtentReportManager.getReportInstance();
	public ExtentTest logger;
	SoftAssert softAssert = new SoftAssert();

	/*************************** Invoke browser ************************/
	/*
	 * invokeBrowser gets the browser name from the properties file and opens the
	 * browser accordingly
	 */
	public void invokeBrowser(String browserNameKey) {

		if (prop == null) {
			prop = new Properties();
			try {
				FileInputStream file = new FileInputStream(System.getProperty("user.dir")
						+ "\\src\\test\\resources\\objectRepository\\projectConfig.properties");
				prop.load(file);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				reportFail(e.getMessage());
				e.printStackTrace();
			}
		}

		try {
			if (prop.getProperty(browserNameKey).equalsIgnoreCase("chrome")) {
				logger.log(Status.INFO, "Opening Chrome browser");
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\chromedriver.exe");
				driver = new ChromeDriver();
			} else if (prop.getProperty(browserNameKey).equalsIgnoreCase("mozilla")) {
				logger.log(Status.INFO, "Opening Mozilla firefox browser");
				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\geckodriver.exe");
				driver = new FirefoxDriver();
			}

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
		} catch (Exception e) {
			reportFail(e.getMessage());
		}

	}

	/*************************** Open website Url ************************/
	/*
	 * open URL method is used to pass the url value to the driver and the website
	 * is opened
	 */
	public void openURL(String websiteURLKey) {
		try {
			driver.get(prop.getProperty(websiteURLKey));
			reportPass(websiteURLKey + "Identified successfully");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}

	/*************************** Close browser ************************/
	/*
	 * closing the browser window
	 */
	public void tearDown() {
		driver.close();
	}

	/*************************** Quit browser ************************/
	/*
	 * completely quitting the browser
	 */
	public void quitBrowser() {
		driver.quit();
	}

	/*************************** Enter text ************************/
	/*
	 * Entering the text into the element location
	 */
	public void enterText(String locatorKey, String data) {
		try {
			getElement(locatorKey).sendKeys(Keys.chord(Keys.CONTROL, "a"));
			getElement(locatorKey).sendKeys(data);
			implicitWait();
			reportPass(data + " - Entered successfully in locator element : " + locatorKey);
		} catch (Exception e) {
			reportFail(e.getMessage());
		}

	}
	
	
	/*************************** Click functions  ************************/
	/*
	 * Clicking the enter button at the locatorkey location
	 */
	public void clickEnter(String locatorKey) {
		try {
			getElement(locatorKey).sendKeys(Keys.ENTER);
			;
			reportPass("Entered values successfully ");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}

	/*
	 * Clicking the element present at the locatorkey location
	 */
	public void elementClick(String locatorKey) {
		try {
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("arguments[0].scrollIntoView(true);", getElement(locatorKey));
			implicitWait();
			getElement(locatorKey).click();
			reportPass(locatorKey + " - Element clicked successfully");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}

	/*
	 * clicking somewhere on the screen
	 */
	public void simpleClick() {
		Actions act = new Actions(driver);
		act.click().perform();
	}
	
	/*************************** Slider UI check ************************/
	/*
	 * The slider UI check function checks the slider UI by moving to some position
	 * to the right and the left and the values at the completion of slider movement on
	 * each side are entered as log on the report
	 */
	public void sliderUICheck(String sliderLocatorKey, String textboxLocatorKey) {
		try {
			String value = getElement(textboxLocatorKey).getAttribute("value");
			logger.log(Status.INFO, "The inital value before moving the slider :" + value);
			for (int i = 0; i <= 5; i++) {
				getElement(sliderLocatorKey).sendKeys(Keys.ARROW_RIGHT);
			}
			String rightValue = getElement(textboxLocatorKey).getAttribute("value");
			logger.log(Status.INFO, "The value after moving the slider right :" + rightValue);
			waitLoad(2);
			for (int i = 3; i > 0; i--) {
				getElement(sliderLocatorKey).sendKeys(Keys.ARROW_LEFT);
			}
			String leftValue = getElement(textboxLocatorKey).getAttribute("value");
			logger.log(Status.INFO, "The value after moving the slider left :" + leftValue);
			waitLoad(2);
			reportPass("The slider UI of the " + sliderLocatorKey + "is working fine");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}
	
	/*************************** Get page title ************************/
	/*
	 * Getting the title of the current webpage
	 */
	public String getPageTitle() {
		String title = driver.getTitle();
		reportPass(" Title of page is :" + title);
		return title;
	}
	
	/*************************** Refresh page ************************/
	/*
	 * Refreshing the current webpage
	 */
	public void refreshPage() {
		driver.navigate().refresh();
		reportPass("The webpage has been refreshed");
	}
	
	/*************************** Get text function ************************/
	/*
	 * Extracting the text from locator location and along with the message the text
	 * extracted is logged
	 */
	public void getTextFromLocator(String locatorKey, String msg) {
		try {
			System.out.println(msg + getElement(locatorKey).getText());
			logger.log(Status.INFO, "Value from the locator is identified and it is printed in console as : " + msg
					+ getElement(locatorKey).getText());
			reportPass(locatorKey + " - value from the locator is extracted successfully");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}

	/*************************** Identify element ************************/
	/*
	 * The webelement is located using the get element method and the webelement are
	 * used for further operations
	 */
	public WebElement getElement(String locatorKey) {
		WebElement element = null;
		try {
			if (locatorKey.endsWith("_id")) {
				element = driver.findElement(By.id(prop.getProperty(locatorKey)));
				logger.log(Status.INFO, "Locator identified : " + locatorKey);
			} else if (locatorKey.endsWith("_xpath")) {
				element = driver.findElement(By.xpath(prop.getProperty(locatorKey)));
				logger.log(Status.INFO, "Locator identified : " + locatorKey);
			} else if (locatorKey.endsWith("_CSS")) {
				element = driver.findElement(By.cssSelector(prop.getProperty(locatorKey)));
				logger.log(Status.INFO, "Locator identified : " + locatorKey);
			} else if (locatorKey.endsWith("_linkText")) {
				element = driver.findElement(By.linkText(prop.getProperty(locatorKey)));
				logger.log(Status.INFO, "Locator identified : " + locatorKey);
			} else if (locatorKey.endsWith("_partialLinkTest")) {
				element = driver.findElement(By.partialLinkText(prop.getProperty(locatorKey)));
				logger.log(Status.INFO, "Locator identified : " + locatorKey);
			} else if (locatorKey.endsWith("_name")) {
				element = driver.findElement(By.name(prop.getProperty(locatorKey)));
				logger.log(Status.INFO, "Locator identified : " + locatorKey);
			} else if (locatorKey.endsWith("_className")) {
				element = driver.findElement(By.className(prop.getProperty(locatorKey)));
				logger.log(Status.INFO, "Locator identified : " + locatorKey);
			} else {
				reportFail("Failing the TestCase, Invalid Locator key" + locatorKey);
				Assert.fail();
			}
		} catch (Exception e) {
			// fail the test case and report the error
			reportFail(e.getMessage());
			e.printStackTrace();
			Assert.fail("Failing the testCase : " + e.getMessage());
		}
		return element;
	}
	
	/*************************** Identify the list of elements with findElements ************************/
	/*
	 * The list of webelements is located using the list of elements method which
	 * returns a list of the webelements with which further operations are proceeded
	 * 
	 */
	public List<WebElement> listOfElements(String locatorKey) {
		List<WebElement> element = null;
		try {
			if (locatorKey.endsWith("_id")) {
				element = driver.findElements(By.id(prop.getProperty(locatorKey)));
				logger.log(Status.INFO, "list of Locator identified for the locatorKey : " + locatorKey);
			} else if (locatorKey.endsWith("_xpath")) {
				element = driver.findElements(By.xpath(prop.getProperty(locatorKey)));
				logger.log(Status.INFO, "list of Locator identified for the locatorKey : " + locatorKey);
			} else if (locatorKey.endsWith("_CSS")) {
				element = driver.findElements(By.cssSelector(prop.getProperty(locatorKey)));
				logger.log(Status.INFO, "list of Locator identified for the locatorKey : " + locatorKey);
			} else if (locatorKey.endsWith("_linkText")) {
				element = driver.findElements(By.linkText(prop.getProperty(locatorKey)));
				logger.log(Status.INFO, "list of Locator identified for the locatorKey : " + locatorKey);
			} else if (locatorKey.endsWith("_partialLinkTest")) {
				element = driver.findElements(By.partialLinkText(prop.getProperty(locatorKey)));
				logger.log(Status.INFO, "list of Locator identified for the locatorKey : " + locatorKey);
			} else if (locatorKey.endsWith("_name")) {
				element = driver.findElements(By.name(prop.getProperty(locatorKey)));
				logger.log(Status.INFO, "list of Locator identified for the locatorKey : " + locatorKey);
			} else if (locatorKey.endsWith("_className")) {
				element = driver.findElements(By.className(prop.getProperty(locatorKey)));
				logger.log(Status.INFO, "list of Locator identified for the locatorKey : " + locatorKey);
			} else {
				reportFail("Failing the TestCase, Inalid Locator key" + locatorKey);
				Assert.fail();
			}
		} catch (Exception e) {
			// fail the test case and report the error
			reportFail(e.getMessage());
			e.printStackTrace();
			Assert.fail("Failing the testCase : " + e.getMessage());
		}
		return element;
	}
	
	
	/*************************** Reporting functions ************************/
	/*
	 * reporting functions creates a log on the report which is generated and takes
	 * screenshot if the report is failure along with log
	 */
	public void reportFail(String reportString) {
		logger.log(Status.FAIL, reportString);
		takeScreenShotOnFailure();
		Assert.fail(reportString);
	}

	public void reportPass(String reportString) {
		logger.log(Status.PASS, reportString);
	}


	/*************************** Capture ScreenShots ************************/
	/*
	 * Takes screenshot and the screenshot is saved with the timestamp as the the
	 * name of the screenshot
	 */
	public void takeScreenShotOnFailure() {
		TakesScreenshot takeScreenShot = (TakesScreenshot) driver;
		File sourceFile = takeScreenShot.getScreenshotAs(OutputType.FILE);

		File destFile = new File(
				System.getProperty("user.dir") + "\\Screenshots\\" + DateUtils.getTimeStamp() + ".png");
		try {
			FileUtils.copyFile(sourceFile, destFile);
			logger.addScreenCaptureFromPath(
					System.getProperty("user.dir") + "\\Screenshots\\" + DateUtils.getTimeStamp() + ".png");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/*************************** Assertion Functions ************************/
	/*
	 * Assert functions compares according to the functions and logs the assertion
	 * output
	 */
	public void assertTrue(boolean flag) {
		softAssert.assertTrue(flag);
	}

	public void assertFalse(boolean flag) {
		softAssert.assertFalse(flag);
	}

	public void assertequals(String actual, String expected) {
		try {
			logger.log(Status.INFO, "Assertion : Actual is -" + actual + " And Expected is - " + expected);
			softAssert.assertEquals(actual, expected);
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}
	
	/*************************** Writing in excel File ************************/
	/*
	 * Writing the webtable values in the excel file
	 */
	public void writeSheet(String workbookTitle, String sheetName) {
		int actualRows = listOfElements("rowsList_xpath").size() - 1;
		int actualCols = listOfElements("columnsList_xpath").size();
		XSSFWorkbook wb = new XSSFWorkbook();
		logger.log(Status.INFO, "A new workbook for the excel sheet is created");
		// creating a Sheet object using the sheet Name
		XSSFSheet sheet = wb.createSheet(sheetName);
		logger.log(Status.INFO, "A new worksheet in the workbook is created with sheetname" + sheetName);
		XSSFRow row0 = sheet.createRow(0);
		String headingBreaked1 = prop.getProperty("headingRowListBreak1_xpath");
		String headingBreaked2 = prop.getProperty("headingRowListBreak2_xpath");

		int actualHeads = listOfElements("headingRowList_xpath").size();
		for (int i = 1; i <= actualHeads; i++) {
			String heading = driver.findElement(By.xpath(headingBreaked1 + i + headingBreaked2)).getText();
//    	 String heading = driver.findElement(By.xpath("//*[@id='paymentschedule']/table/tbody/tr[1]/th["+i+"]")).getText();
			row0.createCell(i - 1).setCellValue(heading);
		}
		logger.log(Status.INFO, "The values of headings are entered into the excel sheet");

		String cellBreaked1 = prop.getProperty("columnsListBreak1_xpath");
		String cellBreaked2 = prop.getProperty("columnsListBreak2_xpath");
		String cellBreaked3 = prop.getProperty("columnsListBreak3_xpath");
		for (int i = 2, rowNo = 1; i <= actualRows && rowNo <= actualRows; i = i + 2, rowNo++) {
			XSSFRow row = sheet.createRow(rowNo);
			for (int j = 1; j <= actualCols; j++) {
				String value = driver.findElement(By.xpath(cellBreaked1 + i + cellBreaked2 + j + cellBreaked3)).getText();
						
//				String value = driver.findElement(By.xpath("//*[@id='paymentschedule']/table/tbody/tr["+i+"]/td["+j+"]")).getText();
				row.createCell(j - 1).setCellValue(value);
			}
		}
		logger.log(Status.INFO, "The values of table are entered into the excel sheet");

		try {
			FileOutputStream writeFile = new FileOutputStream(workbookTitle + ".xlsx");
			logger.log(Status.INFO, "The workbook is created with title : " + workbookTitle);
			wb.write(writeFile);
			writeFile.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			reportFail(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			reportFail(e.getMessage());
			e.printStackTrace();
		}
	}

	/***************** Wait Functions in Framework *****************/
	/*
	 * wait functions puts wait wherever the methods are called
	 */
	public void waitForPageLoad() {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		int i = 0;
		while (i != 180) {
			String pageState = (String) js.executeScript("return document.readyState;");
			if (pageState.equals("complete")) {
				break;
			} else {
				waitLoad(1);
			}
		}

		waitLoad(2);

		i = 0;
		while (i != 180) {
			Boolean jsState = (Boolean) js.executeScript("return window.jQuery != undefined && jQuery.active == 0;");
			if (jsState) {
				break;
			} else {
				waitLoad(1);
			}
		}
	}

	public void waitLoad(int i) {
		try {
			Thread.sleep(i * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void implicitWait() {
		driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
	}

	
	/***************** Selecting month and year from the calendar *****************/
	/*
	 * Selecting the month and year from the calendar using the method
	 */
	public void selectDateInCalendar(String monthAndYear) {
		String word0 = monthAndYear.substring(0, 3);
		String word1 = monthAndYear.substring(4, 8);
		int expectedYear = Integer.parseInt(word1);
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
//				driver.findElement(By.xpath("//div[@class = 'datepicker-months']/table/thead/tr[2]/th[1]")).click();
				getElement("previousYearBtn_xpath").click();
			}

		} else if (expectedYear > year) {
			for (int i = 0; i < (expectedYear - year); i++) {
//				driver.findElement(By.xpath("//div[@class = 'datepicker-months']/table/thead/tr[2]/th[3]")).click();
				getElement("nextYearBtn_xpath").click();

			}

		}

		String equalMonth1 = prop.getProperty("equalMonth1_xpath");
		String equalMonth2 = prop.getProperty("equalMonth2_xpath");
		String diffMonth1 = prop.getProperty("diffMonth1_xpath");
		String diffMonth2 = prop.getProperty("diffMonth2_xpath");

		if (monthName.equalsIgnoreCase(word0)) {
			driver.findElement(By.xpath(equalMonth1 + (month + 1) + equalMonth2)).click();
			// driver.findElement(By.xpath("/html/body/div[3]/div[2]/table/tbody/tr/td/span["
			// + (month + 1) + "]")).click();

		} else {
			driver.findElement(By.xpath(diffMonth1 + word0 + diffMonth2)).click();
//			driver.findElement(By.xpath("//span[contains(text(),'" + word0 + "')]")).click();
		}

	}
	
	
	
	
	@AfterMethod
	public void afterTest() {
		softAssert.assertAll();
	}

}
