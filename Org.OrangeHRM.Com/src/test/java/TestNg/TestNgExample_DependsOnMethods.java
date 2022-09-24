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
import org.testng.annotations.Test;

public class TestNgExample_DependsOnMethods {

	public WebDriver driver;

	@BeforeSuite
	public void launchBrowser() {

		System.out.println("In Before Suite method");
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\himaj\\Desktop\\07th July Batch\\Selenium Required documents\\chromedriver_win32 (2)\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();
	}

	@BeforeClass
	public void lanuchURL() {

		System.out.println("In Before Class method");

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		System.out.println(driver.getTitle());
	}
	
	@BeforeMethod
	public void beforeMethod1() {
		
		System.out.println("In Before Method method");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	}
	
	@AfterMethod
	public void AfterMethod1() {
		
		System.out.println("In After Method method");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	}
	
	@Test
	public void enterUserName() {
		
		System.out.println("In enterUserName method");

		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
	}
	
	@Test(dependsOnMethods = "enterUserName")
	public void enterPassword() {
		
		System.out.println("In enterPassword method");

		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
	}
	
	@Test(dependsOnMethods = "enterPassword")
	public void clickLogin() {
		
		System.out.println("In clickLogin method");

		driver.findElement(By.xpath("//button[contains(@type,'submit')]")).click();
	}

	@AfterSuite
	public void closeBrowser() {

		System.out.println("In After Suite method");

		driver.close();
	}

}
