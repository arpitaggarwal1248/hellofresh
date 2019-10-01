package com.helloFresh.challenge.UI.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

import com.helloFresh.utils.Log;
import com.helloFresh.utils.WaitUtil;

public class ShippingPage {
	
	WebDriver driver;

	public ShippingPage(WebDriver driver) {
		ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver, WaitUtil.MaxElementWait);
		PageFactory.initElements(finder, this);
		this.driver = driver;
		WaitUtil.waitForElementVisibilityAndClick(driver,proceedToCheckout, WaitUtil.MaxElementWait);
	}

	
	@FindBy(id = "uniform-cgv")
	private WebElement termsNconditions;
	
	@FindBy(name = "processCarrier")
	private WebElement proceedToCheckout;
	
	public void agreeTermsAndConditions()
	{
		Log.message("Agree for terms and conditions");
		termsNconditions.click();
	}
	
	public void checkout()
	{
		Log.message("Clicking proceed to checkout on shipping page");
		proceedToCheckout.click();
	}
	
	public PaymentPage shippingCheckout()
	{
		agreeTermsAndConditions();
		checkout();
		return new PaymentPage(driver);
	}
}
