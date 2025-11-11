package com.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.setup.BaseSteps;

public class TrendingCoursesPage extends BaseSteps {
   private static  WebDriver driver;

    // Landing Page Elements
    @FindBy(xpath = "//h2[text()='Trending Courses']")

    static WebElement trendingCoursesSection;

    static WebElement courseCard;

    // Course Detail Page Elements
    @FindBy(xpath = "//h1[contains(text(),'Prompt Engineering Certification Course with LLM')]")
    WebElement courseHeader;

    @FindBy(xpath = "//section[@id='sitejabber-reviews']")
	
    static WebElement sitejabberSection;

    @FindBy(xpath = "//a[contains(text(),'Sitejabber Reviews')]")
	
    static WebElement sitejabberLink;

    public TrendingCoursesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Landing Page Actions
    public static void scrollToTrendingCourses() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", trendingCoursesSection);
    }

//    public void locateCourseCard(String courseName) {
//        courseCard = driver.findElement(By.xpath("//*[@id="__next"]/div/div[3]/div/div[1]/div/div/div/div[4]/div[1]/div[2]/div[1]"));
//    }

    public static void clickCourseCard() {
    	 courseCard = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div/div[1]/div/div/div/div[4]/div[1]/div[2]"));
        courseCard.click();
    }

    // Course Detail Page Actions
    public boolean isCourseDetailPageDisplayed(String courseName) {
        return driver.getTitle().contains(courseName);
    }

    public boolean isHeaderVisible(String headerText) {
        return courseHeader.getText().contains(headerText);
    }

    public static void scrollToSitejabberSection() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sitejabberSection);
    }

    public static void clickSitejabberLink() {
        sitejabberLink.click();
    }

    public boolean isSitejabberPageDisplayed() {
        return driver.getCurrentUrl().contains("sitejabber");
    }
    
}