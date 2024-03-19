package interview_Questions_set2;

public class VowelPresence {
	
	public static void checkForVowel(String input) {
		
		boolean a = input.toLowerCase().matches(".*[aeiou].*");
		
		System.out.println(a);
	}
	
	//Method 2 : Traverse through string and look for vowel
	
	public static void main(String[] args) {
		
		checkForVowel("Apple");
		checkForVowel("Map");
		checkForVowel("bbbbbb");
		
	}

}
