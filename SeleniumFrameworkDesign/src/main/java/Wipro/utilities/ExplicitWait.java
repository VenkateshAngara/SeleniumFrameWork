package Wipro.utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Wipro.PageObjectModel.OrderDetailsPage;

public class ExplicitWait {
	WebDriver driver;
	
	public ExplicitWait(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css="[routerlink*='cart']")
	 WebElement cartBtn;
	@FindBy(css="[routerlink*='myorders']")
	WebElement orderBtn;

	public void ElementToBeVisible(By products) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(products));
	}
	public void ElementToBeVisible(WebElement products) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(products));
	}
	public void ElementToBeInvisible(WebElement spin )  {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOf(spin));
	}
	public void cartClick() {
		cartBtn.click();
	}
	public OrderDetailsPage OrderClick() {
		orderBtn.click();
		return new OrderDetailsPage(driver);
	}


}
