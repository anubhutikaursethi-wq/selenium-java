package com.anu.automation.framework.testcases;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.anu.automation.framework.base.BaseTest;
import com.anu.automation.framework.pages.HomePage;
import com.anu.automation.framework.listeners.RetryAnalyzer;

public class GreenKartHomePage extends BaseTest {

	private static final Logger log = LogManager.getLogger(HomePage.class);
	BaseTest baseTest = new BaseTest();

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void launchGreenKartHomePage() {
		baseTest.setUp();
		log.info("Thread: " + Thread.currentThread().getName());
		log.info("GreenKart Home Page is launched successfully");
		log.info("GreenKart Home Page title is: " + driver.getTitle());
		baseTest.tearDown();
	}
	
	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void partialMatch() {
		HomePage homePage = getHomePage();
		homePage.openHomePage();
		log.info("Thread: " + Thread.currentThread().getName());
		log.info("GreenKart Home Page title is: " + homePage.getHomePageTitle());
		homePage.searchForProduct("Tom");
		List<String> products = homePage.getProductsName();
		log.info("Product Name Fetched: " + products);
		Assert.assertTrue(products.contains("Tomato - 1 Kg"));
	}

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void testHomePage() {
		HomePage homePage = getHomePage();
		homePage.openHomePage();
		log.info("Thread: " + Thread.currentThread().getName());
		log.info("GreenKart Home Page title is: " + homePage.getHomePageTitle());
		homePage.searchForProduct("Cucumber");
		List<String> products = homePage.getProductsName();
		log.info("Product Name Fetched: " + products);
		Assert.assertTrue(products.contains("Cucumber - 1 Kg"));
	}

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void testProductSearch() {
		HomePage homePage = getHomePage();
		homePage.openHomePage();
		log.info("Thread: " + Thread.currentThread().getName());
		log.info("GreenKart Home Page title is: " + homePage.getHomePageTitle());
		homePage.searchForProduct("Brocolli");
		List<String> products = homePage.getProductsName();
		log.info("Product Name Fetched: " + products);
		Assert.assertTrue(products.contains("Brocolli - 1 Kg"));
	}

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void productNotFound() {
		HomePage homePage = getHomePage();
		homePage.openHomePage();
		log.info("Thread: " + Thread.currentThread().getName());
		log.info("GreenKart Home Page title is: " + homePage.getHomePageTitle());
		homePage.searchForProduct("xyz123");
	}

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void caseSensitivityInProductSearch() {
		HomePage homePage = getHomePage();
		homePage.openHomePage();
		log.info("Thread: " + Thread.currentThread().getName());
		log.info("GreenKart Home Page title is: " + homePage.getHomePageTitle());
		homePage.searchForProduct("beetroot");
		List<String> products = homePage.getProductsName();
		log.info("Product Name Fetched: " + products);
		Assert.assertTrue(products.contains("Beetroot - 1 Kg"));
	}

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void emptySearchInProductSearch() {
		HomePage homePage = getHomePage();
		homePage.openHomePage();
		log.info("Thread: " + Thread.currentThread().getName());
		log.info("GreenKart Home Page title is: " + homePage.getHomePageTitle());
		homePage.searchForProduct("");
		log.info("Product Name Fetched: " + homePage.getProductsName());
		Assert.assertFalse(homePage.getProductsName().isEmpty(),
				"Product list should not be empty when searching with an empty string");
	}

	@DataProvider(name = "searchData")
	public Object[][] getData() {
		return new Object[][] { { "Cucumber" }, { "Brocolli" }, { "Tom" }, { "xyz123" }, { "beetroot" }, { "" } };
	}

	@Test(dataProvider = "searchData", retryAnalyzer = RetryAnalyzer.class)
	public void dataProviderProductSearch(String input) {
		HomePage homePage = getHomePage();
		homePage.openHomePage();
		homePage.searchForProduct(input);
		List<String> product = homePage.getProductsName();
		log.info("Input: " + input);
		log.info("Product: " + product);
	}
}