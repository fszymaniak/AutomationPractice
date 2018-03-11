Feature: Testing categories in store

	Scenario: Add 3 products from Women category to basket
    Given user is on Women category page "http://automationpractice.com/index.php?id_category=3&controller=category"
    When user click on button Add To Cart "Faded Short Sleeve T-shirts"
    Then product should be successfully added to shopping cart
    And continue shopping
    When user click on button Add To Cart "Blouse"
	Then product should be successfully added to shopping cart
	And continue shopping
	When user click on button Add To Cart "Printed Chiffon Dress"
	Then product should be successfully added to shopping cart
	And continue shopping
    And there should be 3 products in basket
    
    Scenario: Add 1 products from Dressess category to basket
    Given user is on Women category page "http://automationpractice.com/index.php?id_category=8&controller=category"
	When user click on button Add To Cart "Printed Chiffon Dress"
	Then product should be successfully added to shopping cart
	And continue shopping
    And there should be 1 products in basket
    
    Scenario: Add 1 products from T-shirts category to basket
    Given user is on Women category page "http://automationpractice.com/index.php?id_category=5&controller=category"
    When user click on button Add To Cart "Faded Short Sleeve T-shirts"
    Then product should be successfully added to shopping cart
    And continue shopping
    And there should be 1 products in basket