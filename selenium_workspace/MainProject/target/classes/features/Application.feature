Feature: Test Sprint retrospection

Scenario Outline: Navigate to sprint retrospection
	Given user is logged in the website and user navigates into project
	Then user navigates to the sprint retrospection menu
	Then user adds new sprint retrospection taking data from excel sheet from row "<TestCaseId>"
	Then user verifies the entered data comparing with data from excel sheet from row "<TestCaseId>"
	Then close the browser



Examples:
	|TestCaseId|
	|Testcase_001|
	|Testcase_002|
	|Testcase_003|	
	|Testcase_004|
