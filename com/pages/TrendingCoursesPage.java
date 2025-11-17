package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.setup.BaseSteps;
import com.setup.Reports;

public class TrendingCoursesPage extends BaseSteps {

    private  static WebDriver driver;

    // Constructor
    public TrendingCoursesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        
    }
    static ExtentTest test;

   
    @FindBy(xpath = "//h2[text()='Trending Courses']")
    private WebElement trendingCoursesSection;

    // Method to check if Trending Courses section is visible
    public boolean isTrendingCoursesSectionVisible() {
    	boolean actResult = true;
        try {
        	
           trendingCoursesSection.isDisplayed();
            Reports.generateReport(driver, test, Status.PASS, "Trending Course is Displayed ");
        } catch (Exception e) {
        	actResult = false;
        	Reports.generateReport(driver, test, Status.FAIL, "Trending Course is not Displayed ");
        }
        return actResult;
    }
}