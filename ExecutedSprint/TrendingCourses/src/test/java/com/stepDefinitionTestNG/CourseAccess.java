package com.stepDefinitionTestNG;

import org.testng.Assert;

import com.pages.CourseAccessPage;
import com.parameters.PropertyReader;
import com.setup.BaseSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CourseAccess extends BaseSteps {
	CourseAccessPage courseAccessPage=new CourseAccessPage(driver);
	PropertyReader propertyReader;
	@Given("the user scrolls to the Trending Courses section")
	public void the_user_scrolls_to_the_trending_courses_section() {
//		 try {
//			 CourseAccessPage courseAccessPage = new CourseAccessPage(driver);
//		        String trendingSectionXpath = PropertyReader.get("trending_section_xpath");
//		      //  courseAccessPage.scrollToSection(trendingSectionXpath);
//		        
//
//		    } catch (Exception e) {
//		        throw new AssertionError("Failed to scroll to Trending Courses section: " + e.getMessage());
//		    }
		courseAccessPage.clickOnCourseCard();

	}
	@When("the user clicks on the page for LLM Prompt Engineering Certification Course")
	public void the_user_clicks_on_the_page_for_llm_prompt_engineering_certification_course() {
		/*try {
			 CourseAccessPage  courseAccessPage = new  CourseAccessPage(driver);
	        String courseCardXpath = PropertyReader.get("llm_course_card_xpath");
	        courseAccessPage.clickOnCourseCard(courseCardXpath);
	    } catch (Exception e) {
	        throw new AssertionError("Failed to click on LLM Prompt Engineering course card: " + e.getMessage());
	    }*/
		
		courseAccessPage.clickOnCourseCard();
		//Assert.assertTrue(status, "clicked");

	}
	@Then("the  LLM Prompt Engineering Certification Course Header should be displyed")
	public void the_llm_prompt_engineering_certification_course_header_should_be_displyed() {
		boolean isVisible = CourseAccessPage.getCourseTitle(PropertyReader.get("llm_course_name"));
        Assert.assertTrue(isVisible, "Confirmation section visible");
        driver.close();
	}
//		 try {
//			 CourseAccessPage courseAccessPage = new CourseAccessPage(driver);
//		        String courseName = PropertyReader.get("llm_course_name");
//		        WebElement courseTitle = courseAccessPage.getCourseTitle(courseName);
//		        Assert.assertTrue(courseTitle.isDisplayed(), "Course page for '" + courseName + "' is not visible.");
//		    } catch (Exception e) {
//		        throw new AssertionError("Failed to verify course page visibility: " + e.getMessage());
//		    }
//
//	}

}
