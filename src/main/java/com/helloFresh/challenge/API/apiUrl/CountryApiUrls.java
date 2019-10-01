package com.helloFresh.challenge.API.apiUrl;

import java.text.MessageFormat;

public class CountryApiUrls {

	private static String getAllApiUrl="country/get/all";

	private static String iso2CodeApiUrl="country/get/iso2code/{0}";

	private static String addCountryApiUrl="country/post/addNewCountry";

	private static String deleteCountryApiUrl="country/post/deleteCountry/{0}";

	public static String getAllCountriesApiUrl()
	{	
		return getAllApiUrl;
	}

	public static String getIso2CodeApiUrl(String countryCode)
	{
		return 		MessageFormat.format(iso2CodeApiUrl, countryCode);
	}

	public static String addNewCountryApiUrl()
	{
		return addCountryApiUrl;
	}

	public static String deleteCountryApiUrl(String countryCode)
	{
		return 		MessageFormat.format(deleteCountryApiUrl, countryCode);
	}

}
