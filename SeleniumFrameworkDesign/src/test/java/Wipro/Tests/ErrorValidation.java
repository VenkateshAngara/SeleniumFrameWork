package Wipro.Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Wipro.PageObjectModel.CartPage;
import Wipro.PageObjectModel.HomePage;
import Wipro.PageObjectModel.LoginPage;
import Wipro.TestComponents.BaseTest;
import Wipro.TestComponents.Retry;

public class ErrorValidation extends BaseTest {
	//String Act="Account Created Successfully";
	//String semail="angaravenkat5656@gmail.com";
	//String fname="Angara";
	//String lname="Venky";
	//String occupation="Engineer";
	//String conpass="Angara@123";
	//String mobile="9542322769";
	String LAct="Incorrect email or password.";
	String email="VenkatAngara0809@gmail.com";
	String pass="Angara@123";
	String product="IPHONE 13 PRO";
	String wemail="angara@gmail.com";
	String ActItemtxt="Product Added To Cart";
	String wproduct="IPHONE 13 PROo";
	
	@Test(groups= {"Error"},retryAnalyzer=Retry.class)
	public void LoginValidation() throws IOException, InterruptedException  {
		//String txt=rp.registration(fname, lname, email, mobile, pass, conpass,occupation);
		//Assert.assertEquals(txt,Act );
		LoginPage lp=rp.objectReturn();
		lp.loginIn(wemail,pass);
		String lTxt=lp.getError();
		Assert.assertEquals(lTxt,LAct );
	}
	@Test
	public void OrderValidation() throws IOException, InterruptedException  {
	
		//String txt=rp.registration(fname, lname, semail, mobile, pass, conpass,occupation);
		//Assert.assertEquals(txt,Act );
		LoginPage lp=rp.objectReturn();
		HomePage hp=lp.loginIn(email,pass);
		hp.getProducts();
		hp.getProduct(product);
		String itemTxt=hp.addToCart(product);
		Assert.assertEquals(itemTxt,ActItemtxt);
		hp.cartClick();
		CartPage cp=hp.objectReturn();
		boolean verify=cp.searchProduct(wproduct);
		Assert.assertFalse(verify);
	}
}
