package com.qa.api.tests;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import com.qa.api.restclient.RestClient;

import io.restassured.response.Response;

public class GetUserTest {
	
	String baseURI = "https://gorest.co.in/";
	String basePath = "public-api/users";
	String token = "cQSLQNEqgZM3ssTfVshS9_7guocQWFyb6P8c";
	
	@Test(priority=1)
	public void getalluser()
	{
		Response response = RestClient.doGet("JSON", baseURI, basePath, token, null, true);
		System.out.println(response.prettyPrint());
		System.out.println(response.getStatusCode());
	}
	
	@Test(priority=2)
	public void getuserwithqueryparameter()
	{
		Map<String, String> params = new HashMap<String, String>();
		params.put("first_name", "Elsie");
		params.put("last_name", "Armstrong");
		
		Response response = RestClient.doGet("JSON", baseURI, basePath, token, params, true);
		System.out.println(response.prettyPrint());
		System.out.println(response.getStatusCode());
	}

}
