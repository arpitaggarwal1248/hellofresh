package com.helloFresh.challenge.UI.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

import com.helloFresh.utils.Log;
import com.helloFresh.utils.WaitUtil;

public class AddressPage {
	
	WebDriver driver;

	public AddressPage(WebDriver driver) {
		ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver, WaitUtil.MaxElementWait);
		PageFactory.initElements(finder, this);
		this.driver = driver;
		WaitUtil.waitForElementVisibilityAndClick(driver, proceedToCheckoutAddr, WaitUtil.MaxElementWait);
	}
	
	@FindBy(name = "processAddress")
	private WebElement proceedToCheckoutAddr;
	
	public ShippingPage addressCheckout()
	{
		Log.message("Clicking proceed to checkout on address page");
		proceedToCheckoutAddr.click();
		return new ShippingPage(driver);
	}

}
