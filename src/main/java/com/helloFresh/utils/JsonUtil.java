package com.helloFresh.utils;

import static com.jayway.restassured.RestAssured.given;

import org.testng.Assert;

import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ValidatableResponse;
import com.jayway.restassured.specification.RequestSpecification;

public class JsonUtil {

	public static String jsonPost(String APIUrl, String APIBody) {



		// Creating object for JSON request
		RequestSpecBuilder builder = new RequestSpecBuilder();

		// Set Request Body
		builder.setBody(APIBody);

		// Set Type of body sending to the request
		builder.setContentType("application/json; charset=UTF-8");

		// Building request
		RequestSpecification requestSpec = builder.build();

		// Hitting request using post method
		Response response = given().spec(requestSpec).when().post(APIUrl);

		if(response.getStatusCode()>399)
		{
			Assert.fail("<b>Response status code is :"+response.getStatusCode()+response.getStatusLine()+"</b>"+ "for request: "+APIUrl);
		}
		
		if(!response.getContentType().equals(""))
			Assert.fail("Response Content type is: "+ response.getContentType());

		// Saving response and return
		String res = response.body().asString();

		return res;
	}

	public static ValidatableResponse jsonPostRestAssured(String APIUrl, String APIBody) {



		// Creating object for JSON request
		RequestSpecBuilder builder = new RequestSpecBuilder();

		// Set Request Body
		builder.setBody(APIBody);

		// Set Type of body sending to the request
		builder.setContentType("application/json; charset=UTF-8");

		// Building request
		RequestSpecification requestSpec = builder.build();

		// Hitting request using post method
		ValidatableResponse response = given().spec(requestSpec).when().post(APIUrl).
				then()
					.assertThat()
						.statusCode(200)
					.and()
						.contentType(ContentType.JSON);
		return response;
	}

	public static Response jsonGetRestAssured(String url)
	{
		return	given().relaxedHTTPSValidation().when().get(url);
	}
	
	public static String jsonGet(String Url)  {

		// Hitting request using get method
		Response response =given().relaxedHTTPSValidation().when().get(Url);

		if(response.getStatusCode()>399)
		{
			Assert.fail("<b>Response status code is :"+response.getStatusCode()+response.getStatusLine()+"</b>"+ "for request: "+Url);
		}
		
		if(!response.getContentType().equals("application/json;charset=UTF-8"))
			Assert.fail("<b>Response Content type is: "+ response.getContentType()+"</b>");

		String res = response.body().asString();

		return res;
	}
}
