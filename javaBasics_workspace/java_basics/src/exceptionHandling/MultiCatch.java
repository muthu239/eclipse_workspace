package exceptionHandling;

public class MultiCatch {

	public static void main(String[] args) {
try {
//			
//			int value = 100;
//			int result = 100/0;
			
		String text = null;
		text.length();
	
		}catch(ArithmeticException ae) {
			System.out.println("Arithmeic catch block");
			ae.printStackTrace();
		}catch (Exception e) {
			System.out.println("generic catch block");
			e.printStackTrace();
		}

	}

}
