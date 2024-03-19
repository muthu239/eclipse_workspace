Feature: Sign Up 

Scenario: Sign Up Scenario
		Given User is on Application Home Page 
		When Application Page Title is PHP Travels
		Then user clicks on MY ACCOUNT 
		And user clicks on Sign Up option
		When User navigate to Sign Up page
		Then user enters personal data and the entered values are validated 
		| Roronoa | Zoro | 9786583300 | muthu99n23@gmail.com | aqwer1234@ | aqwer1234@ |
		
		Then click on Sign Up button
		Then Close the Browser
