package com.flipkart.generic.listenerutility;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.flipkart.generic.basetest.Base_Class;
import com.flipkart.generic.webdriverutility.UtilityClassObject;

public class ListImpClass implements ITestListener, ISuiteListener {
	public ExtentReports report;
	public static ExtentTest test;

	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println("Report confifguration");
		String time = new Date().toString().replace(" ", "_").replace(":", "_");

		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report_" + time + ".html");
		spark.config().setDocumentTitle("Flipkart Test Suite Results");
		spark.config().setReportName("Flipkart Report");
		spark.config().setTheme(Theme.DARK);
		// add Env information & create test
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-11");
		report.setSystemInfo("BROWSER", "CHROME-116");

	}

	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println("Report backUP");
		report.flush();

	}

	public void onTestStart(ITestResult result) {
		System.out.println("===== =====>" + result.getMethod().getMethodName() + ">===START======");
		test = report.createTest(result.getMethod().getMethodName());
		UtilityClassObject.setTest(test);
		test.log(Status.INFO, result.getMethod().getMethodName() + "==== > STARTED < ====");
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("===== =====>" + result.getMethod().getMethodName() + ">=====END======");
		test.log(Status.PASS, result.getMethod().getMethodName() + "==== > COMPLETED < ====");

	}

	public void onTestFailure(ITestResult result) {
		String testNAme = result.getMethod().getMethodName();
		TakesScreenshot eDriver = (TakesScreenshot) Base_Class.sDriver;
		String filePath = eDriver.getScreenshotAs(OutputType.BASE64);

		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		test.addScreenCaptureFromBase64String(filePath, testNAme + "_" + time);
		test.log(Status.FAIL, result.getMethod().getMethodName() + "==> FAILED <====");

	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

}
