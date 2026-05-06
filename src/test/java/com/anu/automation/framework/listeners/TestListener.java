package com.anu.automation.framework.listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.anu.automation.framework.driver.DriverFactory;
import com.anu.automation.framework.utils.ScreenshotUtil;

public class TestListener implements ITestListener {	
	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("INSIDE TEST FAILURE LISTENER");
	    String testName = result.getName();

	    ScreenshotUtil.captureScreenshot(
	            DriverFactory.getDriver(),
	            testName
	    );
	}
}
