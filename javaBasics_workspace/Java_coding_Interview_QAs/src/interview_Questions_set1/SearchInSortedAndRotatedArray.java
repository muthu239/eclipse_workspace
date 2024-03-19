package interview_Questions_set1;

public class SearchInSortedAndRotatedArray {
	
	// You have an sorted & rotated array, and you need to search for an element in that array
	
	// Solution : 
	// 1. You can search an element in above array using linear search but that will take O(n) time complexity
	// 2. You can use variant of binary search algorithm to solve above problem. You can use a property that you can divide array into two sorted sub arrays
	// and search in every half
	
	// Algorithm
	// Compute mid i.e) low + (high-low)/2
	// Check if arr[mid..high] is sorted
		// If number lies between the range, low = mid + 1
		// If number does not lie in the range, high = mid+1
	
	// Check if arr[low..mid] is sorted
		// If number lies between the range, high = mid + 1
		// If number does not lie in the range, low = mid+1
	
	public static void main(String[] args) {
		int arr[] = {16,19,21,25,3,5,8,10};
		
		System.out.println("Index of Element 8 : " + findElementIndex(arr, 8));
		
		int arr1[] = {6,88,101,125,220,430,500,808};
		
		System.out.println("Index of element 101 : " + findElementIndex(arr1, 101));
	}

	public static int findElementIndex(int[] arr, int num) {
		int low = 0;
		int high = arr.length-1; 
		int mid;
		
		while(low<=high) {
			
			mid = low + ((high - low)/2);
			
			if(arr[mid] == num) {
				return mid;
			}
			
			if(arr[mid]<= arr[high]) {
				//Right part is sorted
				if(num>arr[mid] && num <= arr[high]) {
					low = mid + 1;
				}
				else {
					high = mid -1 ;
				}
			}else {
				//Left part is sorted
				if(arr[low] <= num && num < arr[mid]) {
					high = mid - 1;
				}else {
					low = mid + 1 ;
				}
			}
		}
		
		
		return -1;
	}
	
}
