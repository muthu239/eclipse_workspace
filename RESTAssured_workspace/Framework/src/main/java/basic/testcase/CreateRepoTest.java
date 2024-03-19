package basic.testcase;

import java.io.IOException;

import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.Test;

import com.RestAPIBase.BaseClass;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import junit.framework.Assert;
import pojoClasses.PojoClasses;
import utility.Authn;
import utility.CommonUtilFunctions;
import utility.CreateURL;
import utility.RestFrameworkLogger;
import utility.payloadGenerator;

public class CreateRepoTest {

	Response response;
	String endpoint = CreateURL.getBaseURI("/user/repos");
	String bearerToken = Authn.getBearerToken();
	ObjectMapper objectMapper;

	@Test(priority = 1)
	public void createRepoTestCase() throws IOException {

		RestFrameworkLogger.initLogger();
		RestFrameworkLogger.startTestCase("createRepoTestCase");
		RestFrameworkLogger.info("Starting create repo test case");

		RestFrameworkLogger.info("Step 1 : Generating payload string");

		String req_payload = payloadGenerator.generateStringPayload("/createRepo.json");

		RestFrameworkLogger.info("Step 2 : Executing create repo API");
		response = BaseClass.postRequest(endpoint, req_payload, bearerToken);

		String responseString = response.getBody().asString();

//		System.out.println("*****************************************************");
//		System.out.println("Response for the request");
//		System.out.println(responseString);

//		JsonPath responseBody = new JsonPath(responseString);
//		
//		System.out.println("Node ID : " + responseBody.get("node_id"));
//		System.out.println("Name : " + responseBody.get("name"));

//		System.out.println("Name from Request --> " + CommonUtilFunctions.getResponseValue(req_payload, "name"));
//		System.out.println("Name from Response --> " + CommonUtilFunctions.getResponseValue(responseString, "name"));
//
//		System.out.println(
//				"Description from Request --> " + CommonUtilFunctions.getResponseValue(req_payload, "description"));
//		System.out.println(
//				"Description from Response --> " + CommonUtilFunctions.getResponseValue(responseString, "description"));

		RestFrameworkLogger.info("Step 3: Validating repository name");
		Assert.assertEquals(CommonUtilFunctions.getResponseValue(responseString, "name"),
				CommonUtilFunctions.getResponseValue(req_payload, "name"));

		RestFrameworkLogger.info("Name assertion is done! ");

		RestFrameworkLogger.info("Step 4: Validating repository Description");

		Assert.assertEquals(CommonUtilFunctions.getResponseValue(responseString, "description"),
				CommonUtilFunctions.getResponseValue(req_payload, "description"));

		RestFrameworkLogger.info("Description assertion is done! ");

		RestFrameworkLogger.endTestCase();
	}

	@Test(priority = 2)
	// Test case creating with POJO class methods by writing the body text usinig
	// POJO methods
	public void createRepoTest() throws JsonProcessingException {
		
		PropertyConfigurator.configure("log4j.properties");
		RestFrameworkLogger.startTestCase("createRepoTestUsingPojo");
		RestFrameworkLogger.info("Starting create repo test case");
	
		PojoClasses requestPayload = new PojoClasses();
		requestPayload.setName("ABC1");
		requestPayload.setDescription("This is your first repo! Repo created using Rest API2");
		
		
		objectMapper = new ObjectMapper();
		String payload = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(requestPayload);
		response = BaseClass.postRequest(endpoint, payload, bearerToken);

		String responseString = response.getBody().asString();

		System.out.println("*****************************************************");
		System.out.println("Response for the request");
		System.out.println(responseString);

//		JsonPath responseBody = new JsonPath(responseString);
//		System.out.println("Node ID : " + responseBody.get("node_id"));
//		System.out.println("Name : " + responseBody.get("name"));

		System.out.println("Name from Request --> " + requestPayload.getName());
		System.out.println("Name from Response --> " + CommonUtilFunctions.getResponseValue(responseString, "name"));

		System.out.println("Description from Request --> " + requestPayload.getDescription());
		System.out.println(
				"Description from Response --> " + CommonUtilFunctions.getResponseValue(responseString, "description"));

		Assert.assertEquals(requestPayload.getName(), CommonUtilFunctions.getResponseValue(responseString, "name"));
		Assert.assertEquals(requestPayload.getDescription(),
				CommonUtilFunctions.getResponseValue(responseString, "description"));
	}
	
	@Test(priority = 3)
	public void deleteRepo() throws IOException {
		
		PropertyConfigurator.configure("log4j.properties");
		RestFrameworkLogger.startTestCase("DeleteRepoTestCase");
		RestFrameworkLogger.info("Deleting created repo test case");
		
		String req_payload = payloadGenerator.generateStringPayload("/createRepo.json");
		RestFrameworkLogger.info("Request payload -->  " +  req_payload);
		String deleteEndpoint = CreateURL.getBaseURI("/repos/muthu239/") + CommonUtilFunctions.getResponseValue(req_payload,"name");
		System.out.println(deleteEndpoint);
		
		response = BaseClass.deleteRequest(deleteEndpoint,bearerToken);
		CommonUtilFunctions.getStatusCode(response);
		Assert.assertEquals(CommonUtilFunctions.getStatusCode(response), 204);
		String responseString = response.getBody().asString();
		System.out.println(responseString);	
		
		RestFrameworkLogger.endTestCase();
	}
	
	@Test(priority = 4)
	public void deleteRepoPOJO() throws IOException {

		PropertyConfigurator.configure("log4j.properties");
		RestFrameworkLogger.startTestCase("deleteRepoPOJO");
		RestFrameworkLogger.info("Deleting created repo using Pojo test case");

		PojoClasses requestPayload = new PojoClasses();
		requestPayload.setName("ABC1");
		requestPayload.setDescription("This is your first repo! Repo created using Rest API2");

		objectMapper = new ObjectMapper();
		String payload = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(requestPayload);
		String deleteEndpoint = CreateURL.getBaseURI("/repos/muthu239/") + requestPayload.getName();
		System.out.println(deleteEndpoint);

		response = BaseClass.deleteRequest(deleteEndpoint, bearerToken);
		CommonUtilFunctions.getStatusCode(response);
		Assert.assertEquals(CommonUtilFunctions.getStatusCode(response), 204);

		String responseString = response.getBody().asString();
		System.out.println(responseString);
		
		RestFrameworkLogger.endTestCase();
	}

}
