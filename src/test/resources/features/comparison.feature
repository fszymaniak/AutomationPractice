Feature: Operations in Comparison Page

Scenario: add products to comparison
	Given user is on store main page
	When add "Test product 1" to comparison
	Then apropriate info alert should show
	When add "Test product 2" to comparison
	Then apropriate info alert should show
	When add "Test product 3" to comparison
	Then apropriate info alert should show
	
Scenario: remove products from Comparison Page
	Given user is on store main page
	When add "Test product 1" to comparison
	Then apropriate info alert should show
	When add "Test product 2" to comparison
	Then apropriate info alert should show
	When add "Test product 3" to comparison
	Then apropriate info alert should show
	And go to Comparison Page
	When click on remove product Test product 1 button
	Then product "Test product 1" should be removed
	When click on remove product Test product 2 button
	Then product "Test product 2" should be removed
	
	
