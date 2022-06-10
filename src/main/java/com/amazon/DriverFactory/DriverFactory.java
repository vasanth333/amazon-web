
package com.amazon.DriverFactory;

import org.openqa.selenium.WebDriver;

/**
 * DriverManager class helps to achieve thread safety for the
 * {@link org.openqa.selenium.WebDriver} instance.
 * 
 * June 10, 2022
 * 
 * @author Vasanthakumar
 * @version 1.0
 * @since 1.0
 * @see Driver
 */

public class DriverFactory {

	/**
	 * Singleton design Pattern 
	 * Private constructor to avoid external instantiation
	 */
	private DriverFactory() {

	}

	private static DriverFactory instance = new DriverFactory();

	public static DriverFactory getInstance() {
		return instance;
	}

	
	
	/**
	 * factory design pattern --> define separate factory methods for creating
	 * objects and create objects by calling that methods
	 */

	ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	/**
	 * Returns the thread safe {@link org.openqa.selenium.WebDriver} instance
	 * fetched from ThreadLocal variable.
	 * 
	 * @author Vasanthakumar June 10, 2022
	 * @return {@link org.openqa.selenium.WebDriver} instance.
	 */

	public WebDriver getDriver() {
		return driver.get();
	}
	
	
	
	
	
	/**
	 * Set the WebDriver instance to thread local variable
	 * 
	 * @author Vasanthakumar
	 * June 10, 2022
	 * @param driverref {@link org.openqa.selenium.WebDriver} instance that needs to saved from Thread safety issues.<p>
	 */
	public void setDriver(WebDriver driverParm) {
		driver.set(driverParm);
	}

	
	
	
	
	/**
	 * Calling remove method on Threadlocal variable ensures to set the default value to Threadlocal variable.
	 * It is much safer than assigning null value to ThreadLocal variable.
	 * @author Vasanthakumar
	 * June 10, 2022
	 */
	
	
	
	
	public void closeBrowser() {
		driver.get().quit();
		driver.remove();
	}
}
