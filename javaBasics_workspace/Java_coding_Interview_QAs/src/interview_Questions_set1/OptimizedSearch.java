package interview_Questions_set1;

//How to get value from a index in a sorted array. in the most optimized way 

public class OptimizedSearch {
	
	int[] numbers = {2,6,10,51,63,233,6754};
	
	public void linearSearch(int value) {
		
		//Time complexity: O(n)
		
		int index = 0;
		boolean flag = false;
		
		for(int i =0; i<numbers.length ;i++) {
			if(numbers[i] == value) {
				index = i;
				flag = true;
				break;
			}
				
		}
		
		if(flag) {
			System.out.println("Element is at index : " +  index);
		}
		else {
			System.out.println("Element is not available");
		}
	}
	
	
	
	public void binarySearch(int value) {
		
		//Binary search : Time complexity : O(log n) -> Worst case
		//									O(1) -> Best case
		
		int len = numbers.length - 1;
		
		int start = 0;
		
		while(start<=len) {
			int mid = start + (len-start)/2;
			
			if(numbers[mid] == value) {
				System.out.println("Element is at index : " +  mid);
				break;
			}
			else if(numbers[mid] > value) {
				len = mid - 1;
			}
			else{
				start = mid +1;
			}	
		}
	}
	
	

	public int binarySearchRecursion(int arr[], int value ,int start, int len) {
		
		if(start<=len) {
			int mid = start + (len-start)/2;
			
			if(numbers[mid] == value) {
				System.out.println("Element is at index : " +  mid);
				return mid;
			}
			else if(numbers[mid] > value) {
				return binarySearchRecursion(arr, value, start, mid-1);
			}
			else{
				
				return binarySearchRecursion(arr, value, mid+1, len);
			}
		}
		
		
		return -1;
	}
	
	
	public static void main(String[] args) {
		OptimizedSearch obj = new OptimizedSearch();
		
//		obj.linearSearch(63);
		obj.binarySearch(63);
		int indexNumber = obj.binarySearchRecursion(obj.numbers, 63, 0, obj.numbers.length);
		System.out.println("Index Number is  : " +  indexNumber);
		
	}

}
