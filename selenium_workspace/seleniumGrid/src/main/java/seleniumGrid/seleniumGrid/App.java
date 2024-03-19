package seleniumGrid.seleniumGrid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Hello world!
 *
 */
public class App 
{
    public RemoteWebDriver driver;
    public static String appURL = "https://www.google.com/";
    
    @BeforeClass
    public void setUp() throws MalformedURLException {
    	DesiredCapabilities capabilities = DesiredCapabilities.chrome();
    	driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
    	driver.manage().window().maximize();
    }
    
    @Test
    public void test() {
    	System.out.println("****navigate to application*******");
    	driver.navigate().to(appURL);
    	String title = driver.getTitle();
    	System.out.println("******verify page title***********");
    	Assert.assertEquals(title.equalsIgnoreCase("Google"), "Page title doesn't match");
    }
    
    @AfterClass
    public void closeBrowser() {
    	if(driver!=null)
    		driver.quit();
    }
}
