import org.testng.annotations.Test;

public class FacebookLogin {
	
	@Test
	public void loginWithValidCred() {
		System.out.println("I am successfully logged in");
	}
	
	@Test
	public void loginWithInvalidCred() {
		System.out.println("I am not Successful in logging in");
	}

}


//TestNG.xml file

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
//</suite> <!-- Suite -->
