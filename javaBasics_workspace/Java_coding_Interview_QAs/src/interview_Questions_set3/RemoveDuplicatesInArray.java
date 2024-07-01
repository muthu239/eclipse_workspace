package interview_Questions_set3;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class RemoveDuplicatesInArray {

	//Method1 : Convert Array to set //Output will be unsorted
	public Set removeDuplicatesUsingSet(int[] arr) {
		
		Set<Integer> newSet = new HashSet<Integer>();

		for(int i=0;i<arr.length;i++) {
			newSet.add(arr[i]);
		}
		
		System.out.println("Traverse through set using for");
		//Traverse through set using for
		for(int i : newSet) {
			System.out.println(i);
		}
		
		System.out.println("Traverse through set using Iterator");
		//Traverse through set using Iterator		
		Iterator it = newSet.iterator();
		while(it.hasNext()) { 
			System.out.println(it.next()); 
		}
		
		return newSet;

	}
	
	//Method 2 : Without using collections. Sort any array and traverse  //Output will be sorted
	
	public void removeDuplicatesUsingTempArray(int[] arr) {
		
		Arrays.sort(arr); //sort array
		int n = arr.length;
		
		if(n == 0 || n == 1 ) {
			System.out.println(arr);
		}
		
		int[] temp = new int[n];  
        int j = 0;  
        for (int i=0; i<n-1; i++){  
            if (arr[i] != arr[i+1]){  
                temp[j++] = arr[i];  
            }  
         }  
        temp[j++] = arr[n-1];   
        
        System.out.println("Duplicates removed and sorted array : ");
        // Changing original array  
        for (int i=0; i<j; i++){  
            arr[i] = temp[i]; 
            System.out.println(arr[i]);
        }  
		
		
		
		
		
	}
	
	
	
	
	public static void main(String[] args) {
		RemoveDuplicatesInArray obj = new RemoveDuplicatesInArray();
		int arr[] = {20,30,40,10,23,10,30,23,20,40};
		
		System.out.println("After removing duplicates array is : " + obj.removeDuplicatesUsingSet(arr));
		obj.removeDuplicatesUsingTempArray(arr);
		
	}

}

