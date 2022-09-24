package Tests;

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

import Methods.LoginPageMethods;
import Pages.ForgotYourPasswordPage;

public class ForgotYourPasswordTest {

	public WebDriver driver;
	
	LoginPageMethods lpm;
	
	ForgotYourPasswordPage fp;

	@BeforeSuite
	public void launchBrowser() {
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\himaj\\Desktop\\07th July Batch\\Selenium Required documents\\chromedriver_win32 (2)\\chromedriver.exe");

		driver = new ChromeDriver();
		
		lpm=new LoginPageMethods(driver);
		
		fp=new ForgotYourPasswordPage(driver);

		driver.manage().window().maximize();
	}

	@BeforeClass
	public void lanuchURL() {

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		System.out.println(driver.getCurrentUrl());
	}
	
	@BeforeMethod
	public void beforeMethod1() {
				
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@AfterMethod
	public void AfterMethod1() {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@Test(priority = 0)
	public void clickForgotPassword() {
		
		lpm.clickForgotYourPassword();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		System.out.println(driver.getCurrentUrl());
		
	}
	
	@Test(priority = 1)
	public void enterCredentials() {
		
		fp.enterUsername();
		
		fp.clickCancel();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		System.out.println(driver.getCurrentUrl());

	}
	
	@AfterSuite
	public void closeBrowser() {

		driver.quit();
	}

}
