package com.selenium.master1;

import java.net.HttpURLConnection;
import java.net.URL;


public class GetLinkStatus {
	
	static int invalidLink;
	
	public static void verifyLink(String linkString) {
		
		try {
			URL url = new URL(linkString);
			
			
			//open HTTP connection
			HttpURLConnection urlConnect = (HttpURLConnection) url.openConnection();
			
			//define timeout
			urlConnect.setConnectTimeout(50000);
			
			//hit url
			urlConnect.connect();
			
			if(urlConnect.getResponseCode() == 200) {
				//do nothing
			}
			else {
				invalidLink++; 
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void getInvalidLinkCount() {
		System.out.println(invalidLink);
	}

}
