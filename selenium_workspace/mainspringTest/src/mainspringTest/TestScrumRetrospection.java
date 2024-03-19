package mainspringTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestScrumRetrospection {
	
WebDriver driver = null;
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "E:\\eclipse_workspace\\mainspringTest\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://pratesting.cognizant.com/");
		
		driver.manage().window().maximize();
		try {
			Thread.sleep(80000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	@Test
	public void testSprintRetrospection() {
		
		WebElement sideMenu = driver.findElement(By.xpath("//div[@class = 'left_menu_icon_overlay']/span"));
		Actions action = new Actions(driver);
		action.moveToElement(sideMenu).build().perform();
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		WebElement projectMenu = driver.findElement(By.xpath("//ul[@class='left_menu_items']//a[contains(text(),'CFO_Onsite')]"));
		projectMenu.click();
		
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		
		WebElement monitorMenu = driver.findElement(By.cssSelector("#LOCK_Monitor"));
		action.moveToElement(monitorMenu).build().perform();
		//LOCK_Sprint Retrospection
		WebElement sprintRetrospectionMenu = driver.findElement(By.xpath("//a[@id='LOCK_Sprint Retrospection']"));
		//action.moveToElement(sprintRetrospectionMenu).build().perform();
		sprintRetrospectionMenu.click();
		
	
		
		driver.findElement(By.cssSelector("#KEY_BUTTON_Add-btnIconEl")).click();
		
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='contentframe']")));
		
		WebElement sprintDropDown = driver.findElement(By.name("DN_Sprint"));
		Select select = new Select(sprintDropDown);
		select.selectByVisibleText("newSprint385");
		
		driver.findElement(By.cssSelector("#DN_WhatwentRight")).sendKeys("abcd");
		driver.findElement(By.cssSelector("#DN_WhatwentWrong")).sendKeys("efgh");
		driver.findElement(By.cssSelector("#DN_Lessonslearnt")).sendKeys("ijkl");
		
		driver.findElement(By.cssSelector("#SaveAddNewBtn")).click();
		

		
//fluent wait		
		
//		 Waiting 30 seconds for an element to be present on the page, checking
//		    for its presence once every 5 seconds.
//		   Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
//		       .withTimeout(30, TimeUnit.SECONDS)
//		       .pollingEvery(2, TimeUnit.SECONDS)
//		       .ignoring(NoSuchElementException.class);
//
//		   WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
//		     public WebElement apply(WebDriver driver) {
//		       WebElement ele =  driver.findElement(By.cssSelector("#CancelBtn"));
//		       
//		       if(ele.isDisplayed()) {
//		    	   System.out.println("enabled");
//		       }
//		       return ele;
//		     }
//		   });
//
//	    
//		foo.click();
		
		
		WebDriverWait wait=new WebDriverWait(driver, 20);
		WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#CancelBtn")));
		ele.click();
		driver.switchTo().defaultContent();
		List<WebElement> element = driver.findElements(By.xpath("//div[contains(text(),'SPRT')]"));
		element.get(0).click();
		
		
		
		
		  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='contentframe']")));
		
	
		  System.out.println(driver.findElement(By.cssSelector("#CM_ItemCode")).getText());
		System.out.println(driver.findElement(By.cssSelector("#DN_WhatwentRight")).getText());
		System.out.println(driver.findElement(By.cssSelector("#DN_WhatwentWrong")).getText());
		System.out.println(driver.findElement(By.cssSelector("#DN_Lessonslearnt")).getText());

//		WebElement abc = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@id='CM_ItemCode']")));
//		
//		System.out.println(abc.getAttribute("value"));
		
		//     //*[@id="loadDiv"]/img
	//check homepage title
		// check everypage title
//		action.moveToElement(monitorMenu).build().perform();
//		
//		sprintRetrospectionMenu.click();
//		
		
	}

}
