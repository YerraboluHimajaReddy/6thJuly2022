package TestNgAssertions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertion_Example {

	public WebDriver driver;

	public SoftAssert softassert;

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
		
		softassert=new SoftAssert();

		actualTitle = driver.getTitle();

		expectedTitle = "Google";

		softassert.assertEquals(actualTitle, expectedTitle);

		System.out.println("Both strings are not same");

		System.out.println(actualTitle);

		System.out.println(expectedTitle);
		
		softassert.assertAll();
	}

	@Test(priority = 1)
	public void veriftTitle_Positive() {

		softassert=new SoftAssert();

		actualTitle = driver.getTitle();

		expectedTitle = "Automation Testing Practice";

		softassert.assertEquals(actualTitle, expectedTitle);

		System.out.println("Both strings are same");

		System.out.println(actualTitle);

		System.out.println(expectedTitle);
		
		softassert.assertAll();

	}
	
	@Test(priority = 2)
	public void veriftTitle_NotEquals_Positive() {

		softassert=new SoftAssert();

		actualTitle = driver.getTitle();

		expectedTitle = "Google";

		softassert.assertNotEquals(actualTitle, expectedTitle);

		System.out.println("Both strings are not same");

		System.out.println(actualTitle);

		System.out.println(expectedTitle);
		
		softassert.assertAll();

	}
	
	@Test(priority = 3)
	public void veriftTitle_NotEquals_Negative() {

		softassert=new SoftAssert();

		actualTitle = driver.getTitle();

		expectedTitle = "Automation Testing Practice";

		softassert.assertNotEquals(actualTitle, expectedTitle);

		System.out.println("Both strings are not same");

		System.out.println(actualTitle);

		System.out.println(expectedTitle);
		
		softassert.assertAll();

	}
	
	@Test(priority = 4)
	public void veriftTitle_True_Positive() {

		softassert=new SoftAssert();

		softassert.assertTrue(true);
		
		softassert.assertTrue(true, "But found false");
		
		softassert.assertAll();

	}
	
	@Test(priority = 5)
	public void veriftTitle_True_Negative() {

		softassert=new SoftAssert();

		softassert.assertTrue(false);
		
		softassert.assertTrue(false, "But found false");
		
		softassert.assertAll();

	}
	
	@Test(priority = 6)
	public void veriftTitle_False_Positive() {

		softassert=new SoftAssert();

		softassert.assertFalse(false);
		
		softassert.assertFalse(false, "But found true");
		
		softassert.assertAll();

	}
	
	@Test(priority = 7)
	public void veriftTitle_False_Negative() {

		softassert=new SoftAssert();

		softassert.assertFalse(true);
		
		softassert.assertFalse(true, "But found false");
		
		softassert.assertAll();

	}

	@AfterSuite
	public void closeBrowser() {

		System.out.println("In After Suite method");

		driver.close();
	}

}
