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
Feature: Login Attempts
  
        
      
     #kitoltetlen login attempts
    Scenario Outline: Invalid Login Attempts without fields
	    Given the Login page is opened
	    And the "LoginEmail" field is filled with "<username>"
	    And the "LoginPassword" field is filled with "<password>"
	    When the "Login" button on the login page is clicked
			Then verify page "https://automationexercise.com/login"
	
	    Examples:
	    | email            | password | 
	      |                   |          | 
	      | example@test.com |          |
	      |                   | password |

	#nem letezo fiok login
  Scenario Outline: Invalid Login Attempts with <username> and <password>
    Given the Login page is opened
    And the "LoginEmail" field is filled with "<username>"
    And the "LoginPassword" field is filled with "<password>"
    Then the "Login" button on the login page is clicked
		Then Verify error "'Your email or password is incorrect!'" is visible

    Examples:
      | username      | password | 
      |        incorrect@mail     |   a      |
      |     incorrect2@mail      | noemail  | 
      | incorrect@mail    |    a     |
      | test@test.com | invalid  |

	      
	      
	  #valid login es logged in visible
	  Scenario: Valid Login + Logged in as visible + login button on homepage works
	    Given the home page is opened
	    And the "LoginPageButton" button is clicked
	    And the "LoginEmail" field is filled with "nagysanyi@gmail.hu"
	    And the "LoginPassword" field is filled with "asd"
	    And the "Login" button on the login page is clicked
	    Then Verify that Logged in as username is visible
	    Then the "logoutButton" button is clicked
	    
	  #singup attempts
    Scenario Outline: Failed signup attempts
	    Given the Login page is opened
	    And the "SignupName" field is filled with "<username>"
	    And the "SignupEmail" field is filled with "<email>"
	    And the "Signup" button on the login page is clicked
			Then verify page "https://automationexercise.com/login"
	
	    Examples:
	    | username            | email | 
	      |                   |          | 
	      | asd               |             |
	      |                   | example@test.com |

		#invalid signup datas
	  Scenario: Signup Fail Attempts with <username> and <email>
    Given the Login page is opened
    And the "SignupName" field is filled with "asdasd"
    And the "SignupEmail" field is filled with "nagysanyi@gmail.hu"
    Then the "Signup" button on the login page is clicked
		Then Verify error "'Email Address already exist!'" is visible


      