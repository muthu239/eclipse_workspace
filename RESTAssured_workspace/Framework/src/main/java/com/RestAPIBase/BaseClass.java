package com.RestAPIBase;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utility.RestFrameworkLogger;

public class BaseClass {

	// basic function of Framework
	// Request - Response

	public static Response getRequest(String requestURI) {
		RestFrameworkLogger.initLogger();
		RestFrameworkLogger.info("Request URI is entered - " + requestURI);
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.get(requestURI);
		RestFrameworkLogger.info("Response is -> " + response.getBody().asString());
		return response;
	}

	public static Response postRequest(String requestURI, String reqPayload) {
		
		RestFrameworkLogger.initLogger();
		RestFrameworkLogger.info("Request URI is entered - " + requestURI);
		RestFrameworkLogger.info("Request payload is -> " +  reqPayload);
		RequestSpecification requestSpecification = RestAssured.given().body(reqPayload);
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.post(requestURI);
		RestFrameworkLogger.info("Response is -> " + response.getBody().asString());
		return response;
	}
	
	public static Response postRequest(String requestURI, String reqPayload, String bearerToken) {
		RestFrameworkLogger.initLogger();
		RestFrameworkLogger.info("Request URI is entered - " + requestURI);
		RestFrameworkLogger.info("Request payload is -> " +  reqPayload);
		RequestSpecification requestSpecification = RestAssured.given().body(reqPayload);
		requestSpecification.contentType(ContentType.JSON);
		requestSpecification.header("Authorization","Bearer "+bearerToken);
		Response response = requestSpecification.post(requestURI);
		RestFrameworkLogger.info("Response is -> " + response.getBody().asString());
		return response;
	}


	public static Response putRequest(String requestURI, String reqPayload) {
		RestFrameworkLogger.initLogger();
		RestFrameworkLogger.info("Request URI is entered - " + requestURI);
		RestFrameworkLogger.info("Request payload is -> " +  reqPayload);
		RequestSpecification requestSpecification = RestAssured.given().body(reqPayload);
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.put(requestURI);
		RestFrameworkLogger.info("Response is -> " + response.getBody().asString());
		return response;

	}

	public static Response deleteRequest(String requestURI) {
		RestFrameworkLogger.initLogger();
		RestFrameworkLogger.info("Request URI is entered - " + requestURI);
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.delete(requestURI);
		RestFrameworkLogger.info("Response status code is -> " + response.getStatusCode());
		return response;

	}
	
	public static Response deleteRequest(String requestURI,String bearerToken) {
		RestFrameworkLogger.initLogger();
		RestFrameworkLogger.info("Request URI is entered - " + requestURI);
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.contentType(ContentType.JSON);
		requestSpecification.header("Authorization","Bearer "+bearerToken);
		Response response = requestSpecification.delete(requestURI);
		RestFrameworkLogger.info("Response status code is -> " + response.getStatusCode());
		return response;

	}


	public Response deleteRequestWithPayload(String requestURI, String reqPayload) {
		RestFrameworkLogger.initLogger();
		RestFrameworkLogger.info("Request URI is entered - " + requestURI);
		RestFrameworkLogger.info("Request payload is -> " +  reqPayload);
		RequestSpecification requestSpecification = RestAssured.given().body(reqPayload);
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.get(requestURI);
		RestFrameworkLogger.info("Response status code is -> " + response.getStatusCode());
		return response;

	}

}
