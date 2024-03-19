package java_basics;

public class SecondJavaProgram {
	
	
	//Instance variable example
	
	String myVar = "Instance variable";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SecondJavaProgram obj1 = new SecondJavaProgram();
		SecondJavaProgram obj2 = new SecondJavaProgram();
		
		System.out.println(obj1.myVar);   //Instance variable
		System.out.println(obj2.myVar);   //Instance variable
		
		obj1.myVar = "Changed value";
		
		System.out.println(obj1.myVar);    //Changed value
		System.out.println(obj2.myVar);    //Instance variable
		FirstJavaProgram obj3 = new FirstJavaProgram();
		
		
	}

}
