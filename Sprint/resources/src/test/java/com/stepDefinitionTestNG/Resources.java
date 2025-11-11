package com.stepDefinitionTestNG;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.Pages.ResourcesPage;
import com.Parameters.PropertyReader;
import com.setUp.BaseSteps;

import io.cucumber.java.en.*;

public class Resources {

    WebDriver driver;
    ResourcesPage resourcesPage;

    @Given("the user opens the browser")
    public void the_user_opens_the_browser() {
        BaseSteps.launchBrowser();
        driver = BaseSteps.driver;
    }

    @When("the user navigates to the homepage")
    public void the_user_navigates_to_the_homepage() {
        driver.get(PropertyReader.get("homepage"));
        resourcesPage = new ResourcesPage(driver);
    }

    @When("the user clicks on the menu")
    public void the_user_clicks_on_the_menu() {
        resourcesPage.clickResources();
    }

    @When("the user clicks on the subMenu")
    public void the_user_clicks_on_the_sub_menu() {
        resourcesPage.clickBlog();
    }

    @When("the user selects the category")
    public void the_user_selects_the_category() {
        resourcesPage.selectCategory(PropertyReader.get("category"));
    }

    @When("the user clicks on the article")
    public void the_user_clicks_on_the_article() {
        resourcesPage.clickArticleByTitle(PropertyReader.get("article"));
    }

    @Then("the article page should be displayed")
    public void the_article_page_should_be_displayed() {
        String expectedTitle = PropertyReader.get("article");
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle),
            "Expected title to contain: " + expectedTitle + " but got: " + actualTitle);
        driver.quit();
    }
}