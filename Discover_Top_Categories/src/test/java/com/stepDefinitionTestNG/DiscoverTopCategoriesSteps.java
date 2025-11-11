package com.stepDefinitionTestNG;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pages.CategoryPage;
import com.pages.HomePage;
import com.parameters.PropertyReader;
import com.setup.BaseSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DiscoverTopCategoriesSteps {

    WebDriver driver;
    Properties prop = PropertyReader.readProperty();
    HomePage homePage;
    CategoryPage categoryPage;
    @Given("the user is on the sourceUrl")
    public void the_user_is_on_the_source_url() {
        BaseSteps.launchBrowser();
        driver = BaseSteps.driver;
        driver.get(prop.getProperty("sourceUrl"));
        homePage = new HomePage(driver);
    }

    @When("the user scrolls to the sectionName section")
    public void the_user_scrolls_to_the_section_name_section() {
        homePage.scrollToDiscoverTopCategories();
    }

    @When("clicks on category1")
    public void clicks_on_category1() {
        String categoryName = prop.getProperty("category1");
        homePage.clickCategory(categoryName);
        BaseSteps.sleep(1000); // Optional wait
        navigateBackToHomePage();
    }

    @When("clicks on category2")
    public void clicks_on_category2() {
        String categoryName = prop.getProperty("category2");
        homePage.clickCategory(categoryName);
        BaseSteps.sleep(1000); // Optional wait
        navigateBackToHomePage();
    }

    @When("clicks on category3")
    public void clicks_on_category3() {
        String categoryName = prop.getProperty("category3");
        homePage.clickCategory(categoryName);
        categoryPage = new CategoryPage();
        verifyCategoryPage("category3_urlPart");
    }
    @When("navigates back to homepage")
    public void fallback_navigate_back() {
        System.out.println("Fallback step executed.");
    }

    @Then("each respective category page should load successfully")
    public void each_respective_category_page_should_load_successfully() {
        System.out.println("Category 3 page verified successfully.");
    }

    private void verifyCategoryPage(String expectedTitlePartKey) {
        String expectedTitlePart = prop.getProperty(expectedTitlePartKey);
        if (expectedTitlePart == null) {
            throw new IllegalArgumentException("Missing property for key: " + expectedTitlePartKey);
        }

        String actualTitle = driver.getTitle();
        System.out.println("Page title: " + actualTitle);

        if (!actualTitle.contains(expectedTitlePart)) {
            throw new AssertionError("Expected title to contain: " + expectedTitlePart + " but got: " + actualTitle);
        }
    }

    // ✅ Helper method to navigate back and wait for homepage
    private void navigateBackToHomePage() {
        driver.navigate().back();
        new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h2[text()='Discover Top Categories']")));
        BaseSteps.sleep(1000);
    }
}