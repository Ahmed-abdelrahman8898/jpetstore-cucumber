package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.WaitHelper;

public class RegistrationPage extends BasePage {

	private WaitHelper waitHelper;
    public RegistrationPage() {
        super();
        waitHelper = new WaitHelper(driver, 60); // 10 seconds timeout
    }
	
	
    @FindBy(name = "username") 
    private WebElement username;
    @FindBy(name = "password") 
    private WebElement password;
    @FindBy(name = "repeatedPassword") 
    private WebElement repeatedPassword;
    @FindBy(name = "account.firstName") 
    private WebElement firstName;
    @FindBy(name = "account.lastName") 
    private WebElement lastName;
    @FindBy(name = "account.email") 
    private WebElement email;
    @FindBy(name = "account.phone") 
    private WebElement phone;
    @FindBy(name = "account.address1") 
    private WebElement address1;
    @FindBy(name = "account.address2") 
    private WebElement address2;
    @FindBy(name = "account.city") 
    private WebElement city;
    @FindBy(name = "account.state") 
    private WebElement state;
    @FindBy(name = "account.zip") 
    private WebElement zip;
    @FindBy(name = "account.country") 
    private WebElement country;
    @FindBy(name = "account.listOption") 
    private WebElement enableMyList;
    @FindBy(name = "account.bannerOption") 
    private WebElement bannerOption;
    @FindBy(name = "newAccount") 
    private WebElement newAccount;
   

    @FindBy(css = "a[href*='newAccountForm']")
    private WebElement registerLink;

    
    public WebElement getusername() {
        return waitHelper.waitForElementVisible(username);
    }
    public WebElement getpassword() {
        return waitHelper.waitForElementVisible(password);
    }
    public WebElement getrepeatedPassword() {
        return waitHelper.waitForElementVisible(repeatedPassword);
    }
    public WebElement getfirstName() {
        return waitHelper.waitForElementVisible(firstName);
    }
    public WebElement getlastName() {
        return waitHelper.waitForElementVisible(lastName);
    }
    public WebElement getemail() {
        return waitHelper.waitForElementVisible(email);
    }
    public WebElement getphone() {
        return waitHelper.waitForElementVisible(phone);
    }
    public WebElement getaddress1() {
        return waitHelper.waitForElementVisible(address1);
    }
    public WebElement getaddress2() {
        return waitHelper.waitForElementVisible(address2);
    }
    public WebElement getcity() {
        return waitHelper.waitForElementVisible(city);
    }
    public WebElement getstate() {
        return waitHelper.waitForElementVisible(state);
    }
    public WebElement getzip() {
        return waitHelper.waitForElementVisible(zip);
    }
    public WebElement getcountry() {
        return waitHelper.waitForElementVisible(country);
    }
    public WebElement getenableMyList() {
        return waitHelper.waitForElementVisible(enableMyList);
    }
    public WebElement getbannerOption() {
        return waitHelper.waitForElementVisible(bannerOption);
    }
    public WebElement getnewAccount() {
        return waitHelper.waitForElementVisible(newAccount);
    }
    
    public WebElement getregisterLink() {
        return waitHelper.waitForElementVisible(registerLink);
    }
    
}
