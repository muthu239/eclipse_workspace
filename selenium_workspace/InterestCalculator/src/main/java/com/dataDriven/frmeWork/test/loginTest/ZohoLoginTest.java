package com.dataDriven.frmeWork.test.loginTest;

import java.util.Hashtable;

import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.dataDriven.frameWork.base.BaseUI;
import com.dataDriven.frameWork.utils.TestDataProvider;

public class ZohoLoginTest extends BaseUI {

	@Test(dataProvider = "getDatadoZohoLoginTest")
	public void doZohoLoginTest(Hashtable<String, String> dataTable) {

		logger = report.createTest("Zoho Login Test Case : " + dataTable.get("Comment"));
		invokeBrowser("browserName");
		openURL("websiteURL");
		elementClick("carLoan_linkText");
		enterText("loanAmountTextbox_id", dataTable.get("loanAmount"));
		enterText("interestRateTextbox_id", dataTable.get("interestRate"));
		elementClick("yearBtn_xpath");
		enterText("loanTenureTextbox_id", dataTable.get("tenure"));
		clickEnter("loanTenureTextbox_id");
		
		waitForPageLoad();
		
//		enterText("zhPasswordTB_id", dataTable.get("Password"));
//		elementClick("zhSignBtn_id");
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		waitForPageLoad();
//
//		verifyPageTitle(dataTable.get("PageTitle"));

	}

	@DataProvider
	public Object[][] getDatadoZohoLoginTest() {
		return TestDataProvider.getTestData("loanEntries.xlsx", "Sheet1", "carLoanWithYear");
	}

	@AfterTest
	public void endReport() {
		report.flush();
	}

}
