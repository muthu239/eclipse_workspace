package javaWithProp;

import java.io.FileInputStream;
import java.util.Properties;

public class UsePropertiesFile {
	public static Properties prop;
	public static void main(String[] args) {
	
		
		if (prop == null) {
			prop = new Properties();
			try {
				FileInputStream file = new FileInputStream("E:\\eclipse_workspace\\javaBasic\\src\\javaWithProp\\newProp.properties");
				prop.load(file);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(prop.getProperty("websiteURL"));
		System.out.println(prop.getProperty("browserName"));
		
	}
	

}
