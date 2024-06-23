package interview_Questions_set3;

import java.util.Arrays;

public class ReverseArray {
	
	
	
	public static void main(String[] args) {
		int arr[] = {20,30,40,10,23,10,30,23,20,40};
		
		System.out.println("Reverse without sorting");
		for(int i = arr.length-1; i>=0 ;i--) {
			System.out.println(arr[i]);
		}
		System.out.println("**************************************");
		
		System.out.println("Sort and reverse");
		Arrays.sort(arr);
		
		for(int i = arr.length-1; i>=0 ;i--) {
			System.out.println(arr[i]);
		}
	}

}
