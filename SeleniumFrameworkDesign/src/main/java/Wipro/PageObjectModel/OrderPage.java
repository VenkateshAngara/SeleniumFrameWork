package Wipro.PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Wipro.utilities.ExplicitWait;

public class OrderPage extends ExplicitWait {

	WebDriver driver;
	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	@FindBy(css= ".hero-primary")
	WebElement OrderDetails;

	public String OrderConfirm() {
		return OrderDetails.getText();
	}
}
