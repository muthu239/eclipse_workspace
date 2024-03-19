package java_basics;

public class FirstJavaProgram {
	
	//static variable example
	public static String myvar = "static variable";
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("This is my first java program");
		
		System.out.println(myvar);
		
		FirstJavaProgram obj = new FirstJavaProgram();
		FirstJavaProgram obj1 = new FirstJavaProgram();
		FirstJavaProgram obj2 = new FirstJavaProgram();
		
		System.out.println(obj.myvar);   //static variable
		System.out.println(obj1.myvar);  //static variable
		
		obj2.myvar = "changed variable";
		
		System.out.println(obj.myvar);   //changed variable
		System.out.println(obj1.myvar);  //changed variable
	}

}
