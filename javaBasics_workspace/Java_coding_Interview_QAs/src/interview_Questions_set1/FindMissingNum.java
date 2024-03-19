package interview_Questions_set1;

public class FindMissingNum {

	// You are given an integer array containing 1 to n but one of the number from 1 to n in the array is missing. 
	// You need to provide an optimum solution to find the missing number.
	// Note : Number cannot be repeated in the array
	// eg : [1,2,3,4,6,7,8,9,10]
	// missing is 5
	
	//Solution:
	// 1. Find the sum of  of n numbers using formula n = n*(n+1)/2
	// 2. Find the sum of elements present in given array
	// 3. Subtract (Sum of n numbers - Sum of elements present in the array)
	
	
	public static void main(String[] args) {
		int[] arr1 = {8,9,7,5,6,1,4,2};
		
		System.out.println("Missing element of arr1 : " + missingNumber(arr1));
		
		int[] arr2 = {5,3,1,2,4,7};
		
		System.out.println("Missing element of arr2 : " + missingNumber(arr2));
		
		
	}
	
	public static int missingNumber (int[] arr) {
		int n = arr.length+1;  //including the missing number size
		int sum = n * (n+1)/2;
		
		int arrElementSum = 0;
		
		for(int i = 0; i<arr.length ;i++) {
			arrElementSum += arr[i];
		}
		
		int missingNum = sum - arrElementSum;
		
		return missingNum;
	}
	
	
}
