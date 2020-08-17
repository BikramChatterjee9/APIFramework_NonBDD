package com.qa.api.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.api.pojo.User;
import com.qa.api.restclient.RestClient;
import com.qa.api.util.ExcelUtil;

import io.restassured.response.Response;

public class CreateUserTest {
	
	String baseURI = "https://gorest.co.in/";
	String basePath = "public-api/users";
	String token = "cQSLQNEqgZM3ssTfVshS9_7guocQWFyb6P8c";
	
	@DataProvider
	public Object[][] getUserData()
	{
		Object[][] userdata = ExcelUtil.getTestData("userdata");
		return userdata;
	}
	
	
	@Test(dataProvider="getUserData")
	public void createusertest(String firstname, String lastname, String dob, String email, String gender, String status, String address)
	{
	//	User user = new User("vicky", "chatterjee", "01-01-2000", "vicky@abc.com", "male", "active", "bangalore");
		
		User user = new User(firstname, lastname, dob, email, gender, status,  address);
		
		Response response = RestClient.doPost("JSON", baseURI, basePath, token, null, true, user);
		System.out.println(response.getStatusCode());
		System.out.println(response.prettyPrint());
	}

}
