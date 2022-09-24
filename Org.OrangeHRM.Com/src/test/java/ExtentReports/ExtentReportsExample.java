package ExtentReports;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReportsExample {

	public static ExtentTest test;
	public static ExtentReports report;
	public WebDriver driver;

	@BeforeClass
	public static void startTest() {
		report = new ExtentReports(System.getProperty("user.dir") + "\\ExtentReportResults.html");
		test = report.startTest("ExtentDemo");
	}

	@Test(priority = 0)
	public void extentReportsDemo() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\himaj\\Desktop\\07th July Batch\\Selenium Required documents\\chromedriver_win32 (2)\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.get("https://www.google.co.in");
		if (driver.getTitle().equals("Google")) {
			test.log(LogStatus.PASS, "Navigated to the specified URL");
		} else {
			test.log(LogStatus.FAIL, "Test Failed");
		}

		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void launchOrangeHRM() {
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
		if (driver.getTitle().equals("Himaja")) {
			test.log(LogStatus.PASS, "Navigated to the specified URL");
		} else {
			test.log(LogStatus.FAIL, "Test Failed");
		}
	}

	@AfterClass
	public static void endTest() {
		report.endTest(test);
		report.flush();
	}

	@AfterSuite
	public void closeBrowser() {

		driver.close();
	}
}
