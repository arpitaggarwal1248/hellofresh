package com.helloFresh.API.testClass;

import java.util.List;
import java.util.stream.Collectors;

import org.testng.Assert;
import org.testng.annotations.Guice;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.helloFresh.API.dataProvider.CountryApiDataProvider;
import com.helloFresh.challenge.API.apiRequests.CountryApiRequests;
import com.helloFresh.challenge.API.country.getAll.response.GetAllResponse;
import com.helloFresh.challenge.API.country.getAll.response.Result;
import com.helloFresh.challenge.API.country.iso2Code.response.Iso2CodeResponse;
import com.helloFresh.listeners.TestListener;
import com.helloFresh.utils.Log;


@Guice
@Listeners(TestListener.class)
public class Iso2CodeTestCases {

	//@Test( CountryApiDataProvider.class , dataProvider = "getAllCountries") -- To test for all the countries
	@Test(dataProviderClass = CountryApiDataProvider.class ,dataProvider = "getSpecificCountry")
	public void testVerifyCountry(String countryCode)
	{
		Log.message("CountryCode: "+countryCode);
		GetAllResponse getAllResponse=CountryApiRequests.getAllRequest();
		Iso2CodeResponse iso2CodeResponse=CountryApiRequests.iso2CodeRequest(countryCode);
		List<Result> response=		getAllResponse.getRestResponse().getResult().stream().filter(country-> country.getAlpha2Code().equalsIgnoreCase(countryCode)).collect(Collectors.toList());
		if(response.size()==0)
			Assert.fail("No data found for country: "+countryCode);
		SoftAssert softAssert=new SoftAssert();
		softAssert.assertEquals(iso2CodeResponse.getRestResponse().getResult().getName(),response.get(0).getName(),"country name is incorrect for country code "+countryCode);
		softAssert.assertEquals(iso2CodeResponse.getRestResponse().getResult().getAlpha2Code(),response.get(0).getAlpha2Code(),"alpha2 code is incorrect for country code "+countryCode);
		softAssert.assertEquals(iso2CodeResponse.getRestResponse().getResult().getAlpha3Code(),response.get(0).getAlpha3Code(),"alpha3 code is incorrect for country code "+countryCode);
		softAssert.assertEquals(iso2CodeResponse.getRestResponse().getMessages().get(0), "Country found matching code ["+response.get(0).getAlpha2Code()+"].");
		softAssert.assertAll();
	}

	@Test(dataProviderClass = CountryApiDataProvider.class ,dataProvider = "invalidCountryCodes")
	public void testVerifyInvalidCountryCodes(String countryCode)
	{
		Log.message("CountryCode: "+countryCode);
		Iso2CodeResponse iso2CodeResponse=CountryApiRequests.iso2CodeRequest(countryCode);
		Assert.assertEquals(iso2CodeResponse.getRestResponse().getMessages().get(0), "No matching country found for requested code ["+countryCode+"].");
	}
}
