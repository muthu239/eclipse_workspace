package interview_Questions_set3;

public class PrintCharAsPerNoOfTimes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String pattern = "A3B1C1D2";
		String newPattern = "";
		int count = 0;
		for(int i=1;i<pattern.length();i=i+2) {
			char c = pattern.charAt(i);
			int n = count * 10+c-'0';
			for(int j = 0;j<n;j=j+1) {
				newPattern = newPattern+pattern.charAt(i-1);
			}
		}
		System.out.println(newPattern);
	}
}
