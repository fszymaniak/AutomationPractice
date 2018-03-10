Feature: Searching product
 
	Scenario: Search 3 products from main page
    Given user is on main page
    When input "Test product 1" in search 
    Then user should see results in search page
   	And back to main page
	When input "Test product 3" in search 
    Then user should see results in search page
   	And back to main page
	When input "Test product 4" in search 
    Then user should see results in search page
   	And back to main page
   	
   	Scenario: Search 4 products from search product page
   	Given user is on search page
   	When input "Test product 3" in Search Criteria
   	Then user should see the same product searched in Search Criteria
   	When input "Test product 4" in Search Criteria
   	Then user should see the same product searched in Search Criteria
   	When input "Test product 2" in Search Criteria
   	Then user should see the same product searched in Search Criteria
   	When input "Test product 1" in Search Criteria
   	Then user should see the same product searched in Search Criteria
   	
   	