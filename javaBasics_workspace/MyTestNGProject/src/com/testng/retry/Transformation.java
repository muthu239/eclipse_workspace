package com.testng.retry;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

public class Transformation implements IAnnotationTransformer{

	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		
		Class<? extends IRetryAnalyzer> retry = annotation.getRetryAnalyzerClass();
		
		if(retry == null) {
			annotation.setRetryAnalyzer(Retry.class);
		}
		
		
	}
	
}
