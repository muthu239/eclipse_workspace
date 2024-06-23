package interview_Questions_set3;

public class ReverseEachWord {
	
	//Method 1 : reverse using length
	public void reverseEachWordsUsingLength(String[] arr) {
		
		for(int i = 0 ;i< arr.length ; i++) {
			int wordlen = arr[i].length();
			String word = arr[i];
//			System.out.println(wordlen);
//			System.out.println(word);
			String temp = "";
			for(int j = wordlen-1 ; j>=0 ; j--) {
				temp = temp+word.charAt(j);
			}
			arr[i] = temp;
			System.out.println(arr[i]);
		}
		
	}
	
	//Method2 : Reverse using inbuilt method
	public void reverseStringUsingInBuiltMethod(String[] arr) {
		for(int i= 0;i<arr.length;i++) {
			StringBuffer word = new StringBuffer(arr[i]);
			word.reverse();
			arr[i] = word.toString();
			System.out.println(arr[i]);
		}
	}
	
	
	
	public static void main(String[] args) {
		String sentence = "Luffy Zoro Nami Usopp Chopper Franky Sanji Robin Jinbe";
		
		String[] arr = sentence.split(" ");
		String[] arr1 = sentence.split(" ");
		
		ReverseEachWord obj = new ReverseEachWord();
		obj.reverseEachWordsUsingLength(arr);
		
		System.out.println("***********************************************************");
		
		obj.reverseStringUsingInBuiltMethod(arr1);
		
//		for(int i = 0 ; i < arr.length ;i++) {
//			System.out.println(arr[i]);
//		}
		
		
	}

}
