
Feature: Checkout shopping

  Scenario: Proceed to checkout
     Given the Login page is opened
	    And the "LoginPageButton" button is clicked
	    And the "LoginEmail" field is filled with "nagysanyi@gmail.hu"
	    And the "LoginPassword" field is filled with "asd"
	    And the "Login" button on the login page is clicked
	    When add item to the cart: "Blue Top"
	    And the "ContinueShopping" button is clicked
	    And add item to the cart: "Men Tshirt"
	    And the "ContinueShopping" button is clicked
	    And add item to the cart: "Sleeveless Dress"
	    Given the Cart page is opened
	    And the "ProceedToCheckout" button is clicked in the view cart page
	    When verify total price of the Cart: "Rs. 1900"
	    Then the Place Order button is clicked in the view cart page without iframe google AD
	    
	Scenario Outline: invalid payment attempts
			Given the "name_on_card" payment field is filled with "<paymentName>"
			And the "card_number" payment field is filled with "<paymentCardNumber>"
			And the "cvc" payment field is filled with "<paymentCVC>"
			And the "expiry_month" payment field is filled with "<paymentExpirationMM>"
			And the "expiry_year" payment field is filled with "<paymentExpirationYY>"
			Then the "PayAndConfirmOrder" button is clicked in the view cart page
			Then verify page "https://automationexercise.com/payment"

			Examples:
			|paymentName|paymentCardNumber|paymentCVC|paymentExpirationMM|paymentExpirationYY|
			|						|    							|          |  								 |							  	 |
			|asd			  | 							  |          |  								 |  								 |
			|asd				| 123							|          |  								 |  								 |
			|asd				| 123							| 123      |  								 |  								 |
			
	    Scenario: VALID CARD AND CONFIRM PAYMENT
	    Given the "name_on_card" payment field is filled with "ASD"
			And the "card_number" payment field is filled with "123"
			And the "cvc" payment field is filled with "123"
			And the "expiry_month" payment field is filled with "123"
			And the "expiry_year" payment field is filled with "123"
		  When the "PayAndConfirmOrder" button is clicked in the view cart page
			Then verify page "https://automationexercise.com/payment_done/1900"
			
