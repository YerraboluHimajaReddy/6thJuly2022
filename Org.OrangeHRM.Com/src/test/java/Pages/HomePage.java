package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		
		this.driver=driver;
	}
	
	@FindBy(how=How.XPATH, using="//p[@class='oxd-userdropdown-name']")
	public WebElement paul;
	
	public void clickPaul() {
		
		paul.click();
	}
	

}
