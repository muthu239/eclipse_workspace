import org.testng.annotations.Test;

public class FaceBookLogin {

	@Test
	public void loginWithValidCredentials() {

		System.out.println("Hi, I am successfully Loged-in");

	}

	@Test
	public void loginWithInValidCredentials() {

		System.out.println("Hi, I am not unable to Log-in");

	}
	
	@Test
	public void loginWithInValidUserName() {

		System.out.println("Hi, I am not unable to Log-in");

	}

}



//TestNG.xml file

//<?xml version="1.0" encoding="UTF-8"?>
//<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
//<suite name="Suite">
//	<test thread-count="1" name="Facebook Login positive test case">
//		<classes>
//			<class name="FaceBookLogin">
//			</class>
//		</classes>
//
//	</test> <!-- Test -->
//</suite> <!-- Suite -->
