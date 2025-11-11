package com.stepDefinitionTestNG;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pages.SearchCoursePage;
import com.parameters.PropertyReader;
import com.setup.BaseSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Search extends BaseSteps {


	SearchCoursePage searchPage;
	Properties prop = PropertyReader.readProperty();

	// Scenario 1:
	@Given("The browser is launched and the Edureka homepage is opened")
	public void the_browser_is_launched_and_the_edureka_homepage_is_opened() {
		BaseSteps.launchBrowser();
		searchPage = new SearchCoursePage(driver);
	}
	@When("I click on the Search course bar")
	public void i_click_on_the_search_course_bar() {
		searchPage.clickSearchBar();
	}
	@When("I enter a Big Data in the search input field")
	public void i_enter_a_big_data_in_the_search_input_field() {
		String courseName = prop.getProperty("validCourseName");
		searchPage.enterCourseName(courseName);
	}
	@Then("The search results page should be displayed")
	public void the_search_results_page_should_be_displayed() {
		searchPage.verifySearchResults();
	}
	@When("I click on Big Data Hadoop Certification Training Course from the search results")
	public void i_click_on_big_data_hadoop_certification_training_course_from_the_search_results() {
		String selectCourseName = prop.getProperty("selectCourseName1");
		searchPage.selectCourse(selectCourseName);
	}
	@Then("The course details page should be displayed")
	public void the_course_details_page_should_be_displayed() throws InterruptedException {
		searchPage.verifyCourseDetailsPage();
		BaseSteps.closeBrowser();
	}
	
	
	// Scenario 2
	@And("I click on aws technology")
	public void i_click_on_aws_technology() {
		String techName = prop.getProperty("tech1");
		searchPage.clickTechnology(techName);
	}

	@And("The user clicks on Job Role")
	public void the_user_clicks_on_job_role() {
		String filterOption = prop.getProperty("filterOption");
		searchPage.clickFilterOption(filterOption);
	}

	@And("Select filter from AWS page")
	public void select_filter_from_aws_page() {
		String filterValue = prop.getProperty("filter");
		searchPage.selectFilter(filterValue);
	}

	@Then("The page should display Cloud Devops courses")
	public void the_page_should_display_cloud_devops_courses() throws InterruptedException {
		searchPage.verifyCloudDevOpsCourses();
		BaseSteps.closeBrowser();
	}
	
}
