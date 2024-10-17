package interview_Questions_set3;

public class PrintCharAsPerNoOfTimes {
	
	
	public static void method2(String str) {
		char[] charArray = str.toCharArray();
		String newString = "";
		for(int i = 0 ; i<charArray.length;i++) {
			if(Character.isDigit(charArray[i])) {
				int n = Integer.valueOf(charArray[i]);  //returns ascii value 
				System.out.println("Ascii Value of "+charArray[i]+" character is "+n);
				for(int j = 0 ; j<(n-48);j++) {                          //Ascii value of '0'(Zero) is 48, Ascii of '1' is 49
					newString = newString+charArray[i-1];
				}
			}
		}
		
		System.out.println(newString);
	}
	
	public static void method1(String pattern) {
		String newPattern = "";
		int count = 0;
		for(int i=1;i<pattern.length();i=i+2) {
			char c = pattern.charAt(i);
			int n = count * 10 + c-'0';                     //Same as the method2 but written in logical way instead of using inbuilt methods
			for(int j = 0;j<n;j=j+1) {
				newPattern = newPattern+pattern.charAt(i-1);
			}
		}
		System.out.println(newPattern);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String pattern = "A3B1C1D4";
		method1(pattern);
		System.out.println("*********************************Method 2*************************");
		method2(pattern);
	}
}
