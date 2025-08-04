package utilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import static TestPackage.PracTest.driver;
public class ITestListenerUtil implements ITestListener{
	
	ExtentReports extent= ExtentReportUtil.getReport();
	ThreadLocal<ExtentTest> test= new ThreadLocal<>();
	
	public void onTestStart(ITestResult result) {
		ExtentTest extenttest= extent.createTest(result.getMethod().getMethodName());
		test.set(extenttest);
	}
	
	public void onTestSuccess(ITestResult result) {
		test.get().log(Status.PASS, "Test Passed");
	}
	public void onTestFailure(ITestResult result) {
		
		String path=utilities.ScreenshotUtil.getScreenshot(driver, result.getName());
		test.get().addScreenCaptureFromPath(path);
		test.get().log(Status.FAIL, "Test Failed: "+result.getThrowable());
	}
	
	public void onFinish(ITestContext context) {
		extent.flush();
		ExtentReportUtil.getReport().flush();
		try {
			ExtentReportUtil.openReport();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
