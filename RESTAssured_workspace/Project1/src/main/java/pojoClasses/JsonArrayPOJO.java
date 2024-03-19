package pojoClasses;

public class JsonArrayPOJO {
//	creating the below Json using the code below
	
	
//	[ {
//		  "firstname" : "ABC",
//		  "lastname" : "XYZ",
//		  "gender" : "male",
//		  "age" : 29,
//		  "salary" : 155.5,
//		  "married" : true
//		}, {
//		  "firstname" : "Mark",
//		  "lastname" : "Zuck",
//		  "gender" : "Female",
//		  "age" : 30,
//		  "salary" : 130.5,
//		  "married" : true
//		}, {
//		  "firstname" : "Bruce",
//		  "lastname" : "Wayne",
//		  "gender" : "male",
//		  "age" : 20,
//		  "salary" : 999.9,
//		  "married" : true
//		} ]
		
	
	private String firstname;
	private String lastname;
	private String gender;
	private int age;
	private double salary;
	private boolean married;
	
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public boolean isMarried() {
		return married;
	}
	public void setMarried(boolean married) {
		this.married = married;
	}

}
