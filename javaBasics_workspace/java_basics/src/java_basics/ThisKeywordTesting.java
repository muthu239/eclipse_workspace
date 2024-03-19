package java_basics;

public class ThisKeywordTesting {
	
	int rollNumber;
	String name;
	String standard;
	
	public ThisKeywordTesting(int i, String n) {
		rollNumber = i;
		name = n;
	}
	
	public ThisKeywordTesting(int rollNumber, String name, String standard) {
		
		//when the parameter i.e)local variable is using the same name as the class variables, this keyword helps in declaring. 
		//this.rollNumber ->means the class variable rollNumber
		//when the parameter is not using the same variable name as class variables then this is not required 
		
		this.rollNumber = rollNumber;
		this.name = name;
		this.standard = standard;
		
	}
	
	public void display() {
		System.out.println("Rollnumber is  " + rollNumber + " name is " + name + " standard is " + standard);
	}

	public static void main(String[] args) {
		
		ThisKeywordTesting obj = new ThisKeywordTesting(2, "Tom");
		obj.display();
		
		ThisKeywordTesting obj1 = new ThisKeywordTesting(2, "Tom","2nd");
		obj1.display();

	}

}
