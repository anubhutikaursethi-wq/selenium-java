package com.anu.automation.framework.driver;

import com.anu.automation.framework.utils.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver initDriver() {

        if (driver.get() == null) {

            String browser = ConfigReader.getBrowser(); // ✅ FIX

            switch (browser.toLowerCase()) {

                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    WebDriver chromeDriver = new ChromeDriver();
                    driver.set(chromeDriver);
                    break;

                default:
                    throw new RuntimeException("Browser not supported: " + browser);
            }

            getDriver().manage().window().maximize();
        }

        return getDriver();
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}