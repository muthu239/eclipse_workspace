package HandleBrowserWindows.MultiWindowHandles;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;
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

public class BaseClass {
	
	public WebDriver driver;
	public Properties prop;
	public ExtentReports report = ExtentReportManager.getReportInstance();
	public ExtentTest logger;
	SoftAssert softAssert = new SoftAssert();
	
	
	/*************************** Invoke browser ************************/
	public void invokeBrowser(String browserNameKey) {
		
		if (prop == null) {
			prop = new Properties();
			try {
				FileInputStream file = new FileInputStream(System.getProperty("user.dir")
						+ "\\src\\test\\resorces\\objectRepository\\projectConfig.properties");
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
						System.getProperty("user.dir") + "\\src\\test\\resorces\\drivers\\chromedriver.exe");
				driver = new ChromeDriver();
			} else if (prop.getProperty(browserNameKey).equalsIgnoreCase("mozilla")) {
				logger.log(Status.INFO, "Opening Mozilla firefox browser");
				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + "\\src\\test\\resorces\\drivers\\geckodriver.exe");
				driver = new FirefoxDriver();
			}

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
		// System.out.println(System.getProperty("user.dir"));
		// System.getProperty("user.dir") gives the current working projects's file pat
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
			}else if(locatorKey.endsWith("_className")) {
				element = driver.findElement(By.className(prop.getProperty(locatorKey)));
				logger.log(Status.INFO, "Locator identified : " + locatorKey);
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

	
	/*************************** Reporting functions ************************/
	public void reportFail(String reportString) {
		logger.log(Status.FAIL, reportString);
		takeScreenShotOnFailure();
		Assert.fail(reportString);
	}

	public void reportPass(String reportString) {
		logger.log(Status.PASS, reportString);
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
	
	/****************** Handle windows **********************/
	
	public String getParentWindowHandle() {
		logger.log(Status.INFO, "Get the parent window handle");
		return driver.getWindowHandle();
	}
	
	public Set<String> getChildWindowHandles(){
		logger.log(Status.INFO, "Get the child window handles");
		return driver.getWindowHandles();
	}
	
	public int getNoChildWindow(Set<String> child) {
		logger.log(Status.INFO, "Get the number of child windows");
		return child.size();
		
	}
	
	public void switchWindow(String win) {
		logger.log(Status.INFO, "Switching the window with handle :"+win);
		driver.switchTo().window(win);
	}
	
	
	public String titleOfWindow() {
		logger.log(Status.INFO, "Get the title of the window");
		return driver.getTitle();
	}
	
	@AfterMethod
	public void afterTest() {
		softAssert.assertAll();
	}


}
