package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pages.*;
import utils.DriverManager;
import utils.WaitHelper;
import utils.RandomLetter;

import java.util.Random;
import org.junit.Assert;

public class Steps {

		//Initilizing the variable
	    WebDriver driver = DriverManager.getDriver();
	    HomePage homePage;
	    RegistrationPage registrationPage;
	    SignInPage signInPage;
	    CartPage cartPage;
	    ProductPage productPage;
	    WaitHelper wait;

	    // Shared data across the execution
	    public static String userId;
	    public static String pwd;
	    public static String productDescription;
	    
	    
	    @Given("the user opens the browser")
	    public void the_user_opens_the_browser() {
	    	
	        homePage = new HomePage();
	        registrationPage = new RegistrationPage();
	        signInPage = new SignInPage();
	        cartPage = new CartPage();
	        productPage = new ProductPage();
	        wait =new WaitHelper(driver,60);
	        driver.manage().window().maximize();
	    }
	    @Given("the user navigates to {string}")
	    public void the_user_navigates_to(String string) {
	    	driver.get(string);
	    	// as the systems expect a human to use them so i add from time to time a wait so i can mimic human behavior
	    	//Explicit wait is performed while identifying the element in Page Object Model
	    	wait.waitForSeconds(3);
	    	
	    	
	    }
	    @Then("the user should land on the homepage")
	    public void the_user_should_land_on_the_homepage() {
	    	Assert.assertTrue(homePage.getsideBar().isDisplayed() );
	    }
	    @When("the user clicks on the Sign In link")
	    public void the_user_clicks_on_the_sign_in_link() {
	    	homePage.getsignInLink().click();
	    	wait.waitForSeconds(3);
	    	Assert.assertTrue(signInPage.getpassword().isDisplayed());
	    }
	    @When("the user clicks on button Register Now")
	    public void the_user_clicks_on() {
	    	registrationPage.getregisterLink().click();
	    	wait.waitForSeconds(3);
	    	Assert.assertTrue(registrationPage.getfirstName().isDisplayed());
	    }
	    @When("the user fills the registration form with random values")
	    public void the_user_fills_the_registration_form_with_random_values() {
	    	userId=RandomLetter.getRandomLetters(6);
	    	pwd=RandomLetter.getRandomLetters(6);
	    	registrationPage.getusername().sendKeys(userId);
	    	wait.waitForSeconds(3);
	    	registrationPage.getpassword().sendKeys(pwd);
	    	registrationPage.getrepeatedPassword().sendKeys(pwd);
	    	registrationPage.getfirstName().sendKeys(RandomLetter.getRandomLetters(6));
	    	registrationPage.getlastName().sendKeys(RandomLetter.getRandomLetters(6));
	    	registrationPage.getemail().sendKeys(RandomLetter.getRandomLetters(6)+"@aaa.com");
	    	registrationPage.getphone().sendKeys(RandomLetter.getRandomNumbers(7));
	    	registrationPage.getaddress1().sendKeys(RandomLetter.getRandomLetters(6));
	    	registrationPage.getaddress2().sendKeys(RandomLetter.getRandomLetters(6));
	    	registrationPage.getcity().sendKeys(RandomLetter.getRandomLetters(6));
	    	registrationPage.getstate().sendKeys(RandomLetter.getRandomLetters(6));
	    	registrationPage.getzip().sendKeys(RandomLetter.getRandomNumbers(5));
	    	registrationPage.getcountry().sendKeys(RandomLetter.getRandomLetters(6));
	    	registrationPage.getenableMyList().click();
	    	registrationPage.getbannerOption().click();
	    	wait.waitForSeconds(3);
	    	
	    }
	    @When("the user saves the account information")
	    public void the_user_saves_the_account_information() {
	    	registrationPage.getnewAccount().click();
	    	wait.waitForSeconds(3);
	    	Assert.assertTrue(homePage.getsideBar().isDisplayed());
	    	
	    }
	  
	    
	    @Then("the user enter the already picked random username and password")
	    public void the_user_enter_the_already_picked_random_username_and_password() {
	    	signInPage.getusername().sendKeys(userId);
	    	signInPage.getpassword().clear();
	    	signInPage.getpassword().sendKeys(pwd);
	    	wait.waitForSeconds(3);
	    }
	    @When("the user click Login")
	    public void the_user_click_login() {
	    	signInPage.getsignon().click();
	    	wait.waitForSeconds(3);
	    }
	    @Then("the user is logged")
	    public void the_user_is_logged() {
	    Assert.assertTrue(homePage.getsignoff().isDisplayed());
	    }
	    
	    @When("the user click randomly on any catalog")
	    public void the_user_click_randomly_on_any_catalog() {
	       int randomcatalog= RandomLetter.getRandomNumberInRange(0, 4);
	       homePage.getmenuContent().get(randomcatalog).click();
	       wait.waitForSeconds(3);
	    }
	    @Then("the catalog is displayed")
	    public void the_catalog_is_displayed() {
	    	Assert.assertTrue(productPage.getbackLink().isDisplayed());
	    }
	    @When("the user click randomly on any product")
	    public void the_user_click_randomly_on_any_product() {
	       //now we will choose the product randomly
	    	int min=0;
	    	int max=productPage.gettableProducts().size()-1;
	    	
	    	int randomproduct= RandomLetter.getRandomNumberInRange(min, max);
	    	productPage.gettableProducts().get(randomproduct).click();
	    	wait.waitForSeconds(3);
	    }
	    @Then("the product is displayed")
	    public void the_product_is_displayed() {
	    	Assert.assertTrue(productPage.getgenericproduct().isDisplayed());
	    }
	    @When("the user click Add to Cart on any random variant")
	    public void the_user_click_add_to_cart_on_any_random_variant() {
	    	//we will choose also randomly a variant
	    	int min=0;
	    	int max=productPage.gettableVariantsAddItemToCart().size()-1;
	    	int randomvariant;

	    	if (min==max) {

	    		randomvariant=min;
	    		productDescription=productPage.getproductDesciption().get(randomvariant).getText();

	    		productPage.gettableVariantsAddItemToCart().get(randomvariant).click();

		    	wait.waitForSeconds(3);

	    	}

	    	else {

	    		randomvariant= RandomLetter.getRandomNumberInRange(min, max);
	    		productDescription=productPage.getproductDesciption().get(randomvariant).getText();
	    		productPage.gettableVariantsAddItemToCart().get(randomvariant).click();

		    	wait.waitForSeconds(3);


	    	}
	    	
	    }
	    @Then("the item is added and can seen in the cart")
	    public void the_item_is_added_and_can_seen_in_the_cart() {
	    	Assert.assertTrue(cartPage.getupdateCartQuantities().isDisplayed());
	    	Assert.assertEquals(productDescription, cartPage.getrandomAddedVariant().getText());
	    	wait.waitForSeconds(3);
	    }


}
