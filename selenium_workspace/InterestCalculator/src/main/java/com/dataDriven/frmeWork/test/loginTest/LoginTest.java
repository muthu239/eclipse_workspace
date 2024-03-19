package com.dataDriven.frmeWork.test.loginTest;

import java.util.Hashtable;

import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.dataDriven.frameWork.base.BaseUI;
import com.dataDriven.frameWork.utils.TestDataProvider;


public class LoginTest extends BaseUI {
	
	
	@Test(dataProvider = "getTestOneData")
	public void testOne(Hashtable<String, String> dataTable) {
		
		logger = report.createTest("Test One");
		
		invokeBrowser("chrome");
		openURL("websiteURL");
		elementClick("signinBtn_xpath");
		enterText("usernameTextbox_id",dataTable.get("Col1") );
		enterText("passwordTextbox_xpath", dataTable.get("Col3") );
		//tearDown();
		
	}
	
	//After test is necessary to generate a report
	@AfterTest
	public void endReport() {
		report.flush();
	}
	
	@DataProvider
	public Object[][] getTestOneData(){
		return TestDataProvider.getTestData("TestData_Testmanagement.xlsx", "Feature 1", "Test Three");
	}
	
	
	
	//@Test(dependsOnMethods = "testOne")
	public void testTwo() {
		invokeBrowser("chrome");
		openURL("websiteURL");
		elementClick("signinBtn_xpath");
		enterText("usernameTextbox_xpath", "muthu23");
		tearDown();
	}

	
	//@Test(dependsOnMethods = "testTwo")
	public void testThree() {
		invokeBrowser("chrome");
		openURL("websiteURL");
		elementClick("signinBtn_xpath");
		enterText("usernameTextbox_xpath", "muthu23");
		tearDown();
	}

}
