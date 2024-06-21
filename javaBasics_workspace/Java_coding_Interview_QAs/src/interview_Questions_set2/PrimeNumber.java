package interview_Questions_set2;

public class PrimeNumber {
	
	public static boolean checkPrimeNum(int num) {

		if (num == 0 || num == 1) {
			return false;
		}
		
		if(num == 2) {
			return true;
		}
		
		for (int i = 2; i <= num / 2; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		
//	Optimized solution
//		for (int i = 2; i < Math.sqrt(num); i++) {
//			if (num % i == 0) {
//				return false;
//			}
//		}

		return true;
	}
	
	public static void main(String[] args) {
		
		System.out.println(checkPrimeNum(19));
		System.out.println(checkPrimeNum(4));
		System.out.println(checkPrimeNum(102));
		
	}

}
