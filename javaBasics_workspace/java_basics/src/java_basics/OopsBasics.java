package java_basics;

public class OopsBasics {
	
	String name = "Tom";
	String breed = "German Shepard";
	int height = 4;
	
	public void barking() {
		System.out.println(name + " is barking");
	}
	
	public void eating() {
		System.out.println(name + " is eating");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		OopsBasics obj = new OopsBasics();
		OopsBasics obj1 = new OopsBasics();
		
		System.out.println(obj.height);
		obj.barking();
		obj1.eating();

	}

}
