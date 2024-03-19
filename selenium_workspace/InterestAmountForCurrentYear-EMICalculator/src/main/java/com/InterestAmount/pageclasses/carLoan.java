package com.InterestAmount.pageclasses;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import com.InterestAmount.baseClass.baseMethods;
import com.aventstack.extentreports.Status;

public class carLoan extends baseMethods
{
	/*
	 *  Open browser and navigate to the test URL
	 */
	public void openBrowser() 
	{
		try
		{
			logger = report.createTest("Browser Initialization");
			invokeBrowser("chrome");
			logger.log(Status.INFO, "Browser opened Successfully");
			openURL("webURL");
			runScriptWriteExcel.write(4,3,"Pass");
			logger.log(Status.PASS, "Test Passed");
		}
		catch(Exception e)
		{
			reportFail(e.getMessage());
			runScriptWriteExcel.write(4,3,"Fail");
		}
	}
	/*
	 * Send the Car Loan values
	 */
	public void carEMIForm() 
	{
		try
		{
		    logger = report.createTest("Car Loan Calculation");
			elementClick("carloanmenu_Id");
			getElement("loanamount_Id").sendKeys(Keys.CONTROL, "a", Keys.BACK_SPACE);
			getElement("loanamount_Id").sendKeys(prop.getProperty("amount"));
			getElement("loanamount_Id").sendKeys(Keys.ENTER);
			getElement("loaninterest_Id").sendKeys(Keys.CONTROL, "a", Keys.BACK_SPACE);
			getElement("loaninterest_Id").sendKeys(prop.getProperty("interest"));
			getElement("loaninterest_Id").sendKeys(Keys.ENTER);
			getElement("loanterm_Id").sendKeys(Keys.CONTROL, "a", Keys.BACK_SPACE);
			getElement("loanterm_Id").sendKeys(prop.getProperty("tenure"));
			getElement("loanterm_Id").sendKeys(Keys.ENTER); 
			logger.log(Status.INFO, "Car Loan Calculated");
			logger.log(Status.PASS, "Test Passed");
			runScriptWriteExcel.write(5,3,"Pass");
		}
		catch(Exception e)
		{
			reportFail(e.getMessage());
			runScriptWriteExcel.write(5,3,"Fail");
		}
	}
	
	/*
	 * Print One month Principle Amount and Interest Amount
	 */
	public void getdata() 
	{
		try
		{
			logger = report.createTest("EMI Calculation for a Month");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,1500)", "");
			elementClick("year_Id");
			String PA = getElement("PA_Xpath").getText();
			String[] principle = PA.split("\\s+");
			String IA = getElement("IA_Xpath").getText();
			String[] interest = IA.split("\\s+");
			String rupees = "Rs.";
			System.out.println("The Principal Amount for One Month is:" + rupees.concat(principle[1]));
			System.out.println("The Interest Amount for One Month is:" + rupees.concat(interest[1]));
			runScriptWriteExcel.write(6,3,"Pass");
			logger.log(Status.INFO, "EMI Calculated for a month");
			logger.log(Status.PASS, "Test Passed");
		}
		catch(Exception e)
		{
			reportFail(e.getMessage());
			runScriptWriteExcel.write(6,3,"Fail");
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