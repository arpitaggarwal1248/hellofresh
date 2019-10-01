package com.helloFresh.challenge.UI.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

import com.helloFresh.utils.Log;
import com.helloFresh.utils.WaitUtil;

public class PaymentPage {
	
	WebDriver driver;

	public PaymentPage(WebDriver driver) {
		ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver, WaitUtil.MaxElementWait);
		PageFactory.initElements(finder, this);
		this.driver = driver;
		WaitUtil.waitForElementVisibilityAndClick(driver,bankWire, WaitUtil.MaxElementWait);
	}


	@FindBy(className = "bankwire")
	private WebElement bankWire;
	
	public BankWirePaymentPage selectBankWire()
	{
		Log.message("selecting bank wire as payment mode");
		bankWire.click();
		return new BankWirePaymentPage(driver);
	}
}
