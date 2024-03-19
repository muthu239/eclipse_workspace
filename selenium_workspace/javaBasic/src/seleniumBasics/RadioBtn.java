package seleniumBasics;

public class RadioBtn extends BaseMethods {
	
	public static void clickRadioBtn() {
		
		invokeBrowser("https://www.seleniumeasy.com/test/basic-radiobutton-demo.html");
		loadPropertiesFile("E:\\eclipse_workspace\\javaBasic\\src\\seleniumBasics\\locators.properties");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		clickOnMenu(prop.getProperty("genRadioBtn_xpath"));
		clickOnMenu(prop.getProperty("genSubmitBtn_xpath"));
		getTextFromLocator(prop.getProperty("genText_xpath"));
		
		clickOnMenu(prop.getProperty("sexRadioBtn_xpath"));
		clickOnMenu(prop.getProperty("ageRadioBtn_xpath"));
		clickOnMenu(prop.getProperty("groupSubmit_xpath"));
		getTextFromLocator(prop.getProperty("groupText_xpath"));
		CheckBox.clickCheckBox();
		
	}

}
