package Oct_20;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport implements ITestListener
{
	ExtentSparkReporter spark;
	ExtentReports extent;
	ExtentTest test;
	
	public void onStart(ITestContext testContext)
	{
	 spark = new ExtentSparkReporter("./Reports/spark.html");
	 spark.config().setDocumentTitle("New Extent Rep Generated...");
	 spark.config().setReportName("  Functional Testing....");
	 spark.config().setTheme(Theme.STANDARD);
	 extent = new ExtentReports();
	 
	 extent.attachReporter(spark);
	 extent.setSystemInfo("Tester Name", " Laxmi");
	 
	}
	
	public void onTestStart(ITestResult result)
	{
		test = extent.createTest(" TC started...");
		test.log(Status.INFO, "The TC started...");
	}
	
	public void onTestSuccess(ITestResult result)
	{
		test.log(Status.PASS, "The TC Passed...");
	}
	
	public void onTestSkipped(ITestResult result)
	{
		test.log(Status.SKIP, "The TC skipped...");
	}

	public void onTestFailure(ITestResult result)
	{
		test.log(Status.FAIL, "The TC Failed...");
		
	}
	
	public void onFinish(ITestContext testContext)
	{
		extent.flush();
	}
	
}
