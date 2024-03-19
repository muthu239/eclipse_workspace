package com.insurance.test;

import java.util.Hashtable;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.insurance.main.BaseClass;
import com.insurance.utils.DataProviderTest;

public class TravelInsurance_test extends BaseClass {

	@Test(priority = 0)
	public void openurl() throws NullPointerException {
		logger = report.createTest("POLICY BAZAAR : ");
		getProperties();
		invokeBrowser("browser");

		openBrowser("Url");
		waitForPageLoad();

	}

	/***********************************
	 * Travel Insurance
	 ********************************************/
	@Test(dataProvider = "getDataTravelInsurance", priority = 1)
	public void testone(Hashtable<String, String> testdata) {

		logger = report.createTest("POLICY BAZAAR - TRAVEL INSURANCE test case : " + testdata.get("Comment"));
		moveToElement("insuranceproductsbtn_Xpath");
		navigate("url1");
		waitForPageLoad();

		elementClick("student_Xpath");

		autoSuggestElement("destnation_Id", testdata.get("Country"));

		enterText("age1_Id", testdata.get("Age1"));
		enterText("age2_Id", testdata.get("Age2"));

		elementClick("startDate_Name");

		selectDateFromCalendar(testdata.get("StartDate"), "date_Xpath", "year_Xpath", "month_Xpath");
		waitForPageLoad();
		elementClick("endDate_Name");
		selectDateFromCalendar(testdata.get("EndDate"), "date1_Xpath", "year1_Xpath", "month1_Xpath");

		elementClick("proceed_Id");
		waitForPageLoad();

		String name = testdata.get("Full Name");
		String prefix = name.substring(0, 3);// To select name prefix
		String travelername = name.substring(3);// To enter traveller name

		selectValue("gender_Name", prefix);
		enterText("fullname_Name", travelername);

		selectValue("code_Id", "INDIA (+91)");
		enterText("mobnum_Id", testdata.get("Mobile number"));
		enterText("emailbox_Id", testdata.get("Email Id"));
		elementClick("getfreequotesbtn_Xpath");
		waitForPageLoad();

		elementClick("sumbtn_Xpath");
		elementClick("smallvalue_Xpath");
		elementClick("applybtn_Xpath");

		selectValue("sortby_Xpath", "Price: Low to High");

		getThreeLowTravelPlans("companyname_Xpath", "cost_Xpath");
		navigate("Url");
		waitForPageLoad();

	}

	/*************************************************
	 * Car insurance
	 ***********************************************************/

	@Test(dataProvider = "getDataCarInsurance", priority = 2)
	public void testtwo(Hashtable<String, String> testdata) {

		logger = report.createTest("POLICY BAZAAR - CAR INSURANCE test case  : " + testdata.get("Comment"));

		moveToElement("InsuranceProducts_Xpath");
		moveToElement("carInsurance_Xpath");
		elementClick("carInsurance_Xpath");
		waitForPageLoad();

		elementClick("withoutCarNumber_Xpath");
		waitForPageLoad();

		autoSuggestElementClick1("citySearch_Xpath", testdata.get("RTO & City Name"));
		waitForPageLoad();

		autoSuggestElementClick1("carBrand_Xpath", testdata.get("Car Name"));
		waitForPageLoad();

		elementClick("petrol_Id");

		autoSuggestElementClick1("variant_Xpath", testdata.get("Model Variant"));
		waitForPageLoad();

		elementClick("carYear_Xpath");

		enterText("name_Id", testdata.get("Name"));
		enterText("email_Id", testdata.get("Email"));

		enterText("phoneNumber_Id", testdata.get("PhoneNumber"));

		elementClick("viewPrice_Id");

		getErrorMessage("error_Xpath");

		navigate("Url");

	}

	/**************************************
	 * health insurance
	 ***************************************************/
	@Test(priority = 3)
	public void testthree() {

		logger = report.createTest("POLICY BAZAAR -  HEALTH INSURANCE Test Case  : ");

		moveToElement("insuranceproductsbtn_Xpath");
		System.out.println("Moved to Insurance_Products");

		List<WebElement> elements = getElements("healthInsuranceList_Xpath");
		int i = 1;
		for (WebElement webElement : elements) {

			reportPass(i + " : " + webElement.getText());
			i++;
		}

	}

	@AfterSuite
	public void endReport() {
		report.flush();
		closeBrowser();
	}

	@DataProvider
	public Object[][] getDataTravelInsurance() {
		return DataProviderTest.getTestData("TEST INPUTS", "Input", "Travel Insurance test");
	}

	@DataProvider
	public Object[][] getDataCarInsurance() {
		return DataProviderTest.getTestData("TEST INPUTS", "Input", "Car Insurance Test");
	}

}
