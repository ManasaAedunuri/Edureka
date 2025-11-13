package com.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class TrendingCoursesPage {

    private static WebDriver driver;
    private static WebDriverWait wait;

    // Constructor
    public TrendingCoursesPage(WebDriver driver) {
        TrendingCoursesPage.driver = driver;
        TrendingCoursesPage.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    // Landing Page Elements
    @FindBy(xpath = "//h2[text()='Trending Courses']")
    private static WebElement trendingCoursesSection;

    @FindBy(xpath = "//h1[contains(text(),'Prompt Engineering Certification Course with LLM')]")
    private WebElement courseHeader;

    @FindBy(xpath = "//section[@id='sitejabber-reviews']")
    private WebElement sitejabberSection;
    
    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[3]/div/div[1]/div/div/div/div[8]")
    private WebElement courseCard;

    @FindBy(xpath = "//a[contains(text(),'Sitejabber Reviews')]")
    private WebElement sitejabberLink;

    // Scroll to Trending Courses section
    public static void scrollToTrendingCourses() {
        wait.until(ExpectedConditions.visibilityOf(trendingCoursesSection));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", trendingCoursesSection);
    }

    // Click course card by name (dynamic XPath)
    public void clickCourseCardByName(String courseName) {
        String dynamicXPath = "//h3[contains(text(),'" + courseName + "')]/ancestor::div[contains(@class,'course-card')]";
        WebElement courseCard = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(dynamicXPath)));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", courseCard);
        courseCard.click();
        
        
    }

    // Course Detail Page Validations
    public boolean isCourseDetailPageDisplayed(String courseName) {
        return driver.getTitle().contains(courseName);
    }

    public boolean isHeaderVisible(String headerText) {
        return courseHeader.getText().contains(headerText);
    }

    public void scrollToSitejabberSection() {
        wait.until(ExpectedConditions.visibilityOf(sitejabberSection));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sitejabberSection);
    }

    public void clickSitejabberLink() {
        wait.until(ExpectedConditions.elementToBeClickable(sitejabberLink)).click();
    }

    public boolean isSitejabberPageDisplayed() {
        return driver.getCurrentUrl().contains("sitejabber");
    }
}