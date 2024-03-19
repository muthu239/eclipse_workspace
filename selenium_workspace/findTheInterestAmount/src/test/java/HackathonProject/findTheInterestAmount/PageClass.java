package HackathonProject.findTheInterestAmount;

import java.util.Hashtable;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utilities.TestDataProvider;

public class PageClass extends BaseUI {

	/*
	 * The below Method calculateCarLoan will be the first test to proceed as it's
	 * priority is set to zero
	 */

	@Test(dataProvider = "calculateCarLoan", priority = 0,groups = {"Smoke","Regression"})
	public void calculateCarLoan(Hashtable<String, String> dataTable) {

		logger = report.createTest("Finding the principal amount & Interest amount of first month");
		/*
		 * The browser is invoked and the URL to the website is clicked and the car Loan
		 * button is clicked to load car loan page In the projectConfig.properties file
		 * the browser and the url can be changed if needed
		 */
		invokeBrowser("browserName");
		openURL("websiteURL");
		elementClick("carLoan_linkText");

		implicitWait();

		/*
		 * The textboxes on the car loan page are filled with the enterText method
		 */
		enterText("loanAmountTextbox_id", dataTable.get("loanAmount"));
		enterText("interestRateTextbox_id", dataTable.get("interestRate"));
		enterText("loanTenureTextbox_id", dataTable.get("loanTenure"));
		clickEnter("loanTenureTextbox_id");

		waitForPageLoad();

		/*
		 * The getTextFromLocator method gets the text with locating the locator on the
		 * page The principal amount and the interest amount of the 1st month are
		 * extracted using the below method
		 */
		elementClick("principalYearBtn_xpath");
		getTextFromLocator("principalAmount_xpath", "Principal amount of first month in Rupees : ");
		getTextFromLocator("interestAmount_xpath", "Interest amount of first month in Rupees : ");
		quitBrowser();

	}

	/*
	 * The below Method homeLoanEmiCalculator will be the second test to proceed as
	 * it's priority is set to one The values are entered in the text box and after
	 * the calculation of emi the values on the webtable are entered in a excel file
	 */

	@Test(dataProvider = "homeLoanCalc", priority = 1,groups = {"Smoke","Regression"})
	public void homeLoanEmiCalculator(Hashtable<String, String> dataTable) {
		logger = report.createTest("Entering the home loan details and storing the output values in the excel");
		/*
		 * The browser is invoked and the website in the url is opened
		 */
		invokeBrowser("browserName");
		openURL("websiteURL");

		String title1 = getPageTitle();
		elementClick("mainMenu_xpath");
		elementClick("homeLoanEmiCalc_linkText");
		waitForPageLoad();
		String title2 = getPageTitle();
		/*
		 * The page title are compared to see whether an ad is present in between going
		 * from main page to the home loan emi calculator page if an ad is present the
		 * title will match the main page title and a click action is to be performed to
		 * proceed further
		 */

		if (title1.matches(title2)) {
			simpleClick();
		}
		/*
		 * The textboxes in the home loan emi calculator page are filled with values
		 */
		enterText("homeValue_CSS", dataTable.get("homeValue"));
		enterText("downPayment_CSS", dataTable.get("downPay"));
		enterText("loanInsurance_CSS", dataTable.get("insurance"));
		enterText("interestRate_CSS", dataTable.get("intRate"));
		enterText("loanTenure_CSS", dataTable.get("tenure"));
		enterText("loanFees_CSS", dataTable.get("fees"));
		elementClick("startMonthYear_CSS");
		selectDateInCalendar(dataTable.get("startDate"));

		implicitWait();

		enterText("oneTimeExpenses_CSS", dataTable.get("oneTimeexpense"));
		enterText("propertyTaxes_CSS", dataTable.get("propTax"));
		enterText("homeInsurance_CSS", dataTable.get("homeInsurance"));
		enterText("maintanence_CSS", dataTable.get("maintanence"));
		clickEnter("maintanence_CSS");

		waitForPageLoad();
		/*
		 * The interest and other values split up yearwise in the webtable for the
		 * values we entered are entered in the excel file The name of the excel file is
		 * given in the testdata excel file under workbook name and the worksheet name
		 * can also be changed in the testData excel file
		 */

		writeSheet(dataTable.get("workbookName"), dataTable.get("worksheetName"));

		quitBrowser();

	}

	@Test(dataProvider = "differentCalcRun", priority = 2,groups = {"Smoke","Regression"})
	public void testLoanCalculator(Hashtable<String, String> dataTable) {
		logger = report.createTest(
				"Testing the UI and the text fields of the "+ dataTable.get("calculator_used") +" under loan calculators menu");
		/*
		 * The browser is invoked and the website in the url is opened
		 */
		invokeBrowser("browserName");
		openURL("websiteURL");

		String title1 = getPageTitle();
		elementClick("mainMenu_xpath");
		elementClick("loanCalculator_linkText");
		waitForPageLoad();
		String title2 = getPageTitle();
		/*
		 * The page title are compared to see whether an ad is present in between going
		 * from main page to the corresponding calculator page if an ad is present the
		 * title will match the main page title and a click action is to be performed to
		 * proceed further
		 */
		if (title1.matches(title2)) {
			simpleClick();
		}

		waitForPageLoad();
		/*
		 * The loan calculator is choosen form the testdata and that calculator is
		 * clicked The values are entered in the textboxes to check the UI working of
		 * that text boxes
		 */
		elementClick(dataTable.get("chooseCalc_locator"));
		enterText(dataTable.get("textbox1_locator"), dataTable.get("textbox1_value"));
		enterText(dataTable.get("textbox2_locator"), dataTable.get("textbox2_value"));
		enterText(dataTable.get("textbox3_locator"), dataTable.get("textbox3_value"));
		enterText(dataTable.get("textbox4_locator"), dataTable.get("textbox4_value"));
		clickEnter(dataTable.get("textbox4_locator"));

		refreshPage();
		waitForPageLoad();

		/*
		 * For the UI check of slider, the slider are moved on to its right and left and
		 * the values are captured in the report
		 */

		elementClick(dataTable.get("chooseCalc_locator"));
		sliderUICheck(dataTable.get("slider1_locator"), dataTable.get("textbox1_locator"));
		sliderUICheck(dataTable.get("slider2_locator"), dataTable.get("textbox2_locator"));
		sliderUICheck(dataTable.get("slider3_locator"), dataTable.get("textbox3_locator"));
		sliderUICheck(dataTable.get("slider4_locator"), dataTable.get("textbox4_locator"));

		quitBrowser();
	}

	@DataProvider(name = "homeLoanCalc")
	public Object[][] getDataHomeLoanEmiCal() {
		return TestDataProvider.getTestData("sheet.xlsx", "Sheet1", "homeLoanEMICalc");
	}

	@DataProvider(name = "differentCalcRun")
	public Object[][] getDataTestLoanCalc() {
		return TestDataProvider.getTestData("sheet.xlsx", "Sheet1", "calculatorRun");
	}

	@DataProvider(name = "calculateCarLoan")
	public Object[][] getDataOnCarLoan() {
		return TestDataProvider.getTestData("sheet.xlsx", "Sheet1", "carLoanParameters");
	}

	@AfterTest
	public void endReport() {
		report.flush();
	}
//testng vs junit
//implicitwait vs explicitwait vs fluentwait
}
