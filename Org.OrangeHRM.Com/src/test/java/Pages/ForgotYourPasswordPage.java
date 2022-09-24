package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotYourPasswordPage {

	WebDriver driver;

	public ForgotYourPasswordPage(WebDriver driver) {

		this.driver = driver;
	}
	// 2nd way

	private By username_Textbox = By.xpath("//input[@name='username']");

	private By cancel_Button = By.xpath("//button[@type='button']");

	private By resetPassword_Button = By.xpath("//button[@type='submit']");

	public void enterUsername() {

		driver.findElement(username_Textbox).sendKeys("Testing");
	}

	public void clickCancel() {

		driver.findElement(cancel_Button).click();
	}

	public void clickResetPassword() {

		driver.findElement(resetPassword_Button).click();
	}

}
