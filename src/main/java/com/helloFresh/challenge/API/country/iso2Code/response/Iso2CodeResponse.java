package com.helloFresh.challenge.API.country.iso2Code.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Iso2CodeResponse {

	@JsonProperty("RestResponse")
	 private RestResponse RestResponse;

	public RestResponse getRestResponse() {
		return RestResponse;
	}

	public void setRestResponse(RestResponse restResponse) {
		RestResponse = restResponse;
	}
	 
	 
}
