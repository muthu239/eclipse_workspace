package utility;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CommonUtilFunctions {
	
	public static JsonPath jsonPath;
	
	public static String getResponseValue(String response_body, String response_key) {
		RestFrameworkLogger.initLogger();
		jsonPath = new JsonPath(response_body);
		String  key_value = jsonPath.get(response_key);
		RestFrameworkLogger.info("Response value is -> " + key_value);
		return key_value;
				
	}
	
	public static int getStatusCode(Response response) {
		RestFrameworkLogger.initLogger();
		int statusCode = response.getStatusCode();
		RestFrameworkLogger.info("Response status code is -> " + statusCode);
		return statusCode;
		
	}
	
	public static String getStatusMessage(Response response) {
		RestFrameworkLogger.initLogger();
		String statusMessage = response.getStatusLine();
		RestFrameworkLogger.info("Response status message is -> " + statusMessage);
		return statusMessage;
	}
	
	public static String getResponseHeader(Response response, String headerKey) {
		RestFrameworkLogger.initLogger();
		String responseHeader = response.getHeader(headerKey);
		RestFrameworkLogger.info("Response Header is -> " + responseHeader + "for response headerKey - >" + headerKey );
		return responseHeader;
	}

	public static String getResponseContentType(Response response) {
		RestFrameworkLogger.initLogger();
		String contentType = response.getContentType();
		RestFrameworkLogger.info("Response contentType is -> " + contentType);
		return contentType;
	}
	
	public static int getResponseExecutionTime(Response response) {
		RestFrameworkLogger.initLogger();
		int responseExecTime = (int) response.getTime();
		RestFrameworkLogger.info("Response execution time is -> "+  responseExecTime);
		return responseExecTime;
	}
}
