package com.dataDriven.frameWork.base;

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
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.dataDriven.frameWork.utils.DateUtils;
import com.dataDriven.frameWork.utils.ExtentReportManager;

public class BaseUI {

	public WebDriver driver;
	public Properties prop;
	public ExtentReports report = ExtentReportManager.getReportInstance();  //this will initialize the report
	public ExtentTest logger; //logger will help in adding the steps to report
	SoftAssert softAssert = new SoftAssert();

	/*************************** Invoke browser ************************/
	public void invokeBrowser(String browserName) {

		try {
			if (browserName.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browserName.equalsIgnoreCase("mozilla")) {
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
		// System.out.println(System.getProperty("user.dir"));
		// System.getProperty("user.dir") gives the current working projects's file path

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

	}

	/*************************** Open website Url ************************/
	public void openURL(String websiteURLKey) {
		try {
			driver.get(prop.getProperty(websiteURLKey));
			reportPass(websiteURLKey + "Identified successfully");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}

	}

	/*************************** Close browser ************************/
	public void tearDown() {
		driver.close();
	}

	/*************************** Quit browser ************************/
	public void quitBrowser() {
		driver.quit();
	}

	/*************************** Enter text ************************/
	public void enterText(String locatorKey, String data) {
		try {
			getElement(locatorKey).sendKeys(data);
			reportPass(data + " - Entered successfully in locator element : " + locatorKey);
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
		// instead of driver.findElement we are centralising it
		// driver.findElement(By.xpath(prop.getProperty(xpathKey))).sendKeys(data);
	}

	/*************************** click an element ************************/
	public void elementClick(String locatorKey) {
		try {
			getElement(locatorKey).click();
			reportPass(locatorKey + " - Element clicked successfully");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
		// driver.findElement(By.xpath(prop.getProperty(xpathKey))).click();
	}

	/*************************** Identify element ************************/
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

	/*************************** Verify Element ************************/
	public boolean isElementPresent(String locatorKey) {
		try {
			if (getElement(locatorKey).isDisplayed()) {
				reportPass(locatorKey + " - Element is displayed");
				return true;
			}
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
		return false;
	}

	public boolean isElementSelected(String locatorKey) {
		try {
			if (getElement(locatorKey).isSelected()) {
				reportPass(locatorKey + " - Element is Selected");
				return true;
			}
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
		return false;
	}

	public boolean isElementEnabled(String locatorKey) {
		try {
			if (getElement(locatorKey).isEnabled()) {
				reportPass(locatorKey + " - Element is enabled");
				return true;
			}
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
		return false;
	}

	public void verifyPageTitle(String pageTitle) {
		try {
			String actualTite = driver.getTitle();
			logger.log(Status.INFO, "Actual Title is : " + actualTite);
			logger.log(Status.INFO, "Expected Title is : " + pageTitle);
			Assert.assertEquals(actualTite, pageTitle);
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}

	/****************** Select List Drop Down ******************/
	public void SelectElementInList(String locatorXpath, String Value) {
		try {
			List<WebElement> listElement = driver.findElements(By.xpath(locatorXpath));
			for (WebElement listItem : listElement) {
				String prefix = listItem.getText();
				// System.out.println(prefix);
				if (prefix.contains(Value)) {
					// System.out.println("Inside if statenment");
					waitForPageLoad();
					listItem.click();
				}
			}
			logger.log(Status.INFO, "Selected the Defined Value : " + Value);
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}

	/****************** Handle Frames **********************/
	public void switchToFrame(String frameLocator) {
		try {
			logger.log(Status.INFO, "Switching Frame : " + frameLocator);
			driver.switchTo().frame(frameLocator);
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}

	public void switchToFrameByIndex(int frameNumner) {
		try {
			logger.log(Status.INFO, "Switching Frame : " + frameNumner);
			driver.switchTo().frame(frameNumner);
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}

	public void switchToDefaultFrame() {
		try {
			logger.log(Status.INFO, "Switching to Main Windpw");
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}

	/*************************** Reporting functions ************************/
	public void reportFail(String reportString) {
		logger.log(Status.FAIL, reportString);
		takeScreenShotOnFailure();
		Assert.fail(reportString);
	}

	public void reportPass(String reportString) {
		logger.log(Status.PASS, reportString);
	}

	/*************************** Capture ScreenShots ************************/
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
	public void assertTrue(boolean flag) {
		softAssert.assertTrue(flag);
	}

	public void assertFalse(boolean flag) {
		softAssert.assertFalse(flag);
	}

	public void assertequals(String actual, String expected) {
		try {
			logger.log(Status.INFO, "Assertion : Actual is -" + actual + " And Expacted is - " + expected);
			softAssert.assertEquals(actual, expected);
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}

	/***************** Wait Functions in Framework *****************/
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

	/**************** Core Application Functions ******************/
	public void doLogin() {
		logger.log(Status.INFO, "Logging the Application");
		invokeBrowser("chrome");
		openURL("websiteURL");
		elementClick("zohoLoginTextBox_className");
		enterText("zohoUserNameTextBox_id", "anshulc55@gmail.com");
		enterText("zhPasswordTB_id", "Test@12345");
		elementClick("zhSignBtn_id");
		waitForPageLoad();
		verifyPageTitle("Zoho Home");
	}

	@AfterMethod
	public void afterTest() {
		softAssert.assertAll();
	}

}
