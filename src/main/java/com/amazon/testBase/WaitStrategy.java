package com.amazon.testBase;
/**
 * Enums to restrict the users to choose an appropriate waiting strategy before operating an element.
 * 
 *June 10, 2022 
 * @author Vasanthakumar
 * @version 1.0
 * @since 1.0
 * @see com.ExplicitWait.govermaxx.factories.ExplicitWaitFactory
 * @see com.splitvision.govermaxx.pages.BasePage
 */
public enum WaitStrategy {
	
	
	CLICKABLE,
	PRESENCE,
	VISIBLE,
	CLICKABLEBYID,
	NONE

}
