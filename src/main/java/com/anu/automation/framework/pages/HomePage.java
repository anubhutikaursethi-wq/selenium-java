package com.anu.automation.framework.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.anu.automation.framework.base.BasePage;
import com.anu.automation.framework.utils.ConfigReader;

public class HomePage extends BasePage {

	By searchBox = By.cssSelector("input.search-keyword");
	By productName = By.cssSelector("h4.product-name");
	By searchButton = By.cssSelector("button.search-button");
	By loader = By.cssSelector(".loading");

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public void openHomePage() {
		driver.get(ConfigReader.getBaseUrl());
	}

	public String getHomePageTitle() {
		return driver.getTitle();
	}

	public void searchForProduct(String product) {
		WebElement element = getElement(searchBox);
		element.clear();
		element.sendKeys(product);
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<String> getProductsName() {
		List<String> productNames = new ArrayList<>();
		List<WebElement> products = driver.findElements(productName);
		for (WebElement product : products) {
			productNames.add(product.getText().trim());
		}
		return productNames;
	}

	public void clickSearchButton() {
		click(searchButton);
	}
}
