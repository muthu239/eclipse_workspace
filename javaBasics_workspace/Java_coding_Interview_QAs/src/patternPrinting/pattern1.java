package patternPrinting;

public class pattern1 {
	
	
//	0 
//	1 2 
//	3 4 5 
//	6 7 8 9 
	
	
	
	public static void main(String args[]) {
		int num =0;
		for(int i=0;i<4;i++) {
			for(int j=0;j<=i;j++) {
				System.out.print(num+" ");
				num++;
			}
			System.out.println("");
		}
	}

}


