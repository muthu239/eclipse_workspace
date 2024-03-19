package java_basics;

public class StaticVariableTesting {
	
	int i = 0;
	static int j = 0;
	
	public StaticVariableTesting() {
		
		i++;
		j++;
		
		System.out.println("Non static variable i : " + i);
		System.out.println("Static variable j : " + j);
	}
	

	public static void main(String[] args) {
	
		StaticVariableTesting obj = new StaticVariableTesting();
		StaticVariableTesting obj1 = new StaticVariableTesting();
		StaticVariableTesting obj2 = new StaticVariableTesting();
		
		System.out.println(obj.i); //non static can be accessed only by obj
		
		System.out.println(StaticVariableTesting.j); //static 

		
		
	}

}
