package com.stepDefinitionTestNG;

import java.util.Properties;

import org.testng.Assert;

import com.pages.TrendingCoursesPage;
import com.parameters.PropertyReader;
import com.setup.BaseSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class TrendingCourses extends BaseSteps {

    TrendingCoursesPage trendingPage;
    Properties prop = PropertyReader.readProperty();

    @Given("the user launches the Edureka application")
    public void the_user_launches_the_edureka_application() {
        BaseSteps.launchBrowser(); // Initializes driver and opens URL
        trendingPage = new TrendingCoursesPage(driver); // Pass driver to Page Object
    }

    @Then("the page title should be Instructor-Led Online Training with 24X7 Lifetime Support | Edureka")
    public void the_page_title_should_be_instructor_led_online_training_with_24x7_lifetime_support_edureka() {
        String expectedTitle = "Instructor-Led Online Training with 24X7 Lifetime Support | Edureka";
        String actualTitle = driver.getTitle();
        System.out.println("Actual Page Title: " + actualTitle);
        Assert.assertEquals(actualTitle.trim(), expectedTitle.trim(), "Page title mismatch");
    }

//    @Then("verify Trending Courses section is displayed")
//    public void verify_trending_courses_section_is_displayed() {
//        boolean isDisplayed = trendingPage.isTrendingCoursesSectionVisible();
//        Assert.assertTrue(isDisplayed, "Trending Courses section is not visible on the page.");
//    }
}