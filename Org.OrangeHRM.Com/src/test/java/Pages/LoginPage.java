package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		
		this.driver=driver;
	}
	
	public By username_Textbox=By.xpath("//input[@name='username']");
	
	public By password_Textbox=By.xpath("//input[@name='password']");

	public By login_Button=By.xpath("//button[@type='submit']");

	public By forgotYourPassword_Link=By.xpath("(//p[contains(text(),'')])[3]");

	

}
