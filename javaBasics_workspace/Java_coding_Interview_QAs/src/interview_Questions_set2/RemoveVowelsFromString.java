package interview_Questions_set2;

public class RemoveVowelsFromString {
	
	public static void method1(String str) {
		String newStr = "";
		//Using concept of regex and split we are removing characters
		String[] strArr = str.split("[aeiouAEIOU]");
		for(String s: strArr) {
			System.out.println(s);
			newStr = newStr+s;
		}
		System.out.println(newStr);
	}
	
	public static void main(String[] args) {
		method1("Appleadaykeepsthedoctoraway");
	}

}
