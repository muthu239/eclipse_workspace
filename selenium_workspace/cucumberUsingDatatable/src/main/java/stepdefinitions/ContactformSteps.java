package stepdefinitions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class ContactformSteps {
	
	WebDriver driver;

	@Before
	public void startBrowser() {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}
	
	
//	@Before("@Smoke")  // it will run as pre req only to @smoke tags 
//	public void startBrowser() {
//		System.setProperty("webdriver.chrome.driver",
//				System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
//		driver = new ChromeDriver();
//		driver.manage().window().maximize();
//
//	}

	@After
	public void closebrowser() {
		driver.quit();
	}

	@Given("^User is on homepage of myContactForm$")
	public void user_is_on_homepage_of_myContactForm() {
		// Write code here that turns the phrase above into concrete actions
		driver.get("https://www.mycontactform.com/samples/basiccontact.php");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}


	
	@Then("^user needs to click on here button for signup$")
	public void user_needs_to_click_on_here_button_for_signup() {
		// Write code here that turns the phrase above into concrete actions
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.findElement(By.xpath("//*[@id=\"center_col\"]/p/a")).click();

	}

	@Then("^enter the details of user$")
	public void enter_the_details_of_user(DataTable credentials) {
		List<List<String>> value = credentials.cells();
		driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys(value.get(0).get(0));
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(value.get(0).get(1));
		driver.findElement(By.xpath("//*[@id=\"user_signup\"]")).sendKeys("Roronoa");
		driver.findElement(By.xpath("//*[@id=\"pass_signup\"]")).sendKeys("aqwer1234@");
		driver.findElement(By.xpath("//*[@id=\"pass2\"]")).sendKeys("aqwer1234@");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("^after giving details submit the form$")
	public void after_giving_details_submit_the_form() {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//*[@id=\"useragree\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"center_col\"]/form/div[7]/input")).click();
		WebDriverWait wait1 = new WebDriverWait(driver, 20);
		wait1.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"success_status\"]"))));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
