package TestNgAssertions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class HardAssertion_Example2 {

	public WebDriver driver;

	public String actualTitle;

	public String expectedTitle;

	@BeforeSuite
	public void launchBrowser() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\himaj\\Desktop\\07th July Batch\\Selenium Required documents\\chromedriver_win32 (2)\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();

	}

	@BeforeClass
	public void lanuchURL() {

		driver.get("https://testautomationpractice.blogspot.com/");
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
	public void veriftTitle_Negative() {

		actualTitle = driver.getTitle();

		expectedTitle = "Google";

		Assert.assertEquals(actualTitle, expectedTitle);

		System.out.println("Both strings are not same");

		System.out.println(actualTitle);

		System.out.println(expectedTitle);
	}

	@Test(priority = 1)
	public void veriftTitle_Positive() {

		actualTitle = driver.getTitle();

		expectedTitle = "Automation Testing Practice";

		Assert.assertEquals(actualTitle, expectedTitle);

		System.out.println("Both strings are same");

		System.out.println(actualTitle);

		System.out.println(expectedTitle);
	}
	
	@Test(priority = 2)
	public void veriftTitle_NotEquals_Positive() {

		actualTitle = driver.getTitle();

		expectedTitle = "Google";

		Assert.assertNotEquals(actualTitle, expectedTitle);

		System.out.println("Both strings are not same");

		System.out.println(actualTitle);

		System.out.println(expectedTitle);
	}
	
	@Test(priority = 3)
	public void veriftTitle_NotEquals_Negative() {

		actualTitle = driver.getTitle();

		expectedTitle = "Automation Testing Practice";

		Assert.assertNotEquals(actualTitle, expectedTitle);

		System.out.println("Both strings are not same");

		System.out.println(actualTitle);

		System.out.println(expectedTitle);
	}
	
	@Test(priority = 4)
	public void veriftTitle_True_Positive() {

		Assert.assertTrue(true);
		
		Assert.assertTrue(true, "But found false");
	}
	
	@Test(priority = 5)
	public void veriftTitle_True_Negative() {

		Assert.assertTrue(false);
		
		Assert.assertTrue(false, "But found false");
	}
	
	@Test(priority = 6)
	public void veriftTitle_False_Positive() {

		Assert.assertFalse(false);
		
		Assert.assertFalse(false, "But found true");
	}
	
	@Test(priority = 7)
	public void veriftTitle_False_Negative() {

		Assert.assertFalse(true);
		
		Assert.assertFalse(true, "But found false");
	}

	@AfterSuite
	public void closeBrowser() {

		System.out.println("In After Suite method");

		driver.close();
	}

}
