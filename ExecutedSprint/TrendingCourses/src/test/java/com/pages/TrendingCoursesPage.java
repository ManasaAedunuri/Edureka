package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrendingCoursesPage {

    private WebDriver driver;

    // Constructor
    public TrendingCoursesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Locator for Trending Courses section
    @FindBy(xpath = "//h2[text()='Trending Courses']")
    private WebElement trendingCoursesSection;

    // Method to check if Trending Courses section is visible
    public boolean isTrendingCoursesSectionVisible() {
        try {
            return trendingCoursesSection.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}