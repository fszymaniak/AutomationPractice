Feature: Operations in Checkout Page

Scenario: Finalize shopping order with changing data
	Given user is on the main page
	And basket should contain 2 products
	When user click on checkout button
	Then should go to Checkout Page
	And user fill Checkout Options as guest
	And user fill Billing Details when same address is false
	And user fill Delivery Detail
	And user fill Delivery Method
	And user fill Payment Method
	When user confirm order
	Then order should be placed
	
Scenario: Finalize shopping order without changing data
	Given user is on the main page
	And basket should contain 2 products
	When user click on checkout button
	Then should go to Checkout Page
	And user fill Checkout Options as guest
	And user fill Billing Details when same address is true
	And user fill Delivery Method
	And user fill Payment Method
	When user confirm order
	Then order should be placed
	
