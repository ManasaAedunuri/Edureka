package com.pages;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.setup.Reports;

public class EnrollNowPage {

    private WebDriver driver;

    static ExtentTest  test;
    
    public EnrollNowPage(WebDriver driver,  ExtentTest test) {
    	this.test = test;
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

    
    public void clickEnrollButton() {
    	
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
         wait.until(ExpectedConditions.visibilityOf(enrollButton));
       wait.until(ExpectedConditions.elementToBeClickable(enrollButton));
       
       
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", enrollButton);
        try {
        Reports.generateReport(driver, test, Status.PASS, "Enroll Button clicked");
    	}catch (Exception e) {
    		Reports.generateReport(driver, test, Status.FAIL, "Enroll button not clicked");
		}
        
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
    	try {
        phoneField.sendKeys(phone);
        phoneField.sendKeys(Keys.ENTER);
        Reports.generateReport(driver, test, Status.PASS, "Phone Number is entered ");
    	}catch (Exception e) {
    		 Reports.generateReport(driver, test, Status.FAIL, "Phone Number is not entered");
		}
		return phone;
    }

 
    	public void submitEnrollmentForm() {
    	    try {
    	        // Click the button
    	        formEnrollButton.click();

    	        // Wait for the next page to load (Order Summary)
    	       
    	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ord_bx_tot_mob']/div[1]")));
    	       // Reports.generateReport(driver, test, Status.PASS, "Enrollment Form is Submitted ");
    	      
    	    } catch (StaleElementReferenceException e) {
    	        System.out.println("Element became stale after click, which is expected due to page navigation.");
    	       // Reports.generateReport(driver, test, Status.FAIL, "Enrollement Form is not Submitted");
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


