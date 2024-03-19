Feature: Validate create Repository and Delete Repo

Scenario: verify create Repo API
	Given Starting TestCase "verify create Repo API"
	Given create Repo payload
	When User calls create API "/user/repos" Post API Call 
	Then API call got successful with status code 201
	Then Verify Repo "name" is "API-TEST-REPO"
	And Verify Repo "description" is "API repo created via BDD Test" 
	And Ending TestCase 

		
	
Scenario: Verify Delete repo API	
	Given Starting TestCase "Verify Delete repo API"
	Given create Repo payload
	Then User calls delete API "/repos/muthu239/" delete API Call
	Then API call got successful with status code 204
	And Ending TestCase 
	

Scenario Outline: verify create Repo API using scenario Outline
	Given Starting TestCase "verify create Repo API using scenario Outline"
	Given create Repo payload name "<name>" and description "<description>"
	When User calls create API "/user/repos" Post API Call 
	Then API call got successful with status code 201
	Then Verify Repo "name" is "<name>"
	And Verify Repo "description" is "<description>" 
	And Ending TestCase 
	
Examples: 
	| name | description |
	| repo1 | This is data driven test repo1 | 
	| repo2 | This is data driven test repo2 |
	| repo3 | This is data driven test repo3 |

		
Scenario Outline: Verify Delete repo API using scenario Outline	
	Given Starting TestCase "Verify Delete repo API using scenario Outline"
	Given create Repo payload name "<name>" and description "<description>"
	Then User calls delete API "/repos/muthu239/" delete API Call
	Then API call got successful with status code 204
	And Ending TestCase 
	
Examples: 
	| name | description |
	| repo1 | This is data driven test repo1 | 
	| repo2 | This is data driven test repo2 |
	| repo3 | This is data driven test repo3 |