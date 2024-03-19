import org.testng.annotations.Test;

public class FaceBookProfileTest {
	
	@Test
	public void checkProfileLink(){
		System.out.println("Profile Link is fine");
	}
	
	@Test
	public void checkProfileLogo(){
		System.out.println("Profile Logo is fine");
	}

}

//testNG supports multiple Tests

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
//	
//	<test thread-count="1" name="Facebook Profile test case">
//		<classes>
//			<class name="FaceBookProfileTest">
//			</class>
//		</classes>
//
//	</test> <!-- Test -->
//	
//</suite> <!-- Suite -->
