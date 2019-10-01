package com.helloFresh.challenge.UI.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

import com.helloFresh.utils.Log;
import com.helloFresh.utils.WaitUtil;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver, WaitUtil.MaxElementWait);
		PageFactory.initElements(finder, this);
		this.driver = driver;
		WaitUtil.waitForElementVisibilityAndClick(driver,loginButton, WaitUtil.MaxElementWait);
	}

	@FindBy(className = "login")
	private WebElement loginButton;

	
	public SignInPage goToLoginPage()
	{
		Log.message("Clicking on sign in button");
		loginButton.click();
		return new SignInPage(driver);
	}

}
