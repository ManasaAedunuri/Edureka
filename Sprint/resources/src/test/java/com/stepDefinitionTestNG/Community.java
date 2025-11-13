package com.stepDefinitionTestNG;

import org.openqa.selenium.WebDriver;
import com.Pages.CommunityPage;
import com.Pages.ResourcesPage;
import com.Parameters.ExcelReader;
import com.Parameters.PropertyReader;
import com.setUp.BaseSteps;
import io.cucumber.java.en.*;

public class Community {

	WebDriver driver;
	String communityName;
	ResourcesPage resourcesPage;
	CommunityPage communityPage;

	@When("the user navigates to the homepage from Property file with row {int}")
	public void the_user_navigates_to_the_homepage_from_excel(int rowIndex) {
	    String excelPath = PropertyReader.get("excel_path");
	    communityName = ExcelReader.getLocalityByRow(excelPath, 0, rowIndex);

	    BaseSteps.launchBrowser();
	    driver = BaseSteps.driver;
	    driver.get(PropertyReader.get("homepage"));
	}


	@When("the user clicks on the menu from Property file")
	public void the_user_clicks_on_the_menu_from_Property_file() {
		 communityPage.clickResource();
	}

	@When("the user clicks on the submenu from Property file")
	public void the_user_clicks_on_the_submenu_from_Property_file() {
	     communityPage.clickSubMenu();
	}

	@When("the user searches for the community from Excel")
	public void the_user_searches_for_the_community_from_excel() {
		communityPage.searchCommunity(communityName);

	}

	@Then("the user should be able to view and join the community from Excel")
	public void the_user_should_be_able_to_view_and_join_the_community_from_excel() {
		communityPage.joinCommunity();
		driver.close();

	}
}








