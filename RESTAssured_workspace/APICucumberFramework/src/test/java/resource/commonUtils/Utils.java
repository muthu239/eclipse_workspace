package resource.commonUtils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {
	
	RequestSpecification reqSpecification;
	String bearer_token = "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";
	String base_URI = "https://api.github.com";
	Response response;
	
	public Response postRequest(String resourcePath, String payload) {
		RestLogger.info("Bas URI is : " + base_URI);
		RestLogger.info("Resource path is : " + resourcePath);
		RestLogger.info("Request payload is : " + payload);
		reqSpecification = RestAssured.given().body(payload);
		reqSpecification.contentType(ContentType.JSON);
		reqSpecification.header("Authorization", "Bearer " + bearer_token );
		response =	reqSpecification.post(base_URI+resourcePath);
		RestLogger.info("Response of request : " + response.getBody().asString());
		return response;
	}

	
	public Response deleteRequest(String resourcePath, String repo_name) {
		String reqURI = base_URI+resourcePath+repo_name;
		RestLogger.info("Delete request URI  : " + reqURI);
		
		reqSpecification = RestAssured.given();
		reqSpecification.contentType(ContentType.JSON);
		reqSpecification.header("Content-Type","application/json");
		reqSpecification.header("Authorization","Bearer "+ bearer_token);
		response = reqSpecification.delete(reqURI);
		return response;
		
	}
}
