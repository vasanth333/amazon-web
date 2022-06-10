
package com.amazon.DriverFactory;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * June 10, 2022
 * 
 * @author Vasanthakumar
 * @version 1.0
 * @since 1.0
 */

public class BrowserFactory {
	/**
	 * 
	 * @author Vasanthakumar June 10, 2022
	 * @param browser
	 * @param version
	 * @return
	 * @throws MalformedURLException TODO Remove hardcoded value of grid url
	 */

	// create webdriver object for given browser
	public WebDriver createBrowserInstance(String browser) throws MalformedURLException {
		WebDriver driver = null;
		// RemoteWebDriver driver = null;
		if (browser.equalsIgnoreCase("Chrome")) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("firefox")) {
			FirefoxOptions options = new FirefoxOptions();
			FirefoxProfile profile = new FirefoxProfile();
			profile.setAcceptUntrustedCertificates(true);
			profile.setAssumeUntrustedCertificateIssuer(false);
			options.setCapability(FirefoxDriver.PROFILE, profile);
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
			System.out.println("Firefox started");

		}
		if (browser.equalsIgnoreCase("ie")) {

			WebDriverManager.iedriver().setup();
			InternetExplorerOptions iOptions = new InternetExplorerOptions();
			iOptions.addCommandSwitches("-private");

			driver = new InternetExplorerDriver(iOptions);
		}
		return driver;
	}

}
