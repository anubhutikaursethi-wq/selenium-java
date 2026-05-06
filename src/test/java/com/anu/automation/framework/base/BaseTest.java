package com.anu.automation.framework.base;

import com.anu.automation.framework.driver.DriverFactory;
import com.anu.automation.framework.pages.HomePage;
import com.anu.automation.framework.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

	protected WebDriver driver;

	@BeforeMethod(alwaysRun = true)
	public void setUp() {
		DriverFactory.quitDriver();
		driver = DriverFactory.initDriver();
		driver.get(ConfigReader.getBaseUrl());
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		DriverFactory.quitDriver();
	}

	public HomePage getHomePage() {
		return new HomePage(driver);
	}
}