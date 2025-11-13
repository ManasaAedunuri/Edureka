package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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
import com.stepDefinitionTestNG.Hooks;

public class SearchCoursePage extends BaseSteps{
	
	private static ExtentTest test;
	private static WebDriverWait wait;

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
	/*public SearchCoursePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}*/
	public SearchCoursePage(WebDriver driver, ExtentTest test) {
        this.driver = driver;
        this.test = test;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
    }

	// Actions
	public void clickSearchBar() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement courseList = wait.until(ExpectedConditions.visibilityOf(searchBar));
		Reports.generateReport(driver, test, Status.PASS, "Search Bar is clicked");
		searchBar.click();
	}

	public void enterCourseName(String courseName) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(13));
		wait.until(ExpectedConditions.visibilityOf(searchInput));
		Reports.generateReport(driver, test, Status.PASS, "Data is passed");
		searchInput.sendKeys(courseName);
		searchInput.sendKeys(Keys.ENTER);
	}

	public boolean verifySearchResults() {
		boolean actResult=true;
		try {
			if (searchResultsList.isDisplayed()) {
				System.out.println("Search results are displayed.");
				Reports.generateReport(driver, test, Status.PASS, "Search page is displayed");
			} else {
				throw new AssertionError("Search results not displayed.");
			}
		}
		catch(Exception e) {
			actResult=false;
			Reports.generateReport(driver, test, Status.FAIL, "Search page is not displayed");
		}
		return actResult;
	}

    public void selectCourse(String courseName) {
    	Reports.generateReport(driver, test, Status.PASS, "Search course is clicked");
    	courseLink.click();
    }

    public boolean verifyCourseDetailsPage() {
    	boolean actResult=true;
		try {
			if (driver.getTitle().contains("Course")) {
				System.out.println(driver.getTitle());
				Reports.generateReport(driver, test, Status.PASS, "Course details page is displayed");
			} else {
				throw new AssertionError("Course details page not displayed.");
			}
		}
		catch(Exception e) {
			actResult=false;
			Reports.generateReport(driver, test, Status.FAIL, "Course details page is not displayed");
		}
		return actResult;
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
    	Reports.generateReport(driver, test, Status.PASS, "Technology is clicked");
    	techElement.click();
    }

    public void clickFilterOption(String filterOption) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    	WebElement filterElement = wait.until(ExpectedConditions.elementToBeClickable(filtersSection));
    	Reports.generateReport(driver, test, Status.PASS, "Filter is clicked");
    	filterElement.click();
    }

    public void selectFilter(String filterValue) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    	WebElement filterValueElement = wait.until(ExpectedConditions.elementToBeClickable(courseListSection));
    	Reports.generateReport(driver, test, Status.PASS, "Filter is selected");
    	filterValueElement.click();
    }

    public boolean verifyCloudDevOpsCourses() {
    	boolean actResult=true;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
			WebElement courseList = wait.until(ExpectedConditions.visibilityOf(verifyCloudPage));
			if (courseList.isDisplayed()) {
				System.out.println("Cloud DevOps courses are displayed successfully.");
				Reports.generateReport(driver, test, Status.PASS, "Cloud Dev Courses are displayed");
			} else {
				throw new AssertionError("Cloud DevOps courses not displayed.");
			}
		}
		catch(Exception e) {
			actResult=false;
			Reports.generateReport(driver, test, Status.FAIL, "Cloud Dev Courses are not displayed");
		}
		return actResult;
    }
    
    /* Scenario 3 */
    @FindBy(id = "search-input")
    WebElement enterInput;
    
    public boolean enterCourseInput(String cname) {
    	try {
    		wait.until(ExpectedConditions.visibilityOf(enterInput));
    		enterInput.clear();
    		enterInput.sendKeys(cname);
    		enterInput.sendKeys(Keys.ENTER);
    		return true;
    	}
    	catch(Exception e) {
    		return false;
    	}
    }
    
    public boolean verifyDisplay() {
    	try {
			if (driver.getTitle().contains("Instructor-Led Online Training with 24X7 Lifetime Support | Edureka")) {
				System.out.println(driver.getTitle());
				Reports.generateReport(driver, test, Status.PASS, "Course details page is displayed");
			}
			return true;
		}
		catch(Exception e) {
			Reports.generateReport(driver, test, Status.FAIL, "Course details page is not displayed");
			return false;
		}
    }
    
    /* Scenario 4 */
    @FindBy(xpath = "/html/body/div[3]/div/div/div/div[3]/div[1]/div[2]/div[2]/ul/li[1]/a")
    WebElement buttonAI;
    
    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[3]/div[1]/div/div[2]/div[2]/div[2]")
    WebElement reviewButton;
    
    @FindBy(xpath = "/html/body/div[2]/header[2]/div/div[1]/div[1]/div[1]/form")
    WebElement secondSearchInput;
    
    public void clickAI() {
    	try {
    		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    		WebElement elementAIClick = wait.until(ExpectedConditions.elementToBeClickable(buttonAI));
    		elementAIClick.click();
    	}
		catch(Exception e) {
			//Reports.generateReport(driver, test, Status.FAIL, "Course details page is not displayed");
			e.printStackTrace();
		}
    }
    
    public void clickReview() {
    	try {
    		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    		wait.until(ExpectedConditions.elementToBeClickable(reviewButton));
    		((JavascriptExecutor) driver).executeScript("arguments[0].click();", reviewButton);
    		//sagReview.click();
    	}
    	catch(Exception e) {
			//Reports.generateReport(driver, test, Status.FAIL, "Course details page is not displayed");
		}
    }
    
    public boolean enterWebsiteInput(String websiteName) {
    	try {
    		wait.until(ExpectedConditions.visibilityOf(secondSearchInput));
    		wait.until(ExpectedConditions.elementToBeClickable(secondSearchInput));
    		((JavascriptExecutor) driver).executeScript("arguments[0].click();", secondSearchInput);
    		//secondSearchInput.click();
    		//secondSearchInput.clear();
    		secondSearchInput.sendKeys(websiteName);
    		secondSearchInput.sendKeys(Keys.ENTER);
    		return true;
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    		return false;
    	}
    }
    
    public boolean verifyReviewDisplay() {
    	try {
			if (driver.getTitle().contains("Sitejabber - Search")) {
				System.out.println(driver.getTitle());
				Reports.generateReport(driver, test, Status.PASS, "Review details page is displayed");
			}
			return true;
		}
		catch(Exception e) {
			Reports.generateReport(driver, test, Status.FAIL, "Review details page is not displayed");
			return false;
		}
    } 

    /* Scenario 5 */
   /* @FindBy(xpath = "(//a)[text()='Cloud Computing'][3]")
    WebElement cloudButton;
    
//    @FindBy(xpath = "(//input[@placeholder='Enter Course, Category or keyword'])[2]")
//    WebElement searchInputField;
//    
//    @FindBy(xpath = "//*[@id=\"remote\"]/span[2]")
//    WebElement searchButtonIcon;
    
    public boolean clickCloudComputing() {
    	try {
    		wait.until(ExpectedConditions.elementToBeClickable(cloudButton));
    		cloudButton.click();
    		return true;
    	}
    	catch(Exception e) {
    		return false;
    	}
    }*/
    
    /*public boolean clickSearchInput() {
    	try {
    		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    		WebElement searchInputField = wait.until(ExpectedConditions.elementToBeClickable(
    				By.xpath("(//input[@placeholder='Enter Course, Category or keyword'])[2]")
    						));
    		searchInputField.click();
    		return true;
    	}
    	catch(Exception e) {
    		return false;
    	}
    }*/
    
    /*public boolean enterCourseInput(String cname) {
    	try {
    		//wait.until(ExpectedConditions.elementToBeClickable(searchInputField));
    		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    		WebElement searchInputField = wait.until(ExpectedConditions.elementToBeClickable(
    				By.xpath("/html/body/header/nav/div[3]/input")
    						));
    		searchInputField.clear();
    		searchInputField.sendKeys(cname);
    		
//    		WebElement searchButtonIcon = wait.until(ExpectedConditions.elementToBeClickable(
//    				By.xpath("/html/body/header/nav/div[3]")
//    				));
//    		searchButtonIcon.click();
    		searchInputField.sendKeys(Keys.ENTER);
    		return true;
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    		return false;
    	}
    }

    public boolean verifyVisibilityCoursePage() {
		try {
			if (driver.getTitle().contains("Instructor-Led Online Training with 24X7 Lifetime Support | Edureka")) {
				System.out.println(driver.getTitle());
				//Reports.generateReport(driver, test, Status.PASS, "Courses page is visible");
			} else {
				throw new AssertionError("Courses page not visible.");
			}
			return true;
		}
		catch(Exception e) {
			return false;
			//Reports.generateReport(driver, test, Status.FAIL, "Courses page is not visible");
		}
    }*/
}
