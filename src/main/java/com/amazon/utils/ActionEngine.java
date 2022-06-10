package com.amazon.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.amazon.DriverFactory.DriverFactory;
import com.amazon.testBase.ExplicitWait;
import com.amazon.testBase.ExtentFactory;
import com.amazon.testBase.WaitStrategy;
import com.aventstack.extentreports.Status;




public class ActionEngine {

	public void waitForVisibility(WebElement e, int timeout) {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getDriver(), timeout);
		wait.until(ExpectedConditions.visibilityOf(e));

	}

	// Scroll in to web element
	public void scrollElementIntoView(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].scrollIntoView();", element);
	}

	/**
	 * Locates element by given wait strategy, performs the clicking operation on webelement and
	 * writes the pass even to the extent report.
	 * @author Vasanthakumar
	 * June 10, 2022
	 * @param by By Locator of the webelement
	 * @param waitstrategy Strategy to find webelement. Known  strategies {@link com.tmb.enums.WaitStrategy}
	 * @param elementname Name of the element that needs to be logged in the report.
	 */

	
	// Customized sendkeys method-> To log sendkeys message for every occ.
	public void sendKeys(By by, WaitStrategy waitstrategy, String elementname, String valueToBeSent) {
		try {
			WebElement element = ExplicitWait.performExplicitWait(waitstrategy, by);
			element.sendKeys(valueToBeSent);
			// log success message in exgent report
			ExtentFactory.getInstance().getExtent().log(Status.PASS, elementname + valueToBeSent);
		} catch (Exception e) {
			// log failure in extent
			ExtentFactory.getInstance().getExtent().log(Status.FAIL,
					"Value enter in field: " + elementname + " is failed due to exception: " + e);
		}
	}

	// custom click method to log evey click action in to extent report
	public void click(By by, WaitStrategy waitstrategy, String elementname) {
		try {
			WebElement element = ExplicitWait.performExplicitWait(waitstrategy, by);
			element.click();
			// log success message in extent report
			ExtentFactory.getInstance().getExtent().log(Status.PASS, elementname);
		} catch (Exception e) {
			// log failure in extent
			ExtentFactory.getInstance().getExtent().log(Status.FAIL, "Unable to click on field: " + elementname + e);
		}
	}

	// custom mouseHover
	public void moveToElement_custom(WebElement element, String elementname) {
		try {
			JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
			executor.executeScript("arguments[0].scrollIntoView(true);", element);
			Actions actions = new Actions(DriverFactory.getInstance().getDriver());
			actions.moveToElement(element).build().perform();
			ExtentFactory.getInstance().getExtent().log(Status.PASS, elementname);
			Thread.sleep(1000);
		} catch (Exception e) {
			ExtentFactory.getInstance().getExtent().log(Status.FAIL, "Unable to hover mouse on field: " + e);

		}
	}

	// check if element is Present
	public boolean isElementPresent(WebElement element, String elementname) {
		boolean flag = false;
		try {
			flag = element.isDisplayed();
			ExtentFactory.getInstance().getExtent().log(Status.PASS, elementname + flag);
			return flag;
		} catch (Exception e) {
			ExtentFactory.getInstance().getExtent().log(Status.FAIL,
					"Checking for presence of field: " + elementname + " not tested due to exception: " + e);
			return flag;
		}
	}

	// Select dropdown value value by visibleText
	public void selectDropDownByVisibleText_custom(WebElement element, String fieldName, String ddVisibleText)
			throws Throwable {
		try {
			Select s = new Select(element);
			s.selectByVisibleText(ddVisibleText);
			ExtentFactory.getInstance().getExtent().log(Status.PASS,
					fieldName + "==> Dropdown Value Selected by visible text: " + ddVisibleText);
		} catch (Exception e) {
			ExtentFactory.getInstance().getExtent().log(Status.FAIL,
					"Dropdown value not selected for field: " + fieldName + "  due to exception: " + e);
		}
	}

	// String Asserts
	public void assertEqualsString(String expvalue, String actualValue, String elementname) throws Throwable {
		try {
			if (actualValue.equals(expvalue)) {
				ExtentFactory.getInstance().getExtent().log(Status.PASS, "String Assertion is successful on field "
						+ elementname + " Expected value was: " + expvalue + " actual value is: " + actualValue);
			} else {
				ExtentFactory.getInstance().getExtent().log(Status.FAIL, "String Assertion FAILED on field "
						+ elementname + " Expected value was: " + expvalue + " actual value is: " + actualValue);
				Assert.assertTrue(false);
			}
		} catch (Exception e) {
			Assert.assertTrue(false, e.toString());
		}
	}

	// Get text from webelement
	public String getText(By by, WaitStrategy waitstrategy, String elementname) {
		WebElement element = ExplicitWait.performExplicitWait(waitstrategy, by);

		String text = "";
		try {
			text = element.getText();
			ExtentFactory.getInstance().getExtent().log(Status.PASS, elementname + text);
			return text;
		} catch (Exception e) {
			ExtentFactory.getInstance().getExtent().log(Status.FAIL,
					elementname + "==> Text not retried due to exception: " + e);

		}
		return text;
	}

}
