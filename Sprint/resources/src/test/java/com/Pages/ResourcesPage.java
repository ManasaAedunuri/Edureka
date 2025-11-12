package com.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.setUp.BaseSteps;

import java.time.Duration;

public class ResourcesPage extends BaseSteps{
  
    WebDriverWait wait;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/nav/div[4]/div[2]/button")
    WebElement resourcesMenu;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/nav/div[4]/div[2]/div/a[1]")//*[@id="__next"]/div/nav/div[4]/div[2]/div/a[1]//a[text()='Blog']
    WebElement blogLink;

    @FindBy(xpath = "/html/body/section[1]/div/div/div[1]/a")
    WebElement categoryLink;

    @FindBy(xpath = "//*[@id=\"category-course-blog-list-2\"]/section/div/div/div/div[1]/div/div[1]/a/h3")
    WebElement articleLink;

    public ResourcesPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

   

    public void clickResources() {
        resourcesMenu.click();
    }

    public void clickBlog() {
    	blogLink.click();
    }

    public void selectCategory(String category) {
    	categoryLink.click();
    }

    public void clickArticleByTitle(String title) {
    	articleLink.click();
    }
    
}
