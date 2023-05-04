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

public class ProductsStepDef  extends AbstractStepDef{
	
    private WebDriverWait wait;
    
    public ProductsStepDef() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
    }
	
    @Given("the Products page is opened")
    public void theLoginPageIsOpened() {
        productsPage.openProductsPage();
    }
    
    @When("the {string} field is filled for review in products page {string}")
    public void theFieldIsFilledWithText(String field, String text) {
    	productsPage.fillOutField(field, text);
    }

    @When("the {string} button on the products page is clicked")
    public void theLoginPageButtonIsClicked(String button) {
    	productsPage.clickButtonProductsPage(button);
    }
    
    @Then("verify {string} product is displayed after category selection")
    public void verifyProductInTheCart(String productName) {
		WebElement product = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), '" + productName + "')]")));
        assertTrue(product.isDisplayed());    }
}
