package com.stepDefinitionTestNG;

import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.pages.AskAQuestionPage;
import com.pages.CommunityPage;
import com.pages.ResourcesPage;
import com.parameters.PropertyReader;
import com.setup.BaseSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AskAQuestion extends BaseSteps {
	AskAQuestionPage askAQuestionPage;
	ExtentTest test=Hooks.test;

	@Given("the user launches the browser with the URL from the properties file")
	public void the_user_launches_the_browser_with_the_url_from_the_properties_file() {
		 BaseSteps.launchBrowser();
		    driver = BaseSteps.driver;
	}

	@When("the user clicks on the menu from Properies file")
	public void the_user_clicks_on_the_menu_from_properies_file() {
		ResourcesPage resourcesPage = new ResourcesPage(driver,test);
		 resourcesPage.clickResources();
	}

	@When("the user clicks on the submenu from Properties file")
	public void the_user_clicks_on_the_submenu_from_properties_file() {
		CommunityPage communityPage=new CommunityPage(driver,test);
	     communityPage.clickSubMenu();
	}

	@When("the user clicks on the ask a question button using the ID from the properties file")
	public void the_user_clicks_on_the_ask_a_question_button_using_the_id_from_the_properties_file() {
	 askAQuestionPage=new AskAQuestionPage(driver,test);
	   askAQuestionPage.clickonAsk();
	}

	@Then("the user should see the header text on the Ask a Question page matches the expected value from the properties file")
	public void the_user_should_see_the_header_text_on_the_ask_a_question_page_matches_the_expected_value_from_the_properties_file() {
		boolean isVisible = askAQuestionPage.isTextVisible(PropertyReader.get("TextValue"));
        Assert.assertTrue(isVisible, "Confirmation section not visible");
       

	}


}
