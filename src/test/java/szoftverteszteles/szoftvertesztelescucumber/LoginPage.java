package szoftverteszteles.szoftvertesztelescucumber;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {

    private static final String PAGE_URL = "https://automationexercise.com/login";

    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openLoginPage() {
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
    private static final Map<String, By> LoginSignupButtons = Map.of(
    	      "Login", By.xpath("/html/body/section/div/div/div[1]/div/form/button"),
    	      "Signup", By.xpath("/html/body/section/div/div/div[3]/div/form/button"),
    	      "Subscribe", By.xpath("/html/body/footer/div[1]/div/div/div[2]/div/form/button")
    	    );
    //gomb nyomas
	public void clickButtonLoginPage(String button) {
        driver.findElement(LoginSignupButtons.get(button)).click();
		
	}

    //input fields
    private static final Map<String,By> LoginSignupTextfields = Map.of(
    		"LoginEmail",By.xpath("/html/body/section/div/div/div[1]/div/form/input[2]") ,
    		"LoginPassword", By.xpath("/html/body/section/div/div/div[1]/div/form/input[3]") ,
    		"SignupName",By.xpath("/html/body/section/div/div/div[3]/div/form/input[2]") , 
    		"SignupEmail",By.xpath("/html/body/section/div/div/div[3]/div/form/input[3]") ,
    		"SubscribeEmail",By.xpath("/html/body/footer/div[1]/div/div/div[2]/div/form/input[2]")
    		);
    	//input field kitoltes	
    public void fillOutField(String field, String text) {
    	driver.findElement(LoginSignupTextfields.get(field)).sendKeys(text);
    }

}
