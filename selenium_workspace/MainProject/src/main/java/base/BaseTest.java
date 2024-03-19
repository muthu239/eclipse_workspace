package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utils.Constants;
import utils.DateUtils;
import utils.ExcelReader;
import utils.ExtentReportManager;


public class BaseTest {
	
	public static WebDriver driver;
	public static Properties prop;
	public static ExtentReports report = ExtentReportManager.getReportInstance();
	public static ExtentTest logger;
	
	/*************************** Constructor ************************/
	public BaseTest() {
		prop = new Properties();
		FileInputStream file;
		try {
			file = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\config\\config.properties");
			prop.load(file);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	/*************************** Invoke browser ************************/
	/*
	 * invokeBrowser gets the browser name from the properties file and opens the
	 * browser accordingly
	 */
	public static void initBrowser() {
		try {
		 String browser = prop.getProperty("browserName");
		 if (browser.equalsIgnoreCase("chrome")) {
			 logger.log(Status.INFO, "Opening Chrome browser");
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browser.equalsIgnoreCase("mozilla")) {
				logger.log(Status.INFO, "Opening Mozilla firefox browser");
				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + "\\drivers\\geckodriver.exe");
				driver = new FirefoxDriver();
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Constants.IMPLICITLY_WAIT, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(Constants.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	}catch(Exception e) {
		reportFail(e.getMessage());
		e.printStackTrace();
	}
	}
	
	
	/*************************** Open website Url ************************/
	/*
	 * open URL method is used to pass the url value to the driver and the website
	 * is opened
	 */
	public static void initURL(String websiteURL) {
		try {
		driver.get(prop.getProperty(websiteURL));
		reportPass(websiteURL + "Identified successfully");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}
	
	
	/*************************** Close browser ************************/
	/*
	 * closing the browser window
	 */
	public static void tearDown() {
		logger.log(Status.INFO, "closing the browser window");
		driver.close();
	}
	
	
	/*************************** Quit browser ************************/
	/*
	 * completely quitting the browser
	 */
	public static void quitBrowser() {
		logger.log(Status.INFO, "Completely closing the entire browser");
		driver.quit();
	}
	
	
	/*************************** Enter text ************************/
	/*
	 * Entering the text into the element location
	 */
	public static void enterText(String locatorKey, String data) {
		try {
			getElement(locatorKey).sendKeys(data);
			reportPass(data + " - Entered successfully in locator element : " + locatorKey);
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}
	
	
	/*************************** Identify element ************************/
	/*
	 * The webelement is located using the get element method and the webelement are
	 * used for further operations
	 */
	public static WebElement getElement(String locatorKey) {
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
			}else {
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
	
	
	/*************************** Get text function ************************/
	/*
	 * Extracting the text from locator location and along with the message the text
	 * extracted is logged
	 */
	public static String getTextFromLocator(String locatorKey) {
		String text = "";
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getElement(locatorKey));
			text = getElement(locatorKey).getText();
		logger.log(Status.INFO, "Value got from the locator is : "+ text );
		reportPass(locatorKey + " - value from the locator is extracted successfully");
		}catch (Exception e) {
			reportFail(e.getMessage());
		}
		
			return text;
	}
	
	
	/*************************** Click functions  ************************/
	/*
	 * Clicking the enter button at the locatorkey location
	 */
	public static void elementClick(String locatorKey) {
		
			
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("arguments[0].click();", getElement(locatorKey));
//			getElement(locatorKey).click();
			reportPass(locatorKey + " - Element clicked successfully");
		
	}
	
	public static void clickElement(String locatorKey) {
		getElement(locatorKey).click();
		reportPass(locatorKey + " - Element clicked successfully");
	}
	
	
	/*************************** Get page title ************************/
	/*
	 * Getting the title of the current webpage
	 */
	public static String getPageTitle() {
		String title = driver.getTitle();
		reportPass(" Title of page is :" + title);
		return title;
	}
	
	
	/*************************** Select value from dropdown ************************/
	/*
	 * Selecting the value from dropdown menu
	 */
	public static void selectFromDropDown(String locatorKey, String data) {
		try {	
			logger.log(Status.INFO, data+" is selected using the locatorKey"+locatorKey);
		Select select = new Select(getElement(locatorKey));
			Thread.sleep(2000);
			select.selectByVisibleText(data);
			reportPass("The value selected from dropdown is: "+data);
		}
			catch (Exception e) {
				reportFail(e.getMessage());
			}
	}
	
	
	/*************************** Move to element ************************/
	/*
	 * Moving tothe element using Action class
	 */
	public static void moveToMenu(String locatorKey) {
		try {
		logger.log(Status.INFO, "cursor is moved to the locatorKey: "+locatorKey);
			WebElement element = getElement(locatorKey);
			Actions action = new Actions(driver);
			action.moveToElement(element).build().perform();
			reportPass("The cursor is moved to menu of locatorkey: "+locatorKey);
		}
		catch (Exception e) {
			reportFail(e.getMessage());
		}
		}
	
	
	/*************************** Identify the list of elements with findElements ************************/
	/*
	 * The list of webelements is located using the list of elements method which
	 * returns a list of the webelements with which further operations are proceeded
	 * 
	 */
	public static List<WebElement> listOfElements(String locatorKey) {
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
			}else {
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
	
	
	/*************************** Switching the iframe ************************/
	/*
	 * Switching the iframe using locatorkey
	 */
	public static void switchFrame(String locatorKey) {
		try {
			logger.log(Status.INFO, "switching to the iframe: "+locatorKey);
		driver.switchTo().frame(getElement(locatorKey));
		reportPass("Switched to the iframe with locator: "+locatorKey);
	}catch (Exception e) {
		reportFail(e.getMessage());
	}
	}
	
	public static void switchToDefaultFrame() {
		try {
			logger.log(Status.INFO, "switching to the default frame");
		driver.switchTo().defaultContent();
		reportPass("Switched to the default content");
		}catch (Exception e) {
			reportFail(e.getMessage());
		}
	}
	
	
	/*************************** Assertion Functions ************************/
	/*
	 * Assert functions compares according to the functions and logs the assertion
	 * output
	 */
	
	public static void checkTrue(String text) {
		if(text.contains("SPRT"))
			reportPass("Sprint retrospection is created");
		else
			reportFail("Sprint retrospection is not created");
	}
	
	public static void checkEquals(String actual, String expected) {
		try {
			logger.log(Status.INFO, "Assertion : Actual is -" + actual + " And Expected is - " + expected);
			if(actual.equalsIgnoreCase(expected))
				reportPass(actual+" is equal to "+expected);
			else
				reportFail(actual+" is not equal to "+expected);
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}
	
	
	/*************************** Read from excel File ************************/
	/*
	 * Reading testdata from a excel file
	 */
	public static String getValue(String testCaseId, String data) {
		String text ="";
		try {
	logger.log(Status.INFO, "Getting value from excel file");
	Map<String, String> mappedData = ExcelReader.getTestDataInMap("src\\main\\java\\testData\\mainProject.xlsx","Sheet1",testCaseId);
	 text = mappedData.get(data);
	reportPass("The value to be used in the function is extracted from the excel file");
	
	}catch (Exception e) {
		reportFail(e.getMessage());
	}
		return text;
	}
	
	/*************************** Reporting functions ************************/
	/*
	 * reporting functions creates a log on the report which is generated and takes
	 * screenshot if the report is failure along with log
	 */
	public static void reportFail(String reportString) {
		logger.log(Status.FAIL, reportString);
		takeScreenShotOnFailure();
//		Assert.fail(reportString);
	}

	public static void reportPass(String reportString) {
		logger.log(Status.PASS, reportString);
	}


	/*************************** Capture ScreenShots ************************/
	/*
	 * Takes screenshot and the screenshot is saved with the timestamp as the the
	 * name of the screenshot
	 */
	public static void takeScreenShotOnFailure() {
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
	
	
	

}
