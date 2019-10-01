package com.helloFresh.API.testClass;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.helloFresh.API.dataProvider.CountryApiDataProvider;
import com.helloFresh.challenge.API.apiRequests.CountryApiRequests;
import com.helloFresh.challenge.API.country.addCountry.Request.AddCountryRequestBuilder;
import com.helloFresh.listeners.TestListener;
import com.helloFresh.utils.Log;



@Listeners(TestListener.class)
public class AddCountryTestCases {


	@Test(dataProviderClass = CountryApiDataProvider.class,dataProvider = "duplicateCountry")
	public void testAddDuplicateCountry(String countryName,String alpha2Code,String alpha3Code)
	{
		Log.message("CountryName: "+countryName);
		Log.message("alpha code 2: "+alpha2Code);
		Log.message("alpha code 3: "+alpha3Code);
		Log.message("Creating add country request");
		String addCountryRequestBody=	AddCountryRequestBuilder.getAddCountryRequestBody(countryName,alpha2Code,alpha3Code);
		CountryApiRequests.addCountryApiRequest(addCountryRequestBody);
	}

	@Test(dataProviderClass = CountryApiDataProvider.class,dataProvider = "addNewCountry")
	public void testAddNewCountry(String countryName,String alpha2Code,String alpha3Code)
	{
		Log.message("CountryName: "+countryName);
		Log.message("alpha code 2: "+alpha2Code);
		Log.message("alpha code 3: "+alpha3Code);
		Log.message("Creating add country request");
		String addCountryRequestBody=	AddCountryRequestBuilder.getAddCountryRequestBody(countryName,alpha2Code,alpha3Code);
		CountryApiRequests.addCountryApiRequest(addCountryRequestBody);
	}



}
