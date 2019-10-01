package com.helloFresh.challenge.UI.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

import com.helloFresh.utils.Log;
import com.helloFresh.utils.WaitUtil;

public class MyAccountPage {

	WebDriver driver;

	public MyAccountPage(WebDriver driver) {
		ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver, WaitUtil.MaxElementWait);
		PageFactory.initElements(finder, this);
		this.driver = driver;
		WaitUtil.waitForElementVisibilityAndClick(driver,userName, WaitUtil.MaxElementWait);
	}

	
	@FindBy(css = "h1")
	private WebElement heading;
	
	@FindBy(className  = "account")
	private WebElement userName;

	@FindBy(className  = "info-account")
	private WebElement welcomeMessage;

	@FindBy(className = "logout")
	private WebElement logoutButton;

	@FindBy(css="li a[title='Women']")
	private WebElement womenCategory;

	public String getUserName()
	{
		return		userName.getText();
	}
	
	public String getHeading()
	{
		return heading.getText();
	}
	
	public String getMessage()
	{
		return welcomeMessage.getText();
	}

	public void logout()
	{
		logoutButton.click();
	}

	public boolean logoutIsDisplayed()
	{
		return		logoutButton.isDisplayed();
	}

	public CategoryPage clickWomenCategory()
	{
		Log.message("Selecting women category");
		womenCategory.click();
		return new CategoryPage(driver);
	}

}
