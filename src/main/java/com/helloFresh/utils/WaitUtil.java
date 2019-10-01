package com.helloFresh.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class WaitUtil {

	public static final int MaxElementWait = 10;


	
	public static synchronized void waitForElementVisibilityAndClick(WebDriver driver,WebElement element, int timeOut) {
	    Wait<WebDriver> wait = null;
	    try {
	        wait = new FluentWait<WebDriver>((WebDriver) driver).withTimeout(timeOut, TimeUnit.SECONDS).pollingEvery(1,
	                TimeUnit.SECONDS);
	        wait.until(ExpectedConditions.visibilityOf(element));
	      //  element.click();
	    }catch(Exception e) {
	    }
	}

	
}
