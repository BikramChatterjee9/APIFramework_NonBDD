package com.qa.api.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestUtil {
	
	public static String getSerelizedJson(Object obj)
	{
		ObjectMapper mapper = new ObjectMapper();
		String jsonstring = null;
		try {
			jsonstring = mapper.writeValueAsString(obj);
			System.out.println("JSON body payload" + jsonstring);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonstring;	
	}

}
