package com.anu.automation.framework.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getExtentReports() {

        if (extent == null) {

            String reportPath = System.getProperty("user.dir")
                    + "/reports/ExtentReport.html";

            ExtentSparkReporter spark =
                    new ExtentSparkReporter(reportPath);

            spark.config().setReportName("Automation Test Results");
            spark.config().setDocumentTitle("Selenium Framework Report");

            extent = new ExtentReports();

            extent.attachReporter(spark);

            extent.setSystemInfo("Tester", "Anubhuti");
            extent.setSystemInfo("Framework", "Selenium + TestNG");
        }

        return extent;
    }
}