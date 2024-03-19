package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadPropertiesFile {

	public static void main(String[] args) {
		Properties prop = new Properties();
		InputStream readFile = null;
		
		try {
			readFile = new FileInputStream("config.properties");

				prop.load(readFile);
			
			
			System.out.println(prop.getProperty("DBname"));
			System.out.println(prop.getProperty("DBserver"));
			System.out.println(prop.getProperty("DBPass"));

					
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(readFile != null) {
				try {
					readFile.close();
					
				} catch (IOException e) {
				
					e.printStackTrace();
				}
			}
		}
		
		
		
	}
	
}
