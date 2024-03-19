package basic.rest.postcall;

import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;

import org.testng.annotations.Test;


public class DeleteRequest {
	
	public String baseURi = "https://reqres.in";
	
//	@Test
	public void postUsers() {
		RestAssured.baseURI = baseURi;
		String requestBody = "{\r\n"
				+ "    \"email\": \"eve.holt@reqres.in\",\r\n"
				+ "    \"password\": \"pistol\"\r\n"
				+ "}";

		Response response = given().
			header("Content-Type","application/json").
			body(requestBody).
		when().
			post("/api/register").
		then().
			assertThat().statusCode(200).and().
			contentType(ContentType.JSON).and().
			body("id", equalTo(4)).
		extract().response();
		
		
		System.out.println(response.asPrettyString());
		
		String jsonReponse = response.asString();
		
		//to convert string to json, so we can send json in the other request when needed
		JsonPath responseBody = new JsonPath(jsonReponse);
		
		//to fetch certain key value from the json response
		System.out.println("ID: " + responseBody.get("id"));
		
	}
	
	
	@Test
	public void  delete() {
		
		RestAssured.baseURI = baseURi;
		
		given().
		when().
		delete("/api/users/2").
	then().
		assertThat().statusCode(204);
		
	}
	

}
