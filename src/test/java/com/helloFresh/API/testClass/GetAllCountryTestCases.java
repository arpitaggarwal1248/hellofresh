package com.helloFresh.API.testClass;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.helloFresh.challenge.API.apiRequests.CountryApiRequests;
import com.helloFresh.challenge.API.country.getAll.response.GetAllResponse;
import com.helloFresh.listeners.TestListener;

@Listeners(TestListener.class)
public class GetAllCountryTestCases {


	@Test
	public void testForCountry()
	{
		GetAllResponse getAllResponse=CountryApiRequests.getAllRequest();
		SoftAssert softAssert=new SoftAssert();
		if(getAllResponse.getRestResponse().getResult()==null || getAllResponse.getRestResponse().getResult().size()==0)
			Assert.fail("Country list is empty");
		softAssert.assertTrue(getAllResponse.getRestResponse().getResult().stream().anyMatch(country-> country.getAlpha2Code().equals("US")));
		softAssert.assertTrue(getAllResponse.getRestResponse().getResult().stream().anyMatch(country-> country.getAlpha2Code().equals("GB")));
		softAssert.assertTrue(getAllResponse.getRestResponse().getResult().stream().anyMatch(country-> country.getAlpha2Code().equals("DE")));
		softAssert.assertAll();
	}

}
