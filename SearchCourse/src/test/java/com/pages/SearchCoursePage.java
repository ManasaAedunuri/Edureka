package com.pages;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.parameters.PropertyReader;
import com.setup.BaseSteps;

public class SearchCoursePage extends BaseSteps{

	/* Scenario 1 */
	// Locators
	@FindBy(xpath = "//span[text()='Search courses']")
	WebElement searchBar;
	
	@FindBy(xpath = "//*[@id=\"search-input\"]")
	WebElement searchInput;

	@FindBy(xpath = "//*[@id=\"add-master-courses\"]/a[1]/div[1]/div[2]/div[1]")
	WebElement searchResultsList;

	@FindBy(css = "#add-master-courses > a:nth-of-type(1) > div:nth-of-type(1) > div:nth-of-type(2)")
	WebElement courseLink;
	
	// Constructor
	public SearchCoursePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Actions
	public void clickSearchBar() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    	WebElement courseList = wait.until(ExpectedConditions.visibilityOf(searchBar));
		searchBar.click();
	}

	public void enterCourseName(String courseName) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(13));
		wait.until(ExpectedConditions.visibilityOf(searchInput));
		searchInput.sendKeys(courseName);
		searchInput.sendKeys(Keys.ENTER);
	}

	public void verifySearchResults() {
		if (searchResultsList.isDisplayed()) {
			System.out.println("Search results are displayed.");
		} else {
			throw new AssertionError("Search results not displayed.");
		}
	}

    public void selectCourse(String courseName) {
        courseLink.click();
    }

    public void verifyCourseDetailsPage() {
        if (driver.getTitle().contains("Course")) {
            System.out.println(driver.getTitle());
        } else {
            throw new AssertionError("Course details page not displayed.");
        }
    } 
    
    /* Scenario 2 */

    @FindBy(xpath = "//a[text()='aws']")
    WebElement popularCoursesSection;

    @FindBy(xpath = "(//button)[@id='filterdropdown'][1]")
    WebElement filtersSection;

    @FindBy(xpath = "(//label)[text()='Cloud DevOps Engineer'][1]")
    WebElement courseListSection;
    
    @FindBy(xpath = "//span[@id='span-job_role: Cloud DevOps Engineer ']")
    WebElement verifyCloudPage;

    // Actions
    public void clickTechnology(String techName) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    	WebElement techElement = wait.until(ExpectedConditions.elementToBeClickable(popularCoursesSection));
    	techElement.click();
    }

    public void clickFilterOption(String filterOption) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    	WebElement filterElement = wait.until(ExpectedConditions.elementToBeClickable(filtersSection));
    	filterElement.click();
    }

    public void selectFilter(String filterValue) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    	WebElement filterValueElement = wait.until(ExpectedConditions.elementToBeClickable(courseListSection));
    	filterValueElement.click();
    }

    public void verifyCloudDevOpsCourses() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    	WebElement courseList = wait.until(ExpectedConditions.visibilityOf(verifyCloudPage));
    	if (courseList.isDisplayed()) {
    		System.out.println("Cloud DevOps courses are displayed successfully.");
    	} else {
    		throw new AssertionError("Cloud DevOps courses not displayed.");
    	}
    }

}
