package com.anu.automation.framework.base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	protected WebDriver driver;
	WebDriverWait wait;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	public void click(By locator) {
		getElement(locator).click();
	}
	
	public void type(By locator, String text) {
		getElement(locator).sendKeys(text);
	}
	
	public String getText(By locator) {
		return getElement(locator).getText();
	}
	
	public WebElement getElement(By locator) {
	    return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
}