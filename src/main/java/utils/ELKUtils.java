package utils;

import java.time.LocalDateTime;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ELKUtils 
{
	private ELKUtils()
	{
		
	}
	
	public static void sendDetailsToELK(String testname, String status)
	{
		if(PropertyUtils.get("sendResultsToELK").equalsIgnoreCase("yes"))
		{
			JSONObject requestParams = new JSONObject();
			requestParams.put("testName", testname);
			requestParams.put("status", status);
			requestParams.put("executionTime", LocalDateTime.now().toString());
			requestParams.put("author", System.getProperty("author"));
			
			RestAssured.baseURI = PropertyUtils.get("elkhost");
			RequestSpecification request = RestAssured.given();
			request.header("Content-Type","application/json");
			request.body(requestParams.toJSONString());
			Response response = request.post("/testing/results");
		}
	}
}
