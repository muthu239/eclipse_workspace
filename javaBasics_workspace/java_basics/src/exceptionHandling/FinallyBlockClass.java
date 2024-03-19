package exceptionHandling;

public class FinallyBlockClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			String name = "abc";
			System.out.println(name);
			
			String text = null;
			text.length();
		
			
		}catch (Exception e) {
			System.out.println("catch block");
			e.printStackTrace();
		}finally {
			System.out.println("finally block");
		}
	}

}
