package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
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

public class CourseAccessPage extends BaseSteps {
	static WebDriverWait wait;
	static ExtentTest test;

	public CourseAccessPage(WebDriver driver,ExtentTest Test) {
		this.driver = driver;
		this.test=test;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@FindBy(xpath = "//div[contains(@class,'trending-course-section')]")
	WebElement trendingSection;

	@FindBy(xpath="//*[@id=\"__next\"]/div/div[3]/div/div[1]/div/div/div/div[8]")
	WebElement llmCourseCard;

	@FindBy(xpath = "//*[@id=\"__next\"]/div/div[3]/section/div/div[1]/div[1]/div/div[1]/h1")
	WebElement getCourseHeader;



	@FindBy(xpath ="//*[@id=\"__next\"]/div/div[3]/section/div/div[1]/div[1]/div/div[1]/h1")
	static
	WebElement validTitle;



	public void scrollToSection() {

		WebElement section = wait.until(ExpectedConditions.visibilityOf(llmCourseCard));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", section);
		WebElement llmcourse=driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div/div[1]/div/div/div/div[8]"));
		scrollToElement(llmCourseCard);
	}

	public boolean clickOnCourseCard() {

		try {
			wait.until(ExpectedConditions.visibilityOf(llmCourseCard));
			llmCourseCard.click();
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	public static boolean getCourseTitle(String llm_course_name) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(validTitle));
		//Reports reports = new Reports();
		try {
			//reports.generateReport(driver, test, Status.PASS, "Trending Course is Displayed ");
		} catch (Exception e) {
			
			e.printStackTrace();
		}

		return wait.until(ExpectedConditions.visibilityOf(validTitle)).isDisplayed();
	}

	private void scrollToElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
}



