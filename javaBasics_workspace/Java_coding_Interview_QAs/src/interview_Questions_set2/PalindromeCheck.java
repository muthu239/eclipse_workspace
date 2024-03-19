package interview_Questions_set2;

public class PalindromeCheck {
	
	public static boolean palindromeString(String str) {
		
		int len = str.length();
		
		for(int i = 0; i<len/2; i++) {
			if(str.charAt(i) != str.charAt(len-1-i)) {
				return false;
			}
		}
		
		
		return true;
	}
	
	
	public static boolean palindromeNumber(int num) {
		
		int tem, remainder, sum = 0;
		
		tem = num;
		
		while(num>0) {
			remainder = num%10;
			sum = (sum*10) + remainder;
			num = num/10;
		}
		
		if(sum == tem) {
			return true;
		}else {
			return false;
		}
		
	}
	
	
	public static void main(String[] args) {
		
		System.out.println(palindromeString("madam"));
		
		System.out.println(palindromeString("apple"));
		
		System.out.println(palindromeNumber(12521));
		
		System.out.println(palindromeNumber(5634));
		
	}

}
