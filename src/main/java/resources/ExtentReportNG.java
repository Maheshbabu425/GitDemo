package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {
	
	static ExtentReports extent;
	
	public static ExtentReports getReportObject()
	{
		String path = System.getProperty("user.dir")+"index.html";		
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);			
		reporter.config().setReportName("Mahesh Report");						
		reporter.config().setDocumentTitle("Test Result");						
		
		extent = new ExtentReports();										
		extent.attachReporter(reporter);										
		extent.setSystemInfo("Tester", "Mahesh Babu");						
		return extent;
	}

}
