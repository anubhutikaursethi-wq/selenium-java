package com.anu.automation.framework.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.anu.automation.framework.pages.HomePage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RetryAnalyzer implements IRetryAnalyzer {
	
	private static final Logger log = LogManager.getLogger(HomePage.class);

    private int count = 0;
    private static final int maxTry = 1;

    @Override
    public boolean retry(ITestResult result) {
    	log.info("Retrying test: " + result.getName());
        if (count < maxTry) {
            count++;
            return true;
        }

        return false;
    }
}