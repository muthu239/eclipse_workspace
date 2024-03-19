package interview_Questions_set1;

public class FindSecondLargestNum {
	
	// Given an unsorted array, you need to find the second largest element in the array in O(n) time complexity
	
	// Solution
	// 1. We can sort the array and then return second last element in the array but it will be done in O(nlog n) time
	
	//Alternate method
	// Initialize Highest and secondHighest with minimum possible value
	// Iterate over array
	// If current element is greater than Highest
	//	Assign secondHighest = Highest
	// 	Assign highest = currentElement
	// Else if current element is greater than secondHighest
	// 	Assign secondHighest = currentElement
	
	public static void main(String[] args) {
		int arr[] = {7,5,8,3,1,9};
		
		int secondHigh = findSecondLargest(arr);
		
		System.out.println("Second largest element is : " +  secondHigh);
	}
	
	public static int findSecondLargest(int[] arr) {
		
		int highest = Integer.MIN_VALUE;
		int secondHighest = Integer.MIN_VALUE;
		
		for(int i=0 ; i< arr.length ; i++) {
			if(arr[i] > highest) {
				secondHighest = highest;
				highest = arr[i];
			}
			else if(arr[i] > secondHighest) {
				secondHighest = arr[i];
			}
		}
		
		return secondHighest;
	}

}
