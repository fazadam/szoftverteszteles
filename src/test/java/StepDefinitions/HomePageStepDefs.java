package StepDefinitions;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageStepDefs extends AbstractStepDef{
    private WebDriverWait wait;
    
    public HomePageStepDefs() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
    }

    @Given("the home page is opened")
    public void theHomePageIsOpened() {
        homePage.openHomePage();
    }

    @When("the {string} button is clicked")
    public void theButtonIsClicked(String button) {
        homePage.clickButton(button);
    }

    @Then("Verify that Logged in as username is visible")
    public void verifyLoggedInUsername() {
    	assertTrue(homePage.loggedinText.isDisplayed());
    }

    
    @Then("verify page {string}")
    public void successfullRegistration(String PageUrl) {
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = PageUrl;
        
        if (!currentUrl.equals(expectedUrl)) {
            throw new AssertionError("Problem current URL is: " + currentUrl);
        }
    }
    
    @Then("Verify error {string} is visible")
    public void verifyErrorMessageIsVisible(String Error) {
        WebElement errorMessage = driver.findElement(By.xpath("//p[contains(text(),"+ Error+ ")]"));
        assertTrue(errorMessage.isDisplayed());
    }

    @When("add item to the cart: {string}")
    public void addItemToCart(String item) {
    	homePage.addItemToCart(item);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"cartModal\"]/div/div")));
    }
    
    @Then("Verify {string} is visible")
    public void verifySubscribe(String subMsg) {
		WebElement subscribeMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), '" + subMsg + "')]")));
        assertTrue(subscribeMsg.isDisplayed());
    }
    
}
