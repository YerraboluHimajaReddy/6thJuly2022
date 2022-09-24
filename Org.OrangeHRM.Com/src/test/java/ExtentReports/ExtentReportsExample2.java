package ExtentReports;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Listeners.WebDriverListeners;
import Methods.LoginPageMethods;

public class ExtentReportsExample2 extends WebDriverListeners {

	public static ExtentTest test;
	public static ExtentReports report;
	public WebDriver driver;

	LoginPageMethods lpm;

	@BeforeClass
	public static void startTest() {
		report = new ExtentReports(System.getProperty("user.dir") + "\\ExtentReportResults.html");
		test = report.startTest("ExtentDemo");
	}

	@Test
	public void launchOrangeHRM() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\himaj\\Desktop\\Selenium With Java\\Selenium\\Selenium\\25thApril2022\\chromedriver_win32 (1)\\chromedriver.exe");
		driver = new ChromeDriver();
		lpm = new LoginPageMethods(driver);
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
		if (driver.getTitle().equals("OrangeHRM")) {
			test.log(LogStatus.PASS, "Navigated to the specified URL");
		} else {
			test.log(LogStatus.FAIL, "Test Failed");
		}

		lpm.enterUsername();
		lpm.enterPassword("admin123");
		
		WebElement login=driver.findElement(By.id("btnLogin"));
		
		beforeClickOn(login, driver);
		
		lpm.clickLogin();
		
		afterClickOn(login, driver);

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		if (driver.getTitle().equals("OrangeHRM")) {
			test.log(LogStatus.PASS, "Navigated to the specified URL");
		} else {
			test.log(LogStatus.FAIL, "Test Failed");
		}

	}

	@AfterClass
	public static void endTest() {
		report.endTest(test);
	}

	@AfterSuite
	public void closeBrowser() {

		driver.close();
	}
}
