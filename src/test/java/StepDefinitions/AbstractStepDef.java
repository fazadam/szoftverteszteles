package StepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import szoftverteszteles.szoftvertesztelescucumber.CartPage;
import szoftverteszteles.szoftvertesztelescucumber.HomePage;
import szoftverteszteles.szoftvertesztelescucumber.LoginPage;
import szoftverteszteles.szoftvertesztelescucumber.ProductsPage;
import szoftverteszteles.szoftvertesztelescucumber.SingupPage;

public class AbstractStepDef {

	  protected static final WebDriver driver;

	    protected static HomePage homePage;
	    protected static LoginPage loginPage;
	    protected static SingupPage singupPage;
	    protected static CartPage cartPage;
	    protected static ProductsPage productsPage;

	    static {

	        WebDriverManager.chromedriver().setup();
	        ChromeOptions options = new ChromeOptions();
	        driver = new ChromeDriver(options);
	        homePage = new HomePage(driver);
	        loginPage = new LoginPage(driver);
	        singupPage = new SingupPage(driver);
	        cartPage = new CartPage(driver);
	        productsPage = new ProductsPage(driver);
	    }

}


