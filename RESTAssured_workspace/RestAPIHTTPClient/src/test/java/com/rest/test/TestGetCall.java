package com.rest.test;

import java.io.IOException;

import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.rest.client.HTTPClient;
import com.rest.utils.TestUtils;
import com.test.base.TestBase;

public class TestGetCall extends TestBase {
	
	public TestGetCall() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	String URI;
	TestBase testBase;
	HTTPClient driver;
	CloseableHttpResponse response;
	
	@BeforeTest
	public void setup() throws IOException {
		testBase = new TestBase();
		String URL = prop.getProperty("URI");
		String pathParam = prop.getProperty("ServiceURI");
		
		 URI = URL + pathParam;
		
	}
	
	@Test
	public void testGetCall() throws ParseException, IOException {
		driver = new HTTPClient();
		response = driver.getCall(URI);
		
		System.out.println("Response status code is : " +  response.getCode());
		
		Assert.assertEquals(response.getCode(), 200);
	}
	
	@Test
	public void testGetCallResponse() throws ParseException, IOException {
		driver = new HTTPClient();
		response = driver.getCall(URI);
		
		System.out.println("Response status code is : " +  response.getCode());
		
		Assert.assertEquals(response.getCode(), repsonse_code_200);
		
		String responseString = EntityUtils.toString(response.getEntity(),"UTF-8"); //this is to return the response in String format 
		
		//parsing string to Json format
		JSONObject jsonObj = new JSONObject(responseString);
		System.out.println("API response JSON : " +  jsonObj);
		
		String responseValue = TestUtils.getValueByJPath(jsonObj, "/per_page");
		Assert.assertEquals(responseValue, "6");
		
		
		//to get the json value
		System.out.println(TestUtils.getValueByJPath(jsonObj, "/data[0]/first_name"));
		System.out.println(TestUtils.getValueByJPath(jsonObj, "/data[1]/first_name"));
	}
	
	

}
