package interview_Questions_set1;

import java.util.HashMap;
import java.util.Map.Entry;


public class OddNumberOfOccurence {
	
	
	// How to find a number occurring odd number of times in the array
	// you are given a array of integer. All numbers occur even number of times except one. You need to find the number which occurs odd number of time
	// you need to solve it with O(n) time complexity and O(1) space complexity
	
	// Solution 1:
		// Use two loops and compare elements
		// This is brute force solution for this problem, but it takes O(n*n) time complexity
	
	// Solution 2: (Suitable solution)
		// Use Hashing
		// You can use key as number and count as value and whenever key is repeated, increment counter by 1
	
	public int getOddTimeElement(int[] arr) {
		
		int i;
		
		
		HashMap<Integer, Integer> elements= new HashMap<Integer, Integer>();
		
		for(i = 0; i<arr.length ; i++) {
			int element = arr[i];
			if(elements.get(element) == null) {
				elements.put(element, 1);
			}else {
				elements.put(element, elements.get(element)+1);
			}
		}
		
		for(int key : elements.keySet()) {
			if(elements.get(key)%2 ==1) {
				return key;	
			}
		}
		

		return -1;
	}
	
	
	public static void main(String[] args) {
		OddNumberOfOccurence obj = new OddNumberOfOccurence();
		int arr[] = {20,30,40,10,23,10,30,23,20};
		
		System.out.println("Number occurring odd number of times : " + obj.getOddTimeElement(arr));
	}

}
