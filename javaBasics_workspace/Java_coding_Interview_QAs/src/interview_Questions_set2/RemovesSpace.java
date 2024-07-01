package interview_Questions_set2;

public class RemovesSpace {
	
	public static void removeWhitSpace(String str) {
		
		String finalStr = "";
//		System.out.println(str.replace(" ", ""));
		 char[] charArr = str.toCharArray();
		 
		 
		 for(char a : charArr) {
			 if(!Character.isWhitespace(a)) {
				 finalStr = finalStr+a;
			 }
		 }
		 
		 System.out.println(finalStr);
	}
	
	public static void main(String[] args) {
		
		removeWhitSpace("apple a day keeps doctor away");
	}

}
