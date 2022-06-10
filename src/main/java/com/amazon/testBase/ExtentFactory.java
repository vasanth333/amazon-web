package com.amazon.testBase;

import com.aventstack.extentreports.ExtentTest;

/**
 * ExtentManager class helps to achieve thread safety for the {@link com.aventstack.extentreports.ExtentTest} instance.
 * 
 * June 10, 2022 
 * @author Vasanthakumar
 * @version 1.0
 * @since 1.0
 * @see Driver
 */



public class ExtentFactory {
	/**
	 * Private constructor to avoid external instantiation
	 */
	private ExtentFactory() {
		
	}
	
	private static ExtentFactory instance  = new ExtentFactory();
	
	public static ExtentFactory getInstance() {
		return instance;
	}
	
	
	/**
	 * Returns the thread safe {@link com.aventstack.extentreports.ExtentTest} instance fetched from ThreadLocal variable.
	 * @author Vasanthakumar
	 * JUne 10, 2022
	 * @return Thread safe {@link com.aventstack.extentreports.ExtentTest} instance.
	 */
	
	ThreadLocal<ExtentTest> extent = new ThreadLocal<ExtentTest>();
	public ExtentTest getExtent() {
		return extent.get();
	}
	
	
	
	/**
	 * Set the {@link com.aventstack.extentreports.ExtentTest} instance to thread local variable
	 * 
	 * @author Vasanthakumar
	 * JUne 10, 2022
	 * @param test {@link com.aventstack.extentreports.ExtentTest} instance that needs to saved from Thread safety issues.<p>
	 */
	
	public void setExtent(ExtentTest extentTestObject) {
		extent.set(extentTestObject);
	}
	
	
	
	/**
	 * Calling remove method on Threadlocal variable ensures to set the default value to Threadlocal variable.
	 * It is much safer than assigning null value to ThreadLocal variable.
	 * @author Vasanthakumar
	 * JUne 10, 2022
	 */
	
	
	
	public void removeExtentObject() {
		extent.remove();
	}
}
