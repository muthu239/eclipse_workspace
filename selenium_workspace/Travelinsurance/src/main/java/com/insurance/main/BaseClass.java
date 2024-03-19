package com.insurance.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.insurance.utils.DateUtils;
import com.insurance.utils.ExtentReportManager;

public class BaseClass {
	public static RemoteWebDriver driver;
	public static Properties prop;
	public ExtentReports report = ExtentReportManager.getReportInstance();
	public static ExtentTest logger;
	public List<WebElement> planname;
	public List<WebElement> plancost;

	// getting properties file
	public void getProperties() {
		if (prop == null) {
			prop = new Properties();
			try {
				FileInputStream file = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\resources\\ObjectRepository\\config.properties");
				prop.load(file);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// invoke browser
	public void invokeBrowser(String browserkey) {
		try {
			if (prop.getProperty(browserkey).equalsIgnoreCase("Chrome")) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\src\\test\\resources\\Drivers\\chromedriver.exe");
				driver = new ChromeDriver();
				logger.log(Status.INFO, "Browser Found : Chrome");
			} else if (prop.getProperty(browserkey).equalsIgnoreCase("Firefox")) {
				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + "\\src\\test\\resources\\Drivers\\geckodriver.exe");
				driver = new FirefoxDriver();
				logger.log(Status.INFO, "Browser Found : Firefox");
			} else {
				System.out.println("\nEnter valid browser name");
			}
		} catch (Exception e) {
			reportFail(e.getMessage());
			e.printStackTrace();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	// opening the url
	public void openBrowser(String urlkey) {
		try {
			driver.get(prop.getProperty(urlkey));
			logger.log(Status.INFO, "Url openned : policybazaar.com");
		} catch (Exception e) {
			reportFail(e.getMessage());
			e.printStackTrace();
		}
	}

	// close browser
	public void closeBrowser() {
		driver.close();
	}

	// quit browser
	public void quitBrowser() {
		driver.quit();
	}

	// Element
	public static WebElement getElement(String locatorkey) {
		WebElement element = null;

		try {
			if (locatorkey.endsWith("_Xpath")) {
				element = driver.findElement(By.xpath(prop.getProperty(locatorkey)));
				logger.log(Status.INFO, "Locator Found : " + locatorkey);
			} else if (locatorkey.endsWith("_Id")) {
				element = driver.findElement(By.id(prop.getProperty(locatorkey)));
				logger.log(Status.INFO, "Locator Found : " + locatorkey);
			} else if (locatorkey.endsWith("_Name")) {
				element = driver.findElement(By.name(prop.getProperty(locatorkey)));
				logger.log(Status.INFO, "Locator Found : " + locatorkey);
			} else if (locatorkey.endsWith("_CSS")) {
				element = driver.findElement(By.cssSelector(prop.getProperty(locatorkey)));
				logger.log(Status.INFO, "Locator Found : " + locatorkey);
			} else if (locatorkey.endsWith("_Linktext")) {
				element = driver.findElement(By.linkText(prop.getProperty(locatorkey)));
				logger.log(Status.INFO, "Locator Found : " + locatorkey);
			} else if (locatorkey.endsWith("_Partiallinktext")) {
				element = driver.findElement(By.partialLinkText(prop.getProperty(locatorkey)));
				logger.log(Status.INFO, "Locator Found : " + locatorkey);
			} else {
				reportFail("\nFailing the testcase, Invalid locator :" + locatorkey);
				Assert.fail("Failing the testcase, Invalid locator :" + locatorkey);
			}
		} catch (Exception e) {
			reportFail(e.getMessage());
			e.printStackTrace();
			Assert.fail("failing the testcase : " + e.getMessage());

		}
		return element;

	}

	// list of elements
	public List<WebElement> getElements(String locatorkey) {
		List<WebElement> list = null;
		try {
			if (locatorkey.endsWith("_Xpath")) {
				list = driver.findElements(By.xpath(prop.getProperty(locatorkey)));
				logger.log(Status.INFO, "Locator Found : " + locatorkey);
			} else if (locatorkey.endsWith("_Id")) {
				list = driver.findElements(By.id(prop.getProperty(locatorkey)));
				logger.log(Status.INFO, "Locator Found : " + locatorkey);
			} else if (locatorkey.endsWith("_Name")) {
				list = driver.findElements(By.name(prop.getProperty(locatorkey)));
				logger.log(Status.INFO, "Locator Found : " + locatorkey);
			} else if (locatorkey.endsWith("_CSS")) {
				list = driver.findElements(By.cssSelector(prop.getProperty(locatorkey)));
				logger.log(Status.INFO, "Locator Found : " + locatorkey);
			} else if (locatorkey.endsWith("_Linktext")) {
				list = driver.findElements(By.linkText(prop.getProperty(locatorkey)));
				logger.log(Status.INFO, "Locator Found : " + locatorkey);
			} else if (locatorkey.endsWith("_Partiallinktext")) {
				list = driver.findElements(By.partialLinkText(prop.getProperty(locatorkey)));
				logger.log(Status.INFO, "Locator Found : " + locatorkey);
			} else {
				reportFail("\nFailing the testcase, Invalid locator :" + locatorkey);
				Assert.fail("Failing the testcase, Invalid locator :" + locatorkey);
			}
		} catch (Exception e) {
			reportFail(e.getMessage());
			e.printStackTrace();
			Assert.fail("Failing the testcase : " + e.getMessage());

		}
		return list;

	}

	// click
	public void elementClick(String xpathkey) {
		try {
			getElement(xpathkey).click();
			Thread.sleep(1000);
		} catch (Exception e) {
			reportFail("Element is unable to click" + e.getMessage());
			e.printStackTrace();
		}
	}

	// auto suggest Element click
	public void autoSuggestElement(String xpathkey, String value) {
		try {
			Thread.sleep(700);
			WebElement ele = getElement(xpathkey);
			ele.sendKeys(Keys.CONTROL + "a");
			ele.sendKeys(Keys.DELETE);
			Thread.sleep(300);
			ele.sendKeys(value);
			ele.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
			Thread.sleep(700);
		} catch (Exception e) {
			reportFail("Element is unable to click" + e.getMessage());
			e.printStackTrace();
		}
	}

	// * Auto Suggest Elements Click
	public void autoSuggestElementClick1(String xpathkey, String data) {
		try {

			Thread.sleep(2000);
			// To delete previous values
			getElement(xpathkey).sendKeys(Keys.CONTROL + "a");
			getElement(xpathkey).sendKeys(Keys.DELETE);
			Thread.sleep(1000);

			// sending the RTOValue by using excel
			enterText(xpathkey, data);
			Thread.sleep(2000);
			getElement(xpathkey).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);

		} catch (Exception e) {
			reportFail("Unable to select");

		}

	}

	// entertext
	public void enterText(String xpathKey, String data) {
		try {
			WebElement text = getElement(xpathKey);
			text.sendKeys(Keys.CONTROL + "a");
			text.sendKeys(Keys.DELETE);
			text.sendKeys(data);
			Thread.sleep(1000);
		} catch (Exception e) {
			reportFail(data + " not entered successfully" + e.getMessage());
			e.printStackTrace();
		}
	}

	// Mouse action to click an element
	public void moveToElement(String elementPath) {
		try {
			Actions action = new Actions(driver);
			action.moveToElement(getElement(elementPath)).perform();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// navigate to another url
	public void navigate(String url1key) {
		try {
			driver.get(prop.getProperty(url1key));

		} catch (Exception e) {
			reportFail(e.getMessage());
			e.printStackTrace();
		}
	}

	// selecting value by visible text
	public void selectValue(String xpathkey, String value) {
		try {
			Select select = new Select(getElement(xpathkey));
			select.selectByVisibleText(value);
			Thread.sleep(2000);

		} catch (Exception e) {
			reportFail("Element is unable to select" + e.getMessage());
			e.printStackTrace();
		}
	}

	// selecting date from calendar
	public void selectDateFromCalendar(String date, String days, String yearkey, String monthkey) {
		try {

			int month = Integer.parseInt(date.substring(3, 5));

			String year = date.substring(6, 10);

			Select month1 = new Select(getElement(monthkey));
			month1.selectByIndex(month - 1);

			Select year1 = new Select(getElement(yearkey));
			year1.selectByVisibleText(year);
			Thread.sleep(1000);
			int day1 = Integer.parseInt(date.substring(0, 2));
			String day;
			if (day1 > 9) {
				day = date.substring(0, 2);
			} else {
				day = date.substring(1, 2);
			}
			/* To scroll down the web page */
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,100)");

			List<WebElement> daysList = getElements(days);
			Actions action = new Actions(driver);
			for (WebElement webElement : daysList) {
				if (webElement.getText().equals(day)) {
					action.moveToElement(webElement).perform();
					webElement.click();
					break;
				}
			}

		} catch (Exception e) {
			reportFail("The date is not selected");
			e.printStackTrace();
		}

	}

	// get error message
	public void getErrorMessage(String Error_locators) {
		try {
			List<WebElement> list = getElements(Error_locators);
			int size = list.size();
			int count = 0;
			for (WebElement webElement : list) {
				if (webElement.isDisplayed())
					count++;
			}
			if (size == 0)
				reportPass("\nNo Error");
			else if (size == count) {
				for (int i = 0; i < list.size(); i++) {
					reportPass(list.get(i).getText());
				}
				takeScreenShotOnFailure();
			}

		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}

	// page load wait
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
			e.printStackTrace();
		}
	}

	// reprot fail function
	public static void reportFail(String reportmessage) {
		logger.log(Status.FAIL, reportmessage);
		takeScreenShotOnFailure();
		// Assert.fail(reportmessage);

	}

	// report pass function
	public static void reportPass(String reportmessage) {
		logger.log(Status.PASS, reportmessage);
		System.out.println(reportmessage);

	}

	// screenshot when testcase failed
	public static void takeScreenShotOnFailure() {
		TakesScreenshot takescreenshot = (TakesScreenshot) driver;
		File sourceFile = takescreenshot.getScreenshotAs(OutputType.FILE);
		File destFile = new File(
				System.getProperty("user.dir") + "\\Screenshots\\" + DateUtils.getTimeStamp() + ".png");
		try {
			FileUtils.copyFile(sourceFile, destFile);
			logger.addScreenCaptureFromPath(System.getProperty("user.dir") + "\\Screenshots\\" + ".png");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// method to display three lowest international travel insurance
	public void getThreeLowTravelPlans(String planname, String plancost) {
		try {

			Iterator<WebElement> itr1 = getElements(planname).iterator();
			Iterator<WebElement> itr2 = getElements(plancost).iterator();

			System.out.println("\nThe three lowest international  travel insurance plan are listed below");
			for (int i = 0; i < 3; i++) {
				String logoname = itr1.next().getAttribute("class");
				String[] companyname = logoname.split("\\s+");
				String name = companyname[1];
				String costvalue = itr2.next().getText();
				String[] costarray = costvalue.split("\\s+");
				String cost = costarray[1];

				reportPass("\n" + (i + 1) + ":" + " Insurance Provider Company Name : " + "\"" + name.toUpperCase()
						+ "\"" + " \nAmount is : " + "\"" + cost + "\"");
			}

		} catch (Exception e) {
			reportFail("Failed to Retrieve the Travel Plan Quotes");
		}

	}

}
