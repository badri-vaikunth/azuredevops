package rest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojo.SessionRequest;

public class RestRequest 
{
	static Response response = null;
	
	public static Response sessionAPI(SessionRequest payload,String url)
	{
		
		RestAssured.baseURI = url+"/pts/v2/payment-references";

        response = RestAssured.given()
                .relaxedHTTPSValidation()
                .header("v-c-correlation-id","123434")
                .header("v-c-horizon-enabled","false")
                .header("v-c-merchant-id","npr_ctp")
                .log()
                .all()
                .contentType(ContentType.JSON)
                .body(payload)
                .post();
		
		return response;
	}
}
