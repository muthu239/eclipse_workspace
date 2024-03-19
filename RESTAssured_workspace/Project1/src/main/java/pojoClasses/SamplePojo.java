package pojoClasses;

public class SamplePojo {
	
//Json of below format is the target to create	

//	{
//		"firstname" : "ABC",
//		"lastname" : "Mahan";
//		"gender" : "male";
//		"age" : 12
//		"salary" : 122.56
//		"married" : false
//		}
	
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
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isMarried() {
		return married;
	}
	public void setMarried(boolean married) {
		this.married = married;
	}
	
	

}
