package interview_Questions_set3;

public class CheckNoOfDigit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int num = 9830;
		
		//Method1: convert into string and find length
		String num1 = Integer.toString(num);
		System.out.println(num1.length());
		
		//Method2: use while method 
		int remainder,count=0;
		
		while(num>0) {
			remainder = num%10;
			count++;
			num = num/10;
		}
		System.out.println(count);

	}

}
