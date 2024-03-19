package interview_Questions_set2;

public class FactorialOfNum {
	
	//F(n) = F(1)*F(2)...F(n-1)*F(n)
	
	public static long factorialWithRecursion(long num) {
		
		if(num ==1) {
			return 1;
		}
		else {
			return (num * factorialWithRecursion(num-1));
		}
	}
	
	public static void main(String[] args) {

		System.out.println(factorialWithRecursion(5));
	
	}

}
