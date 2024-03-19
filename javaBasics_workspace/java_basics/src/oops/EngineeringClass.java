package oops;

public class EngineeringClass implements Student {

	
	public void displayName() {
		System.out.println("TOM");
		
	}

	
	public void getDept() {
		System.out.println("BE CSE");
		
	}

	
	public void getRollNumber() {
		System.out.println("11");
		
	}
	
	public void getUniversity() {
		System.out.println(Student.university);
	}
	
	public static void main(String[] args) {
		EngineeringClass obj = new EngineeringClass();
		
		obj.displayName();
		obj.getDept();
		obj.getRollNumber();
		obj.getUniversity();
		
	}

}
