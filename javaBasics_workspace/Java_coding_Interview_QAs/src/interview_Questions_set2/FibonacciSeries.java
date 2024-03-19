package interview_Questions_set2;

public class FibonacciSeries {
	
	//A Fibonacci sequence of 10 numbers: 0 1 1 2 3 5 8 13 21 34
	
	public static int fibonacciWithRecursion(int num) {
		if (num <= 1)
			return num;

		return fibonacciWithRecursion(num - 1) + fibonacciWithRecursion(num - 2);
	}
	
	
	
	public static void fibonacciWithoutRecursion(int num) {
		
		int a = 0;
		int b = 1;
		int c = 1;

		for (int i = 1; i <= num; i++) {
			System.out.print(a + " ");

            a = b;
			b = c;
			c = a + b;
		}
	}

	public static void main(String[] args) {
		
		int num = 10;
		
		System.out.println("Without Recursion : ");
		
		fibonacciWithoutRecursion(num);
		
		System.out.println("\nWith Recursion : ");
		
		for (int i = 0; i < num; i++) {
      	    System.out.print(fibonacciWithRecursion(i) + " ");
    	}
		
		
		
	}
		
	

}
