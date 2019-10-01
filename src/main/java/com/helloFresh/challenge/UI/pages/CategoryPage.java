package com.helloFresh.challenge.UI.pages;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

import com.helloFresh.utils.Log;
import com.helloFresh.utils.WaitUtil;

public class CategoryPage {


	WebDriver driver;

	public CategoryPage(WebDriver driver) {
		ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver, WaitUtil.MaxElementWait);
		PageFactory.initElements(finder, this);
		this.driver = driver;
		WaitUtil.waitForElementVisibilityAndClick(driver, productList.get(0), WaitUtil.MaxElementWait);
	}

	@FindBy(css=".right-block .product-name")
	private List<WebElement> productList;

	public List<WebElement> getProductList()
	{
		return	productList;
	}

	public int getTotalProducts()
	{
		return productList.size();
	}

	public ProductPage selectProductByName(String productName)
	{
		List<WebElement> prodList=		getProductList().stream().filter(x-> x.getAttribute("title").equals(productName)).collect(Collectors.toList());
		prodList.get(0).click();	
		return new ProductPage(driver);
	}

	public ProductPage selectProduct(int num)
	{

		if(num<getTotalProducts()) {
			Log.message("Selecting product");
			getProductList().get(num).click();
		}

		return new ProductPage(driver);
	}

}
