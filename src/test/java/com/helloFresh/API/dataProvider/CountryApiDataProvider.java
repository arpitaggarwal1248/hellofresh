package com.helloFresh.API.dataProvider;

import org.testng.annotations.DataProvider;

import com.helloFresh.challenge.API.apiRequests.CountryApiRequests;
import com.helloFresh.challenge.API.country.getAll.response.GetAllResponse;
import com.helloFresh.challenge.API.country.getAll.response.Result;
import com.helloFresh.utils.RandomUtil;

public class CountryApiDataProvider {

	GetAllResponse getAllResponse=null;

	@DataProvider(name="duplicateCountry")
	public Object[][] dataForDuplicateCountry()
	{
		if(getAllResponse==null)
			getAllResponse=CountryApiRequests.getAllRequest();
		int size=		getAllResponse.getRestResponse().getResult().size();
		int index=RandomUtil.generateRandomNumber(0, size-1);
		Result country=getAllResponse.getRestResponse().getResult().get(index);
		return	new Object[] []{{country.getName(),country.getAlpha2Code(),country.getAlpha3Code()}};
	}


	@DataProvider(name="addNewCountry")
	public Object[][] dataForAddNewCountry()
	{
		if(getAllResponse==null)
			getAllResponse=CountryApiRequests.getAllRequest();
		int size=		getAllResponse.getRestResponse().getResult().size();
		int index=RandomUtil.generateRandomNumber(0, size-1);
		Result country=getAllResponse.getRestResponse().getResult().get(index);
		deleteCountry(country.getAlpha2Code());
		return	new Object[] []{{country.getName(),country.getAlpha2Code(),country.getAlpha3Code()}};
	}

	private static void deleteCountry(String countryCode)
	{
		CountryApiRequests.deleteCountryApiRequest(countryCode);
	}

	@DataProvider(name="getSpecificCountry")
	public Object[][] getSpecificCountryList()
	{
		return	new Object[] []{{"GB"},{"US"},{"DE"}};
	}


	@DataProvider(name="getAllCountries")
	public Object[][] getAllCountries()
	{
		GetAllResponse getAllResponseObj=		CountryApiRequests.getAllRequest();
		return getAllResponseObj.getRestResponse().getResult().stream().map(country-> new Object[] {country.getAlpha2Code()}).toArray(Object[][]::new);
	}

	@DataProvider(name = "invalidCountryCodes")
	public Object[][] invalidCountryCodes()
	{
		return	new Object[] []{{"gB"},// case sensitive
			{"12"}, //numbers
			{""}, //blank
			{"AP"}, //invalid country code
			{"U$"}, //special chars
			{"GBR"}}; //alpha3 code // length of code
	}
}
