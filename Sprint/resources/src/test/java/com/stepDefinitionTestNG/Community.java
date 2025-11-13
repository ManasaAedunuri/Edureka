package com.stepDefinitionTestNG;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.Pages.CommunityPage;
import com.Pages.ResourcesPage;
import com.Parameters.ExcelReader;
import com.Parameters.PropertyReader;
import com.setUp.BaseSteps;
import io.cucumber.java.en.*;

public class Community {

	WebDriver driver;
	String communityName;
	
	CommunityPage communityPage;
	 

	@When("the user navigates to the homepage from Property file with row {int}")
	public void the_user_navigates_to_the_homepage_from_excel(int rowIndex) {
//		Properties prop = PropertyReader.readProperty();
//	    String excelPath = prop.getProperty("excel_Path");
//
//	    communityName = ExcelReader.getLocalityByRow(excelPath, 0, rowIndex);
//	    System.out.println("Community name: " + communityName);
//
//	    BaseSteps.launchBrowser();
//	    driver = BaseSteps.driver;
//	    driver.get(prop.getProperty("homepage"));
		Properties prop = PropertyReader.readProperty();

	    // ✅ Now safely get the Excel path
	    String excelPath = prop.getProperty("excel_path");
	    System.out.println("Excel path: " + excelPath); // Debug

	    // ✅ Defensive check
	    if (excelPath == null || excelPath.isEmpty()) {
	        throw new RuntimeException("Excel path is missing in properties file");
	    }

	    // ✅ Read from Excel
	    communityName = ExcelReader.getLocalityByRow(excelPath, 0, rowIndex);
	    System.out.println("Community name: " + communityName); // Debug

	    BaseSteps.launchBrowser();
	    driver = BaseSteps.driver;
//	    driver.get(prop.getProperty("homepage"));

	}



	@When("the user clicks on the menu from Property file")
	public void the_user_clicks_on_the_menu_from_Property_file() {
		ResourcesPage resourcesPage = new ResourcesPage(driver);
		 resourcesPage.clickResources();
	}

	@When("the user clicks on the submenu from Property file")
	public void the_user_clicks_on_the_submenu_from_Property_file() {
		communityPage=new CommunityPage(driver);
	     communityPage.clickSubMenu();
	}

	@When("the user searches for the community from Excel")
	public void the_user_searches_for_the_community_from_excel() {
		communityPage=new CommunityPage(driver);
		communityPage.searchCommunity(communityName);

	}

	@Then("the user should be able to view and join the community from Excel")
	public void the_user_should_be_able_to_view_and_join_the_community_from_excel() {
//		communityPage=new CommunityPage(driver);
//		communityPage.isCommunityVisible(communityName);
//		driver.close();
		boolean isVisible = communityPage.isCommunityVisible(PropertyReader.get("communityText"));
        Assert.assertTrue(isVisible, "Confirmation section not visible");
        driver.quit();

	}
}








