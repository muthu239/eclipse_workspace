package com.testng.dataprovider;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestParameterExample {
	
	@Test (dataProvider = "getData")
	public void testAddition(int actual, int expected){
		int actualValue = actual + 20;
		
		Assert.assertEquals(actualValue, expected);
	}
	
	
	@DataProvider
	public Object[][] getData(){
		return new Object[][]{
			{100, 120},
			{200, 220},
			{250, 270},
			{300, 310},
			{400, 420}
		};
	}
	
	@DataProvider (name = "DoubleSet")
	public String[][] getDataSet2(){
		return new String[][]{
			{"s10", "30"},
			{"20", "40"},
		};
	}
	
	@Test
	public void newMethod() {
		TestParameterExample tp = new TestParameterExample();
		System.out.println(tp.getDataSet2()[0][0]);
		String abc = tp.getDataSet2()[0][0];
		String ab = tp.getDataSet2()[0][1];
		Assert.assertEquals(abc, ab,"new");
	}
}
