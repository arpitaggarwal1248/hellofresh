package com.helloFresh.driverFactory;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.safari.SafariDriver;

import com.google.common.io.Resources;
import com.helloFresh.cache.CommonCache;
import com.helloFresh.constants.Browsers;
import com.helloFresh.constants.Platforms;
import com.helloFresh.constants.WebDriverConstants;
import com.helloFresh.utils.ConfigProperties;
import com.helloFresh.utils.Log;



	public class WebdriverFactory {



		private static WebDriver webDriver = null;

		/*
		 * Factory method to return a RemoteWebDriver instance given the url of the
		 * Grid hub and a Browser instance.
		 * 
		 * @param gridHubUrl : grid hub URI
		 * 
		 * @param browser : Browser object containing info around the browser to hit
		 * 
		 * @param username : username for BASIC authentication on the page to test
		 * 
		 * @param password : password for BASIC authentication on the page to test
		 * 
		 * @return RemoteWebDriver
		 */
		public static WebDriver getInstance(Browsers browser) {

			WebDriver webDriver = null;
			DesiredCapabilities capability = new DesiredCapabilities();
			capability.setJavascriptEnabled(true);

			String gridHubUrl=new ConfigProperties(CommonCache.getEnv()).fetchConfig(WebDriverConstants.GRIDURL);
			try {

				if (gridHubUrl == null || gridHubUrl.length() == 0) 
					gridHubUrl=WebDriverConstants.DefaultGridURL;


				if (Browsers.CHROME.equals(browser)) {
					capability = DesiredCapabilities.chrome();
					
				} else if (Browsers.FIREFOX.equals(browser)) {
					capability = DesiredCapabilities.firefox();
					capability.setCapability(CapabilityType.TAKES_SCREENSHOT, true);
					
				} else if (Browsers.INTERNET_EXPLORER.equals(browser)) {

					capability = DesiredCapabilities.internetExplorer();
					capability.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
					
				} else if (Browsers.SAFARI.equals(browser)) {
					capability = DesiredCapabilities.safari();
					
				} else {

					capability = DesiredCapabilities.htmlUnit();
					// HTMLunit Check
					webDriver = new HtmlUnitDriver(true);

					return webDriver;
				}

				// Create Remote WebDriver
					webDriver = new RemoteWebDriver(new URL(gridHubUrl), capability);

				return webDriver;
			}
			catch (UnreachableBrowserException | MalformedURLException e) {
				Log.message("Hub is down or not running");
			}
			// In case there is no Hub
			return getDriverInstance(browser);
		}

		/*
		 * Factory method to return a WebDriver instance given the browser to hit
		 * 
		 * @param browser : String representing the local browser to hit
		 * 
		 * @param username : username for BASIC authentication on the page to test
		 * 
		 * @param password : password for BASIC authentication on the page to test
		 * 
		 * @return WebDriver instance
		 */

		private static WebDriver getDriverInstance(Browsers browser) {


			if (Browsers.CHROME.equals(browser)) {
				if(Platforms.getCurrentPlatform().equals(Platforms.WINDOWS))
					System.setProperty(WebDriverConstants.CHROMEDRIVERVARIABLE, Resources.getResource(WebDriverConstants.CHROMEDRIVERWINDOWS).getPath());
				webDriver = new ChromeDriver();

			} else if (Browsers.FIREFOX.equals(browser)) {

				FirefoxProfile ffProfile = new FirefoxProfile();

				webDriver = new FirefoxDriver(ffProfile);

			} else if (Browsers.INTERNET_EXPLORER.equals(browser)) {
				webDriver = new InternetExplorerDriver();

			} else if (Browsers.OPERA.equals(browser)) {
				webDriver = new OperaDriver();

			} else if (Browsers.SAFARI.equals(browser)) {
				webDriver = new SafariDriver();

			} else {
				// HTMLunit Check
				webDriver = new HtmlUnitDriver(true);
			}

			return webDriver;
		}
}
