package com.InterestAmount.testcases;

 

import org.testng.annotations.Test;

 

import com.InterestAmount.pageclasses.loanEMIUICheck;

 

public class loanEMIUICheckTestCases extends loanEMIUICheck
{
	/*
	 * calling the method and adding priority the method using testNG
	 */
    @Test(priority=0,groups = "Smoke Test")
    public void testopenBrowsertestCase() 
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
     * calling the method and adding priority the method using testNG
     */
    @Test(priority = 1, groups = {"UICheck","Smoke Test"})
    public void testloanemicalcnavigate()
    {
        try
        {
            loanemicalcnavigate();
        }
        catch(Exception e)
        {
            reportFail(e.getMessage());
        }
    }
    /*
     * calling the method and adding priority the method using testNG
     */
    @Test(priority = 2, groups = {"UICheck","Regression Test"})
    public void testloanamttextbox() 
    {
        try
        {
            loanamttextbox();
        }
        catch(Exception e)
        {
            reportFail(e.getMessage());
        }
    }
    /*
     * calling the method and adding priority the method using testNG
     */
    @Test(priority = 2, groups = {"UICheck","Regression Test"})
    public void testloanamtslidercheck() 
    {
        try
        {
            loanamtslidercheck();
        }
        catch(Exception e)
        {
            reportFail(e.getMessage());
        }
    }
    /*
     * calling the method and adding priority the method using testNG
     */
    @Test(priority = 2, groups = {"UICheck","Regression Test"})
    public void testloanamtslider()
    {
        try
        {
            loanamtslider();
        }
        catch(Exception e)
        {
            reportFail(e.getMessage());
        }
    }
    /*
     * calling the method and adding priority the method using testNG
     */
    @Test(priority = 2, groups = {"UICheck","Regression Test"})
    public void testinterestratetextbox() 
    {
        try
        {
            interestratetextbox();
        }
        catch(Exception e)
        {
            reportFail(e.getMessage());
        }
    }
    /*
     * calling the method and adding priority the method using testNG
     */
    @Test(priority = 2, groups = {"UICheck","Regression Test"})
    public void testinterestrateslider() 
    {
        try
        {
            interestrateslider();
        }
        catch(Exception e)
        {
            reportFail(e.getMessage());
        }
    }
    /*
     * calling the method and adding priority the method using testNG
     */
    @Test(priority = 2, groups = {"UICheck","Regression Test"})
    public void testinterestrateslidercheck() 
    {
        try
        {
            interestrateslidercheck();
        }
        catch(Exception e)
        {
            reportFail(e.getMessage());
        }
    }
    /*
     * calling the method and adding priority the method using testNG
     */
    @Test(priority = 2, groups = {"UICheck","Regression Test"})
    public void testloantermtextbox() 
    {
        try
        {
            loantermtextbox();
        }
        catch(Exception e)
        {
            reportFail(e.getMessage());
        }
    }
    /*
     * calling the method and adding priority the method using testNG
     */
    @Test(priority = 2, groups = {"UICheck","Regression Test"})
    public void testloantermslider() 
    {
        try
        {
            loantermslider(); 
        }
        catch(Exception e)
        {
            reportFail(e.getMessage());
        }
    }
    /*
     * calling the method and adding priority the method using testNG
     */
    @Test(priority = 2, groups = {"UICheck","Regression Test"})
    public void testloantermslidercheck()
    {
        try
        {
            loantermslidercheck();
        }
        catch(Exception e)
        {
            reportFail(e.getMessage());
        }
    }
    /*
     * calling the method and adding priority the method using testNG
     */
    @Test(priority = 2, groups = {"UICheck","Regression Test"})
    public void testfeechargestextbox() 
    {
        try
        {
            feechargestextbox();
        }
        catch(Exception e)
        {
            reportFail(e.getMessage());
        }
    }
    /*
     * calling the method and adding priority the method using testNG
     */
    @Test(priority = 2, groups = {"UICheck","Regression Test"})
    public void testfeechargesslider() 
    {
        try
        {
            feechargesslider(); 
        }
        catch(Exception e)
        {
            reportFail(e.getMessage());
        }
    }
    /*
     * calling the method and adding priority the method using testNG
     */
    @Test(priority = 2, groups = {"UICheck","Regression Test"})
    public void testfeeslidercheck() 
    {
        try
        {
            feeslidercheck();
        }
        catch(Exception e)
        {
            reportFail(e.getMessage());
        }
    }
    /*
     * calling the method and adding priority the method using testNG
     */
    @Test(priority=3,groups = "Smoke Test")
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
     * calling the method and adding priority the method using testNG
     */
    @Test(priority=4,groups = "Smoke Test")
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