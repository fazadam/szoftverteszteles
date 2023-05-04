package szoftverteszteles.szoftvertesztelescucumber;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	
    private static final String PAGE_URL = "https://automationexercise.com/";

    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void openHomePage() {
        driver.get(PAGE_URL);
        PageFactory.initElements(driver, this);
    }

    public void closePage() {
        driver.quit();
    }

    
    //gombok
    private static final Map<String, By> navigationButtons = Map.of(
    		"Home", By.xpath("//ul[@class='nav navbar-nav']/li[1]"),
    		"Products", By.xpath("//ul[@class='nav navbar-nav']/li[2]"),
    		"Cart", By.xpath("//ul[@class='nav navbar-nav']/li[3]"),
    		"LoginPageButton", By.xpath("//ul[@class='nav navbar-nav']/li[4]"),
    		"homePageLoginButton", By.xpath("/html/body/section/div/div/div[1]/div/form/button"),
    		"logoutButton", By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]"),
    		"deleteAccount", By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]"),
    		"viewCart", By.xpath("/html/body/section[2]/div/div/div[2]/div[1]/div[1]/div/div/div[2]/p[2]/a"),
    		"ContinueShopping", By.xpath("//*[@id=\"cartModal\"]/div/div/div[3]/button")
    		);
    		
	 public void clickButton (String button) {
		 driver.findElement(navigationButtons.get(button)).click();
	 }
	 
	 
	 //termekek a home oldalon
	 private static final Map<String, By> itemButtons = Map.of(
			 "Blue Top", By.xpath("/html/body/section[2]/div/div/div[2]/div[1]/div[2]/div/div[1]/div[1]/a"),
			 "Men Tshirt", By.xpath("/html/body/section[2]/div/div/div[2]/div[1]/div[3]/div/div[1]/div[1]/a"),
			 "Sleeveless Dress", By.xpath("/html/body/section[2]/div/div/div[2]/div[1]/div[4]/div/div[1]/div[1]/a"),
			 "Stylish dress", By.xpath("/html/body/section[2]/div/div/div[2]/div[1]/div[5]/div/div[1]/div[1]/a"),
			 "Winter Top", By.xpath("/html/body/section[2]/div/div/div[2]/div[1]/div[6]/div/div[1]/div[1]/a"),
			 "Summer White Top", By.xpath("/html/body/section[2]/div/div/div[2]/div[1]/div[6]/div/div[1]/div[1]/a"),
			 "Madame Top For Women", By.xpath("/html/body/section[2]/div/div/div[2]/div[1]/div[8]/div/div[1]/div[1]/a"),
			 "Fancy Green Top", By.xpath("/html/body/section[2]/div/div/div[2]/div[1]/div[9]/div/div[1]/div[1]/a"),
			 "Sleeves Printed Top - White", By.xpath("/html/body/section[2]/div/div/div[2]/div[1]/div[10]/div/div[1]/div[1]/a"),
			 "Half Sleeves Top Schiffli Detailing - Pink", By.xpath("/html/body/section[2]/div/div/div[2]/div[1]/div[11]/div/div[1]/div[1]/a")
			 );
	 
	 public void addItemToCart(String item) {
		 driver.findElement(itemButtons.get(item)).click();
	 }

	    
	    @FindBy(xpath = "/html/body/header/div/div/div/div[2]/div/ul/li[10]")
	    public WebElement loggedinText;
	    

}
