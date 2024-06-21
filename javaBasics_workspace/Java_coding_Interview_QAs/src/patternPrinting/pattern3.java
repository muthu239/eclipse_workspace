package patternPrinting;

public class pattern3 {
	
	
//	7 6 5 4 3 2 1 
//	7 6 5 4 3 2 
//	7 6 5 4 3 
//	7 6 5 4 
//	7 6 5 
//	7 6 
//	7 

	
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
