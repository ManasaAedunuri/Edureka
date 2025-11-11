package com.stepDefinitionTestNG;

import com.pages.CareersPage;
import com.parameters.PropertyReader;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Careers {
	
	CareersPage careersPage = new CareersPage();
	
	@Given("I Launch the Edureka website")
	public void i_launch_the_edureka_website() {
		Hooks.driver.get(PropertyReader.getProperty("base.url"));
	}
	
	@When("I scroll to the footer")
	public  void i_scroll_to_the_footer() throws InterruptedException {
		 
	    careersPage.scrollToFooter();  

	}
//
	@When("I click on the target link")
	public void i_click_on_the_target_link() throws InterruptedException {
		careersPage.clickCareersLink();
	}

	@Then("I should be redirected to the target page")
	public void i_should_be_redirected_to_the_target_page() throws InterruptedException {
		careersPage.verifyJoinUsPage();
	}

	@When("I scroll down to sectionName2")
	public void i_scroll_down_to_section_name2() throws InterruptedException {
		careersPage.scrollToOpenPositions();
	}

	@When("I click on sectionName3 under Marketing")
	public void i_click_on_section_name3_under_marketing() throws InterruptedException {
		careersPage.clickInternshipLink();
        careersPage.switchToJobDescriptionTab();
	}

	
	@Then("a new tab should open with job description")
	public void a_new_tab_should_open_with_job_description() throws InterruptedException {
		careersPage.verifyJobDescriptionPage();

	}

	@And("I scroll down to verify job details")
	public void i_scroll_down_to_verify_job_details() throws InterruptedException   {
		careersPage.scrollToJobDetails();
	}
	
	
	
	
	
	
	
	
	@And("I click on blog")
	public void i_click_on_blog() throws InterruptedException {
		careersPage.clickBlog();
	    careersPage.switchToJobDescriptionTab();
	}

	@And("I click on ebook to get free ebooks in blog page")
	public void i_click_on_ebook_to_get_free_ebooks_in_blog_page() throws InterruptedException {
		careersPage.clickEbook();
	    careersPage.switchToJobDescriptionTab();
	}

	@And("I click on bookName in ebooks page")
	public void i_click_on_book_name_in_ebooks_page() throws InterruptedException {
		careersPage.clickAWSBook();
	}
	

	@Then("The Ebook is displayed")
	public void the_ebook_is_displayed() {
	    careersPage.verifyEbook();
	}
}
