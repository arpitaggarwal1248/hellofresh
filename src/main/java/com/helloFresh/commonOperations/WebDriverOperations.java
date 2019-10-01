package com.helloFresh.commonOperations;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebDriverOperations {

	public static void scrollToView(WebDriver driver,WebElement element,String inView)
	{
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView("+inView+");", element);
	}

	public static void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}

	public static  boolean isElementPresent(WebElement element)
	{
		try {
			element.isEnabled();	
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static String getCurrentPageUrl(WebDriver driver)
	{
		return driver.getCurrentUrl();
	}

	public static void clearTextAndSendKeys(WebElement element,String data)
	{
		element.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), data);
	}

	public static void copyTextFromWebElement(WebElement element,WebDriver driver)
	{
		element.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END));
		new Actions(driver).keyDown( Keys.COMMAND ).sendKeys( "C" ).keyUp( Keys.COMMAND ).build().perform();
	}


	public static String selectByValue(WebElement element,String data)
	{
		Select sel=new Select(element);
		sel.selectByValue(data);
		return		sel.getFirstSelectedOption().getText();
	}

	public static String selectByVisibleText(WebElement element,String data)
	{
		Select sel=new Select(element);
		sel.selectByVisibleText(data);
		return		sel.getFirstSelectedOption().getText();
	}
	
	public static void clearCookies(WebDriver driver)
	{
		driver.manage().deleteAllCookies();
	}


}
