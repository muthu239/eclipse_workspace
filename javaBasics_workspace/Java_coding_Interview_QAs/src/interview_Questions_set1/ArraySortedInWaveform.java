package interview_Questions_set1;

import java.util.Arrays;

public class ArraySortedInWaveform {
	
//	Given an unsorted array of integers, sort the array into a wave like array. 
//	An array ‘arr[0..n-1]’ is sorted in wave form if arr[0] >= arr[1] <= arr[2] >= arr[3] <= arr[4] >= …..
//
//			Examples:
//
//			 Input:  arr[] = {10, 5, 6, 3, 2, 20, 100, 80}
//			 Output: arr[] = {10, 5, 6, 2, 20, 3, 100, 80} OR
//			                 {20, 5, 10, 2, 80, 6, 100, 3} OR
//			                 any other array that is in wave form
	
//	Solution of Problem:
//		A Simple Solution is to use sorting. First sort the input array, then swap all adjacent elements.
//
//		For example, let the input array be {3, 6, 5, 10, 7, 20}. 
//	After sorting, we get {3, 5, 6, 7, 10, 20}. After swapping adjacent elements, we get {5, 3, 7, 6, 20, 10}.
	
	
// A utility method to swap two numbers.
    void swap(int arr[], int a, int b)
    {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
 
    // This function sorts arr[0..n-1] in wave form, i.e.,
    // arr[0] >= arr[1] <= arr[2] >= arr[3] <= arr[4]..
    void sortInWave(int arr[], int n)
    {
        // Sort the input array
        Arrays.sort(arr);
        System.out.println("Sorted Array : ");
        for (int i : arr)
            System.out.print(i + " ");
 
        // Swap adjacent elements
        for (int i=0; i<n-1; i += 2)
            swap(arr, i, i+1);
    }
 
    // Driver method
    public static void main(String args[])
    {
    	ArraySortedInWaveform ob = new ArraySortedInWaveform();
        int arr[] = {10, 90, 49, 2, 1, 5, 23};
        int n = arr.length;
        ob.sortInWave(arr, n);
        System.out.println("\nSorted array -> Wave Array");
        for (int i : arr)
            System.out.print(i + " ");
    }

}
