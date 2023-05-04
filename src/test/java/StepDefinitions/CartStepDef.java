package StepDefinitions;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.openqa.selenium.JavascriptExecutor;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartStepDef  extends AbstractStepDef{

    private WebDriverWait wait;
    public CartStepDef() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
    }

	
    @Given("the Cart page is opened")
    public void theLoginPageIsOpened() {
        cartPage.openViewCartPage();
    }

    @When("the {string} button is clicked in the view cart page")
    public void theButtonIsClicked(String button) {
    	cartPage.clickButtonCartPage(button);
    }
    
    @When("the Place Order button is clicked in the view cart page without iframe google AD")
    public void thePlaceOrderClicked() {
        // Scroll to the "Place Order" button
        WebElement placeOrderButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section/div/div[7]/a")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", placeOrderButton);

        // Click the "Place Order" button
        placeOrderButton.click();

    }
    
    @Then("Verify that cart is empty")
    public void verifyEmptyCart() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section/div/div[2]/span")));
        assertTrue(cartPage.emptyCart.isDisplayed());    
        }
    
    @Then("verify {string} product is displayed")
    public void verifyProductInTheCart(String productName) {
		WebElement product = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), '" + productName + "')]")));
        assertTrue(product.isDisplayed());    }
    
    @Then("verify total price of the Blue Top: {string}")
    public void verifyTotalPriceOfFirstItem(String totalPrice) {
    	assertEquals(totalPrice, cartPage.getTotalFirstProduct());
    }
    
    @Then("verify total price of the Men Shirt: {string}")
    public void verifyTotalPriceOfSecondItem(String totalPrice) {
    	assertEquals(totalPrice, cartPage.getTotalSecondProduct());
    }
    @Then("verify total price of the Sleeveless Dress: {string}")
    public void verifyTotalPriceOfThirdItem(String totalPrice) {
    	assertEquals(totalPrice, cartPage.getTotalThirdProduct());
    }
    
    @Then("verify total price of the Cart: {string}")
    public void verifyTotalCartPrice(String totalPrice) {
    	assertEquals(totalPrice, cartPage.getCartTotalPrice());
    }
    
    @Given("the {string} payment field is filled with {string}")
    public void theFieldIsFilledWithText(String field, String text) {
    	cartPage.fillOutFieldPayment(field, text); 
    }
    
}
