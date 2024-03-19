package StepDefinitions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends BaseClass  {
	
	WebDriver driver = null;
	@Given("^user enters login details$")
	public void user_enters_login_details() {
		
		System.setProperty("webdriver.chrome.driver", "E:\\eclipse_workspace\\BDDCucumberFramework\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://pratesting.cognizant.com/");
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		driver.manage().window().maximize();
//
//		invokeBrowser("browserName");
//		openURL("websiteURL");
		try {
		Thread.sleep(80000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}
	
	@Then("^user goes for project location$")
	public void user_goes_for_project_location() {
		WebElement sideMenu = driver.findElement(By.xpath("//div[@class = 'left_menu_icon_overlay']/span"));
		Actions action = new Actions(driver);
		action.moveToElement(sideMenu).build().perform();
//		moveToMenu("sideMenu_xpath");
		WebElement projectMenu = driver.findElement(By.xpath("//ul[@class='left_menu_items']//a[contains(text(),'CFO_Onsite')]"));
		projectMenu.click();
//		elementClick("projectMenu_xpath");
	}
	
	@When("^check for page title$")
	public void check_for_page_title() {
//		System.out.println(getPageTitle());
	  
	}
	
	@Then("^user clicks sprint retrospection under monitor menu$")
	public void user_clicks_sprint_retrospection_under_monitor_menu() {
		
		WebElement monitorMenu = driver.findElement(By.cssSelector("#LOCK_Monitor"));
		Actions action = new Actions(driver);
		action.moveToElement(monitorMenu).build().perform();
//		moveToMenu("monitorMenu_CSS");
		//LOCK_Sprint Retrospection
		WebElement sprintRetrospectionMenu = driver.findElement(By.xpath("//a[@id='LOCK_Sprint Retrospection']"));
		//action.moveToElement(sprintRetrospectionMenu).build().perform();
		sprintRetrospectionMenu.click();
//		elementClick("sprintRetrospectionMenu_xpath");
	   
	}
	
	@Then("^Adding new sprint retrospection$")
	public void adding_new_sprint_retrospection() {
		
		driver.findElement(By.cssSelector("#KEY_BUTTON_Add-btnIconEl")).click();
//		elementClick("addBtn_CSS");
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='contentframe']")));
		
		WebElement sprintDropDown = driver.findElement(By.name("DN_Sprint"));
		Select select = new Select(sprintDropDown);
		select.selectByVisibleText("newSprint385");
//		selectFromDropDown("sprintDropDown_name", "newSprint385");
		
		driver.findElement(By.cssSelector("#DN_WhatwentRight")).sendKeys("abcd");
		driver.findElement(By.cssSelector("#DN_WhatwentWrong")).sendKeys("efgh");
		driver.findElement(By.cssSelector("#DN_Lessonslearnt")).sendKeys("ijkl");
//		enterText("whatWentRight_CSS","abcd");
//		enterText("whatWentWrong_CSS", "efgh");
//		enterText("lessonsLearnt_CSS", "ijkl");
		
		driver.findElement(By.cssSelector("#SaveAddNewBtn")).click();
//		elementClick("saveAndAddNewBtn_CSS");
		
		WebDriverWait wait=new WebDriverWait(driver, 20);
		WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#CancelBtn")));
		ele.click();
		driver.switchTo().defaultContent();
	}
	
	@Then("^checking the created sprint retrospection$")
	public void checking_the_created_sprint_retrospection() {
		List<WebElement> element = driver.findElements(By.xpath("//div[contains(text(),'SPRT')]"));
		
		element.get(0).click();
//		listOfElements("sprintList_xpath").get(0).click();
	
		
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='contentframe']")));
		
		System.out.println(driver.findElement(By.cssSelector("#CM_ItemCode")).getText());
		System.out.println(driver.findElement(By.cssSelector("#DN_WhatwentRight")).getText());
		System.out.println(driver.findElement(By.cssSelector("#DN_WhatwentWrong")).getText());
		System.out.println(driver.findElement(By.cssSelector("#DN_Lessonslearnt")).getText());
//		getTextFromLocator("itemCode_CSS");
//		getTextFromLocator("whatWentRight_CSS");
//		getTextFromLocator("whatWentWrong_CSS");
//		getTextFromLocator("lessonsLearnt_CSS");
	}


	@Then("^close the browser$")
	public void close_the_browser() {
		driver.close();
	   
	}
	
}
