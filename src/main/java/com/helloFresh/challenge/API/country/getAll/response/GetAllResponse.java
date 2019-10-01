package com.helloFresh.challenge.API.country.getAll.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetAllResponse {
	
	@JsonProperty("RestResponse")
	private RestResponse RestResponse;

	public RestResponse getRestResponse() {
		return RestResponse;
	}

	public void setRestResponse(RestResponse restResponse) {
		RestResponse = restResponse;
	}
	
	
	
}
