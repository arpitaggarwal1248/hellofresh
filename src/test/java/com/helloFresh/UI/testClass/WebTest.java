package com.helloFresh.UI.testClass;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.helloFresh.cache.CommonCache;
import com.helloFresh.cache.ProductCache;
import com.helloFresh.challenge.UI.dataHelper.UserDetails;
import com.helloFresh.challenge.UI.pages.CategoryPage;
import com.helloFresh.challenge.UI.pages.CreateAccountForm;
import com.helloFresh.challenge.UI.pages.HomePage;
import com.helloFresh.challenge.UI.pages.MyAccountPage;
import com.helloFresh.challenge.UI.pages.OrderConfirmationPage;
import com.helloFresh.challenge.UI.pages.ProductPage;
import com.helloFresh.challenge.UI.pages.SignInPage;
import com.helloFresh.commonOperations.WebDriverOperations;
import com.helloFresh.constants.Browsers;
import com.helloFresh.constants.UIConstants;
import com.helloFresh.constants.YamlConstants;
import com.helloFresh.driverFactory.WebdriverFactory;
import com.helloFresh.listeners.TestListener;
import com.helloFresh.utils.ConfigProperties;
import com.helloFresh.utils.Log;
import com.helloFresh.utils.RandomUtil;

@Listeners(TestListener.class)
public class WebTest {

	private String homePageUrl=null;
	private Map<String,String>map=null;
	SignInPage signIn=	null;

	public void navigateToLoginPage(WebDriver driver)
	{
		Log.message("Opening homepage");
		driver.get(homePageUrl);
		WebDriverOperations.maximizeWindow(driver);
		HomePage homePage=new HomePage(driver);
		signIn=	homePage.goToLoginPage();
	}
	
	@BeforeTest
	public void initialise()
	{
		map=new ConfigProperties(CommonCache.getEnv()).getMapOfConfigFile();
		homePageUrl=map.get(UIConstants.ApplicationEndPoint);
	}
	@Test(enabled = true)
	public void signInTest() throws Exception
	{
		WebDriver driver=null;
		try {
			driver=	WebdriverFactory.getInstance(Browsers.CHROME);
			navigateToLoginPage(driver);
			String email=RandomUtil.generateRandomEmailId();
			Log.message("Creating account with email: "+email);
			CreateAccountForm createAccount=  signIn.createAccount(email);
			UserDetails userDetail=	createAccount.enterUserDefaultDetails();
			MyAccountPage myaccountPage=createAccount.clickRegister();

			Log.message("Verifying details");
			assertEquals(myaccountPage.getHeading(), "MY ACCOUNT");
			assertEquals(myaccountPage.getUserName(), userDetail.getName() + " " + userDetail.getLastName());
			assertTrue(myaccountPage.getMessage().contains("Welcome to your account."));
			assertTrue(myaccountPage.logoutIsDisplayed());
			assertTrue(WebDriverOperations.getCurrentPageUrl(driver).contains("controller=my-account"));
		} catch (Exception e) {
			Log.exception(e, driver);
		}
		finally {
			if(driver!=null)
				driver.quit();
		}

	}

	@Test(enabled = true)
	public void logInTest() throws Exception
	{
		WebDriver driver=null;
		try {
			driver=	WebdriverFactory.getInstance(Browsers.CHROME);
			navigateToLoginPage(driver);
			String fullName = map.get(UIConstants.User);
			MyAccountPage myAccountPage	=signIn.login(map.get(UIConstants.Email), map.get(UIConstants.Password));

			Log.message("Verifying details");
			assertEquals(myAccountPage.getHeading(),"MY ACCOUNT");
			assertEquals(myAccountPage.getUserName(),fullName);
			assertTrue(myAccountPage.getMessage().contains("Welcome to your account."));
			assertTrue(myAccountPage.logoutIsDisplayed());
			assertTrue(WebDriverOperations.getCurrentPageUrl(driver).contains("controller=my-account"));
		} catch (Exception e) {
			Log.exception(e, driver);
		}
		finally {
			if(driver!=null)
				driver.quit();
		}
	}

	@Test(enabled = true)
	public void checkoutTest() throws Exception {
		WebDriver driver=null;
		try {
			driver=	WebdriverFactory.getInstance(Browsers.CHROME);
			navigateToLoginPage(driver);
			MyAccountPage myAccountPage	=signIn.login(map.get(UIConstants.Email), map.get(UIConstants.Password));
			CategoryPage categoryPage=		myAccountPage.clickWomenCategory();
			String productName=ProductCache.getProductDetails(CommonCache.getEnv(), YamlConstants.WomenCateogry).getProductName();
			ProductPage productPage=	categoryPage.selectProductByName(productName);

			OrderConfirmationPage orderpage= productPage.addProductAndCheckout()
					.cartCheckout()
						.addressCheckout()
							.shippingCheckout()
								.selectBankWire()
									.confirmOrder();

			Log.message("Verifying details");
			assertEquals("ORDER CONFIRMATION", orderpage.getHeading());
			assertTrue(orderpage.isShippingStepVisible());
			assertTrue(orderpage.isPaymentStepVisible());
			assertTrue(orderpage.getOrderSummary().contains("Your order on My Store is complete."));
			assertTrue(WebDriverOperations.getCurrentPageUrl(driver).contains("controller=order-confirmation"));

		} catch (Exception e) {
			Log.exception(e, driver);
		}
		finally {
			if(driver!=null)
				driver.quit();
		}
	}
}
