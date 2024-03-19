package com.rest.client;

import java.io.IOException;
import java.util.HashMap;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.json.JSONObject;

public class HTTPClient {

	//1. Get call

	public CloseableHttpResponse getCall(String url) throws IOException, ParseException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet getCall = new HttpGet(url);  //this is equvialaent to Rest get call
		CloseableHttpResponse response =    httpClient.execute(getCall);
		
		return response;
//		
//		// Extracting the response code
//		int status_code = response.getCode();
//
//		System.out.println("Response status code is : " + status_code);
//		
//		String responseString = EntityUtils.toString(response.getEntity(),"UTF-8"); //this is to return the response in String format 
//		
//		//parsing string to Json format
//		JSONObject jsonObj = new JSONObject(responseString);
//		System.out.println("API response JSON : " +  jsonObj);
//		
//		
//		// getting response headers
//		Header[] responseHeaders =  response.getHeaders();
//		HashMap<String, String> headerAll = new HashMap<String, String>();
//		
//		for(Header header : responseHeaders) {
//			headerAll.put(header.getName(), header.getValue());
//		}
//	System.out.println("All headers are  : " +  headerAll);
	}
	
}
