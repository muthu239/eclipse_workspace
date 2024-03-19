package com.test.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestBase {
	
	public Properties prop;
	
	public final int repsonse_code_200 = 200;
	
	public TestBase() throws IOException {
		prop = new Properties();
		FileInputStream inputStream = new FileInputStream(System.getProperty("user.dir")+ "\\src\\main\\java\\com\\rest\\config\\config.properties");
		
		prop.load(inputStream);
		
		
	}
	

}
