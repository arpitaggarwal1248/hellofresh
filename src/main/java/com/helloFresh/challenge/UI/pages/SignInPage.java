package com.helloFresh.challenge.UI.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

import com.helloFresh.utils.Log;
import com.helloFresh.utils.WaitUtil;


public class SignInPage {


	WebDriver driver;

	public SignInPage(WebDriver driver) {
		ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver, WaitUtil.MaxElementWait);
		PageFactory.initElements(finder, this);
		this.driver = driver;
		WaitUtil.waitForElementVisibilityAndClick(driver, createAccountButton, WaitUtil.MaxElementWait);
	}

	@FindBy(id = "email_create")
	private WebElement emailTextBoxCreateUser;

	@FindBy(id = "SubmitCreate")
	private WebElement createAccountButton;

	@FindBy(id = "email")
	private WebElement email;

	@FindBy(id = "passwd") 
	private WebElement password;

	@FindBy(id = "SubmitLogin")
	private WebElement loginButton;


	public void email(String emailId)
	{
		Log.message("Entering email: "+ emailId);
		email.sendKeys(emailId);
	}

	public void password(String pass)
	{
		Log.message("Entering passoword: "+pass);
		password.sendKeys(pass);
	}

	public void clickLogin()
	{
		Log.message("Clicking login button");
		loginButton.click();
	}

	public void enterEmail(String email)
	{
		emailTextBoxCreateUser.sendKeys(email);
	}

	public void clickCreateAccount()
	{
		createAccountButton.click();
	}

	public CreateAccountForm createAccount(String email)
	{
		Log.message("Creating account");
		enterEmail(email);
		clickCreateAccount();
		return new CreateAccountForm(driver);
	}

	public MyAccountPage login(String email,String pass)
	{
		email(email);
		password(pass);
		clickLogin();
		return new MyAccountPage(driver);
	}
}
