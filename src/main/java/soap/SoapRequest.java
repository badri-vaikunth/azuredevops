package soap;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SoapRequest 
{
	
	static Response response = null;
	
	public static Response post(String requestPayload, String baseUrl, String apiPath)
	{

//		File requestBody = new File(payloadPath);
//        Response response = RestAssured.given()
//				.relaxedHTTPSValidation()
//                .baseUri(baseUrl)
//                .basePath(apiPath)
//                .header("Content-Type", "text/xml; charset=utf-8")
//                .body(requestBody)
//				.log()
//				.all()
//                .post();
//		response.body().prettyPrint();
//		return response;

		Response response = RestAssured.given()
				.relaxedHTTPSValidation()
				.baseUri(baseUrl)
				.basePath(apiPath)
				.header("Content-Type", "text/xml; charset=utf-8")
				.body(requestPayload)
				.log()
				.all()
				.post();
		response.body().prettyPrint();
		return response;

	}

	public static RequestSpecification exportToReport(String requestPayload, String baseUrl, String apiPath)
	{
		RequestSpecification requestSpecification = RestAssured.given()
				.baseUri(baseUrl)
				.contentType(ContentType.XML)
				.body(requestPayload);
		return requestSpecification;
	}
}
