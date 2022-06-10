package com.amazon.pageObjects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import com.amazon.DriverFactory.DriverFactory;
import com.amazon.DriverFactory.TestBase;
import com.amazon.testBase.WaitStrategy;
import com.amazon.utils.UIMap;

/**
 * Product page-related operations are segregated into separate methods.
 * June 10, 2022 
 * @author Vasanthakumar
 * @version 1.0
 * @since 1.0
 */




public class ProductPageObjects extends TestBase {
	
	/**
	 * For a single point of contact, all web elements are kept in a properties file.

	 */
	public static String workingDir = System.getProperty("user.dir");
	public static UIMap uimap = new UIMap(workingDir + "/src/test/resources/WebElements/productsPageElements.properties");

	
	// Click on Brand Samsung
	public void clickOnBrandSamsung() {
		try {
			WebElement tvAndElectronics = DriverFactory.getInstance().getDriver().findElement(uimap.getLocator("scroll_in_to_brands"));
			scrollElementIntoView(tvAndElectronics);
			click(uimap.getLocator("choose_samsung_brand"), WaitStrategy.PRESENCE, "choose samsung brand");
		} catch (Exception e) {
			e.getMessage();

		}
	}

	// Sort The Price High To Low
	public void sortThePriceHighToLow() {
		try {
			click(uimap.getLocator("sort_menu"), WaitStrategy.PRESENCE, "sort_menu");
			click(uimap.getLocator("price_high_to_low"), WaitStrategy.PRESENCE, "price_high_to_low");

		} catch (Exception e) {
			e.getMessage();

		}
	}

	public void chooseTheItemWithSecondHighestPrice() throws Throwable {
		try {
			List<WebElement> prices = DriverFactory.getInstance().getDriver()
					.findElements(uimap.getLocator("all_products_price_list"));
			Map<WebElement, Integer> map = new HashMap<WebElement, Integer>();
			for (int i = 0; i < prices.size(); i++) {
				if (prices.get(i).getText() != "") {
					map.put(prices.get(i), Integer.parseInt(prices.get(i).getText().replaceAll("[^0-9]", "")));
				}
			}
			for (Map.Entry m : map.entrySet()) {
			}
			List<Map.Entry<WebElement, Integer>> hv = new ArrayList<Map.Entry<WebElement, Integer>>(map.entrySet());
			hv.sort(Map.Entry.comparingByValue());
			for (Map.Entry m : hv) {
			}
			hv.get(hv.size() - 2).getKey().click();

		} catch (NoSuchElementException e) {
			e.getMessage();
		}
	}

	/**
	 * verify About This Item Message
	 * @return 
	 */
	public String verifyAboutThisItemMessage() throws Throwable {

		
		String MainWindow = DriverFactory.getInstance().getDriver().getWindowHandle();
		// To handle all new opened window
		Set<String> s1 = DriverFactory.getInstance().getDriver().getWindowHandles();
		Iterator<String> i1 = s1.iterator();

		// is the main window it will come out of loop.
		while (i1.hasNext()) {
			String ChildWindow = i1.next();
			if (!MainWindow.equalsIgnoreCase(ChildWindow)) {
				DriverFactory.getInstance().getDriver().switchTo().window(ChildWindow);

				if (DriverFactory.getInstance().getDriver().getPageSource().contains("About this item")) {
					WebElement aboutThisItemElement = DriverFactory.getInstance().getDriver().findElement(uimap.getLocator("About_this_item"));
					scrollElementIntoView(aboutThisItemElement);
					String getItemMessage = getText(uimap.getLocator("About_this_item"), WaitStrategy.PRESENCE,"Get About this item Messages");
					System.out.println("About this item message:::" +'\n'+ getItemMessage);
					return getItemMessage;
				}
				else {
					System.out.println("About this item message is not present");
				}

			} 
			
		}	

		return null;

	}
}
