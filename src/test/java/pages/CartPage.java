package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.WaitHelper;

public class CartPage extends BasePage {

	private WaitHelper waitHelper;
    public CartPage() {
        super();
        waitHelper = new WaitHelper(driver, 60); // 10 seconds timeout
    }
    
    @FindBy(xpath = "//*[@id='Cart']/form/table/tbody/tr/td[3]") 
    private WebElement randomAddedVariant;
    @FindBy(name = "updateCartQuantities") 
    private WebElement updateCartQuantities;
   
    
    public WebElement getrandomAddedVariant() {
        return waitHelper.waitForElementVisible(randomAddedVariant);
    }
    public WebElement getupdateCartQuantities() {
        return waitHelper.waitForElementVisible(updateCartQuantities);
    }
}
