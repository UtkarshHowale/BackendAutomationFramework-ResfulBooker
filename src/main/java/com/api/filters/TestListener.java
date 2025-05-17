package com.api.filters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.utilities.ExtentManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class TestListener implements ITestListener {

	private static final Logger logger = LogManager.getLogger(TestListener.class);
	private static ExtentReports extent = ExtentManager.getExtentReports();

	@Override
	public void onStart(ITestContext context) {
		logger.info("Test Suite Started!!!");
	}

	@Override
	public void onFinish(ITestContext context) {
		logger.info("Test Suite Completed!!!");
		extent.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		logger.info("Started --> " + result.getMethod().getMethodName());
		logger.info("Description --> " + result.getMethod().getDescription());

		ExtentTest test = extent.createTest(result.getMethod().getMethodName(), result.getMethod().getDescription());
		ExtentManager.setExtentTest(test);
		test.log(Status.INFO, "Test Started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		logger.info("Passed --> " + result.getMethod().getMethodName());
		logger.info("Description --> " + result.getMethod().getDescription());

		ExtentTest test = ExtentManager.getExtentTest();
		test.log(Status.PASS, "Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		logger.error("Failed --> " + result.getMethod().getMethodName());
		ExtentTest test = ExtentManager.getExtentTest();

		// Log exception and failure details
		test.log(Status.FAIL, "Test Failed: " + result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		logger.info("Skipped --> " + result.getMethod().getMethodName());
		ExtentTest test = ExtentManager.getExtentTest();
		test.log(Status.SKIP, "Test Skipped");
	}
}
