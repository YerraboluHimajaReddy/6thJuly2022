package DataDrivenTests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class XlsExample {
	
	public WebDriver driver;
	
	public HSSFWorkbook workbook;
	
	public HSSFSheet sheet;
	
	public HSSFRow row;
	
	public HSSFCell column;
	
	@BeforeSuite
	public void getData() throws IOException {
		
		File file=new File("C:\\Users\\himaj\\Desktop\\Selenium With Java New\\Org.OrangeHRM.Com\\src\\test\\java\\TestData\\Login_OrangeHRM.xls");
	
		FileInputStream fs=new FileInputStream(file);
		
		workbook=new HSSFWorkbook(fs);
		
		sheet=workbook.getSheet("LoginData");
		
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
	
	@Test(priority = 1)
	public void enterUserName() {
		
		String username=sheet.getRow(1).getCell(0).toString();

		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
	}
	
	@Test(priority = 2)
	public void enterPassword() {
		
		String password=sheet.getRow(1).getCell(1).toString();

		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
	}
	
	@Test(priority = 3)
	public void clickLogin() {
		
		driver.findElement(By.xpath("//button[contains(@type,'submit')]")).click();
	}

	@AfterSuite
	public void closeBrowser() {

		driver.close();
	}


}
