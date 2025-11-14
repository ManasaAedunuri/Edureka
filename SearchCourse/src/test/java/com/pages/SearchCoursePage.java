package com.pages;

import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.parameters.ExcelReader;
import com.parameters.PropertyReader;
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
    		Reports.generateReport(driver, test, Status.PASS, "Course name is enterd");
    		return true;
    	}
    	catch(Exception e) {
    		Reports.generateReport(driver, test, Status.PASS, "Course name is not entered");
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
    @FindBy(xpath = "(//a)[text()='DevOps'][3]/parent::li")
    WebElement clickDev;
    
    @FindBy(xpath = "//a[text()='TimesNow']")
    WebElement timeNow;
    
    public void clickDevOps() {
    	WebElement devClick = wait.until(ExpectedConditions.elementToBeClickable(clickDev));
    	devClick.click();
    	Reports.generateReport(driver, test, Status.PASS, "DevOps is clicked");
    }
    
    public void clickViewDetails() {
    	WebElement element = driver.findElement(By.xpath("(//button)[text()='VIEW DETAILS'][1]"));
    	//JavascriptExecutor js = (JavascriptExecutor) driver;
    	//js.executeScript("arguments[0].scrollIntoView(true);", element);
    	element.click();
    	Reports.generateReport(driver, test, Status.PASS, "View Details is clicked");
    }
    
    public void clickTimesNow() {
    	wait.until(ExpectedConditions.elementToBeClickable(timeNow));
    	timeNow.click();
    	Reports.generateReport(driver, test, Status.PASS, "Times Now is clicked");
    }
    
    public boolean verifyArticlePage() {
    	try {
			if (driver.getTitle().contains("Future-Proof Your Career: Top DevOps Courses to Consider in 2025 | Markets - Times Now")) {
				System.out.println(driver.getTitle());
				Reports.generateReport(driver, test, Status.PASS, "Course details page is displayed");
			}
			return true;
		}
		catch(Exception e) {
			Reports.generateReport(driver, test, Status.FAIL, "Times Now article page is not displayed");
			return false;
		}
    }
    
    /* Scenario 5 */
    @FindBy(xpath = "//a[text()='chatgpt']")
    WebElement chatGPT;
    
    @FindBy(xpath = "//h3[text()=' Generative AI Course Masters Program ']/parent::div")
    WebElement genAI;
    
    @FindBy(xpath = "(//button)[text()='GET IN TOUCH'][1]")
    WebElement getInTouch;
    
    @FindBy(id = "git_email")
    WebElement email;
    
    @FindBy(id = "git_tel")
    WebElement phone;
    
    @FindBy(xpath = "//button[text()='SUBMIT']")
    WebElement submitButton;
    
    @FindBy(xpath = "//*[@id=\"gettopfoldclp\"]/div/div/div/div/div/p/span")
    WebElement thankYou;
    
    public void clickChatGPT() {
    	wait.until(ExpectedConditions.elementToBeClickable(chatGPT));
    	chatGPT.click();
    	//Reports.generateReport(driver, test, Status.PASS, "Power BI is clicked");
    }
    
    public void clickGenAICourse() {
    	wait.until(ExpectedConditions.elementToBeClickable(genAI));
    	genAI.click();
    	//Reports.generateReport(driver, test, Status.PASS, "Course is clicked");
    }
    
    public void clickGetInTouch() {
    	wait.until(ExpectedConditions.elementToBeClickable(getInTouch));
    	getInTouch.click();
    }
    
    Map<String, String> formData;
    PropertyReader propertyreader=new PropertyReader();
    
    public void enterFormData(Integer sheet, Integer row) throws InterruptedException
    {
    	String sheetName = "Sheet" + sheet; // Assuming sheet names are Sheet1, Sheet2
        String rowStr = String.valueOf(row);
 
        SearchCoursePage searchPage = new SearchCoursePage(driver, test);
        searchPage.enterEmail(sheetName, rowStr);
        searchPage.enterPhone(sheetName, rowStr);
        
    }
    
    public void enterEmail(String sheet,String row) throws InterruptedException
    {
    	 wait.until(ExpectedConditions.visibilityOf(email));
		   //clickElement(email);
		   //email.sendKeys(excelData.get(rowIndex)[3]);
		   int rowNum = Integer.parseInt(row);
		    formData = ExcelReader.getRowData(sheet, rowNum);
		    String fieldEmail=propertyreader.getProperty("emailField");
		   email.sendKeys(formData.get(fieldEmail));
    }
    
    public void enterPhone(String sheet,String row) throws InterruptedException
    {
    	wait.until(ExpectedConditions.visibilityOf(phone));
		   phone.click();
		   int rowNum = Integer.parseInt(row);
		    formData = ExcelReader.getRowData(sheet, rowNum);
		    String fieldPhone=propertyreader.getProperty("phoneField");
		    		
		    long phoneNum = Long.parseLong(formData.get(fieldPhone));
		   phone.sendKeys(String.valueOf(phoneNum));
    }
    
    public void clickSubmit() {
    	wait.until(ExpectedConditions.elementToBeClickable(submitButton));
    	submitButton.click();
    }
    
    public void displayThankYou() throws InterruptedException {
    	try {
    		wait.until(ExpectedConditions.visibilityOf(thankYou));
    		Assert.assertTrue(thankYou.isDisplayed(),"Submission Unsuccessful, Please enter valid Data");
    	}
    	catch (Exception e) {
    		Assert.fail("Submission Unsuccessful, Please enter valid Data");
    	}
    	Thread.sleep(1000);
    }
    
    /*public void clickGoogleReview() {

    	WebElement element = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/section[2]/div/div/div/div[1]/div/div"));
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("arguments[0].scrollIntoView(true);", element);

    	//wait.until(ExpectedConditions.elementToBeClickable(googleReview));
    	googleReview.click();
    	//Reports.generateReport(driver, test, Status.PASS, "Course is clicked");
    }
    
    public void enterPlace(String place) {
//    	try {
//    		wait.until(ExpectedConditions.visibilityOf(searchPlace));
//    		searchPlace.clear();
//    		searchPlace.sendKeys(place);
//    		searchPlace.sendKeys(Keys.ENTER);
//    		//Reports.generateReport(driver, test, Status.PASS, "Place is enterd");
//    		return true;
//    	}
//    	catch(Exception e) {
//    		//Reports.generateReport(driver, test, Status.PASS, "Place is not entered");
//    		return false;
//    	}
    	cancelButton.click();
    	wait.until(ExpectedConditions.visibilityOf(searchPlace));
    	wait.until(ExpectedConditions.elementToBeClickable(searchPlace));
    	((JavascriptExecutor) driver).executeScript("arguments[0].click();", searchPlace);
		//searchPlace.clear();
		searchPlace.sendKeys(place);
		searchPlace.sendKeys(Keys.ENTER);
    }
    
    public boolean verifyMaps() {
    	try {
			if (driver.getTitle().contains("Edureka - Google Maps")) {
				System.out.println(driver.getTitle());
				Reports.generateReport(driver, test, Status.PASS, "Maps page is visible");
			}
			return true;
		}
		catch(Exception e) {
			Reports.generateReport(driver, test, Status.FAIL, "Maps page is not visible");
			return false;
		}
    }*/
}
