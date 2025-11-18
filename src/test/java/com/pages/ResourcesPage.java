package com.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.setup.BaseSteps;
import com.setup.Reports;

import java.time.Duration;

public class ResourcesPage extends BaseSteps{
  
    WebDriverWait wait;
    ExtentTest test;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/nav/div[4]/div[2]/button")
    WebElement resourcesMenu;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/nav/div[4]/div[2]/div/a[1]")//*[@id="__next"]/div/nav/div[4]/div[2]/div/a[1]//a[text()='Blog']
    WebElement blogLink;

    @FindBy(xpath = "/html/body/section[1]/div/div/div[1]/a")
    WebElement categoryLink;

    @FindBy(xpath = "//*[@id=\"category-course-blog-list-2\"]/section/div/div/div/div[1]/div/div[1]/a/h3")
    WebElement articleLink;

    public ResourcesPage(WebDriver driver, ExtentTest test) {
        this.driver = driver;
        this.test = test;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    
    }

   

    public void clickResources() {
        resourcesMenu.click();
        try {
        Reports.generateReport(driver, test, Status.PASS, "clicked resources.");
        }catch (Exception e) {
        	Reports.generateReport(driver, test, Status.FAIL, "Failed to select suggestion: " + e.getMessage());
		}
    }

    public void clickBlog() {
    	wait.until(ExpectedConditions.elementToBeClickable(blogLink));
    	blogLink.click();
    	try {
    	 Reports.generateReport(driver, test, Status.PASS, "clicked blog.");
    	}catch (Exception e) {
    		Reports.generateReport(driver, test, Status.FAIL, "Failed to select suggestion: " + e.getMessage());
		}
    }

    public void selectCategory(String category) {
    	categoryLink.click();
    	try {
    	 Reports.generateReport(driver, test, Status.PASS, "selected category.");
    	}catch (Exception e) {
    		Reports.generateReport(driver, test, Status.FAIL, "Failed to select suggestion: " + e.getMessage());
		}
    }
    

    public void clickArticleByTitle(String title) {
    	try {
    	articleLink.click();
    	 Reports.generateReport(driver, test, Status.PASS, "clicked articleby title.");
    	}catch (Exception e) {
    		Reports.generateReport(driver, test, Status.FAIL, "Failed to select suggestion: " + e.getMessage());
		}
    }
    
}
