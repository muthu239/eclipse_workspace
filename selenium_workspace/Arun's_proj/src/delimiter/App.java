package delimiter;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		 String fileName = "E:\\Arun_2\\Work\\sample.txt";
		 String outFile = "E:\\Arun_2\\Work\\mtcn4.txt";
		 String result = null;
	       
		 FileWriter fw;
		
	
	        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
	        	//System.out.println("Number of MTCN:::"+stream.count());
	        	//String result  = stream.collect(Collectors.joining(","));
	        	 result = stream.collect(Collectors.joining("','", "'", "'"));
	            //System.out.println(result);
	          //System.out.println(result.substring(0, 130));
	         // System.out.println(result.substring(130, 260));
	            //System.out.println(result.length());
	        	 fw = new FileWriter(outFile);
	          for (int i = 0; i<=result.length();i=i+130) {
	        	 
	        	  int j = i+130;
	        	  
	        	  if(j>result.length()) {
	        		  j = result.length();
	        	  }
	        	  //System.out.println("I:::" + i + " J:::" + j);
	        	// System.out.println(result.substring(i, j));
	        	  fw.write(result.substring(i,j)+"\n");
	          }
	          fw.close();

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	       
	        

	}

	}
