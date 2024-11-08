package Wipro.StepDefinition;



import org.testng.Assert;

import Wipro.PageObjectModel.CartPage;
import Wipro.PageObjectModel.CheckOutPage;
import Wipro.PageObjectModel.HomePage;
import Wipro.PageObjectModel.LoginPage;
import Wipro.PageObjectModel.OrderPage;
import Wipro.PageObjectModel.RegisterPage;
import Wipro.TestComponents.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CucumberSteps extends BaseTest {
	public RegisterPage rp;
	public LoginPage lp;
	public HomePage hp;
	public CartPage cp;
	public CheckOutPage cop;
	public OrderPage op;

	@Given("I landed on the Ecommerce Website")
	public void i_landed_on_the_ecommerce_website() throws Exception {
		rp=launchapplication();
	}
	
	@Given("I want to Register a Account With all Details fname {string} lname {string} email {string} mob {string} pass {string} conpass {string} occ {string} in the  Register page and message is {string} displayed")
	public void i_want_to_register_a_account_with_all_details_fname_lname_email_mob_pass_conpass_occ_in_the_register_page_and_message_is_displayed(String fname, String lname, String email, String mob, String pass, String conpass, String occ, String msg) {
		String txt=rp.registration(fname, lname, email, mob, pass, conpass,occ);
		Assert.assertEquals(txt,msg);
	}

	@And("I logged into website with userName {string} and Password {string} in login page")
	public void i_logged_into_website_with_user_name_and_password_in_login_page(String email, String pass) {
		 lp=rp.objectReturn();
		 hp=lp.loginIn(email,pass);
	}



	@When("I  add the products {string} to cart from cart page and popup {string} is displayed")
	public void i_add_the_products_to_cart_from_cart_page_and_popup_is_displayed(String product, String ActItemtxt) throws Exception {
		hp.getProducts();
		hp.getProduct(product);
		String itemTxt=hp.addToCart(product);
		Assert.assertEquals(itemTxt,ActItemtxt);
	}


	@And("I click on cart to cartPage and check the product {string} is in cart page")
	public void i_click_on_cart_to_cart_page_and_check_the_product_is_in_cart_page(String product) {
		  hp.cartClick();
		 cp=hp.objectReturn();
		boolean verify=cp.searchProduct(product);
		Assert.assertTrue(verify);
	}

	@And("I checkout the product to paymentPage and enter details {string}{string} {string} {string}")
	public void i_checkout_the_product_to_payment_page_and_enter_details(String fname, String Country, String Cvv, String Code) throws Exception {
		 cop=cp.clickOnCheckOut();
		  cop.countryClick(Country);
		 op=cop.enterDetails(Code,Cvv ,fname );
	}

	@Then("verify the message {string} is Displayed")
	public void verify_the_message_is_displayed(String msg)  {
		String orderconfirm=op.OrderConfirm();
		Assert.assertEquals(orderconfirm,msg);	
		tearDown();
	}

	@Then("verify the message {string} is Displayed in Loginpage")
	public void verify_the_message_is_displayed_in_loginpage(String lmsg) throws InterruptedException {
		String lTxt=lp.getError();
		Assert.assertEquals(lTxt,lmsg );
		tearDown();
	}
	
}
