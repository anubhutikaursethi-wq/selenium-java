package com.anu.automation.framework.base;

import com.anu.automation.framework.driver.DriverFactory;
import com.anu.automation.framework.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = DriverFactory.initDriver();
        driver.get(ConfigReader.getBaseUrl());
        driver.manage().window().maximize();// ✅ important
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}