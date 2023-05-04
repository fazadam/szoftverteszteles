
Feature: Cart items
 
 		 	Scenario: verify empty cart
	    Given the Cart page is opened
	    Then Verify that cart is empty		

 	  Scenario: Adding items to the Cart in the Home Page
	    Given the home page is opened
	    When add item to the cart: "Blue Top"
	    And the "ContinueShopping" button is clicked
	    And add item to the cart: "Men Tshirt"
	    And the "ContinueShopping" button is clicked
	    And add item to the cart: "Sleeveless Dress"
	    When the "viewCart" button is clicked
	    Then verify page "https://automationexercise.com/view_cart"
	    Then verify "Men Tshirt" product is displayed
	    Then verify "Sleeveless Dress" product is displayed
	    Then verify "Blue Top" product is displayed
	    
	    Scenario: Counting Sum in the Cart 
	    Given the home page is opened
	    When add item to the cart: "Blue Top"
	    And the "ContinueShopping" button is clicked
	    And add item to the cart: "Men Tshirt"
	    And the "ContinueShopping" button is clicked
	    And add item to the cart: "Sleeveless Dress"
	    When the "viewCart" button is clicked
	    Then verify total price of the Blue Top: "Rs. 1000"
	    Then verify total price of the Men Shirt: "Rs. 800"
	    Then verify total price of the Sleeveless Dress: "Rs. 2000"	


			Scenario: Removing items from the Cart in the Cart Page
	    Given the Cart page is opened
	    And the "deleteFirstCartElement" button is clicked in the view cart page
	    And the "deleteSecondCartElement" button is clicked in the view cart page
	    And the "deleteThirdCartElement" button is clicked in the view cart page
	    Then Verify that cart is empty
	    

			