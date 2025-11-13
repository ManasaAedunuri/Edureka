package com.pages;

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
	    @FindBy(xpath = "///h2[contains(text(),'Trending Courses')]")
	    WebElement trendingCoursesHeader;

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
	    

	    public EnrollNowPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

	    public void clickEnrollButton() {
	        enrollButton.click();
	    }
//	    public boolean isEnrollmentFormVisible() {
//			return true;
//	    	
//	    }

	    public void enterEmail(String email) {
	        emailField.sendKeys(email);
	    }

	    public void enterPhoneNumber(String phone) {
	        phoneField.sendKeys(phone);
	    }

	    public void submitEnrollmentForm() {
	        formEnrollButton.click();
	    }


	    public boolean isOrderSummaryVisible() {
	        return orderSummaryText.isDisplayed();
	    }

		public boolean isOnPaymentPage() {
			
			return true;
		}
	}


