package Wipro.PageObjectModel;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Wipro.utilities.ExplicitWait;

public class CheckOutPage extends ExplicitWait {

	WebDriver driver;
	public CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	

	
	@FindBy(xpath = "//input[@placeholder='Select Country']")
	WebElement country;
	
	By cdrp=By.cssSelector(".ta-results");
	
	@FindBy(xpath = "(//button[contains(@class,'ta-item')])[2]")
	WebElement dropDown;
	
	@FindBy(xpath = "//input[@name='coupon']")
	WebElement coupon;
	
	@FindBy(xpath = "(//input[@class='input txt'])[1]")
	WebElement cvv;
	
	@FindBy(xpath = "(//input[@class='input txt'])[2]")
	WebElement nameBox;
	
	@FindBy(css= ".action__submit")
	WebElement PlaceOrder;
	
	public void countryClick(String Country) throws InterruptedException {
		Actions a= new Actions(driver);
		a.sendKeys(country, Country ).build().perform();
		ElementToBeVisible(cdrp);
		//Thread.sleep(10000);
		dropDown.click();
	}
	public OrderPage enterDetails(String code,String CVV,String Name) {
		coupon.sendKeys(code);
		cvv.sendKeys(CVV);
		nameBox.sendKeys(Name);
		PlaceOrder.click();
		return new OrderPage(driver);
	}
	

}
