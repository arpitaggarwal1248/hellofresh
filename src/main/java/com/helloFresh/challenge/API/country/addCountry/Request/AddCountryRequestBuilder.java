package com.helloFresh.challenge.API.country.addCountry.Request;

import org.testng.SkipException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AddCountryRequestBuilder {

	public static String getAddCountryRequestBody(String countryName,String alpha2Code,String alpha3Code)
	{
		if(countryName==null || alpha2Code==null || alpha3Code==null)
			throw new SkipException("Invalid request parameters");

		AddCountryRequest addCountry=new AddCountryRequest();
		addCountry.setName(countryName);
		addCountry.setAlpha2Code(alpha2Code);
		addCountry.setAlpha3Code(alpha3Code);
		return	getAddCountryRequestBody(addCountry);

	}


	private static String getAddCountryRequestBody(AddCountryRequest request)
	{
		String requestBody=null;
		try {
			requestBody=	new ObjectMapper().writeValueAsString(request);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return requestBody;
	}

}
