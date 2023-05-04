
Feature: Product page

  Scenario Outline: Category selection works
    Given the Products page is opened
    And the "MenCategory" button on the products page is clicked
    Then verify "Jeans" product is displayed after category selection
    And the "ShowMenJeans" button on the products page is clicked
    Then verify "Soft Stretch Jeans" product is displayed after category selection
    Then verify "Regular Fit Straight Jeans" product is displayed after category selection
    Then verify "Grunt Blue Slim Fit Jeans" product is displayed after category selection


	Scenario: product details page works + write review
		Given the Products page is opened
	    And the "BrandsSelectionMastHarbour" button on the products page is clicked
   		Then verify "Winter Top" product is displayed after category selection
    	Then verify "Lace Top For Women" product is displayed after category selection
   		Then verify "GRAPHIC DESIGN MEN T SHIRT - BLUE" product is displayed after category selection
    	And the "ShowWinterTopMastHarbour" button on the products page is clicked
	    Then verify page "https://automationexercise.com/product_details/5"
	    And the "ReviewName" field is filled for review in products page "MyName"
	    And the "ReviewEmail" field is filled for review in products page "kiskutya@gmail.com"
	    And the "ReviewText" field is filled for review in products page "nagyon jo termek"
	    And the "submitReviewButton" button on the products page is clicked
	    Then Verify "Thank you for your review." is visible