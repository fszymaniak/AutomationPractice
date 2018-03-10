Feature: Testing basket feature on main page
 
	Scenario: Add 4 products to basket on main page
    Given user is on main page of Test Store
    When click on button Add To Cart Test product 1
    Then product name in success info should be visible on top
    When click on button Add To Cart Test product 2
	Then product name in success info should be visible on top
	When click on button Add To Cart Test product 3
	Then product name in success info should be visible on top
	When click on button Add To Cart Test product 4
	Then product name in success info should be visible on top
    And there should be 4 products in basket
   
   Scenario: Remove 4 products from basket on main page
    Given user is on main page of Test Store
    And basket should be filled with products
    When click remove "Test product 1" button
    Then "Test product 1" should be removed from basket
    And there should be 3 products in basket
	When click remove "Test product 2" button
    Then "Test product 2" should be removed from basket
    And there should be 2 products in basket
	When click remove "Test product 3" button
    Then "Test product 3" should be removed from basket
    And there should be 1 products in basket
	When click remove "Test product 4" button
    Then "Test product 4" should be removed from basket
    And there should be 0 products in basket  
    
    Scenario: Change currency
    Given user is on main page of Test Store
    And basket should be filled with products
    When click on "Euro" in Currency
    Then should be this "€" char currency in total value
    When click on "Pound" in Currency
    Then should be this "£" char currency in total value
    When click on "Dollar" in Currency
    Then should be this "$" char currency in total value