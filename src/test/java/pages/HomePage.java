package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.WaitHelper;

public class HomePage extends BasePage {
	private WaitHelper waitHelper;
    public HomePage() {
        super();
        waitHelper = new WaitHelper(driver, 60); // 10 seconds timeout
    }
	
	
    @FindBy(id = "Sidebar") 
    private WebElement sidebar;

    @FindBy(css = "a[href*='signonForm']")
    private WebElement signInLink;
    
    @FindBy(css = "a[href*='signoff']")
    private WebElement signoff;
    
    @FindBy(xpath = "//*[@id='SidebarContent']/a")
    private List<WebElement> menuContent;

    
    public WebElement getsideBar() {
        return waitHelper.waitForElementVisible(sidebar);
    }
    public WebElement getsignInLink() {
        return waitHelper.waitForElementVisible(signInLink);
    }
    public WebElement getsignoff() {
        return waitHelper.waitForElementVisible(signoff);
    }
    public List<WebElement> getmenuContent() {
    	waitHelper.waitForElementVisible(menuContent.get(1));
        return menuContent;
    }
}
