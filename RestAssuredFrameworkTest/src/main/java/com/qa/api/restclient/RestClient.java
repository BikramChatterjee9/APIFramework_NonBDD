package com.qa.api.restclient;

import java.util.Map;

import com.qa.api.util.TestUtil;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestClient
{
	
	public static Response doGet(String contentType, String baseURI, String basePath, String token, Map<String, String>paramsMap, boolean Log)
	{
		if(setbaseURI(baseURI))
		{
			RequestSpecification request = createRequest(contentType, token, paramsMap, Log);
			return getResponse("GET", request, basePath);
		}
		return null;
	}
	
	public static Response doPost(String contentType, String baseURI, String basePath, String token, Map<String, String>paramsMap, boolean Log, Object obj)
	{
		if(setbaseURI(baseURI))
		{
			RequestSpecification request = createRequest(contentType, token, paramsMap, Log);
			addRequestPayload(request, obj);
			return getResponse("POST", request, basePath);
		}
		return null;
	}
	
	public static void addRequestPayload(RequestSpecification request, Object obj)
	{
		String jsonbody = TestUtil.getSerelizedJson(obj);
		request.body(jsonbody);
	}
	
	private static boolean setbaseURI(String baseURI)
	{
		if(baseURI==null || baseURI.isEmpty())
		{
			System.out.println("Enter base uri");
			return false;
		}
		try {
		RestAssured.baseURI = baseURI;
		return true;
		}catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	private static RequestSpecification createRequest(String contentType, String token, Map<String, String>paramsMap, boolean Log)
	{
		RequestSpecification request;
		if(Log)
		{
			request = RestAssured.given().log().all();
		}
		else
		{
			request = RestAssured.given();
		}
		
		if(token !=null)
		{
			request.header("Authorization", "Bearer "+token);
		}
		
		if(!(paramsMap==null))
		{
			request.queryParams(paramsMap);
		}
		
		if(contentType.equalsIgnoreCase("JSON"))
		{
			request.contentType(ContentType.JSON);
		}
		
		else if(contentType.equalsIgnoreCase("XML"))
		{
			request.contentType(ContentType.XML);
		}
		
		else if(contentType.equalsIgnoreCase("Text"))
		{
			request.contentType(ContentType.TEXT);
		}
		
		return request;
	}
	
	private static Response getResponse(String httpMethod, RequestSpecification request, String basePath)
	{
		return executeAPI(httpMethod, request, basePath);
	}
	
	private static Response executeAPI(String httpMethod, RequestSpecification request, String basePath)
	{
		Response response = null;
		switch (httpMethod) {
		case "GET":
			response = request.get(basePath);
			break;
		case "POST":
			response = request.post(basePath);
			break;
		case "PUT":
			response = request.put(basePath);
			break;
		case "DELETE":
			response = request.delete(basePath);
			break;

		default:
			System.out.println("Please pass correct http method");
			break;
		}
		
		return response;
	}
}
