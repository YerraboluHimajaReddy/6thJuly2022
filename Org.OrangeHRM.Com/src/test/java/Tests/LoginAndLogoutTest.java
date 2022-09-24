package Tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Methods.LoginPageMethods;
import Pages.HomePage;
import Pages.SignoutPage;

public class LoginAndLogoutTest {

	public WebDriver driver;

	LoginPageMethods lpm;

	HomePage hp;

	SignoutPage sp;

	@BeforeSuite
	public void launchBrowser() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\himaj\\Desktop\\07th July Batch\\Selenium Required documents\\chromedriver_win32 (2)\\chromedriver.exe");

		driver = new ChromeDriver();

		lpm = new LoginPageMethods(driver);

		hp = PageFactory.initElements(driver, HomePage.class);

		sp = PageFactory.initElements(driver, SignoutPage.class);

		driver.manage().window().maximize();
	}

	@BeforeClass
	public void lanuchURL() {

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		System.out.println(driver.getTitle());
	}

	@BeforeMethod
	public void beforeMethod1() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@AfterMethod
	public void AfterMethod1() {

	}

	@Test(priority = 0)
	public void enterCredentials() {

		lpm.enterUsername();
		lpm.enterPassword("admin123");
		lpm.clickLogin();
	}

	@Test(priority = 1)
	public void clickPaul() {

		hp.clickPaul();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	}

	@Test(priority = 2)
	public void clickSignout() {

		sp.clickLogout();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		System.out.println(driver.getCurrentUrl());
	}

	@AfterSuite
	public void closeBrowser() {

		driver.quit();
	}

}
