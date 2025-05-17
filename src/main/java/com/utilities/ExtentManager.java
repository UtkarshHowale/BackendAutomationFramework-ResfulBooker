package com.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

	private static ExtentReports extentReports;
	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

	// Change theme via JVM property: -Dreport.theme=light or dark (default is dark)
	private static final String REPORT_THEME = System.getProperty("report.theme", "dark").toLowerCase();

	public synchronized static ExtentReports getExtentReports() {
		if (extentReports == null) {
			ExtentSparkReporter sparkReporter = new ExtentSparkReporter("test-output/ExtentReport.html");

			sparkReporter.config().setReportName("API Automation Test Report");
			sparkReporter.config().setDocumentTitle("Automation Test Results");

			if ("light".equals(REPORT_THEME)) {
				sparkReporter.config().setTheme(Theme.STANDARD);
			} else {
				sparkReporter.config().setTheme(Theme.DARK);
			}

			extentReports = new ExtentReports();
			extentReports.attachReporter(sparkReporter);

			// Add system info here as needed
			extentReports.setSystemInfo("Test Engineer", "Utkarsh Howale");
			extentReports.setSystemInfo("Organization", "Restful Booker");
		}
		return extentReports;
	}

	public static synchronized void setExtentTest(ExtentTest test) {
		extentTest.set(test);
	}

	public static synchronized ExtentTest getExtentTest() {
		return extentTest.get();
	}

	public static synchronized void unload() {
		extentTest.remove();
	}
}
