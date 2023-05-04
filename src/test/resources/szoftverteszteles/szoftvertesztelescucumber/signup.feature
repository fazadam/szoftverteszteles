#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
Feature: Signup

	  Scenario: Subscribe button
	  Given the Login page is opened
	  When the "SubscribeEmail" field is filled with "kiskutya@gmail.com"
	  And the "Subscribe" button on the login page is clicked 
	  Then Verify "You have been successfully subscribed!" is visible

		#Invalid singup
		Scenario Outline: Signup with missing data
    Given the Signup page is opened
    And the "SignupName" field is filled with "asdasd"
    And the "SignupEmail" field is filled with "kiskutya@gmail.com"
    And the "Signup" button on the login page is clicked
		Then verify page "https://automationexercise.com/signup"
		And the "Name" field in the signup page is filled with "<name>"
		And the "PasswordRegister" field in the signup page is filled with "<password>"
		And the "FirstName" field in the signup page is filled with "<firstname>"
		And the "LastName" field in the signup page is filled with "<lastname>"
		And the "Address" field in the signup page is filled with "<address>"
		And the "State" field in the signup page is filled with "<state>"
		And the "City" field in the signup page is filled with "<city>"
		And the "ZipCode" field in the signup page is filled with "<zipcode>"
		And the "MobileNumber" field in the signup page is filled with "<mobilenumber>"
		When the "CreateAccount" button on the signup page is clicked
		Then verify page "https://automationexercise.com/signup"

		
			    Examples:
					| name | password | firstname | lastname | address  | state	 | city | zipcode | mobilenumber |
					|      |          | asd 			| asd 		 | address  | state  | city | 123     | 123          |
					|  asd | password1| asd 			| asd 		 | address  | state  | city | 123     |              |
					|  asd | password1| asd 			| asd 		 | address  |        | city |         | 123          |
					|  asd | password1| asd 			| asd 		 | address  | state  |      |  123    |       123    |
					
					
					
		#Valid registration
		Scenario: Signup valid
    Given the Signup page is opened
    And the "SignupName" field is filled with "asdasd"
    And the "SignupEmail" field is filled with "kiskutya@gmail.com"
    And the "Signup" button on the login page is clicked
		Then verify page "https://automationexercise.com/signup"
		And the "Name" field in the signup page is filled with "asdasd"
		And the "PasswordRegister" field in the signup page is filled with "asdasd"
		And the "FirstName" field in the signup page is filled with "asdasd"
		And the "LastName" field in the signup page is filled with "asdasd"
		And the "Address" field in the signup page is filled with "asdasd"
		And the "State" field in the signup page is filled with "asdasd"
		And the "City" field in the signup page is filled with "asdasd"
		And the "ZipCode" field in the signup page is filled with "asdasd"
		And the "MobileNumber" field in the signup page is filled with "asdasd"
		When the "CreateAccount" button on the signup page is clicked
		Then verify page "https://automationexercise.com/account_created"
		
		Scenario: Delete Account
	  Given the "Home" button is clicked
	  When the "deleteAccount" button is clicked
	  Then verify page "https://automationexercise.com/delete_account"
	  


