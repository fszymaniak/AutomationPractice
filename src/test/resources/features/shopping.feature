Feature: Testing operations in Shopping Cart

Scenario: Checking price while quantity is changing
	Given add two products from Desktops
	And go to Shopping Cart
	When change quantity of "Test product 1" to 4
	Then total price of "Test product 1" should change
	When change quantity of "Test product 4" to 3
	Then total price of "Test product 4" should change
	
Scenario: Removing product from Shopping Cart
	Given add two products from Desktops
	And go to Shopping Cart
	When remove Test product 4
	Then "Test product 4" should be removed
	
Scenario: Accept products in Shopping Cart
	Given add two products from Desktops
	And go to Shopping Cart
	When user estimates shipping and taxes
	Then apply shipping metod
	And click checkout

Scenario: Continue shopping at the end of shopping process
	Given add two products from Desktops
	And go to Shopping Cart
	When user estimates shipping and taxes
	Then apply shipping metod
	And click continue shopping
	

