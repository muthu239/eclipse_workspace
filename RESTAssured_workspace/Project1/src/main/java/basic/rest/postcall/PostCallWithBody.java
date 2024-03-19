package basic.rest.postcall;

import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;

import org.testng.annotations.Test;

public class PostCallWithBody {
	
	@Test
	public void postWithoutBody() {
		
		RestAssured.baseURI = "https://reqres.in";

		given().
			header("Content-Type","application/json").
			body("{\r\n"
					+ "    \"email\": \"eve.holt@reqres.in\",\r\n"
					+ "    \"password\": \"pistol\"\r\n"
					+ "}").
		when().
			post("/api/register").
		then().
			assertThat().statusCode(200).and().
			contentType(ContentType.JSON).and().
			body("id", equalTo(4));
	}
	

}
