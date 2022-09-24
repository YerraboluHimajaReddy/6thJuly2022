package TestNgAssertions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class HardAssertion_Example {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\himaj\\Desktop\\07th July Batch\\Selenium Required documents\\chromedriver_win32 (2)\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://testautomationpractice.blogspot.com/");

		String actualTitle = driver.getTitle();

		String expectedTitle = "Automation Testing Practice";

		Assert.assertEquals(actualTitle, expectedTitle);

		System.out.println("Both strings are same");
		
		System.out.println("============================");

		expectedTitle = "Automation";

		Assert.assertEquals(actualTitle, expectedTitle ,"Both strings are not same");

		System.out.println("============================");

		driver.close();
	}

}
