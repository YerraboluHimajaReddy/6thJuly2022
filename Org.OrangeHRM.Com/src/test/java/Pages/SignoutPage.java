package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SignoutPage {
	
	WebDriver driver;
	
	public SignoutPage(WebDriver driver) {
		
		this.driver=driver;
	}
	
	@FindBy(how=How.XPATH, using="//a[text()='About']")
	public WebElement about;
	
	@FindBy(how=How.XPATH, using="//a[text()='Support']")
	public WebElement support;
	
	@FindBy(how=How.XPATH, using="//a[text()='Change Password']")
	public WebElement changePassword;
	
	@FindBy(how=How.XPATH, using="//a[text()='Logout']")
	public WebElement logout;
	
	public void clickLogout() {
		
		logout.click();
	}	
	
	public void clickchangePassword() {
		
		changePassword.click();
	}
	
	public void clickSupport() {
		
		support.click();
	}
	
	public void clickAbout() {
		
		about.click();
	}
	

}
