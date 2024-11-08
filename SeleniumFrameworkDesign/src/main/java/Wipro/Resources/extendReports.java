package Wipro.Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extendReports {

	public static ExtentReports getReport() {
		String path=System.getProperty("user.dir")+"/Reports/index.html";
		ExtentSparkReporter report= new ExtentSparkReporter(path);
		report.config().setDocumentTitle("Let's Shop Test Result");
		report.config().setReportName("Web Automation Result");
		
		ExtentReports ex= new  ExtentReports();
		ex.attachReporter(report);
		ex.setSystemInfo("Tester", "Angara Venkatesh");
		return ex;
	}
}
