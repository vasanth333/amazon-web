package com.amazon.Tests;

import org.testng.annotations.Test;

import com.amazon.DriverFactory.TestBase;
import com.amazon.pageObjects.HomePageObjects;
import com.amazon.pageObjects.ProductPageObjects;

/**
 * Test Will be run based on the @Test, and will be categorized in the testng.xml file.
 * June 10, 2022
 * @author Vasanthakumar
 */



public class ProductDetailsTestCase extends TestBase {
	HomePageObjects homePage = new HomePageObjects();
	ProductPageObjects productPageObjects = new ProductPageObjects();

	@Test()
	public void TaskCreationTest() throws Throwable {
		homePage.clickOnTheHamburgerMenu();
		homePage.clickOnTvAppliancesAndElectronics();
		homePage.clickOnTelevisions();
		productPageObjects.clickOnBrandSamsung();
		productPageObjects.sortThePriceHighToLow();
		productPageObjects.chooseTheItemWithSecondHighestPrice();
		productPageObjects.verifyAboutThisItemMessage();

	}

}
