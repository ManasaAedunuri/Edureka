package com.stepDefinitionTestNG;

import org.testng.Assert;

import com.pages.CourseAccessPage;
import com.pages.ReviewsPage;
import com.parameters.PropertyReader;
import com.setup.BaseSteps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Reviews extends BaseSteps {
	CourseAccessPage courseAccessPage;
	boolean isVisible;

	@When("the user scrolls down to the Sitejabber Reviews section")
	public void the_user_scrolls_down_to_the_sitejabber_reviews_section() {
		CourseAccessPage courseAccessPage=new CourseAccessPage(driver);
		courseAccessPage.clickOnCourseCard();
	}

	@When("the user clicks on the Sitejabber Reviews link")
	public void the_user_clicks_on_the_sitejabber_reviews_link() {
	   ReviewsPage reviewsPage=new ReviewsPage(driver);
	   reviewsPage.clickReviews();
	}

	@Then("the Sitejabber Reviews page should be displayed")
	public void the_sitejabber_reviews_page_should_be_displayed() {
		
		try {
			
			isVisible = ReviewsPage.isReviewVisible(PropertyReader.get("ReviewText"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     Assert.assertTrue(isVisible, "Confirmation section not visible");
   driver.quit();
	}


}
