package com.InterestAmount.testcases;
import java.io.IOException;

 


import org.testng.annotations.Test;
import com.InterestAmount.pageclasses.homeLoan;
public class homeLoanTestCases extends homeLoan
{
    /*
     * Open browser and navigate to the test URL by calling method and using testNG
     */
    @Test(priority=0,groups = "Smoke Test")
    public void testopenBrowser() 
    {
        try
        {
            openBrowser();
        }
        catch(Exception e)
        {
            reportFail(e.getMessage());
        }
    }
    /*
     * Navigate to Home Loan EMI Calculator by calling method and testNG priority
     */
    @Test(priority=1,groups = "Smoke Test")
    public void testHomeEmi() 
    {
        try
        {
            homeemi(); 
        }
        catch(Exception e)
        {
            reportFail(e.getMessage());
        }
    }
    /*
     * calling the dataexport method and adding priority the method using testNG
     */
    @Test(priority=1, groups="Regression Test")
    public void testdataexport() throws IOException//./AmountTable.xlsx
    {
        try
        {
            dataexport();
        }
        catch(Exception e)
        {
            reportFail(e.getMessage());
        }
    }
    /*
     * calling the close browser method and adding priority the method using testNG
     */
    @Test(priority=2,groups = "Smoke Test")
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
     * calling the endReport method and adding priority the method using testNG
     */
    @Test(priority=3,groups = "Smoke Test")
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