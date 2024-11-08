package Wipro.TestComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Wipro.Resources.extendReports;


public class Listeners extends BaseTest implements ITestListener {
	ExtentTest test;
	ExtentReports ex=extendReports.getReport();
	ThreadLocal<ExtentTest> tl=new ThreadLocal<ExtentTest>();//threadsafe

	@Override
	public void onTestStart(ITestResult result) {
	test=ex.createTest(result.getMethod().getMethodName());
	tl.set(test);
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		tl.get().log(Status.PASS, "Test is Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		tl.get().fail(result.getThrowable());
		try {
			driver=(WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String path=null;
			try {
				path=ScreenShot(result.getMethod().getMethodName(),driver);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			tl.get().addScreenCaptureFromPath(path,result.getMethod().getMethodName());
			
	}

	@Override
	public void onTestSkipped(ITestResult result) {
	
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		
	}

	@Override
	public void onFinish(ITestContext context) {
	ex.flush();
	}
	

}
