package Wipro.Tests;

import java.io.IOException;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import Wipro.Data.ReadData;
import Wipro.PageObjectModel.CartPage;
import Wipro.PageObjectModel.CheckOutPage;
import Wipro.PageObjectModel.HomePage;
import Wipro.PageObjectModel.LoginPage;
import Wipro.PageObjectModel.OrderDetailsPage;
import Wipro.PageObjectModel.OrderPage;
import Wipro.TestComponents.BaseTest;
import Wipro.TestComponents.ReadDataExcel;


public class EndToEndTest extends BaseTest {

	String Act="Account Created Successfully";
	String ActItemtxt="Product Added To Cart";
	String ActOrder="THANKYOU FOR THE ORDER.";
	
	//@Test(dataProvider="getData",groups={"purchase"})
	@Test(dataProvider="getData")
	public void OrderProduct(String email,String pass,String fname,String lname,String occupation,String conpass,String product,String mobile,String Code,String Country,String Cvv) throws IOException, InterruptedException  {
		//String txt=rp.registration(fname, lname, email, mobile, pass, conpass,occupation);
		//Assert.assertEquals(txt,Act );
		LoginPage lp=rp.objectReturn();
		HomePage hp=lp.loginIn(email,pass);
		hp.getProducts();
		hp.getProduct(product);
		String itemTxt=hp.addToCart(product);
		Assert.assertEquals(itemTxt,ActItemtxt);
		
		hp.cartClick();
		CartPage cp=hp.objectReturn();
		boolean verify=cp.searchProduct(product);
		Assert.assertTrue(verify);
		
		CheckOutPage cop=cp.clickOnCheckOut();
		cop.countryClick(Country);
		OrderPage op=cop.enterDetails(Code,Cvv ,fname );
		String orderconfirm=op.OrderConfirm();
		Assert.assertEquals(orderconfirm,ActOrder);
	}
	//@Test(dataProvider="getJsonData",groups={"Check"})
	@Test(dependsOnMethods= {"OrderProduct"},dataProvider="getJsonData")
	public void orderHistory(HashMap<String,String> in) {
		LoginPage lp=rp.objectReturn();
		HomePage hp=lp.loginIn(in.get("email"),in.get("pass"));
		OrderDetailsPage odp=hp.OrderClick();
		boolean match= odp.OrderProduct(in.get("product"));
		Assert.assertTrue(match);
		
		
	}
	@DataProvider
	public Object[][] getData() {
		return new Object[][] {{"VenkatAngara0809@gmail.com","Angara@123","Angara","Venky","Engineer","Angara@123","IPHONE 13 PRO","9542322769","First50","India","769"},{"VenkatAngara0809@gmail.com","Angara@123","Angara","Venkat","Student","Angara@123","ADIDAS ORIGINAL","9542322769","First100","India","322"}};
		
	}

	@DataProvider
	public Object[][] getOrderData() {
		HashMap<String,String> hm=new HashMap<String,String>();
		hm.put("email", "Venkat5454@gmail.com");
		hm.put("pass", "Angara@123");
		hm.put("product", "ADIDAS ORIGINAL");
		HashMap<String,String> map=new HashMap<String,String>();
		map.put("email", "Venkat5454@gmail.com");
		map.put("pass", "Angara@123");
		map.put("product", "ADIDAS ORIGINAL");
		return new Object[][] {{hm},{map}};	
	}
	@DataProvider
	public  Object[][] getJsonData() throws IOException{
		ReadData r=new ReadData();
		List<HashMap<String, String>> data =r.readJsonData(System.getProperty("user.dir")+"/src/test/java/Wipro/Data/LoginData.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
		
	}
	@DataProvider
	public  Object[][] getexcelData() throws IOException{
		ReadDataExcel r=new ReadDataExcel();
		String data[][]=r.getData("Create");
		return data;
		
	}

}
