package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class SignupStepDef extends AbstractStepDef{

	
    @Given("the Signup page is opened")
    public void theSignupPageIsOpened() {
        singupPage.openSignupPage();
    }
    
    @Given("the {string} field in the signup page is filled with {string}")
    public void singupFieldsFilled(String field, String text) {
    	singupPage.fillOutField(field, text);
    }

    @When("the {string} button on the signup page is clicked")
    public void theLoginPageButtonIsClicked(String button) {
    	singupPage.clickButtonSignupPage(button);
    }
    
}
