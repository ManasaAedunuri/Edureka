package com.pages;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReviewsPage {
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

}


public static boolean isReviewVisible(String ReviewText) {
//WebElement confirmationSection = driver.findElement(
//    org.openqa.selenium.By.xpath("//*[contains(text(),'" + confirmationText + "')]"));
//scrollToElement(confirmationSection);
//return confirmationSection.isDisplayed();
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
wait.until(ExpectedConditions.visibilityOf(verifyReview));
//Reports.generateReport(driver, test, Status.PASS, "community is visible.");
return wait.until(ExpectedConditions.visibilityOf(verifyReview)).isDisplayed();

}

}
