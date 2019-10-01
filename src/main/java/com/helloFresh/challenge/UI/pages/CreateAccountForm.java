package com.helloFresh.challenge.UI.pages; 


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

import com.helloFresh.challenge.UI.dataHelper.UserDetails;
import com.helloFresh.commonOperations.WebDriverOperations;
import com.helloFresh.utils.DateUtil;
import com.helloFresh.utils.Log;
import com.helloFresh.utils.RandomUtil;
import com.helloFresh.utils.WaitUtil; 



public class CreateAccountForm {

	public enum Gender {MALE,FEMALE};

	WebDriver driver; 


	public CreateAccountForm(WebDriver driver) {
		ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver, WaitUtil.MaxElementWait);
		PageFactory.initElements(finder, this);
		this.driver = driver;
		WaitUtil.waitForElementVisibilityAndClick(driver, maleRadio, WaitUtil.MaxElementWait);
	}

	@FindBy(id = "id_gender2")
	private WebElement femaleRadio; 

	@FindBy(id = "id_gender1")
	private WebElement maleRadio; 

	@FindBy(id = "customer_firstname")
	private WebElement firstName; 

	@FindBy(id = "customer_lastname")
	private WebElement lastName; 

	@FindBy(id = "passwd")
	private WebElement password; 

	@FindBy(id = "days")
	private WebElement dobDays; 

	@FindBy(id = "months")
	private WebElement dobMonth; 

	@FindBy(id = "years") 
	private WebElement dobYear; 

	@FindBy(id = "company")
	private WebElement company; 

	@FindBy(id = "address1")
	private WebElement address1; 

	@FindBy(id = "address2")
	private WebElement address2; 

	@FindBy(id = "city")
	private WebElement city; 

	@FindBy(id = "id_state")
	private WebElement state; 

	@FindBy(id = "postcode")
	private WebElement postalCode; 

	@FindBy(id = "other")
	private WebElement additionalInfo; 

	@FindBy(id = "phone") 
	private WebElement phone; 

	@FindBy(id = "phone_mobile")
	private WebElement  mobile; 

	@FindBy(id = "alias")
	private WebElement addressAlias; 

	@FindBy(id = "submitAccount")
	private WebElement registerButton; 

	public void enterPostalCode(String postal)
	{
		postalCode.sendKeys(postal);
	}

	public void selectFemale()
	{
		femaleRadio.click();
	}

	public void selectMale()
	{
		maleRadio.click();
	}

	public void selectGender(Gender gender)
	{
		if(gender.equals(Gender.FEMALE))
			selectFemale();
		else
			selectMale();
	}

	public void enterName(String name)
	{
		firstName.sendKeys(name);
	}

	public void enterLastName(String name)
	{
		lastName.sendKeys(name);
	}

	public void enterPassword(String pass)
	{
		password.sendKeys(pass);
	}

	public void selectDobDate(String date)
	{
		WebDriverOperations.selectByValue(dobDays, date);
	}

	public void selectDobMonth(String month)
	{
		WebDriverOperations.selectByValue(dobMonth, month);
	}

	public void selectDobYear(String year)
	{
		WebDriverOperations.selectByValue(dobYear, year);
	}

	public void selectDob(String date,String month,String year)
	{
		selectDobDate(date);
		selectDobMonth(month);
		selectDobYear(year);
	}

	public void enterCompanyname(String companyName)
	{
		company.sendKeys(companyName);
	}

	public void enterAddress(String address)
	{
		address1.sendKeys(address);
	}

	public void enterAddress2(String address)
	{
		address2.sendKeys(address);
	}

	public void enterCity(String cityName)
	{
		city.sendKeys(cityName);
	}

	public void enterAdditionalInfo(String info)
	{
		additionalInfo.sendKeys(info);
	}

	public void enterMobile(String mobileNumber)
	{
		mobile.sendKeys(mobileNumber);
	}

	public void enterPhone(String phoneNumber)
	{
		phone.sendKeys(phoneNumber);
	}

	public void enterAliasAdd(String aliasAddr)
	{
		addressAlias.sendKeys(aliasAddr);
	}

	public MyAccountPage clickRegister()
	{
		Log.message("Clicking register button");
		registerButton.click();
		return new MyAccountPage(driver);
	}

	public String enterState(int state)
	{
		return WebDriverOperations.selectByValue(this.state, Integer.toString(state));
	}

	public void enterState(String stateName)
	{
		WebDriverOperations.selectByVisibleText(state, stateName);
	}

	public UserDetails enterUserDefaultDetails()
	{
		Log.message("Registering user with default details");
		String timeStamp=DateUtil.getTimeStamp();
		UserDetails userDetails=new UserDetails();


		userDetails.setGender(Gender.MALE);
		selectGender(Gender.MALE);

		String name=RandomUtil.generateRandomName();
		enterName(name);
		userDetails.setName(name);

		String lastName=RandomUtil.generateRandomName();
		enterLastName(lastName);
		userDetails.setLastName(lastName);

		String password=RandomUtil.generateRandomName()+timeStamp;
		enterPassword(password);
		userDetails.setPassword(password);

		String companyName="company"+timeStamp;
		enterCompanyname(companyName);
		userDetails.setCompany(companyName);

		String address="address "+timeStamp;
		enterAddress(address);
		userDetails.setAddress(address);

		String address2="address 2, "+timeStamp;
		enterAddress2(address2);
		userDetails.setAddress2(address2);

		String city="city"+timeStamp;
		enterCity(city);
		userDetails.setCity(city);

		userDetails.setState(enterState(RandomUtil.generateRandomNumber(1, 50)));

		String postal=Integer.toString(RandomUtil.generateRandomNumber(10000, 99999));
		enterPostalCode(postal);
		userDetails.setPostalCode(postal);

		String additionalInfo="additional Info "+timeStamp; 
		enterAdditionalInfo(additionalInfo);
		userDetails.setAdditionalInfo(additionalInfo);

		String phone=RandomUtil.generateRandomMobileNumber();
		enterPhone(phone);
		userDetails.setPhone(phone);

		String mobile=RandomUtil.generateRandomMobileNumber();
		enterMobile(mobile);
		userDetails.setMobile(mobile);

		String alias="address, "+timeStamp;
		enterAliasAdd(alias);
		userDetails.setAlias(alias);

		return userDetails;
	}

}
