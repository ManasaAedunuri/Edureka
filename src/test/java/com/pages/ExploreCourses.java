package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.setup.BaseSteps;
import com.setup.Reports;

public class ExploreCourses extends BaseSteps{
	  WebDriverWait wait;
	  ExtentTest test;
 @FindBy(xpath="//*[@id=\"navbarSupportedContent\"]/ul[2]/li[1]/a")
 WebElement exploreCourses;
 
 @FindBy(xpath="(//*[text()='Artificial Intelligence'])[1]") 
 WebElement Ai;
 
 @FindBy(xpath="(//*[text()='DevOps'])[1]") 
 WebElement Dev;
 
 @FindBy(xpath="(//*[text()='Cloud Computing'])[1]") 
 WebElement Cc;
 
 
 
 
 public ExploreCourses(WebDriver driver, ExtentTest test) {
     this.driver = driver;
     this.test = test;
     PageFactory.initElements(driver, this);
	        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	       
	    }


 public void clickMenu() {
	 try {
     exploreCourses.click();
     Reports.generateReport(driver, test, Status.PASS, "clicked menu.");
     }catch (Exception e) {
    	 Reports.generateReport(driver, test, Status.FAIL, "Failed to select suggestion: " + e.getMessage());
	}
     
 }
 public void searchCourse(String name)  
 {
 	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
 	if (Ai.getText().equalsIgnoreCase(name)) 
 	{
 		wait.until(ExpectedConditions.elementToBeClickable(Ai));
 	    Ai.click();
 	}
 	else if(Dev.getText().equalsIgnoreCase(name)) {
 		wait.until(ExpectedConditions.elementToBeClickable(Dev));
 	    Dev.click();
 		
 	}
    else if(Cc.getText().equalsIgnoreCase(name)) {
    	wait.until(ExpectedConditions.elementToBeClickable(Cc));
 	    Cc.click();
 	}
 	else {
 	System.out.println("not clicking");
 	}try {
 	 Reports.generateReport(driver, test, Status.PASS, "clicked search course.");
 	}catch (Exception e) {
 		Reports.generateReport(driver, test, Status.FAIL, "Failed to select suggestion: " + e.getMessage());
	}
 
 }
 public void validate()
 {
	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	 WebElement aiCoursesText = wait.until(ExpectedConditions.visibilityOfElementLocated(
	     By.xpath("/html/body/section[3]/div/div[1]")
	 ));

	 boolean isVisible = aiCoursesText.isDisplayed();
	 System.out.println("Text is visible: " + isVisible);
	 try {
	 Reports.generateReport(driver, test, Status.PASS, "validated.");
	 }catch (Exception e) {
		 Reports.generateReport(driver, test, Status.FAIL, "Failed to select suggestion: " + e.getMessage());
	}
	 
 }
}
