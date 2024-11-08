package Wipro.PageObjectModel;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


import Wipro.utilities.ExplicitWait;

public class RegisterPage extends ExplicitWait {
	WebDriver driver;
	
	public RegisterPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css="a[href='/client/auth/register']")
	WebElement registerBtn;

	@FindBy(id="firstName")
	WebElement firstName;
	
	@FindBy(id="lastName")
	WebElement lastName;
	
	@FindBy(xpath="//input[@type='email']")
	WebElement userEmail;
	
	@FindBy(id="userMobile")
	WebElement userMobile;
	
	@FindBy(xpath="//select[@formcontrolname='occupation']")
	WebElement occupation;
	
	@FindBy(css="input[value='Male']")
	WebElement gender;
	
	@FindBy(id="userPassword")
	WebElement Password;
	
	@FindBy(id="confirmPassword")
	WebElement confirmPassword;
	
	@FindBy(css="input[type='checkbox']")
	WebElement checkBox;
	
	@FindBy(css="input[type='submit']")
	WebElement submitBtn;
	
	@FindBy(xpath="//h1[@class='headcolor']")
	WebElement successTxt;
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	WebElement LoginBtn;
	
	public String registration(String fname,String lname,String Email,String mobile,String pass,String conpass,String status) {
		registerBtn.click();
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		userEmail.sendKeys(Email);
		userMobile.sendKeys(mobile);
		Select s= new Select(occupation);
		s.selectByVisibleText(status);
		gender.click();
		Password.sendKeys(pass);
		confirmPassword.sendKeys(conpass);
		checkBox.click();
		submitBtn.click();
		String txt=successTxt.getText();
		LoginBtn.click();
		return txt;
	}
	public LoginPage objectReturn() {
		return  new LoginPage(driver);
	}
	
}
