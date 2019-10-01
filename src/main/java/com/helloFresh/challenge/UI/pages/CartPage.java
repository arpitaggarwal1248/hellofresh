package com.helloFresh.challenge.UI.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

import com.helloFresh.commonOperations.WebDriverOperations;
import com.helloFresh.utils.Log;
import com.helloFresh.utils.WaitUtil;

public class CartPage {
	
	WebDriver driver;

	public CartPage(WebDriver driver) {
		ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver, WaitUtil.MaxElementWait);
		PageFactory.initElements(finder, this);
		this.driver = driver;
		WaitUtil.waitForElementVisibilityAndClick(driver, proceedToCheckout, WaitUtil.MaxElementWait);
	}
	
	@FindBy(css=".cart_navigation a[title='Proceed to checkout']")
	private WebElement proceedToCheckout;
	
	public AddressPage cartCheckout()
	{
		Log.message("Clicking proceed to checkout on cart page");
		WebDriverOperations.scrollToView(driver, proceedToCheckout, "true");
		proceedToCheckout.click();
		return new AddressPage(driver);
	}
}
