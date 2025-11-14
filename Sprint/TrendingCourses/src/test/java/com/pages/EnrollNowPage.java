/*package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.setup.BaseSteps;

	public class EnrollNowPage extends BaseSteps {
	    
		WebDriver driver;

	    public EnrollNowPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

	
	    @FindBy(xpath = "//*[@id=\"__next\"]/div/section[2]/div/div/div/div[3]/div[3]/button[1]")
	    WebElement enrollButton;

	    @FindBy(xpath = "//*[@id=\"firstENForm\"]/div[1]/input")
	    WebElement emailField;

	    @FindBy(xpath = "//*[@id=\"firstENForm\"]/div[2]/input")
	    WebElement phoneField;

	    @FindBy(xpath = "//*[@id=\"firstENForm\"]/div[5]")
	    WebElement formEnrollButton;

	    @FindBy(xpath = "//*[@id=\"ord_bx_tot_mob\"]/div[1]")
	    WebElement orderSummaryText;
	    
	  
	    

	    public void scrollToTrendingCourses() {
//	        new WebDriverWait(driver, Duration.ofSeconds(15))
//	            .until(ExpectedConditions.visibilityOf(trendingCoursesHeader));
//	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", trendingCoursesHeader);
	    	
	    	    try {
	    	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	    	        WebElement trendingHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(
	    	            By.xpath("//h2[contains(text(),'Trending Courses')]")
	    	        ));
	    	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", trendingHeader);
	    	    } catch (TimeoutException e) {
	    	        System.out.println("Trending Courses section not found: " + e.getMessage());
	    	        throw e;
	    	    }
	    	}
	    

	   

	    public void clickEnrollButton() {
	        enrollButton.click();
	    }
	    public boolean isEnrollmentFormVisible() {
			return true;
	    	
	    }

	    public void enterEmail(String email) {
	        emailField.sendKeys(email);
	    }

	    public void enterPhoneNumber(String phone) {
	        phoneField.sendKeys(phone);
	    }

	    public void submitEnrollmentForm() {
	        formEnrollButton.click();
	    }


	    public boolean isOrderSummaryVisible(String paymentText) {
	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	          wait.until(ExpectedConditions.visibilityOf(orderSummaryText));
	         return wait.until(ExpectedConditions.visibilityOf(orderSummaryText)).isDisplayed();
	      
	    }

		public boolean isOnPaymentPage() {
			
			return true;
		}
	}
	*/

package com.pages;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EnrollNowPage {

    private WebDriver driver;

    public EnrollNowPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Use a more robust locator
    @FindBy(xpath = "//*[@id=\"__next\"]/div/section[2]/div/div/div/div[3]/div[3]/button[1]")
    private WebElement enrollButton;

    @FindBy(xpath = "//*[@id=\"firstENForm\"]/div[1]/input")
    private WebElement emailField;

    @FindBy(xpath = "//*[@id=\"firstENForm\"]/div[2]/input")
    private WebElement phoneField;

    @FindBy(xpath = "//*[@id=\"firstENForm\"]/div[5]/button")
    private WebElement formEnrollButton;

    @FindBy(xpath = "//*[@id=\"ord_bx_tot_mob\"]/div[1]")
    private WebElement orderSummaryText;

    /**
     * Scroll to Trending Courses section
     */
    public void scrollToTrendingCourses() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            WebElement trendingHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//h2[contains(text(),'Trending Courses')]")
            ));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", trendingHeader);
        } catch (TimeoutException e) {
            System.out.println("Trending Courses section not found: " + e.getMessage());
            throw e;
        }
    }

    /**
     * Click Enroll Now button with wait and scroll
     */
    public void clickEnrollButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
         wait.until(ExpectedConditions.visibilityOf(enrollButton));
       wait.until(ExpectedConditions.elementToBeClickable(enrollButton));
       // ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", enrollButton);
        //button.click();
    }

    public boolean isEnrollmentFormVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOf(emailField)).isDisplayed();
    }

    public String enterEmail(String email) {
        emailField.sendKeys(email);
        emailField.sendKeys(Keys.ENTER);
		return email;
    }

    public String enterPhoneNumber(String phone) {
        phoneField.sendKeys(phone);
        phoneField.sendKeys(Keys.ENTER);
		return phone;
    }

   // public void submitEnrollmentForm() {
//        formEnrollButton.click();
//        formEnrollButton.submit();
    	public void submitEnrollmentForm() {
    	    try {
    	        // Click the button
    	        formEnrollButton.click();

    	        // Wait for the next page to load (Order Summary)
    	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ord_bx_tot_mob']/div[1]")));
    	    } catch (StaleElementReferenceException e) {
    	        System.out.println("Element became stale after click, which is expected due to page navigation.");
    	    }
    	}
    

    public boolean isOrderSummaryVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        return wait.until(ExpectedConditions.visibilityOf(orderSummaryText)).isDisplayed();
    }

    public boolean isOnPaymentPage() {
        return isOrderSummaryVisible();
    }
}


