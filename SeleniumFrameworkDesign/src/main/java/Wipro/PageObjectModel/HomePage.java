package Wipro.PageObjectModel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Wipro.utilities.ExplicitWait;

public class HomePage extends ExplicitWait{
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	By products=By.cssSelector(".mb-3");
	By cart=By.cssSelector(".card-body button:last-of-type");
	By conTxt=By.cssSelector("#toast-container");
	
	@FindBy(css=".mb-3")
	List<WebElement> Products;
	
	@FindBy(css=".ng-animating")
	 WebElement load;
	
	@FindBy(css="#toast-container")
	 WebElement productTxt;


	
	public List<WebElement> getProducts() throws InterruptedException {
		//Thread.sleep(10000);
		ElementToBeVisible(products);
		return Products;
	}
	public WebElement getProduct(String product) throws InterruptedException {
		WebElement pro=getProducts().stream().filter(
				l->l.findElement(By.tagName("b")).getText().equals(product)).findFirst().orElse(null);
		return pro;
	}
	public String addToCart(String product) throws InterruptedException {
		getProduct(product).findElement(cart).click();
		//Thread.sleep(1000);
		ElementToBeVisible(conTxt);
		String txt=productTxt.getText();
		//Thread.sleep(10000);
		ElementToBeInvisible(load);
		
		return txt;
	}
	public CartPage objectReturn() {
		return new CartPage(driver);
	}
	
}
