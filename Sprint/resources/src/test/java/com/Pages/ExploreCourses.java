package com.Pages;

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

import com.setUp.BaseSteps;

public class ExploreCourses extends BaseSteps{
	  WebDriverWait wait;
 @FindBy(xpath="//*[@id=\"navbarSupportedContent\"]/ul[2]/li[1]/a")
 WebElement exploreCourses;
 
 @FindBy(xpath="(//*[text()='Artificial Intelligence'])[1]") 
 WebElement Ai;
 
 @FindBy(xpath="(//*[text()='DevOps'])[1]") 
 WebElement Dev;
 
 @FindBy(xpath="(//*[text()='Cloud Computing'])[1]") 
 WebElement Cc;
 
 
 
 
 public ExploreCourses(WebDriver driver) {
	// TODO Auto-generated constructor stub
	 
	        this.driver = driver;
	        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	        PageFactory.initElements(driver, this);
	    }


 public void clickMenu() {
     exploreCourses.click();
 }
 public void searchCourse(String name)  
 {
 	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
 	if (Ai.getText().equalsIgnoreCase(name)) 
 	{
 		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
 	    Ai.click();
 	}
 	else if(Dev.getText().equalsIgnoreCase(name)) {
 		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
 	    Dev.click();
 		
 	}
    else if(Cc.getText().equalsIgnoreCase(name)) {
    	wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 	    Cc.click();
 	}
 	else {
 	System.out.println("not clicking");
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
	 
 }
}
