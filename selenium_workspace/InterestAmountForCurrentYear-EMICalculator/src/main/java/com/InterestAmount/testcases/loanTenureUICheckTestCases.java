package com.InterestAmount.testcases;

 

import org.testng.annotations.Test;

 

import com.InterestAmount.pageclasses.loanTenureUICheck;

 

public class loanTenureUICheckTestCases extends loanTenureUICheck
{
	/*
	 * calling the method and adding priority the method using testNG
	 */
    @Test(priority=0,groups = "Smoke Test")
    public void openBrowsertestCase() 
    {
        try
        {
            openBrowser();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    /*
     * calling the method and adding priority the method using testNG
     */
    @Test(priority = 1, groups = {"UICheck","Smoke Test"})
    public void testloanTenurenavigate()
    {
        try
        {
            loanTenurenavigate();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    /*
     * calling the method and adding priority the method using testNG
     */
    @Test(priority = 2, groups = {"UICheck","Regression Test"})
    public void testloanAmounttextbox() 
    {
        try
        {
            loanAmounttextbox();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    /*
     * calling the method and adding priority the method using testNG
     */
    @Test(priority = 2, groups = {"UICheck","Regression Test"})
    public void testloanAmountslidercheck()
    {
        try
        {
            loanAmountslidercheck();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    /*
     * calling the method and adding priority the method using testNG
     */
    @Test(priority = 2, groups = {"UICheck","Regression Test"})
    public void testloanAmountslider() 
    {
        try
        {
            loanAmountslider();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    /*
     * calling the method and adding priority the method using testNG
     */
    @Test(priority = 2, groups = {"UICheck","Regression Test"})
    public void testEMItextbox() 
    {
        try
        {
            EMItextbox();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    /*
     * calling the method and adding priority the method using testNG
     */
    @Test(priority = 2, groups = {"UICheck","Regression Test"})
    public void testemislider() 
    {
        try
        {
           emislider();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    /*
     * calling the method and adding priority the method using testNG
     */
    @Test(priority = 2, groups = {"UICheck","Regression Test"})
    public void testemislidercheck() 
    {
        try
        {
            emislidercheck();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    /*
     * calling the method and adding priority the method using testNG
     */
    @Test(priority = 2, groups = {"UICheck","Regression Test"})
    public void testinterestRatetextbox() 
    {
        try
        {
            interestRatetextbox(); 
        }
        catch(Exception e)
        {
            e.printStackTrace();
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
        	interestrateslider();
        }
        catch(Exception e)
        {
            e.printStackTrace();
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
        	interestRateslidercheck();
        }
        catch(Exception e)
        {
            e.printStackTrace();
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
            e.printStackTrace();
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
            e.printStackTrace();
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
            e.printStackTrace();
        }
    }
    /*
     * calling the method and adding priority the method using testNG
     */
    @Test(priority=3,groups = "Smoke Test")
    public void testclose() 
    {
        try
        {
            closeBrowser();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    /*
     * calling the method and adding priority the method using testNG
     */
    @Test(priority=4,groups = "Smoke Test")
    public void testendReport() 
    {
        try
        {
            report.flush();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}