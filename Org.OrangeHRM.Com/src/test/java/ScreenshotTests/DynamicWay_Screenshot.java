package ScreenshotTests;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class DynamicWay_Screenshot {
	
	public WebDriver driver;
	
	public void takeScreenshot(String screenshotName) throws IOException {
		
		File screenshot=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(screenshot, new File("C:\\Users\\himaj\\Desktop\\Selenium With Java New\\Org.OrangeHRM.Com\\src\\test\\java\\ScreenshotImages\\" + screenshotName));
	}

}
