package Wipro.PageObjectModel;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Wipro.utilities.ExplicitWait;

public class CartPage extends ExplicitWait {
	WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "[class=cartSection] h3")
	List<WebElement> cartProducts;
	
	@FindBy(xpath = "//li[@class='totalRow'] /button")
	WebElement checkOut;

	

	public boolean searchProduct(String product) {
		boolean t = cartProducts.stream().anyMatch(sp -> sp.getText().equalsIgnoreCase(product));
		return t;
	}

	public CheckOutPage clickOnCheckOut() {
		checkOut.click();
		return new CheckOutPage(driver);
	}

}
