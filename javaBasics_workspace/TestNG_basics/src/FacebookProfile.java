import org.testng.annotations.Test;

public class FacebookProfile {
	
	@Test
	public void checkProfileLink() {
		System.out.println("Profile link is fine");
	}
	
	@Test
	public void checkProfileLogo() {
		System.out.println("Profile logo is fine");
	}

}


//testNG supports multiple Tests

//<?xml version="1.0" encoding="UTF-8"?>
//<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
//<suite name="Suite">
//	<test thread-count="1" name="Facebook Login positive test case">
//		<classes>
//			<class name="FacebookLogin">
//			</class>
//		</classes>
//
//	</test> <!-- Test -->
//	
//	<test thread-count="1" name="Facebook Profile test case">
//		<classes>
//			<class name="FacebookProfile">
//			</class>
//		</classes>
//
//	</test> <!-- Test -->
//	
//</suite> <!-- Suite -->
