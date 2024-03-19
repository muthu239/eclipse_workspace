package HandleBrowserWindows.MultiWindowHandles;

import java.util.Set;

import org.openqa.selenium.NoSuchWindowException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class HandleWindows extends BaseClass {
	
	@Test
	public  void testOne() {
		
		logger = report.createTest("Test One");
		
		invokeBrowser("browserName");
		openURL("websiteURL");
		String parent = getParentWindowHandle();
		elementClick("helpBtn_id");
		waitLoad(2);
		elementClick("chatBtn_id");
		waitLoad(2);
		elementClick("visitBtn_id");
		waitLoad(2);
		Set<String> childWindows= getChildWindowHandles();
		System.out.println("Number of browser windows opened : "+getNoChildWindow(childWindows));
		for (String str: childWindows){
			// switching to each window
			switchWindow(str);
			// comparing and closing the window with title "visit us"
			if(titleOfWindow().equalsIgnoreCase("Visit us")){
				System.out.println("Window with title '"+ titleOfWindow()+"' is found");
				tearDown();
			}
	}
		switchWindow(parent);
	childWindows = getChildWindowHandles(); 
    	//if the window is already closed and the childWindows is not updated then this exception works
    	//Here the childWIndows set is updated so there is no exception
    	for (String str: childWindows){
    		try {
    			// switching to each window and closing
    			switchWindow(str);
    			tearDown();
    			}
    		catch(Exception e) {   
            	e.printStackTrace();
            }
    	}
    	

        quitBrowser();
        	
      	}
	
	//After test is necessary to generate a report
	@AfterTest
	public void endReport() {
		report.flush();
	}
	

}
