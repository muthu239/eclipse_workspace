package interview_Questions_set1;

public class ReverseString {
	
	//How to reverse String without inbuilt methods
	
	
	static String example= "This is an example string"; 
	
	public static void main(String[] args) {
		
		ReverseString obj = new ReverseString();
		
		obj.reverseStringWithoutInBuiltMethod(example);
		
		obj.reverseStringWithInBuiltMethods(example);
		
		
	}
	
	public void reverseStringWithoutInBuiltMethod(String sourceString) {
		int len = sourceString.length();
		
		String reversedString = "";
		
		for (int i = len-1; i>=0 ;i--) {
			reversedString = reversedString+sourceString.charAt(i);
		}
		
		System.out.println(reversedString);
	}
	
	
	public void reverseStringWithInBuiltMethods(String sourceString) {
		
		
		//using StringBuffer
		String reverse = new StringBuffer(sourceString).reverse().toString();
		
		//One way to print
		System.out.printf("Original String : %s , reverserd String : %s\n", sourceString, reverse);
		
		
		//using StringBuilder
		reverse = new StringBuilder(sourceString).reverse().toString();
		
		System.out.printf("Original String : %s , reverserd String : %s", sourceString, reverse);
		
	}

}
