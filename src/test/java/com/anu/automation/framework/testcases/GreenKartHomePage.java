package com.anu.automation.framework.testcases;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.anu.automation.framework.base.BaseTest;
import com.anu.automation.framework.pages.HomePage;

public class GreenKartHomePage extends BaseTest {

	BaseTest baseTest = new BaseTest();

	@Test
	public void launchGreenKartHomePage() {
		baseTest.setUp();
		System.out.println("GreenKart Home Page is launched successfully");
		System.out.println("GreenKart Home Page title is: " + driver.getTitle());
		baseTest.tearDown();
	}

	@Test
	public void testHomePage() {
		HomePage homePage = new HomePage(driver);
		homePage.openHomePage();
		System.out.println("GreenKart Home Page title is: " + homePage.getHomePageTitle());
		homePage.searchForProduct("Cucumber");
		System.out.println("Product Name Fetched: " + homePage.getProductsName());
		Assert.assertTrue(homePage.getProductsName().contains("Cucumber"), "Product name does not contain 'Cucumber'");
	}

	@Test
	public void testProductSearch() {
		HomePage homePage = new HomePage(driver);
		homePage.openHomePage();
		System.out.println("GreenKart Home Page title is: " + homePage.getHomePageTitle());
		homePage.searchForProduct("Tomato");
		System.out.println("Product Name Fetched: " + homePage.getProductsName());
		Assert.assertEquals(homePage.getProductsName(), "Tomato - 1 Kg", "Product name does not contain 'Cucumber'");
	}

	@Test
	public void productNotFound() {
		HomePage homePage = new HomePage(driver);
		homePage.openHomePage();
		System.out.println("GreenKart Home Page title is: " + homePage.getHomePageTitle());
		homePage.searchForProduct("xyz123");
	}

	@Test
	public void partialMatch() {
		HomePage homePage = new HomePage(driver);
		homePage.openHomePage();
		System.out.println("GreenKart Home Page title is: " + homePage.getHomePageTitle());
		homePage.searchForProduct("Tom");
		System.out.println("Product Name Fetched: " + homePage.getProductsName());
		Assert.assertEquals(homePage.getProductsName(), "Tomato - 1 Kg", "Product name does not contain 'Cucumber'");
	}

	@Test
	public void caseSensitivityInProductSearch() {
		HomePage homePage = new HomePage(driver);
		homePage.openHomePage();
		System.out.println("GreenKart Home Page title is: " + homePage.getHomePageTitle());
		homePage.searchForProduct("tomato");
		System.out.println("Product Name Fetched: " + homePage.getProductsName());
		Assert.assertEquals(homePage.getProductsName(), "Tomato - 1 Kg", "Product name does not contain 'Cucumber'");
	}

	@Test
	public void emptySearchInProductSearch() {
		HomePage homePage = new HomePage(driver);
		homePage.openHomePage();
		System.out.println("GreenKart Home Page title is: " + homePage.getHomePageTitle());
		homePage.searchForProduct("");
		System.out.println("Product Name Fetched: " + homePage.getProductsName());
		Assert.assertFalse(homePage.getProductsName().isEmpty(),
				"Product list should not be empty when searching with an empty string");
	}

	@DataProvider(name = "searchData")
	public Object[][] getData() {
		return new Object[][] { { "Cucumber" }, { "Tomato" }, { "Tom" }, { "xyz123" }, { "tomato" }, { "" } };
	}

	@Test(dataProvider = "searchData")
	public void dataProviderProductSearch(String input) {
		HomePage homePage = new HomePage(driver);
		homePage.openHomePage();

		homePage.searchForProduct(input);

		List<String> product = homePage.getProductsName();

		System.out.println("Input: " + input);
		System.out.println("Product: " + product);
	}
}