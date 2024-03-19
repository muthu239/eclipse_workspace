package com.testng.retry;

import org.testng.annotations.Test;

public class SamplClassTwo {
	
	@Test (retryAnalyzer = Retry.class)
	public void sampleTestTwoMethodOne(){
		System.out.println("Hi, I am from Sample Class Two, Method One");
	}
	
	@Test (retryAnalyzer = Retry.class)
	public void sampleTestTwoMethodTwo(){
		
		int i = 1/0;
		System.out.println("Hi, I am from Sample Class Two, Method Two");
	}

}
