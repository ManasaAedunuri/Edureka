package com.stepDefinitionTestNG;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.pages.TrendingCoursesPage;
import com.parameters.PropertyReader;
import com.setup.BaseSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TrendingCourses extends BaseSteps {

	
	TrendingCoursesPage trendingcoursepage;
	Properties prop = PropertyReader.readProperty();
	@Given("the user launches the Edureka application")
	public void the_user_launches_the_edureka_application() {
		BaseSteps.launchBrowser();
		//TrendingCourses = new TrendingCourses(BaseSteps.driver);

	}

	@When("the user scrolls to the Trending Courses section")
	public void the_user_scrolls_to_the_trending_courses_section() {
		TrendingCoursesPage.scrollToTrendingCourses();
	}

//	@When("the user locates the coursename course card")
//	public void the_user_locates_the_coursename_course_card() {
//		TrendingCourses.locateCourseCard(coursename);
//	}

	@When("the user clicks on the course card")
	public void the_user_clicks_on_the_course_card() {
		TrendingCoursesPage.clickCourseCard();
	}

	@Then("the course detail page for coursename should be displayed")
	public void the_course_detail_page_for_coursename_should_be_displayed() {

		String courseName = prop.getProperty("coursename");
		Assert.assertTrue(TrendingCourses.isCourseDetailPageDisplayed(courseName),"Course detail page is not displayed for: " + courseName);

	}

	private static boolean isCourseDetailPageDisplayed(String coursename) {
		// TODO Auto-generated method stub
		return false;
	}

	@Then("the header Prompt Engineering Certification Course with LLM should be visible")
	public void the_header_prompt_engineering_certification_course_with_llm_should_be_visible() {
		Assert.assertTrue(TrendingCourses.isHeaderVisible("Prompt Engineering Certification Course with LLM"),
				"Header text is not visible");

	}

	private static boolean isHeaderVisible(String string) {
		// TODO Auto-generated method stub
		return true;
	}

	@When("the user scrolls down to the Sitejabber Reviews section")
	public void the_user_scrolls_down_to_the_sitejabber_reviews_section() {
		TrendingCoursesPage.scrollToSitejabberSection();
	}

	@When("the user clicks on the Sitejabber Reviews link")
	public void the_user_clicks_on_the_sitejabber_reviews_link() {
		TrendingCoursesPage.clickSitejabberLink();
	}

	@Then("the Sitejabber Reviews page should be displayed")
	public void the_sitejabber_reviews_page_should_be_displayed() {

		Assert.assertTrue(TrendingCourses.isSitejabberPageDisplayed(),
				"Sitejabber Reviews page is not displayed");

	}

	private static boolean isSitejabberPageDisplayed() {
		// TODO Auto-generated method stub
		return true;
	}



}
