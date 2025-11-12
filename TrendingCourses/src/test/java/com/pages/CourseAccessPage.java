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

import com.setup.BaseSteps;

public class CourseAccessPage extends BaseSteps {
	WebDriverWait wait;

    public CourseAccessPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @FindBy(xpath = "//div[contains(@class,'trending-course-section')]")
    WebElement trendingSection;
    
    @FindBy(xpath="//div[contains(@data-category,'Artificial Intelligence')][2]")
    WebElement llmCourseCard;
    
    @FindBy(xpath ="//*[@id=\"__next\"]/div/div[3]/section/div/div[1]/div[1]/div/div[1]/h1")
	static
    WebElement validTitle;

    public void scrollToSection() {
//        WebElement section = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", section);
//    	wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body"))); // ensure page is loaded
        WebElement section = wait.until(ExpectedConditions.visibilityOf(llmCourseCard));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", section);
        WebElement llmcourse=driver.findElement(By.xpath("llm_course_card_xpath"));
        scrollToElement(llmCourseCard);
    	
//    	    try {
//    	        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));
//    	        System.out.println("Scrolling to XPath: " + xpath);
//
//    	        for (int i = 0; i < 2; i++) {
//    	            try {
//    	                WebElement section = driver.findElement(By.xpath(xpath));
//    	                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", section);
//    	                wait.until(ExpectedConditions.visibilityOf(section));
//    	                break;
//    	            } catch (StaleElementReferenceException | org.openqa.selenium.NoSuchElementException ex) {
//    	                System.out.println("Retrying scroll due to: " + ex.getClass().getSimpleName());
//    	                Thread.sleep(500);
//    	            }
//    	        }
//
//    	    } catch (Exception e) {
//    	        throw new AssertionError("Failed to scroll to Trending Courses section: " + e.getMessage());
//    	    }
    	}

    

    public boolean clickOnCourseCard() {
       /* WebElement card = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        card.click();*/
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
//        return wait.until(ExpectedConditions.visibilityOfElementLocated(
//            By.xpath("//h1[contains(text(),'" + courseName + "')]")));
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(validTitle));
       return wait.until(ExpectedConditions.visibilityOf(validTitle)).isDisplayed();
    }
    private void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
}



