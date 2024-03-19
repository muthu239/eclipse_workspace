package java_basics;

public class ConstructorTesting {
	
	public ConstructorTesting() {
		System.out.println("This message is inside constructor");
		System.out.println("Second message");
	}
	
	int rollNumber;
	String name;
	
	public ConstructorTesting(int i, String s) {
		rollNumber = i;
		name = s;
	}
	
	public void display() {
		System.out.println("RollNumber is " + rollNumber + " and Name is " + name);
	}

	public static void main(String[] args) {
		ConstructorTesting obj = new ConstructorTesting();
		
		ConstructorTesting obj1 = new ConstructorTesting(2,"Hulk");
		obj1.display();
		
		obj.display();  //this will return null coz this refers to the obj created for default constructor

	}

}
