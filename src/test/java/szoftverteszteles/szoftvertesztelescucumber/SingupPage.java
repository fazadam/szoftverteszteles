package szoftverteszteles.szoftvertesztelescucumber;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SingupPage {
	private static final String PAGE_URL = "https://automationexercise.com/signup";

    private final WebDriver driver;

    public SingupPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openSignupPage() {
        driver.get(PAGE_URL);
        PageFactory.initElements(driver, this);
    }
    
    public String getPageUrl() {
        return PAGE_URL;
    }

    public void closePage() {
        driver.quit();
    }
    
    
    //gombok
    private static final Map<String, By> SignupButtons = Map.of(
    	      "CreateAccount", By.xpath("//*[@id=\"form\"]/div/div/div/div[1]/form/button"),
    	      "SubscribeButtonSignupPage", By.xpath("//*[@id=\"subscribe\"]")
    	    );
    //gomb nyomas
	public void clickButtonSignupPage(String button) {
        driver.findElement(SignupButtons.get(button)).click();
		
	}

    //input fields
    private static final Map<String,By> SignupTextfields = Map.of(
    		"Name",By.xpath("//*[@id=\"name\"]") ,
    		"PasswordRegister",By.xpath("//*[@id=\"password\"]") , 
    		"FirstName",By.xpath("//*[@id=\"first_name\"]") ,
    		"LastName",By.xpath("//*[@id=\"last_name\"]") ,
    		"Address",By.xpath("//*[@id=\"address1\"]"),
    		"Country",By.xpath("//*[@id=\"country\"]"),
    		"State",By.xpath("//*[@id=\"state\"]"),
    		"City",By.xpath("//*[@id=\"city\"]"),
    		"ZipCode",By.xpath("//*[@id=\"zipcode\"]"),
    		"MobileNumber",By.xpath("//*[@id=\"mobile_number\"]")
    		);
    	//input field kitoltes	
    public void fillOutField(String field, String text) {
    	driver.findElement(SignupTextfields.get(field)).sendKeys(text);
    }

}
