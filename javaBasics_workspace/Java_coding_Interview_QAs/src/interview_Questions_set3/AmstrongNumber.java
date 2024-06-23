package interview_Questions_set3;

public class AmstrongNumber {

//		153: 1^3 + 5^3 + 3^3 = 1 + 125+ 27 = 153
//
//		125: 1^3 + 2^3 + 5^3 = 1 + 8 + 125 = 134 (Not an Armstrong Number)
	
	
	public static boolean amstrongNo(int num) {
		
		int num2 = num;
		
		//Method1: convert into string and find length
				String num1 = Integer.toString(num);
				int len1 = num1.length();
				
				
				int remainder, sum=0;
				
				while(num>0) {
					remainder = num%10;
					sum = (int) (sum+(Math.pow(remainder, len1)));
					num = num/10;
				}
				
				if(num2==sum) {
					return true;
				}else {
					return false;
				}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(amstrongNo(125));
		System.out.println(amstrongNo(153));
		System.out.println(amstrongNo(1634));

	}

}
