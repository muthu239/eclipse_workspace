package javaBasic;

public class UniqueCharacters {
	public static void main(String[] args) {
		String str = "ABBCAFF";
		String temp = "";
	    for (int i = 0; i < str.length(); i++){
	        char ch = str.charAt(i);
	        if (temp.indexOf(ch) < 0){
	            temp = temp + ch;
	        } else {
	            temp = temp.replace(String.valueOf(ch), "");
	        }
	    }

	    System.out.println(temp + " ");
	}
}
