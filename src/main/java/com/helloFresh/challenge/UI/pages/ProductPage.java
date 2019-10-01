package com.helloFresh.challenge.UI.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

import com.helloFresh.utils.Log;
import com.helloFresh.utils.WaitUtil;

public class ProductPage {
	
	WebDriver driver;

	public ProductPage(WebDriver driver) {
		ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver, WaitUtil.MaxElementWait);
		PageFactory.initElements(finder, this);
		this.driver = driver;
		WaitUtil.waitForElementVisibilityAndClick(driver,addToCart, WaitUtil.MaxElementWait);
	}
	
	@FindBy(id = "add_to_cart")
	private WebElement addToCart;
	
	@FindBy(css="a[title='Proceed to checkout'] span")
	private WebElement proceedToCheckout;
	
	public void addProductToCart()
	{
		Log.message("adding product to cart");
		addToCart.click();
	}
	
	public CartPage checkout()
	{
		Log.message("Clicking proceed to checkout");
		WaitUtil.waitForElementVisibilityAndClick(driver,proceedToCheckout, WaitUtil.MaxElementWait);
		proceedToCheckout.click();
		return new CartPage(driver);
	}
	
	public CartPage addProductAndCheckout()
	{
		addProductToCart();
		return checkout();
	}

}
