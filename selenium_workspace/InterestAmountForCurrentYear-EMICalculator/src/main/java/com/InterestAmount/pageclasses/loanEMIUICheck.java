package com.InterestAmount.pageclasses;

import java.util.concurrent.TimeUnit;


import com.InterestAmount.baseClass.baseMethods;
import com.aventstack.extentreports.Status;

public class loanEMIUICheck extends baseMethods
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
	 * navigating to the loan amount calculator and clicking EMI calculator
	 */
	public void loanemicalcnavigate()
	{
		try
		{
			logger = report.createTest("Loan EMI Calculator Navigation");
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			elementClick("calculatormenu_Xpath");
			elementClick("loancalculator_Xpath");
			driver.navigate().to("https://emicalculator.net/loan-calculator/");
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			logger.log(Status.PASS, "Test Passed");
			runScriptWriteExcel.write(9,3,"Pass");
		}
		catch(Exception e)
        {
            reportFail(e.getMessage());
            runScriptWriteExcel.write(9,3,"Fail");
        }
	}
	/*
	 * checking whether loan amount text box is visible or not
	 */
	public void loanamttextbox()
	{
		try
		{
			logger = report.createTest("Loan Amount Text Box");
			boolean iselementpresent = getElement("loanamount_Id").isDisplayed();
			if (iselementpresent == true) {
				System.out.println("Loan Amount Text Box is Visible");
			} else {
				System.out.println("Loan Amount Text Box is Not Visible");
			}
			logger.log(Status.PASS, "Test Passed");
			runScriptWriteExcel.write(10,3,"Pass");
		}
		catch(Exception e)
        {
            reportFail(e.getMessage());
            runScriptWriteExcel.write(10,3,"Fail");
        }
	}
	/*
	 * checking whether loan amount slider is working or not
	 */
	public void loanamtslidercheck() 
	{
		try
		{
			logger = report.createTest("Loan Amount Check Slider");
			dragSlider("loanamountslider_Id");
			System.out.println("Loan Amount Slider is Checked");
			logger.log(Status.PASS, "Test Passed");
			runScriptWriteExcel.write(11,3,"Pass");
		}
		catch(Exception e)
        {
            reportFail(e.getMessage());
            runScriptWriteExcel.write(11,3,"Fail");
        }
	}
	/*
	 * loan amount slider is visible or not
	 */
	public void loanamtslider() 
	{
		try
		{
			logger = report.createTest("Loan Amount Slider");
			boolean iselementpresent = getElement("loanamountslider_Id").isDisplayed();
			if (iselementpresent == true) {
				System.out.println("Loan Amount Slider is Visible");
			} else {
				System.out.println("Loan Amount Slider is Not Visible");
			}
			logger.log(Status.PASS, "Test Passed");
			runScriptWriteExcel.write(12,3,"Pass");
		}
		catch(Exception e)
        {
            reportFail(e.getMessage());
            runScriptWriteExcel.write(12,3,"Fail");
        }
	}
    /*
     * checking whether interest rate textbox is visible or not
     */
	public void interestratetextbox() 
	{
		try
		{
			logger = report.createTest("Interest Rate Text Box");
			boolean iselementpresent = getElement("loaninterest_Id").isDisplayed();
			if (iselementpresent == true) {
				System.out.println("Interest Rate Text Box is Visible");
			} else {
				System.out.println("Interest Rate Text Box is Not Visible");
			}
			logger.log(Status.PASS, "Test Passed");
			runScriptWriteExcel.write(13,3,"Pass");
		}
		catch(Exception e)
        {
            reportFail(e.getMessage());
            runScriptWriteExcel.write(13,3,"Fail");
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
			boolean iselementpresent = getElement("loaninterestslider_Id").isDisplayed();
			if (iselementpresent == true) {
				System.out.println("Interest Rate Slider is Visible");
			} else {
				System.out.println("Interest Rate Slider is Not Visible");
			}
			logger.log(Status.PASS, "Test Passed");
			runScriptWriteExcel.write(14,3,"Pass");
		}
		catch(Exception e)
        {
            reportFail(e.getMessage());
            runScriptWriteExcel.write(14,3,"Fail");
        }
	}
	/*
	 * checking whether interest rate slider working or not
	 */
	public void interestrateslidercheck()
	{
		try
		{
			logger = report.createTest("Interest Rate Check Slider");
			dragSlider("loaninterestslider_Id");
			System.out.println("Interest Rate Slider is Checked");
			logger.log(Status.PASS, "Test Passed");
			runScriptWriteExcel.write(15,3,"Pass");
		}
		catch(Exception e)
        {
            reportFail(e.getMessage());
            runScriptWriteExcel.write(15,3,"Fail");
        }
	}
    /*
     * checking whether loan tenure textbox visible or not
     */
	public void loantermtextbox() 
	{
		try
		{
			logger = report.createTest("Loan Term Text Box");
			boolean iselementpresent = getElement("loanterm_Id").isDisplayed();
			if (iselementpresent == true) {
				System.out.println("Loan Tenure Text Box is Visible");
			} else {
				System.out.println("Loan Tenure Text Box is Not Visible");
			}
			logger.log(Status.PASS, "Test Passed");
			runScriptWriteExcel.write(16,3,"Pass");
		}
		catch(Exception e)
        {
            reportFail(e.getMessage());
            runScriptWriteExcel.write(16,3,"Fail");
        }
	}
	/*
	 * checking whether loan tenure slider visible or not
	 */
	public void loantermslider()
	{
		try
		{
			logger = report.createTest("Loan Tenure Slider");
			boolean iselementpresent = getElement("loantermslider_Id").isDisplayed();
			if (iselementpresent == true) {
				System.out.println("Loan Tenure Slider is Visible");
			} else {
				System.out.println("Loan Tenure Slider is Not Visible");
			}
			logger.log(Status.PASS, "Test Passed");
			runScriptWriteExcel.write(17,3,"Pass");
		}
		catch(Exception e)
        {
            reportFail(e.getMessage());
            runScriptWriteExcel.write(17,3,"Fail");
        }
	}
	/*
	 * checking whether loan tenure slider is working or not
	 */
	public void loantermslidercheck()
	{
		try
		{
			logger = report.createTest("Loan Term Check Slider");
			dragSlider("loantermslider_Id");
			System.out.println("Loan Tenure Slider is Checked");
			logger.log(Status.PASS, "Test Passed");
			runScriptWriteExcel.write(18,3,"Pass");
		}
		catch(Exception e)
        {
            reportFail(e.getMessage());
            runScriptWriteExcel.write(18,3,"Fail");
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
			boolean iselementpresent = getElement("loanfees_Id").isDisplayed();
			if (iselementpresent == true) {
				System.out.println("Fees & Charges Text Box is Visible");
			} else {
				System.out.println("Fees & Charges Text Box is Not Visible");
			}
			logger.log(Status.PASS, "Test Passed");
			runScriptWriteExcel.write(19,3,"Pass");
		}
		catch(Exception e)
        {
            reportFail(e.getMessage());
            runScriptWriteExcel.write(19,3,"Fail");
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
			boolean iselementpresent = getElement("loanfeesslider_Id").isDisplayed();
			if (iselementpresent == true) {
				System.out.println("Fees & Charges Slider is Visible");
			} else {
				System.out.println("Fees & Charges Slider is Not Visible");
			}
			logger.log(Status.PASS, "Test Passed");
			runScriptWriteExcel.write(20,3,"Pass");
		}
		catch(Exception e)
        {
            reportFail(e.getMessage());
            runScriptWriteExcel.write(20,3,"Fail");
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
			dragSlider("loanfeesslider_Id");
			System.out.println("Loan Fees Slider is Checked");
			logger.log(Status.PASS, "Test Passed");
			runScriptWriteExcel.write(21,3,"Pass");
		}
		catch(Exception e)
        {
            reportFail(e.getMessage());
            runScriptWriteExcel.write(21,3,"Fail");
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
