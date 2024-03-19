package stepDefinitions;



import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import resource.TestBuilder;
import resource.commonUtils.RestLogger;
import resource.commonUtils.Utils;

public class StepDefinitions extends Utils {
	
	ObjectMapper objectMapper;
	Response response;
	JsonPath jsonPath;
	TestBuilder data = new TestBuilder();
	
	public static String payload;
	
	
	@Given("create Repo payload")
	public void create_repo_payload() throws JsonProcessingException {
	    // Write code here that turns the phrase above into concrete actions
		
		objectMapper = new ObjectMapper();
		payload = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(data.createRepoPayload());
	}
	

	@Given("create Repo payload name {string} and description {string}")
	public void create_repo_payload_name_and_description(String name, String description) throws JsonProcessingException {
	    // Write code here that turns the phrase above into concrete actions
		objectMapper = new ObjectMapper();
		payload = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(data.createRepoPayload(name,description));
	}



	
	@When("User calls create API {string} Post API Call")
	public void user_calls_post_api_call(String resourcePath) {
		response = postRequest(resourcePath, payload);
	    
	}
	
	@Then("API call got successful with status code {int}")
	public void api_call_got_successful_with_status_code(Integer status_code) {
	    // Write code here that turns the phrase above into concrete actions
	    assertEquals(status_code, response.getStatusCode());  
	    RestLogger.info("Status code of req - " + response.getStatusCode());
	   
	}
	
	@Then("Verify Repo {string} is {string}")
	public void verify_created_repo_name(String response_key, String repo_name) {
	    // Write code here that turns the phrase above into concrete actions
		jsonPath = new JsonPath(response.getBody().asString());
		String key_value = jsonPath.getString(response_key);
		 assertEquals(repo_name, key_value);
		 
		 RestLogger.info("Expected repo name : " + repo_name);
		 RestLogger.info("Actual repo name : " + key_value);
	}
	

	@Then("User calls delete API {string} delete API Call")
	public void user_calls_delete_api_delete_api_call(String resourcePath) {
	    // Write code here that turns the phrase above into concrete actions
		response = deleteRequest(resourcePath, data.getRepoName());
		RestLogger.info("Delete req status code is : " + response.getStatusCode());
	}



	@Given("Starting TestCase {string}")
	public void starting_test_case(String testCase) {
	    // Write code here that turns the phrase above into concrete actions
		RestLogger.initLogger();
		RestLogger.startTestCase(testCase);
	
	   
	}
	@Then("Ending TestCase")
	public void ending_test_case() {
	    // Write code here that turns the phrase above into concrete actions
	   RestLogger.endTestCase();
	}





}
