package utilities;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class WritePropertiesFile {
	
	public static void main(String[] args) {
		Properties prop = new Properties();
		OutputStream writeFile = null;
		
		try {
			writeFile = new FileOutputStream("config.properties");
			//this will create the properties at the project root level
			
			prop.setProperty("DBserver", "ins01.kui02.muthu01");
			prop.setProperty("DBname", "db_muthu");
			prop.setProperty("DBPass", "1240");
			
			prop.store(writeFile, "comment - Writing in properties file");
			
			System.out.println("sucessfully created properties file");
			
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
			if (writeFile != null) {
				try {
					writeFile.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
