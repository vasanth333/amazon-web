package com.amazon.testListeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.amazon.utils.PropertiesOperations;

/**
 * Implements {@link IRetryAnalyzer}.<p>
 * Helps in rerunning the failed tests.<p>
 * June 10, 2022 
 * @author Vasanthakumar
 * @version 1.0
 * @since 1.0
 */
public class TestRetryAnalyzer implements IRetryAnalyzer {
	/**
	 * Return true when needs to be retried and false otherwise.
	 * Maximum will retry for one time.
	 * Retry will happen if user desires to and set the value in the property file
	 */
	int counter = 1;
	int retryMaxLimit  = Integer.valueOf(PropertiesOperations.getPropertyValueByKey("retryCount"));
	
	@Override
	public boolean retry(ITestResult result) {
		if(counter<retryMaxLimit) {
			counter++;
			return true;
		}
		return false;
	}

}
