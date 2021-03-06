package Practice.E2EProject;



import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.Base;
import resources.ExtentReportNG;

public class Listeners extends Base implements ITestListener{

	
	ExtentReports extent = ExtentReportNG.getReportObject();
	ExtentTest test;
	//ThreadLocal<ExtentReports> extentTest = new ThreadLocal<ExtentReports>();
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		 test = extent.createTest(result.getMethod().getMethodName());
		// extentTest.set(test);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.PASS, "Test Passed");
		//extentTest().get().log(Status.PASS, "Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		test.fail(result.getThrowable());
		//extentTest().get().fail(result.getThrowable());
		WebDriver driver= null;
		String testMethodName = result.getMethod().getMethodName();
		
		
		try {
			driver= (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch(Exception e)
		{
		}
	//	ExtentTest.get().addScreenCaptureFromPath(imagePath, title);
		getScreenShotPath(testMethodName, driver);
	}

	public void getScreenShotPath(String testMethodName, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
	}

}
