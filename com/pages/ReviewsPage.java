package com.pages;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.setup.Reports;

public class ReviewsPage {
	static ExtentTest test;
	static WebDriver driver;
	Properties prop;
	WebDriverWait wait;

	@FindBy(xpath ="//*[@id=\"__next\"]/div/div[3]/section/div/div[2]/div/span[2]/a")
	WebElement reviewButton;

	@FindBy(xpath ="//*[@id=\"reviews\"]/div/div/div[2]/div[1]/div/div/div[1]/div[1]/div[1]")
	static
	WebElement verifyReview;
	public ReviewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickReviews(){
		reviewButton.click();
		//Reports.generateReport(driver, test, Status.PASS, "Reviews Clicked");
		
	}
	public static boolean isReviewVisible(String ReviewText) {
		
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
			wait.until(ExpectedConditions.visibilityOf(verifyReview));
			try {
			//Reports.generateReport(driver, test, Status.PASS, "Enroll Button clicked");
			
			
		}catch (Exception e) {
			Reports.generateReport(driver, test, Status.FAIL, "Enroll button not clicked");
		}
		
			
		return wait.until(ExpectedConditions.visibilityOf(verifyReview)).isDisplayed();

	}

}
