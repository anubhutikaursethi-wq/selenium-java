package com.anu.automation.framework.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {

    public static void captureScreenshot(WebDriver driver, String testName) {
        if (driver == null) {
            System.out.println("Screenshot skipped: WebDriver is null for test: " + testName);
            return;
        }

        Path screenshotsDir = Paths.get(System.getProperty("user.dir"), "screenshots");
        try {
            Files.createDirectories(screenshotsDir);
        } catch (IOException e1) {
            System.out.println("Could not create screenshots directory: " + screenshotsDir.toAbsolutePath());
            e1.printStackTrace();
            return;
        }

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File dest = screenshotsDir.resolve(testName + "_" + System.currentTimeMillis() + ".png").toFile();

        try {
            Files.copy(src.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Screenshot saved: " + dest.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Failed to save screenshot for test: " + testName + " to " + dest.getAbsolutePath());
            e.printStackTrace();
        }
    }
}