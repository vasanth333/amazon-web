package com.amazon.testBase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.amazon.DriverFactory.DriverFactory;
import com.amazon.utils.Constants;
;
/**
 * Explicit wait factory produces different waits before operating on webelement
 * 
 * June 10, 2022 
 * @author Vasanthakumar
 * @version 1.0
 * @since 1.0
 */
public final class ExplicitWait {
	/**
	 * Private constructor to avoid external instantiation
	 */
	private ExplicitWait() {}

	/**
	 * 
	 * @author Vasanthakumar
	 * June 10, 2022
	 * @param waitstrategy Strategy to be applied to find a webelement {@link com.splitvision.govermaxx.enums.WaitStrategy}
	 * @param by By locator of the webelement
	 * @return webelement Locates and return the webelement
	 */
	public static WebElement performExplicitWait(WaitStrategy waitstrategy, By by) {
		WebElement element = null;
		if(waitstrategy == WaitStrategy.CLICKABLE) {
			element = 	new WebDriverWait(DriverFactory.getInstance().getDriver(), Constants.getExplicitwait())
					.until(ExpectedConditions.elementToBeClickable(by));
		}
		else if(waitstrategy == WaitStrategy.PRESENCE) {
			element =	new WebDriverWait(DriverFactory.getInstance().getDriver(), Constants.getExplicitwait())
					.until(ExpectedConditions.presenceOfElementLocated(by));
		}
		else if(waitstrategy == WaitStrategy.VISIBLE) {
			element =new WebDriverWait(DriverFactory.getInstance().getDriver(), Constants.getExplicitwait())
					.until(ExpectedConditions.visibilityOfElementLocated(by));
		}
		else if(waitstrategy == WaitStrategy.NONE) {
			element = DriverFactory.getInstance().getDriver().findElement(by);
		}
		else if(waitstrategy == WaitStrategy.CLICKABLEBYID) {
			element = 	new WebDriverWait(DriverFactory.getInstance().getDriver(), Constants.getExplicitwait())
					.until(ExpectedConditions.elementToBeClickable(by));
			if (element != null)
				element = DriverFactory.getInstance().getDriver().findElement(by);
		}
		
		return element;
	}
	

}
