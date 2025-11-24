package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {

	   private WebDriver driver;
	   private WebDriverWait wait;

	    public WaitHelper(WebDriver driver, int timeoutInSeconds) {
	        this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
	    }

	    // Wait for visibility of an element
	    public WebElement waitForElementVisible(WebElement element) {
	        return wait.until(ExpectedConditions.visibilityOf(element));
	    }

	    // Wait for an element to be clickable
	    public WebElement waitForElementClickable(WebElement element) {
	        return wait.until(ExpectedConditions.elementToBeClickable(element));
	    }
	    //just waiting to mimic human factors
	    public void waitForSeconds(int seconds) {
	        try {
	            Thread.sleep(seconds * 1000L);  // convert seconds to milliseconds
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }
	    
}
