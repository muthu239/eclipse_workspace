package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class ContactformSteps {

	WebDriver driver;

	@Before
	public void invokeBrowser() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	@Given("^Go to mycontactsform site$")
	public void GotoSite() {
		driver.get("https://www.mycontactform.com/samples/basiccontact.php");
	}

	@Then("^Add the \"(.*)\" and \"(.*)\"$")
	public void EnterCredentials(String nam, String emai) {
		driver.findElement(By.name("q[1]")).sendKeys(nam);
		driver.findElement(By.name("email")).sendKeys(emai);

	}

	@Then("^Enter the \"(.*)\"$")
	public void AddMessage(String message) {
		driver.findElement(By.name("q[2]")).sendKeys(message);

	}

	@Then("^Click on submit Button$")
	public void clickonSubmit() {
		driver.findElement(By.name("submit")).click();
	}

	@After
	public void quit() {
		driver.quit();

	}
}
