package patternPrinting;

public class pattern2 {
	
//    1
//   11
//  111
// 1111

	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 1;
		for(int i = 0;i<4;i++) {
			for(int j =(4-i);j>=0;j--) {
				System.out.print(" ");
			}
			for(int j=0;j<=i;j++) {
				System.out.print(num);
						
			}
			System.out.println("");
		}

	}

}
