package com.stepDefinitionTestNG;

import org.testng.Assert;

import com.pages.WebinarPage;
import com.parameters.PropertyReader;
import com.aventstack.extentreports.ExtentTest;
import com.setup.BaseSteps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class webinar extends BaseSteps 
{
	WebinarPage webinarPage;
	ExtentTest test=Hooks.test;
	
	@When("the user navigates to the homepage from configuration")
	public void the_user_navigates_to_the_homepage_from_configuration()
	{
		 //driver.get(PropertyReader.get("homepage"));
	        webinarPage = new WebinarPage(driver, test);

	    
	}

	@When("the user clicks on the menu from configuration")
	public void the_user_clicks_on_the_menu_from_configuration() {
		webinarPage.clickMenu(); 
	}

	@When("the user clicks on the submenu from configuration")
	public void the_user_clicks_on_the_submenu_from_configuration() {
		webinarPage.clickSubMenu();

	}

	@When("the user searches for the keyword from configuration")
	public void the_user_searches_for_the_keyword_from_configuration() {
		 webinarPage.searchKeyword(PropertyReader.get("searchKeyword"));

	}

	

	@Then("the user should see the confirmation section from configuration")
	public void the_user_should_see_the_confirmation_section_from_configuration() {
		boolean isVisible = webinarPage.isConfirmationVisible(PropertyReader.get("confirmationSection"));
        Assert.assertTrue(isVisible, "Confirmation section not visible");
       

	}

}