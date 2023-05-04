package szoftverteszteles.szoftvertesztelescucumber;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {

    private static final String PAGE_URL = "https://automationexercise.com/products";

    private final WebDriver driver;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openProductsPage() {
        driver.get(PAGE_URL);
        PageFactory.initElements(driver, this);
    }

    public void closePage() {
        driver.quit();
    }
    
    private static final Map<String, By> ProductsPageButtons = Map.of(
    		"MenCategory", By.xpath("//*[@id=\"accordian\"]/div[2]/div[1]/h4/a"),
    		"SoftStretchJeansAddToCart", By.xpath("/html/body/section/div/div[2]/div[2]/div/div[2]/div/div[1]/div[1]/a"),
    		"ShowMenJeans", By.xpath("//*[@id=\"Men\"]/div/ul/li[2]/a"),
    		"viewProductSoftStretchJeans", By.xpath("/html/body/section/div/div[2]/div[2]/div/div[2]/div/div[2]/ul/li/a"),
    		"addToCartProductDetailsPage", By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/span/button"),
    		"submitReviewButton", By.xpath("/html/body/section/div/div/div[2]/div[3]/div[2]/div/div/form/button"),
    		"BrandsSelectionMastHarbour", By.xpath("/html/body/section[2]/div/div/div[1]/div/div[2]/div/ul/li[4]/a"),
    		"ShowWinterTopMastHarbour", By.xpath("/html/body/section/div/div[2]/div[2]/div/div[2]/div/div[2]/ul/li/a")

    		);
	 public void clickButtonProductsPage (String button) {
		 driver.findElement(ProductsPageButtons.get(button)).click();
	 }
	 
	    //input fields
	    private static final Map<String,By> ProductDetailsReviewFields = Map.of(
	    		"ReviewName",By.xpath("/html/body/section/div/div/div[2]/div[3]/div[2]/div/div/form/span/input[1]") ,
	    		"ReviewEmail", By.xpath("/html/body/section/div/div/div[2]/div[3]/div[2]/div/div/form/span/input[2]") ,
	    		"ReviewText",By.xpath("/html/body/section/div/div/div[2]/div[3]/div[2]/div/div/form/textarea")
	    		);
	    	//input field kitoltes	
	    public void fillOutField(String field, String text) {
	    	driver.findElement(ProductDetailsReviewFields.get(field)).sendKeys(text);
	    }
}
