package com.pages;
import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.setup.Reports;

public class CommunityPage 
{
	WebDriver driver;
	ExtentTest test;


	@FindBy(xpath="//*[@id=\"__next\"]/div/nav/div[4]/div[2]/button")
	WebElement resource;
	
	@FindBy(xpath = "//*[@id=\"__next\"]/div/nav/div[4]/div[2]/div/a[3]")
	WebElement communitySubMenu;

	// ====== Community Page Elements ======
	@FindBy(xpath="//*[@id=\"nav\"]/div[1]/div[3]/div/form/div/input")
	WebElement searchBox;
	
	@FindBy(xpath = "/html/body/main/div[2]/div[2]/h1")
	WebElement joinButton;

	public CommunityPage(WebDriver driver, ExtentTest test) {
        this.driver = driver;
        this.test = test;
        PageFactory.initElements(driver, this);
	}
	 
	public void clickResource() {
		try {
		resource.click();
		 Reports.generateReport(driver, test, Status.PASS, "clicked resource.");
		}catch (Exception e) {
			Reports.generateReport(driver, test, Status.FAIL, "Failed to select suggestion: " + e.getMessage());
		}
	}

    public void clickSubMenu() {
    	try {
    
        communitySubMenu.click();
        Reports.generateReport(driver, test, Status.PASS, "clicked submenu.");
    	}catch (Exception e) {
    		Reports.generateReport(driver, test, Status.FAIL, "Failed to select suggestion: " + e.getMessage());
		}
    }

    public void searchCommunity(String name) {
    	try {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	wait.until(ExpectedConditions.elementToBeClickable(searchBox));
        searchBox.clear();
        searchBox.sendKeys(name);
        searchBox.sendKeys(Keys.ENTER);
        Reports.generateReport(driver, test, Status.PASS, "search community.");
    	}catch (Exception e) {
    		Reports.generateReport(driver, test, Status.FAIL, "Failed to select suggestion: " + e.getMessage());
		}
    }

    
    	public boolean isCommunityVisible(String communityText) {
    	
      	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
          wait.until(ExpectedConditions.visibilityOf(joinButton));
          try {
          Reports.generateReport(driver, test, Status.PASS, "community is visible.");
    		}catch (Exception e) {
    			Reports.generateReport(driver, test, Status.FAIL, "Failed to select suggestion: " + e.getMessage());
			}
         return wait.until(ExpectedConditions.visibilityOf(joinButton)).isDisplayed();
      }
    }




