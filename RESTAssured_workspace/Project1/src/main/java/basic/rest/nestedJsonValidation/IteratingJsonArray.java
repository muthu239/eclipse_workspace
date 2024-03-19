package basic.rest.nestedJsonValidation;

import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;

import org.testng.annotations.Test;

public class IteratingJsonArray {
	

	@Test
	public void responseBody() {
		
		RestAssured.baseURI = "https://reqres.in/api";
		
		Response response = given().
			param("page", "2").
		when().
			get("/users").
		then().
			assertThat().statusCode(200).and().
			contentType(ContentType.JSON).and().log().all().
			extract().response();
		
		String jsonResponse = response.asString();
		JsonPath responseBody = new JsonPath(jsonResponse);
		
//		//this is direct reponse key value
//		System.out.println("mainJsonValue : " + responseBody.get("per_page"));
//		
//		//this is to print json key value inside the main json
//		System.out.println("main -> Support(innerjson) : " + responseBody.get("support")); //this will print the entire inside json
//		
//		System.out.println("main -> Support(innerJson) -> URL(innerJsonElement) : " + responseBody.get("support.url"));
//		
//		System.out.println("main -> data (JsonArray )-> arrayIndex_key : " + responseBody.get("data[4].id"));
//		System.out.println("main -> data (JsonArray )-> arrayIndex_key : " + responseBody.get("data[4].first_name"));
		
		
		int data_array_len = responseBody.getInt("data.size()");
		
		System.out.println("data array size found to be : " + data_array_len);
		
		for(int i = 0; i<data_array_len;i++) {
			String firstName =  responseBody.get("data["+i+"].first_name");
			String lastName = responseBody.get("data["+i+"].last_name");
			
			System.out.println("FirstName +  LastName : Index ["+ i + "] = "+firstName + " " + lastName );
		}
		
	}
	

}
