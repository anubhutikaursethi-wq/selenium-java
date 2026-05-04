package com.anu.automation.framework.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.anu.automation.framework.base.BasePage;
import com.anu.automation.framework.utils.ConfigReader;

public class HomePage extends BasePage {
	
	By searchBox = By.cssSelector("input.search-keyword");
	By productName = By.cssSelector("h4.product-name");
	By searchButton = By.cssSelector("button.search-button");
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public void openHomePage() {
		driver.get(ConfigReader.getBaseUrl());
	}
	
	public String getHomePageTitle() {
		return driver.getTitle();
	}
	
	public void searchForProduct(String productName) {
		type(searchBox, productName);
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<String> getProductsName() {		
		return driver.findElements(productName).stream().map(e -> e.getText()).toList();
	}
	
	public void clickSearchButton() {
		click(searchButton);
	}
}
