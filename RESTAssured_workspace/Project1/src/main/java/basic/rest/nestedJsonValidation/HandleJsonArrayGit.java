package basic.rest.nestedJsonValidation;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class HandleJsonArrayGit {
	
	@Test
	public void responseBody() {
		
		RestAssured.baseURI = "https://api.github.com";
		String token = "";
		
		Response response = given().
			header("Authorization","Bearer "+token).
		when().
			get("/user/repos").
		then().
			assertThat().statusCode(200).and().
			contentType(ContentType.JSON).and().log().all().
			extract().response();
		
		String jsonResponse = response.asString();
		JsonPath responseBody = new JsonPath(jsonResponse);
		
		
		//handling the navigation inside array as below given
		System.out.println("main(Jsonarray) -> arrayindex_key : "+responseBody.get("[0].id"));
		System.out.println("main(Jsonarray) -> arrayindex_key -> insideJsonKey : "+responseBody.get("[0].owner.login"));
	}
}
