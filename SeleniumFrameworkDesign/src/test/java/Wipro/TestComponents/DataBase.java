package Wipro.TestComponents;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DataBase { 
	public static void main(String[] args) throws SQLException {
	
		String host="localhost";
		String port="3306";
		String database="QADB";
		Connection con=DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/"+database, "root", "root1234");
		System.out.println("Connection Success");
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from Logininfo where email='venkatesh'");
		WebDriver driver= new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		
		
		while(rs.next()) {
		driver.findElement(By.id("username")).sendKeys(rs.getString("email"));
		driver.findElement(By.id("password")).sendKeys(rs.getString("password"));
		//System.out.println(rs.getString("password") + " "+rs.getString("email"));
		
	}
	}
}
