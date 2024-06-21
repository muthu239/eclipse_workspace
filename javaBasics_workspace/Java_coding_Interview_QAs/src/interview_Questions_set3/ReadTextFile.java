package interview_Questions_set3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadTextFile {
	public static void main(String[] args) throws IOException {
		File file = new File("E:\\CTS\\Daily learning.txt");
		
		BufferedReader bf = new BufferedReader(new FileReader(file));
		
		String str ;
		while ((str = bf.readLine()) != null)
		    System.out.println(str);
	}

}
