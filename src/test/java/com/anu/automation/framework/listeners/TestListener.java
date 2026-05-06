package com.anu.automation.framework.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.anu.automation.framework.driver.DriverFactory;
import com.anu.automation.framework.utils.ScreenshotUtil;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.anu.automation.framework.utils.ExtentManager;

public class TestListener implements ITestListener {

	private static ExtentReports extent = ExtentManager.getExtentReports();

	private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

	@Override
	public void onTestFailure(ITestResult result) {
		test.get().log(Status.FAIL, result.getThrowable());
		String testName = result.getMethod().getMethodName();
		ScreenshotUtil.captureScreenshot(DriverFactory.getDriver(), testName);

		String screenshotPath = System.getProperty("user.dir") + "/screenshots/" + testName + ".png";

		try {
			test.get().addScreenCaptureFromPath(screenshotPath);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestStart(ITestResult result) {
		ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
		test.set(extentTest);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.get().log(Status.PASS, "Test Passed");
	}
	
	@Override
	public void onFinish(ITestContext context) {
	    extent.flush();
	}
}
