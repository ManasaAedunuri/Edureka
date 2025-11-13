package com.stepDefinitionTestNG;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.pages.TrendingCoursesPage;
import com.parameters.PropertyReader;
import com.setup.BaseSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TrendingCourses extends BaseSteps {

    TrendingCoursesPage trendingPage;
    Properties prop = PropertyReader.readProperty();

    @Given("the user launches the Edureka application")
    public void the_user_launches_the_edureka_application() {
        BaseSteps.launchBrowser();
        trendingPage = new TrendingCoursesPage(driver);
    }

    @Then("the page title should be Instructor-Led Online Training with 24X7 Lifetime Support | Edureka")
    public void the_page_title_should_be_instructor_led_online_training_with_24x7_lifetime_support_edureka() {
        String expectedTitle = "Instructor-Led Online Training with 24X7 Lifetime Support | Edureka";
        String actualTitle = driver.getTitle();
        System.out.println("Actual Page Title: " + actualTitle);

        Assert.assertNotNull(actualTitle, "Page title is null.");
        Assert.assertFalse(actualTitle.trim().isEmpty(), "Page title is empty.");
        Assert.assertEquals(actualTitle.trim(), expectedTitle.trim(), "Page title mismatch.");
    }
    
    
   
}
    
