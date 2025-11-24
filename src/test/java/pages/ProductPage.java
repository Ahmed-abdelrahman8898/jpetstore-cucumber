package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.WaitHelper;

public class ProductPage extends BasePage {
	
	private WaitHelper waitHelper;
    public ProductPage() {
        super();
        waitHelper = new WaitHelper(driver, 60); // 10 seconds timeout
    }
    
    @FindBy(xpath = "//*[@id='Catalog']/table/tbody/tr/td/a")
    private List<WebElement> tableProducts;
    @FindBy(css = "a[href*='addItemToCart']")
    private List<WebElement> tableVariantsAddItemToCart;
    @FindBy(xpath = "//*[@id='Catalog']/table/tbody/tr/td[3]")
    private List<WebElement> productDesciption;
    
    @FindBy(id = "BackLink")
    private WebElement backLink;
    
    @FindBy(xpath = "//*[@id='Catalog']/h2")
    private WebElement genericproduct;
    
    public List<WebElement> getproductDesciption() {
    	
        return productDesciption;
    }
    public List<WebElement> gettableVariantsAddItemToCart() {
    	
        return tableVariantsAddItemToCart;
    }
    public List<WebElement> gettableProducts() {
    	waitHelper.waitForElementVisible(tableProducts.get(1));
        return tableProducts;
    }
    public WebElement getbackLink() {
        return waitHelper.waitForElementVisible(backLink);
    }
    public WebElement getgenericproduct() {
        return waitHelper.waitForElementVisible(genericproduct);
    }
    
    

}
