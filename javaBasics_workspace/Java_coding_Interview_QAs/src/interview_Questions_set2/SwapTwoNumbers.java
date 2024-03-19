package interview_Questions_set2;

public class SwapTwoNumbers {
	
	public void swapTwoNumWithoutThird(int num1, int num2) {
		//a = 10, b = 2
		num2 = num1+num2;  //b = 10+2 = 12
		num1 = num2-num1;	//a = 12-10 = 2
		num2 = num2-num1;	//b = 12-2 = 10
		
		System.out.println(num1 +" " + num2);
		
	}
	
	public void swapWithThirdValue(int num1, int num2) {
		
		int tem = 0;
		
		tem = num1;
		num1 = num2;
		num2 = tem;
		
		System.out.println(num1 + " " + num2);
		
	}

	public static void main(String[] args) {
		SwapTwoNumbers obj = new SwapTwoNumbers();
		obj.swapTwoNumWithoutThird(12, 5);
		obj.swapWithThirdValue(3, 7);
		
	}
	
}
