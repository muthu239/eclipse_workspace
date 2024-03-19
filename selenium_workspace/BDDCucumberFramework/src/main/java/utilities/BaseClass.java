package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
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
import org.testng.annotations.AfterMethod;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utilities.DateUtils;
import utilities.ExtentReportManager;

public class BaseClass {
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
						+ "objectRepository\\projectConfig.properties");
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
						System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
				driver = new ChromeDriver();
			} else if (prop.getProperty(browserNameKey).equalsIgnoreCase("mozilla")) {
				logger.log(Status.INFO, "Opening Mozilla firefox browser");
				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + "\\drivers\\geckodriver.exe");
				driver = new FirefoxDriver();
			}
			driver.manage().window().maximize();
			implicitWait();
		} catch (Exception e) {
			reportFail(e.getMessage());
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
			getElement(locatorKey).sendKeys(data);
			reportPass(data + " - Entered successfully in locator element : " + locatorKey);
		} catch (Exception e) {
			reportFail(e.getMessage());
		}

	}
	
	/*************************** Moving to menu ************************/
	/*
	 * Entering the text into the element location
	 */
	public void moveToMenu(String locatorKey) {
		try {
			WebElement element = getElement(locatorKey);
			Actions action = new Actions(driver);
			action.moveToElement(element).build().perform();
			reportPass("Move to the menu using the locatorKey : " + locatorKey);
		} catch (Exception e) {
			reportFail(e.getMessage());
		}

	}
	
	/*************************** Select from dropdown ************************/
	/*
	 * Entering the text into the element location
	 */
	public void selectFromDropDown(String locatorKey, String data) {
		try {
			Select select = new Select(getElement(locatorKey));
			select.selectByVisibleText(data);
			reportPass("The item selected from the dropdown is " + locatorKey);
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
	
	/*************************** Click an element ************************/
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
	
	/*************************** Get text function ************************/
	/*
	 * Extracting the text from locator location and along with the message the text
	 * extracted is logged
	 */
	public void getTextFromLocator(String locatorKey) {
		try {
			System.out.println(getElement(locatorKey).getText());
			logger.log(Status.INFO, "Value from the locator is identified and it is printed in console as : "
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
	
	@AfterMethod
	public void afterTest() {
		softAssert.assertAll();
	}


}
