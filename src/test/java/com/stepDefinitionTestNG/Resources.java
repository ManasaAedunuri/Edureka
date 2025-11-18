package com.stepDefinitionTestNG;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.pages.ResourcesPage;
import com.parameters.PropertyReader;
import com.setup.BaseSteps;

import io.cucumber.java.en.*;

public class Resources extends BaseSteps{

   ExtentTest extenttest=Hooks.test;
    ResourcesPage resourcesPage;

    @Given("the user opens the browser")
    public void the_user_opens_the_browser() {
        
        driver = BaseSteps.driver;
    }

    @When("the user navigates to the homepage")
    public void the_user_navigates_to_the_homepage() {
        driver.get(PropertyReader.get("homepage"));
        resourcesPage = new ResourcesPage(driver,extenttest);
    }

    @When("the user clicks on the menu")
    public void the_user_clicks_on_the_menu() {
    	resourcesPage=new ResourcesPage(driver,extenttest);
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
       
    }

}