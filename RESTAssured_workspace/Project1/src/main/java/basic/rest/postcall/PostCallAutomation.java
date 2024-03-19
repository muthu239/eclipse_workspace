package basic.rest.postcall;


import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;

import org.testng.annotations.Test;

public class PostCallAutomation {
	
	
	//Post request without body data
	
	@Test
	public void postWithoutBody() {
		
		RestAssured.baseURI = "https://httpbin.org";
		String param1_value = "Tom";
		String param2_value = "Hulk";
		String param3_value = "Panther";
		
		
		given().
			queryParam("param1_key", param1_value).
			queryParam("param3_key", param3_value).
			queryParam("param2_key", param2_value).
			header("Content-Type","application/json").
		when().
			post("/post").
		then().
			assertThat().statusCode(200).and().
			contentType(ContentType.JSON).and().
			body("origin", equalTo("103.224.34.231")).log().all();
	}
	
	

}
