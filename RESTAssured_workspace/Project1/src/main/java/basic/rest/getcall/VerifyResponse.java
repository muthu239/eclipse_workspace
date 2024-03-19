package basic.rest.getcall;

import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;

import org.testng.annotations.Test;

public class VerifyResponse {
	
	@Test
	public void responseBody() {
		
		RestAssured.baseURI = "https://reqres.in/api";
		
		given().
			param("page", "2").
		when().
			get("/users").
		then().
			assertThat().statusCode(200).and().
			contentType(ContentType.JSON).and().
			body("total", equalTo(12)).and().
			body("total_pages", equalTo(2)).log().all();
		
	}
	
//	@Test
	public void responseHeader() {
		
		RestAssured.baseURI = "https://reqres.in/api";
		
		given().
			param("page", "2").log().all().
		when().
			get("/users").
		then().
			assertThat().statusCode(200).and().
			contentType(ContentType.JSON).and().
			header("Server","cloudflare").and().	
			header("Cache-Control", "max-age=14400");
	}

}
