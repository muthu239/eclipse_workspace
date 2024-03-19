package exceptionHandling;

public class SampleException {

	public static void main(String[] args) {
		
		try {
			
			int value = 100;
			int result = 100/0;
			
			System.out.println(result);
		}catch(Exception e) {
			
			System.out.println(e);
			
			e.printStackTrace();
			
		
			System.out.println("You have reached catch block since there is an exception in try block");
			
		}
		
		
		try {
			
			String text = null;
			
			System.out.println(text.length());
			
		}catch (Exception e) {
			
			e.printStackTrace();
			System.out.println("You have reached catch block since there is an exception in try block");
		}
		

	}

}
