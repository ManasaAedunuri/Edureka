package com.stepDefinitionTestNG;

import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.pages.CourseAccessPage;
import com.parameters.PropertyReader;
import com.setup.BaseSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CourseAccess extends BaseSteps {
	ExtentTest test=Hooks.test;
	CourseAccessPage courseAccessPage=new CourseAccessPage(driver,test);
	PropertyReader propertyReader;
	
	@Given("the user scrolls to the Trending Courses section")
	public void the_user_scrolls_to_the_trending_courses_section() {

		courseAccessPage.clickOnCourseCard();

	}
	@When("the user clicks on the page for LLM Prompt Engineering Certification Course")
	public void the_user_clicks_on_the_page_for_llm_prompt_engineering_certification_course() {
		
		
		courseAccessPage.clickOnCourseCard();

	}
	@Then("the  LLM Prompt Engineering Certification Course Header should be displyed")
	public void the_llm_prompt_engineering_certification_course_header_should_be_displyed() {
		boolean isVisible = CourseAccessPage.getCourseTitle(PropertyReader.get("llm_course_name"));
        Assert.assertTrue(isVisible, "Confirmation section visible");
        driver.close();
	}		 

}
