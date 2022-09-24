package TestNg;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderExample extends DriverExtensions {

	@BeforeSuite
	public void launchBrowser() {
		
		launchBrowser("edge");
	}

	@BeforeClass
	public void lanuchURL() {

		driver.get("https://www.facebook.com/login.php");

		System.out.println(driver.getTitle());
	}
	
	@BeforeMethod
	public void beforeMethod1() {
				
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	}
	
	@AfterMethod
	public void AfterMethod1() {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	}
	
	@DataProvider(name="FacebookData")
	public Object[][] data(){
		
		Object[][] userData=new Object[4][2];
		
		userData[0][0] ="Himaja";
		userData[0][1] ="Testing";
		
		userData[1][0] ="Gowtham";
		userData[1][1] ="GowthamTesting";
		
		userData[2][0] ="Savithri";
		userData[2][1] ="SavithriTesting";
		
		userData[3][0] ="Ramesh";
		userData[3][1] ="RameshTesting";
		
		return userData;
	}
	
	@Test(dataProvider = "FacebookData", priority =0)
	public void enterCredentials(String username, String password) {		

		driver.findElement(By.id("email")).clear();
		
		driver.findElement(By.id("email")).sendKeys(username);
		
		driver.findElement(By.id("pass")).clear();
		
		driver.findElement(By.id("pass")).sendKeys(password);
	}

	@AfterSuite
	public void closeBrowser() {
		
		driver.quit();
	}
}
