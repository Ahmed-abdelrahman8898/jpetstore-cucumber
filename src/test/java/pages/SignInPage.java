package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.WaitHelper;

public class SignInPage extends BasePage {

	private WaitHelper waitHelper;
    public SignInPage() {
        super();
        waitHelper = new WaitHelper(driver, 60); // 10 seconds timeout
    }
	
	
    @FindBy(name = "username") 
    private WebElement username;
    @FindBy(name = "password") 
    private WebElement password;
    @FindBy(name = "signon") 
    private WebElement signon;

    @FindBy(css = "a[href*='newAccountForm']")
    private WebElement registerLink;

    
    public WebElement getusername() {
        return waitHelper.waitForElementVisible(username);
    }
    
    public WebElement getpassword() {
        return waitHelper.waitForElementVisible(password);
    }
    public WebElement getsignon() {
        return waitHelper.waitForElementVisible(signon);
    }
    public WebElement getregisterLink() {
        return waitHelper.waitForElementVisible(registerLink);
    }
}
