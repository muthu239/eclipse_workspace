package oops;

public class BMW extends Car {
	
	static String name = "BMW";
	String color = "White";
	
	public void run() {
		System.out.println("BMW is running");
		super.run();
	}
	
	public void getColor() {
		//this method to learn about super keyword
		System.out.println(color);
		System.out.println(super.color);
	}

	public static void main(String[] args) {
		
	//this code is to check inheritance	
//		Car car = new Car();
//		System.out.println(name);
//		car.run();
		
		
		//this code is to check super keyword
		BMW bmw = new BMW();
		bmw.getColor();
		bmw.run();

	}

}
