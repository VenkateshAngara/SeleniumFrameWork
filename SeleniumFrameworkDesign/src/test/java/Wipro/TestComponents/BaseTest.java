package Wipro.TestComponents;

import org.testng.annotations.AfterMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.BeforeMethod;

import Wipro.PageObjectModel.RegisterPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public WebDriver driver;
	public Properties prop= new Properties();
	public FileInputStream fs;
	public RegisterPage rp;
	String browser=null;
public WebDriver initiazeDriver() throws IOException {
	if(driver==null) {
	fs= new FileInputStream(System.getProperty("user.dir")+"/src/main/java/Wipro/Resources/GlobalData.properties");
	prop.load(fs);
	 browser=System.getProperty("browser")!=null ?System.getProperty("browser"):prop.getProperty("browser");
	}
	if(browser.contains("chrome")) {
	WebDriverManager.chromedriver().setup();
	ChromeOptions opt= new ChromeOptions();
	opt.setAcceptInsecureCerts(true);
	if(browser.contains("headless")) {
	opt.addArguments("headless");
	}
	driver= new ChromeDriver(opt);
	driver.manage().window().setSize(new Dimension(1440,900));
	}
	else if(browser.equalsIgnoreCase("edge")) {
		WebDriverManager.edgedriver().setup();
    driver= new EdgeDriver();
	}
	else if(browser.equalsIgnoreCase("firefox")) {
		WebDriverManager.firefoxdriver().setup();
		driver= new FirefoxDriver();
	}
	else  {
		WebDriverManager.safaridriver().setup();
		driver= new SafariDriver();	
	}
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	return driver;
}
@BeforeMethod(alwaysRun=true)
public RegisterPage launchapplication() throws IOException {
	driver=initiazeDriver();
	String URL = prop.getProperty("url");
	driver.get(URL);
	rp=new RegisterPage(driver);
	return rp;
}
@AfterMethod(alwaysRun=true)
public void tearDown() {
	driver.close();
}
public  String ScreenShot(String testname,WebDriver driver) throws IOException {
	TakesScreenshot ts=(TakesScreenshot) driver;
	File fs=ts.getScreenshotAs(OutputType.FILE);
	 File des=new File(System.getProperty("user.dir")+"/reports/ScreenShot"+testname+".png");
	FileUtils.copyFile(fs, des);
	return System.getProperty("user.dir")+"/reports/ScreenShot/"+testname+".png";
}
}
