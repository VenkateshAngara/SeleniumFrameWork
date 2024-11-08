package Wipro.PageObjectModel;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Wipro.utilities.ExplicitWait;

public class LoginPage extends ExplicitWait {
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="userEmail")
	WebElement email;

	@FindBy(id="userPassword")
	WebElement password;
	
	@FindBy(id="login")
	WebElement loginBtn;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement error;
	
	
	
	public HomePage loginIn(String Email,String pass) {
		email.sendKeys(Email);
		password.sendKeys(pass);
		loginBtn.click();	
		return new HomePage(driver);
		
	}
	
	public String getError() throws InterruptedException {
		//Thread.sleep(10000);
		ElementToBeVisible(error);
		return error.getText();
	}
}
