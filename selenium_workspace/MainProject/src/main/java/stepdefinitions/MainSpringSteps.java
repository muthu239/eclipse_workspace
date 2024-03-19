package stepdefinitions;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

import base.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


public class MainSpringSteps extends BaseTest {
	
	@Given("user is logged in the website and user navigates into project")
	public void user_is_logged_in_the_website_and_user_navigates_into_project() {
		
		logger = report.createTest("Navigate to sprint retrospection");
		BaseTest.initBrowser();
		BaseTest.initURL("websiteURL");

		try {
			Thread.sleep(70000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		BaseTest.moveToMenu("sideMenu_xpath");

		BaseTest.elementClick("projectMenu_xpath");
	    
	}
	
	@Then("user navigates to the sprint retrospection menu")
	public void user_navigates_to_the_sprint_retrospection_menu() {
		
		BaseTest.elementClick("monitorMenu_CSS");
		 BaseTest.elementClick("sprintRetrospectionMenu_xpath");

	}
	
	@Then("user adds new sprint retrospection taking data from excel sheet from row {string}")
	public void user_adds_new_sprint_retrospection_taking_data_from_excel_sheet_from_row(String testCaseId) {
		
		
			WebDriverWait wait=new WebDriverWait(driver, 30);
			 try {
			 wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(prop.getProperty("addBtn_CSS")))); 
				 
				 BaseTest.elementClick("addBtn_CSS");
			 }catch(Exception e) {
				 driver.navigate().refresh();
				 user_navigates_to_the_sprint_retrospection_menu();
				 BaseTest.elementClick("addBtn_CSS");
			 }
	
		BaseTest.switchFrame("iframe_xpath");
		BaseTest.selectFromDropDown("sprintDropDown_CSS", BaseTest.getValue(testCaseId, "sprint"));
		

		try {
			BaseTest.enterText("whatWentRight_CSS",BaseTest.getValue(testCaseId, "right"));
			BaseTest.enterText("whatWentWrong_CSS",BaseTest.getValue(testCaseId, "wrong"));
			BaseTest.enterText("lessonsLearnt_CSS",BaseTest.getValue(testCaseId, "lessons"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		BaseTest.elementClick("saveAndAddNewBtn_CSS");
	    
	}
	
	@Then("user verifies the entered data comparing with data from excel sheet from row {string}")
	public void user_verifies_the_entered_data_comparing_with_data_from_excel_sheet_from_row(String testCaseId) {
		WebDriverWait wait=new WebDriverWait(driver, 10);
		try {
	
			wait.until(ExpectedConditions.alertIsPresent()); 
			Alert alt = driver.switchTo().alert();
			String text = alt.getText();
			System.out.println(text);
			logger.log(Status.INFO,	text );
			alt.accept();
//			}
//			else {
		
}catch(Exception e) {

			BaseTest.clickElement("returnBtn_CSS");
			
//			driver.switchTo().defaultContent();
			BaseTest.switchToDefaultFrame();
			
			listOfElements("sprintList_xpath").get(0).click();
			
			 wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath(prop.getProperty("iframe_xpath"))));
			
			 BaseTest.checkTrue(BaseTest.getTextFromLocator("itemCode_CSS"));
			 BaseTest.checkEquals(BaseTest.getValue(testCaseId, "right"), BaseTest.getTextFromLocator("whatWentRight_CSS"));
			 BaseTest.checkEquals(BaseTest.getValue(testCaseId, "wrong"), BaseTest.getTextFromLocator("whatWentWrong_CSS"));
			 BaseTest.checkEquals(BaseTest.getValue(testCaseId, "lessons"), BaseTest.getTextFromLocator("lessonsLearnt_CSS"));
			
		
			 System.out.println(BaseTest.getTextFromLocator("itemCode_CSS"));
			 System.out.println(BaseTest.getTextFromLocator("whatWentRight_CSS"));
			 System.out.println(BaseTest.getTextFromLocator("whatWentWrong_CSS"));
			 System.out.println(BaseTest.getTextFromLocator("lessonsLearnt_CSS"));
		}
	}
	
	@Then("close the browser")
	public void close_the_browser() {
		report.flush();
		BaseTest.tearDown();
	}
	
	
}
