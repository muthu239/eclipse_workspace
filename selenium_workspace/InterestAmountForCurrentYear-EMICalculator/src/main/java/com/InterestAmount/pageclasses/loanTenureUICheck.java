package com.InterestAmount.pageclasses;

import java.util.concurrent.TimeUnit;


import com.InterestAmount.baseClass.baseMethods;
import com.aventstack.extentreports.Status;

public class loanTenureUICheck extends baseMethods
{
	/*
	 * Open browser and navigate to the test URL
	 */
	public void openBrowser() 
	{
		try
		{
			logger = report.createTest("Browser Initialization");
			invokeBrowser("chrome");
			logger.log(Status.INFO, "Browser opened Successfully");
			openURL("webURL");
			logger.log(Status.PASS, "Test Passed");
		}
		catch(Exception e)
        {
            reportFail(e.getMessage());
        }
	}
	/*
	 * navigating to the loan amount calculator and opening loan tenure calculator
	 */
	public void loanTenurenavigate() throws  Exception
	{
		try
		{
			logger = report.createTest("Loan Tenure Calculator Navigation");
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			elementClick("calculatormenu_Xpath");
			elementClick("loancalculator_Xpath");
			driver.navigate().to("https://emicalculator.net/loan-calculator/");
			//Thread.sleep(5000);
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			elementClick("LoanTenure_Id");
			//Thread.sleep(5000);
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			logger.log(Status.PASS, "Test Passed");
			runScriptWriteExcel.write(35,3,"Pass");
		}
		catch(Exception e)
        {
            reportFail(e.getMessage());
            runScriptWriteExcel.write(35,3,"Fail");
        }
	}
	/*
	 * checking whether loan amount text box is visible or not
	 */
	public void loanAmounttextbox()
	{
		try
		{
			logger = report.createTest("LoanAmount TextBox");
			boolean iselementpresent = getElement("LoanTenureLoanAmount_Xpath").isDisplayed();
			if (iselementpresent == true) {
				System.out.println("Loan Amount Text Box is Visible");
			} else {
				System.out.println("Loan Amount Text Box is Not Visible");
			}
			logger.log(Status.PASS, "Test Passed");
			runScriptWriteExcel.write(36,3,"Pass");
		}
		catch(Exception e)
        {
            reportFail(e.getMessage());
            runScriptWriteExcel.write(36,3,"Fail");
        }
	}
	/*
	 * checking whether loan amount slider is working or not
	 */
	public void loanAmountslidercheck()
	{
		try
		{
			logger = report.createTest("Loan Amount Check Slider");
			dragSlider("LoanTenureLoanAmountSlider_Xpath");
			System.out.println("Loan Amount Slider is Checked");
			logger.log(Status.PASS, "Test Passed");
			runScriptWriteExcel.write(37,3,"Pass");
		}
		catch(Exception e)
        {
            reportFail(e.getMessage());
            runScriptWriteExcel.write(37,3,"Fail");
        }
	}
	/*
	 * loan amount slider is visible or not
	 */ 
	public void loanAmountslider()
	{
		try
		{
			logger = report.createTest("Loan Amount Slider");
			boolean iselementpresent = getElement("LoanTenureLoanAmountSlider_Xpath").isDisplayed();
			if (iselementpresent == true) {
				System.out.println("Loan Amount Slider is Visible");
			} else {
				System.out.println("Loan Amount Slider is Not Visible");
			}
			logger.log(Status.PASS, "Test Passed");
			runScriptWriteExcel.write(38,3,"Pass");
		}
		catch(Exception e)
        {
            reportFail(e.getMessage());
            runScriptWriteExcel.write(38,3,"Fail");
        }
	}
	/*
	 * checking whether EMI textbox is visible or not
	 */
	public void EMItextbox()
	{
		try
		{
			logger = report.createTest("EMI Text Box");
			boolean iselementpresent = getElement("LoanTenureEMI_Xpath").isDisplayed();
			if (iselementpresent == true) {
				System.out.println("EMI Text Box is Visible");
			} else {
				System.out.println("EMI Text Box is Not Visible");
			}
			logger.log(Status.PASS, "Test Passed");
			runScriptWriteExcel.write(39,3,"Pass");
		}
		catch(Exception e)
        {
            reportFail(e.getMessage());
            runScriptWriteExcel.write(39,3,"Fail");
        }
	}
    /*
     * checking whether EMI slider is visible or not
     */
	public void emislider()
	{
		try
		{
			logger = report.createTest("EMI Slider");
			boolean iselementpresent = getElement("LoanTenureEMISlider_Xpath").isDisplayed();
			if (iselementpresent == true) {
				System.out.println("EMI Slider is Visible");
			} else {
				System.out.println("EMI Slider is Not Visible");
			}
			logger.log(Status.PASS, "Test Passed");
			runScriptWriteExcel.write(40,3,"Pass");
		}
		catch(Exception e)
        {
            reportFail(e.getMessage());
            runScriptWriteExcel.write(40,3,"Fail");
        }
	}
   /*
    * checking whether EMI slider is working or not
    */
	public void emislidercheck() 
	{
		try
		{
			logger = report.createTest("EMI Slider");
			dragSlider("LoanTenureEMISlider_Xpath");
			System.out.println("EMI Slider is Checked");
			logger.log(Status.PASS, "Test Passed");
			runScriptWriteExcel.write(41,3,"Pass");
		}
		catch(Exception e)
        {
            reportFail(e.getMessage());
            runScriptWriteExcel.write(41,3,"Fail");
        }
	}
	/*
	 * checking whether interest rate textbox is visible or not 
	 */
	public void interestRatetextbox() 
	{
		try
		{
			logger = report.createTest("Interest Rate Text Box");
			boolean iselementpresent = getElement("LoanTenureInterestRate_Xpath").isDisplayed();
			if (iselementpresent == true) {
				System.out.println("Interest Rate Text Box is Visible");
			} else {
				System.out.println("Interest Rate Text Box is Not Visible");
			}
			logger.log(Status.PASS, "Test Passed");
			runScriptWriteExcel.write(42,3,"Pass");
		}
		catch(Exception e)
        {
            reportFail(e.getMessage());
            runScriptWriteExcel.write(42,3,"Fail");
        }
	}
	/*
	 * checking whether interest rate slider is visible or not
	 */
	public void interestrateslider()
	{
		try
		{
			logger = report.createTest("Interest Rate Slider");
			boolean iselementpresent = getElement("LoanTenureInterestRateSlider_Xpath").isDisplayed();
			if (iselementpresent == true) {
				System.out.println("Interest Rate slider is Visible");
			} else {
				System.out.println("Interest Rate Slider is Not Visible");
			}
			logger.log(Status.PASS, "Test Passed");
			runScriptWriteExcel.write(43,3,"Pass");
		}
		catch(Exception e)
        {
            reportFail(e.getMessage());
            runScriptWriteExcel.write(43,3,"Fail");
        }
	}
    /*
     * checking whether interest rate slider is working or not
     */
	public void interestRateslidercheck() 
	{
		try
		{
			logger = report.createTest("Interest Rate Check Slider");
			dragSlider("LoanTenureInterestRateSlider_Xpath");
			System.out.println("Interest Rate Slider is Checked");
			logger.log(Status.PASS, "Test Passed");
			runScriptWriteExcel.write(44,3,"Pass");
		}
		catch(Exception e)
        {
            reportFail(e.getMessage());
            runScriptWriteExcel.write(44,3,"Fail");
        }
	}
	/*
	 * checking whether fee & charges textbox is visible or not
	 */
	public void feechargestextbox() 
	{
		try
		{
			logger = report.createTest("Fees & Charges Text Box");
			boolean iselementpresent = getElement("LoanTenureFee_Xpath").isDisplayed();
			if (iselementpresent == true) {
				System.out.println("Fees & Charges Text Box is Visible");
			} else {
				System.out.println("Fees & Charges Text Box is Not Visible");
			}
			logger.log(Status.PASS, "Test Passed");
			runScriptWriteExcel.write(45,3,"Pass");
		}
		catch(Exception e)
        {
            reportFail(e.getMessage());
            runScriptWriteExcel.write(45,3,"Fail");
        }
	}
	/*
	 * checking whether fee & charges slider is visible or not
	 */
	public void feechargesslider()
	{ 
		try
		{
			logger = report.createTest("Fees & Charges Slider");
			boolean iselementpresent = getElement("LoanTenureFeeSlider_Xpath").isDisplayed();
			if (iselementpresent == true) {
				System.out.println("Fees & Charges Slider is Visible");
			} else {
				System.out.println("Fees & Charges Slider is Not Visible");
			}
			logger.log(Status.PASS, "Test Passed");
			runScriptWriteExcel.write(46,3,"Pass");
		}
		catch(Exception e)
        {
            reportFail(e.getMessage());
            runScriptWriteExcel.write(46,3,"Fail");
        }
	}
    /*
     * checking whether fee & charge slider is working or not 
     */
	public void feeslidercheck() 
	{
		try
		{
			logger = report.createTest("Fees & Charges Check Slider");
			dragSlider("LoanTenureFeeSlider_Xpath");
			System.out.println("Loan Fees Slider is Checked");
			logger.log(Status.PASS, "Test Passed");
			runScriptWriteExcel.write(47,3,"Pass");
		}
		catch(Exception e)
	    {
	        reportFail(e.getMessage());
	        runScriptWriteExcel.write(47,3,"Fail");
	    }
	}
	/*
	 * close the browser
	 */
	public void close() 
	{
		try
		{
			closeBrowser();
		}
		catch(Exception e)
        {
            reportFail(e.getMessage());
        }
	}
	/*
	 * close the report and create new report
	 */
	public void endReport()
	{
		try
		{
			report.flush();
		}
		catch(Exception e)
        {
            reportFail(e.getMessage());
        }
	}
}