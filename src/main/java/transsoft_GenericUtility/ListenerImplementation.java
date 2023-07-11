package transsoft_GenericUtility;

import java.io.IOException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
/**
 * This class will take the screenshot of the failed test sceipt
 * @author mishr
 *
 */

public class ListenerImplementation implements ITestListener{
	
	ExtentReports report;
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("execution started");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		String methodname=result.getMethod().getMethodName();
		
		test.log(Status.PASS, methodname+"Testscript is passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		WebDriverUtilities wutil=new WebDriverUtilities();
		JavaUtilities jutil=new JavaUtilities();
		
		String methodname=result.getName()+"-"+jutil.getSystemformateWithSimple();
		try {
			String path=wutil.screenshot(BaseClass.ListenerDriver, methodname);
			test.addScreenCaptureFromPath(path);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		test.log(Status.FAIL, methodname+"Testscript is failed");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		String methodname=result.getMethod().getMethodName();
		test.log(Status.SKIP,methodname+"Testscript skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		
		ExtentSparkReporter htmlreport=new ExtentSparkReporter(".\\ExtentReport\\Report.html"+new JavaUtilities().getSystemformateWithSimple());
		htmlreport.config().setDocumentTitle("Transsoft execution report");
		htmlreport.config().setTheme(Theme.DARK);
		htmlreport.config().setReportName("Online food orderning line");
		
		report=new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("url", "https://rmgtestingserver/domain");
		report.setSystemInfo("Author", "Abhishek");
		
		
		System.out.println("Suite execution started");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Suite execution finished");
		report.flush();
		
	}
	
	
	
	
	
	
	

}
