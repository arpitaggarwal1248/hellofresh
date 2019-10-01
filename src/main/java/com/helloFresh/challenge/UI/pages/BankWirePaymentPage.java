package com.helloFresh.challenge.UI.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

import com.helloFresh.utils.Log;
import com.helloFresh.utils.WaitUtil;

public class BankWirePaymentPage {

	WebDriver driver;

	public BankWirePaymentPage(WebDriver driver) {
		ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver, WaitUtil.MaxElementWait);
		PageFactory.initElements(finder, this);
		this.driver = driver;
		WaitUtil.waitForElementVisibilityAndClick(driver, confirmOrderButton, WaitUtil.MaxElementWait);
	}

	@FindBy(css = "#cart_navigation button")
	private WebElement confirmOrderButton;

	public OrderConfirmationPage confirmOrder() {
		Log.message("confirming order");
		confirmOrderButton.click();
		return new OrderConfirmationPage(driver);
	}

}
