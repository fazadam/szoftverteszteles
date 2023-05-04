package szoftverteszteles.szoftvertesztelescucumber;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    private static final String PAGE_URL = "https://automationexercise.com/view_cart";

    private final WebDriver driver;

	public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openViewCartPage() {
        driver.get(PAGE_URL);
        PageFactory.initElements(driver, this);
    }

    public void closePage() {
        driver.quit();
    }
    
    private static final Map<String, By> viewCartButtons = Map.of(
    "deleteFirstCartElement" , By.xpath("/html/body/section/div/div[2]/table/tbody/tr[1]/td[6]/a"),
    "deleteSecondCartElement" , By.xpath("/html/body/section/div/div[2]/table/tbody/tr[2]/td[6]/a"),
    "deleteThirdCartElement" , By.xpath("/html/body/section/div/div[2]/table/tbody/tr[3]/td[6]/a"),
    "ProceedToCheckout", By.xpath("/html/body/section/div/section/div[1]/div/div/a"),
    "PlaceOrder", By.xpath("/html/body/section/div/div[7]/a"),
    "PayAndConfirmOrder", By.xpath("/html/body/section/div/div[3]/div/div[2]/form/div[5]/div/button")
    		);
    
	 public void clickButtonCartPage (String button) {
		 driver.findElement(viewCartButtons.get(button)).click();
	 }
	 
	    private static final Map<String,By> PaymentFields = Map.of(
	    		"name_on_card",By.xpath("/html/body/section/div/div[3]/div/div[2]/form/div[1]/div/input") ,
	    		"card_number", By.xpath("/html/body/section/div/div[3]/div/div[2]/form/div[2]/div/input") ,
	    		"cvc",By.xpath("/html/body/section/div/div[3]/div/div[2]/form/div[3]/div[1]/input") , 
	    		"expiry_month",By.xpath("/html/body/section/div/div[3]/div/div[2]/form/div[3]/div[2]/input") ,
	    		"expiry_year",By.xpath("/html/body/section/div/div[3]/div/div[2]/form/div[3]/div[3]/input")
	    		);
	    	//input field kitoltes	
	    public void fillOutFieldPayment(String field, String text) {
	    	driver.findElement(PaymentFields.get(field)).sendKeys(text);
	    }
	 
	    @FindBy(xpath = "/html/body/section/div/div[2]/span")
	    public WebElement emptyCart;
	    
	    @FindBy(xpath = "/html/body/section/div/div[2]/table/tbody/tr[1]/td[5]/p")
	    public WebElement firstProductPriceLabel;
	    @FindBy(xpath = "/html/body/section/div/div[2]/table/tbody/tr[2]/td[5]/p")
	    public WebElement secondProductPriceLabel;
	    @FindBy(xpath = "/html/body/section/div/div[2]/table/tbody/tr[3]/td[5]/p")
	    public WebElement thirdProductPriceLabel;
	    
	    @FindBy(xpath = "/html/body/section/div/div[5]/table/tbody/tr[4]/td[4]/p")
	    public WebElement cartTotalPrice;
	    
	    public String getTotalFirstProduct() {
	    	return firstProductPriceLabel.getText();
	    }
	    public String getTotalSecondProduct() {
	    	return secondProductPriceLabel.getText();
	    }
	    public String getTotalThirdProduct() {
	    	return thirdProductPriceLabel.getText();
	    }
	    public String getCartTotalPrice() {
	    	return cartTotalPrice.getText();
	    }

		public void clearPaymentField(String field) {
		    WebElement paymentField = driver.findElement(By.name(field));
		    paymentField.clear();			
		}
}
