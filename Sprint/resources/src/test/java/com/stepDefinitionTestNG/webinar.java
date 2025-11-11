package com.stepDefinitionTestNG;

import org.testng.Assert;

import com.Pages.WebinarPage;
import com.Parameters.PropertyReader;
import com.setUp.BaseSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class webinar extends BaseSteps 
{
	WebinarPage webinarPage;
	
	@When("the user navigates to the homepage from configuration")
	public void the_user_navigates_to_the_homepage_from_configuration()
	{
		 driver.get(PropertyReader.get("homepage"));
	        webinarPage = new WebinarPage(driver);

	    
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

	@When("the user selects the webinar title from configuration")
	public void the_user_selects_the_webinar_title_from_configuration() {
		webinarPage.selectWebinar(PropertyReader.get("webinarTitle"));
    

	}

	@When("the user scrolls and clicks on the register button from configuration")
	public void the_user_scrolls_and_clicks_on_the_register_button_from_configuration() {
		 webinarPage.clickRegister(PropertyReader.get("registerButton"));
    }

	

	@Then("the user should see the confirmation section from configuration")
	public void the_user_should_see_the_confirmation_section_from_configuration() {
		boolean isVisible = webinarPage.isConfirmationVisible(PropertyReader.get("confirmationSection"));
        Assert.assertTrue(isVisible, "Confirmation section not visible");
        driver.quit();

	}

}
