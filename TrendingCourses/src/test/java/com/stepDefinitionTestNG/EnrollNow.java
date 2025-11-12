package com.stepDefinitionTestNG;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.pages.CourseAccessPage;
import com.pages.EnrollNowPage;
import com.pages.TrendingCoursesPage;
import com.parameters.PropertyReader;
import com.setup.BaseSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EnrollNow {
	public static WebDriver driver;
	public static Object prop;
	EnrollNowPage enrollNowPage;
	CourseAccessPage courseAccessPage;
	TrendingCoursesPage trendingPage;
    Properties prop1 = PropertyReader.readProperty();

    
	@Given("the user scrolls to the Trending Courses section")
	public void the_user_scrolls_to_the_trending_courses_section() throws IOException {
		
		courseAccessPage.clickOnCourseCard();
	}
	
	@When("the user clicks on the page for LLM Prompt Engineering Certification Course")
	public void the_user_clicks_on_the_page_for_llm_prompt_engineering_certification_course() {
		//boolean status = courseAccessPage.clickOnCourseCard();
		System.out.println("dbcjkhc");
		//Assert.assertTrue(status, "not clicked");
	}
	
	
	@Then("the LLM Prompt Engineering Certification Course page should be displayed")
	public void the_llm_prompt_engineering_certification_course_page_should_be_displayed() {
	   
		System.out.println("dbcjkhc");
		
	   	}

	@Then("the user clicks on the Enroll Now button")
	public void the_user_clicks_on_the_enroll_now_button() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("dbcjkhc");
	    throw new io.cucumber.java.PendingException();
	}

	@Then("the enrollment form should appear")
	public void the_enrollment_form_should_appear() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("dbcjkhc");
	    throw new io.cucumber.java.PendingException();
	}

	@When("the user enters email {string} and phone number {string}")
	public void the_user_enters_email_and_phone_number(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("dbcjkhc");
	    throw new io.cucumber.java.PendingException();
	}

	@When("clicks on the Enroll Now button in the form")
	public void clicks_on_the_enroll_now_button_in_the_form() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("dbcjkhc");
	    throw new io.cucumber.java.PendingException();
	}

	@When("the user should be redirected to the payment page")
	public void the_user_should_be_redirected_to_the_payment_page() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("dbcjkhc");
	    throw new io.cucumber.java.PendingException();
	}

	@Then("the payment page should display the text {string}")
	public void the_payment_page_should_display_the_text(String string) {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("dbcjkhc");
	    throw new io.cucumber.java.PendingException();
	}


}
