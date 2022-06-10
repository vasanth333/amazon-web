package com.amazon.DriverFactory;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.amazon.utils.ActionEngine;
import com.amazon.utils.PropertiesOperations;


/**
 * 
 * Driver class is responsible for invoking and closing the browsers.
 * 
 * <p>
 * It is also responsible for 
 * setting the driver variable to DriverManager which handles the thread safety for the 
 * webdriver instance.
 * 

 * June 10, 2022 
 * @author Vasanthakumar
 * @version 1.0
 * @since 1.0
 * @see DriverManager
 * @see com.splitvision.govermaxx.tests.BaseTest
 */



/**
 * Invokes a new browser instance and loads the respective URL.
 */
public class TestBase extends ActionEngine {
	BrowserFactory bf = new BrowserFactory();

	@BeforeTest
	public void LaunchApplication() throws Exception {
		String browser = PropertiesOperations.getPropertyValueByKey("browser");
		String url = 	PropertiesOperations.getPropertyValueByKey("url");

		DriverFactory.getInstance().setDriver(bf.createBrowserInstance(browser));
		DriverFactory.getInstance().getDriver().manage().window().maximize();
		DriverFactory.getInstance().getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		DriverFactory.getInstance().getDriver().navigate().to(url);
		 System.out.println("Driver Instance created");

	}

	
	
	
	
	/**
	 * Terminates the browser instance.
	 * Sets the threadlocal to default value, i.e null.
	 * @author Vasanthakumar
	 * June 10 , 2022
	 */	
	
	
	
	
	
	
	@AfterTest
	public void tearDown() {
		//DriverFactory.getInstance().closeBrowser();
	}

}
