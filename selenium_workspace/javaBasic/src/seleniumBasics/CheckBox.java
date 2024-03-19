package seleniumBasics;

public class CheckBox extends BaseMethods {
	
	public static void clickCheckBox() {
		

//		invokeBrowser("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");
		driver.navigate().to("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clickOnMenu(prop.getProperty("singleCheck_xpath"));
		getTextFromLocator(prop.getProperty("singleText_xpath"));
		
		clickOnMenu(prop.getProperty("groupCheck_xpath"));
		
		driver.quit();
		
		
	}

}
