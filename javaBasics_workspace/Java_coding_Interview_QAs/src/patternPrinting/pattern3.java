package patternPrinting;

public class pattern3 {
	
	public static void main(String args[]) {
		for(int i = 6;i>=0;i--) {
			int num = 7;
			for(int j=0;j<7;j++) {
				if(i>=j) {
					System.out.print(num+" ");
					num--;
				}
			}
			System.out.println("");
		}
	}

}
