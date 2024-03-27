package interview_Questions_set1;

import java.io.BufferedReader;
import java.io.FileReader;

public class CountWords {

	// How to count number of words in File in Java

	public static void main(String[] args) {

		// In Java, you can use the regular expression pattern “\\s+” to catch multiple spaces.
		// The “\s” is a character class to find white space, which could match both
		// space and tabs and “+” makes it greedy because
		// it will match one or more of “\s” pattern i.e. one or more space. Now, since
		// you need to escape the “\” backward slash in Java,
		// the whole pattern becomes”\\s+”.

		

		CountWords readFile = new CountWords();

		try {
			readFile.startCount();
		} catch (Exception e) {
			System.out.print("Some problem occured");
		}
	}

	public void startCount() throws Exception {
		
		int wordCount = 0;
		FileReader fr = null;
		BufferedReader br = null;

		try {

			// Declare the file path
			fr = new FileReader("D://SampleTest.txt");
			br = new BufferedReader(fr);

			// Read lines
			String line = br.readLine();
			while (line != null) {
				String a[] = line.split("\\s+");
				
				// Save count of Words in File
				wordCount += a.length;
				line = br.readLine();
			}
			System.out.print("Total number of words : " + wordCount);
			br.close();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error" + e.getMessage());

		} finally {
			br.close();
			fr.close();
		}

	}

}
