package ScreenshotTests;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Methods.LoginPageMethods;

public class ScreenshotTest extends DynamicWay_Screenshot {

	@BeforeSuite
	public void launchBrowser() throws IOException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\himaj\\Desktop\\07th July Batch\\Selenium Required documents\\chromedriver_win32 (2)\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		takeScreenshot("BrowserLaunched.png");

	}

	@BeforeClass
	public void lanuchURL() throws IOException {

		driver.get("https://testautomationpractice.blogspot.com/");

		takeScreenshot("URLLaunched.png");

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

	@Test
	public void enterField2() throws IOException {

		driver.findElement(By.id("field2")).sendKeys("Testing");

		takeScreenshot("Field2.png");

		//static way
		
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(screenshot, new File(
				"C:\\Users\\himaj\\Desktop\\Selenium With Java New\\Org.OrangeHRM.Com\\src\\test\\java\\ScreenshotImages\\Himaja.png"));

	}

	@AfterSuite
	public void closeBrowser() {

		driver.quit();
	}

}
