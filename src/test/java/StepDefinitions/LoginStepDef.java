package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;



public class LoginStepDef extends AbstractStepDef{

    @Given("the Login page is opened")
    public void theLoginPageIsOpened() {
        loginPage.openLoginPage();
    }
    
    @Given("the {string} field is filled with {string}")
    public void theFieldIsFilledWithText(String field, String text) {
    	loginPage.fillOutField(field, text);
    }

    @When("the {string} button on the login page is clicked")
    public void theLoginPageButtonIsClicked(String button) {
        loginPage.clickButtonLoginPage(button);
    }



    }
    
 


