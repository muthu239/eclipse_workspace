package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import baseclass.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class StepDefinition extends BaseClass {
	
	
	@Given("^launch the browser$")
	public void launch_the_browser() {
		BaseClass.invokeBrowser();
	}

	@Given("^user login the site$")
	public void user_login_the_site() {
		BaseClass.openURL("websiteURL");
		try {
			Thread.sleep(80000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Then("^select project$")
	public void select_project() {
		BaseClass.moveToMenu("sideMenu_xpath");
		BaseClass.elementClick("projectMenu_xpath");
	   
	}
	
	@Then("^user clicks sprint retrospection under monitor menu$")
	public void user_clicks_sprint_retrospection_under_monitor_menu() {
		BaseClass.moveToMenu("monitorMenu_CSS");
		BaseClass.moveToMenu("sprintRetrospectionMenu_xpath");
		BaseClass.elementClick("sprintRetrospectionMenu_xpath");
		
	}
	
	@Then("^adding new sprint retrospection$")
	public void adding_new_sprint_retrospection() {
		BaseClass.elementClick("addBtn_CSS");
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='contentframe']")));
		BaseClass.selectFromDropDown("sprintDropDown_name", "newSprint385");
		BaseClass.enterText("whatWentRight_CSS","abcd");
		BaseClass.enterText("whatWentWrong_CSS", "efgh");
		BaseClass.enterText("lessonsLearnt_CSS", "ijkl");
		BaseClass.elementClick("saveAndAddNewBtn_CSS");
	
		WebDriverWait wait=new WebDriverWait(driver, 20);
		WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#CancelBtn")));
		ele.click();
		driver.switchTo().defaultContent();
		
	}

	@Then("^checking the created sprint retrospection$")
	public void checking_the_created_sprint_retrospection() {
		BaseClass.listOfElements("sprintList_xpath").get(0).click();
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='contentframe']")));
		BaseClass.getTextFromLocator("itemCode_CSS");
		BaseClass.getTextFromLocator("whatWentRight_CSS");
		BaseClass.getTextFromLocator("whatWentWrong_CSS");
		BaseClass.getTextFromLocator("lessonsLearnt_CSS");
	  
	}
	
	@Then("^close the browser$")
	public void close_the_browser() {
		BaseClass.tearDown();   
	}
	



	
	

}
