Feature: Navigate to MycontactsForm 		

Scenario Outline: Add Details to Basic details form
	Given Go to mycontactsform site
	Then  Add the "<name>" and "<email>"
	Then  Enter the "<message>"
	Then  Click on submit Button
	
	
	Examples:
	|name|email|message|
	|Roronoa Zoro|muthu99n23@gmail.com|Hello Roronoa Zoro.|
	
	
#if we want give values without examples
	
#Scenario: Add Details to Basic details form
#	Given Go to mycontactsform site
#	Then  Add the "Roronoa Zoro" and "muthu99n23@gmail.com"
#	Then  Enter the "Hello Roronoa Zoro."
#	Then  Click on submit Button