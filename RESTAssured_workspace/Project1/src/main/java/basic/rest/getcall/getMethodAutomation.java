package basic.rest.getcall;

import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;

public class getMethodAutomation {
	
	public static String baseURI = "https://reqres.in/api";
	
	public static void main(String[] args) {
		
		RestAssured.baseURI = baseURI;
		
		given().
			param("page", "2").
		when().
			get("/users").
		then().
			assertThat().statusCode(200).and().
			contentType(ContentType.JSON).and().
			body("total", equalTo(12));
		
		
		System.out.println("This is first getAutomation call");
		System.out.println("Get call, Executed successfully");
		
	}

}
