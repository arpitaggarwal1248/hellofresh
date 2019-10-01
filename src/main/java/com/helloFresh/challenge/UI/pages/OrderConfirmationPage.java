package com.helloFresh.challenge.UI.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

import com.helloFresh.utils.WaitUtil;

public class OrderConfirmationPage {

	WebDriver driver;

	public OrderConfirmationPage(WebDriver driver) {
		ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver, WaitUtil.MaxElementWait);
		PageFactory.initElements(finder, this);
		this.driver = driver;
		WaitUtil.waitForElementVisibilityAndClick(driver,orderSummary, WaitUtil.MaxElementWait);
	}

	@FindBy(xpath = "//li[@class='step_done step_done_last four']")
	private WebElement shippingStep;

	@FindBy(xpath = "//li[@id='step_end' and @class='step_current last']")
	private WebElement paymentStep;

	@FindBy (xpath = "//*[@class='cheque-indent']/strong")
	private WebElement orderSummary;

	@FindBy(css= "h1")
	private WebElement heading;
	
	public String getHeading()
	{
		return heading.getText();
	}
	
	public String getOrderSummary()
	{
		return orderSummary.getText();
	}

	public boolean isShippingStepVisible()
	{
		return shippingStep.isDisplayed();
	}

	public boolean isPaymentStepVisible()
	{
		return paymentStep.isDisplayed();
	}
}
