package interview_Questions_set1;

public class FindFirstTwoSmallestInArray {
	
//	Problem Statement
//		Write a program to find the smallest and second smallest element in array, without Sorting the array
//		
//		Example:
//			arr[] = {17,20,8,130,1,130,17}
//		
//	First smallest number = 1
//	Second smallest Number = 8
	
	
	public void findSmallest(int[] arr) {
		int first , second, length = arr.length;
		
		first = second = Integer.MAX_VALUE;
		
		for(int i = 0 ;i<length ; i++) {
			if(arr[i]<first) {
				second = first;
				first = arr[i];
			}
			else if(arr[i]<second && arr[i]!=first) {
				second = arr[i];
			}
		}
		
		System.out.println("First smallest element : " + first);
		System.out.println("Second smallest element : " + second);
	}
	
	public static void main(String[] args) {
		
		int[] arr = {17,20,8,130,1,130,17};
		
		FindFirstTwoSmallestInArray obj = new FindFirstTwoSmallestInArray();
		
		obj.findSmallest(arr);
		
	}

}
