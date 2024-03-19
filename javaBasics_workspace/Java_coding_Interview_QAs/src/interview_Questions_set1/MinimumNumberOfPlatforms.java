package interview_Questions_set1;

public class MinimumNumberOfPlatforms {
	
	// You are given arrival and departure time of trains reaching to a particular station. 
	// you need to find minimum number of platforms required to accomodate the trains at any point of time
	
	//arrival = {1:00,1:40,1:50,2:00,2:15,4:00}
	//departure = {1:10,3:00,2:20,2:30,3:15,6:00}
	
	// Solution algorithm:
	// If you notice we need to find the maximum number of trains that can be on the station with the help of arrival and departure time
	
	// 1. Compare current element in arrival and departure array and pick smaller one among both
	// 2. If element is pick up from arrival array then increment platform_needed
	// 3. If element is pick up from departure array then decrement platform_needed
	// 4. While performing above steps, we need track count of maximum value reached for platform_needed
	// 5. In the end, we will return maximum value reached for platform needed
	
	
	public static void main(String[] args) {
		
		//arr[] = {1:00,1:40,1:50,2:00,2:15,4:00}
		//dep[] = {1:10,3:00,2:20,2:30,3:15,6:00}
		
		int arr[] = {100,140,150,200,215,400};
		int dep[] = {110,300,220,230,315,600};
		
		System.out.println("Minimum platforms needed : " + findPlatformsrequired(arr, dep, arr.length));
	}

	public static int findPlatformsrequired(int arr[], int dep[], int n) {
		
		int platform_needed = 0;
		int maxPlatform = 0;
		int i = 0, j=0;
		
	
		while(i < n && j < n) {
			if (arr[i] < dep[j]) {
				platform_needed++;
				i++;
				if(platform_needed > maxPlatform) { 
					maxPlatform = platform_needed;
				}
			}else {
				platform_needed--;
				j++;
			}
		}
		
		
		return maxPlatform;
		
	}

}
