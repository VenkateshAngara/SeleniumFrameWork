package Wipro.PageObjectModel;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Wipro.utilities.ExplicitWait;

public class OrderDetailsPage extends ExplicitWait {

	WebDriver driver;
	public OrderDetailsPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(css = "tr td:nth-child(3)")
	List<WebElement> OrderProducts;
	
	public boolean OrderProduct(String product) {
		boolean t = OrderProducts.stream().anyMatch(sp -> sp.getText().equalsIgnoreCase(product));
		return t;
	}



}
