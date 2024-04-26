package utilities;


import org.testng.ITestContext;

import org.testng.ITestListener;

import org.testng.ITestResult;
 
import com.aventstack.extentreports.ExtentReports;

import com.aventstack.extentreports.ExtentTest;

import com.aventstack.extentreports.Status;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import com.aventstack.extentreports.reporter.configuration.Theme;

import testCases.TC_001_Test_Cases;


 
public class Extent_Reports implements ITestListener {

	public ExtentSparkReporter sparkReporter;

	public ExtentReports extentReports;

	public ExtentTest extentTest;

	public void onStart(ITestContext context) {

		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+".\\Extent_Reports\\My_CAS_Report.html");

		sparkReporter.config().setDocumentTitle("Automation Report");

		sparkReporter.config().setReportName("Functional Testing");

		sparkReporter.config().setTheme(Theme.DARK);

		extentReports = new ExtentReports();

		extentReports.attachReporter(sparkReporter);

		extentReports.setSystemInfo("Computer Name", "Lenovo");

		extentReports.setSystemInfo("Environment", "QA");

		extentReports.setSystemInfo("Tester Name", "Maha Vishnu A");

		extentReports.setSystemInfo("OS", "Windows11");

		extentReports.setSystemInfo("Browser Name", "Chrome,Edge");

	}

	public void onTestSuccess(ITestResult result) {
		
		String path1 = TC_001_Test_Cases.path;

				extentTest = extentReports.createTest(result.getName());

				extentTest.log(Status.PASS, "Test case PASSED is : "+result.getName());

	}

	public void onTestFailure(ITestResult result) {

		extentTest = extentReports.createTest(result.getName());

		extentTest.log(Status.FAIL, "Test case FAILED is : "+result.getName());

		extentTest.log(Status.INFO, "Test case FAILED due to : "+result.getThrowable().getMessage());

	}

	public void onTestSkipped(ITestResult result) {

		extentTest = extentReports.createTest(result.getName());

		extentTest.log(Status.SKIP, "Test case Skipped is : "+result.getName());

		extentTest.log(Status.INFO, "Test case Skipped due to : "+result.getThrowable().getMessage());

	}

	public void onFinish(ITestContext context) {

		extentReports.flush();

	}

}

