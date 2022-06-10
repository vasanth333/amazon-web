package com.amazon.pageObjects;

import org.openqa.selenium.WebElement;

import com.amazon.DriverFactory.DriverFactory;
import com.amazon.DriverFactory.TestBase;
import com.amazon.testBase.WaitStrategy;
import com.amazon.utils.UIMap;



/**
 * Home  page-related operations are segregated into separate methods.
 * June 10, 2022 
 * @author Vasanthakumar
 * @version 1.0
 * @since 1.0
 */



public class HomePageObjects extends TestBase {
	

/**
 * For a single point of contact, all web elements are kept in a properties file.

 */
	
	public static String workingDir = System.getProperty("user.dir");
	public static UIMap uimap = new UIMap(workingDir + "/src/test/resources/WebElements/homePageElements.properties");

//Click on Hamburger Menu
	public void clickOnTheHamburgerMenu() {
		try {
			click(uimap.getLocator("nav_hamburger_menu"), WaitStrategy.PRESENCE, "click On the Hamburger Menu");
		} catch (Exception e) {
			e.getMessage();

		}
	}

	// Click on TV, Appliances and Electronics
	public void clickOnTvAppliancesAndElectronics() {
		try {

			WebElement tvAndElectronics = DriverFactory.getInstance().getDriver().findElement(uimap.getLocator("tv_appliances_electronics"));
			scrollElementIntoView(tvAndElectronics);
			click(uimap.getLocator("tv_appliances_electronics"), WaitStrategy.PRESENCE,"click On TV Appliances and electronics");

		} catch (Exception e) {
			e.getMessage();

		}
	}

	// Click on Televisions
	public void clickOnTelevisions() {
		try {
			click(uimap.getLocator("televisions"), WaitStrategy.PRESENCE, "click On Televisions");
		} catch (Exception e) {
			e.getMessage();

		}
	}

}
