package com.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.setup.BaseSteps;

public class HomePage extends BaseSteps {

    @FindBy(xpath = "//h2[text()='Discover Top Categories']")
    private WebElement discoverTopCategoriesSection;

    public HomePage(WebDriver driver) {
        super();
        PageFactory.initElements(driver, this);
    }

    public void scrollToDiscoverTopCategories() {
        CategoryPage.scrollToElement(discoverTopCategoriesSection); // from BasePage
    }

    public void clickCategory(String categoryName) {
        CategoryPage.safeClick(By.xpath("//a[label[text()='" + categoryName + "']]"));
    }
}
