package com.helloFresh.challenge.API.apiRequests;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.helloFresh.cache.CommonCache;
import com.helloFresh.challenge.API.apiUrl.CountryApiUrls;
import com.helloFresh.challenge.API.country.getAll.response.GetAllResponse;
import com.helloFresh.challenge.API.country.iso2Code.response.Iso2CodeResponse;
import com.helloFresh.constants.ApiConstants;
import com.helloFresh.utils.ConfigProperties;
import com.helloFresh.utils.JsonUtil;
import com.helloFresh.utils.Log;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ValidatableResponse;

public class CountryApiRequests {

	public static GetAllResponse getAllRequest()
	{
		Log.message("Got request for getAll api");
		String domain=new ConfigProperties(CommonCache.getEnv()).fetchConfig(ApiConstants.CountryApiEndPoint);
		GetAllResponse getAllResponse=null;
		Log.message("Hitting API");
		String url=CountryApiUrls.getAllCountriesApiUrl();
		String response=JsonUtil.jsonGet(domain+url);
		try {
			getAllResponse=new ObjectMapper().readValue(response, GetAllResponse.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return getAllResponse;
	}
	
	public static Iso2CodeResponse iso2CodeRequest(String countryCode)
	{
		Log.message("Got request for iso2code api");
		String domain=new ConfigProperties(CommonCache.getEnv()).fetchConfig(ApiConstants.CountryApiEndPoint);
		Iso2CodeResponse iso2CodeResponse=null;
		String url=CountryApiUrls.getIso2CodeApiUrl(countryCode);
		Log.message("Hitting API");
		String response=JsonUtil.jsonGet(domain+url);
		try {
			iso2CodeResponse=new ObjectMapper().readValue(response, Iso2CodeResponse.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return iso2CodeResponse;
		
	}

	public static ValidatableResponse addCountryApiRequest(String requestBody)
	{
		Log.message("Got request for addCountry api");
		String domain=new ConfigProperties(CommonCache.getEnv()).fetchConfig(ApiConstants.CountryApiEndPoint);
		String url=CountryApiUrls.addNewCountryApiUrl();
		Log.message("Hitting API");
		ValidatableResponse response= 	JsonUtil.jsonPostRestAssured(domain+url, requestBody);
		return response;
	}
	
	public static Response deleteCountryApiRequest(String countryCode)
	{
		Log.message("Got request for deleteCountry api");
		String domain=new ConfigProperties(CommonCache.getEnv()).fetchConfig(ApiConstants.CountryApiEndPoint);
		String url=CountryApiUrls.deleteCountryApiUrl(countryCode);
		Log.message("Hitting API");
		Response response= 	JsonUtil.jsonGetRestAssured(domain+url);
		return response;
	}
}
