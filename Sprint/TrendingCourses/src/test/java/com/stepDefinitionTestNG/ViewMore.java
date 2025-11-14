package com.stepDefinitionTestNG;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.pages.CourseAccessPage;
import com.pages.EnrollNowPage;
import com.pages.ViewMorePage;
import com.parameters.ExcelReader;
import com.setup.BaseSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ViewMore extends BaseSteps {
	EnrollNowPage EnrollNow;
	CourseAccessPage courseAccessPage;
	ViewMorePage viewMorePage=new ViewMorePage(driver);
	//WebDriver driver = Hooks.driver;
	//WebDriver driver = Hooks.driver;
	
	@Given("the user launches the Edureka application1")
	public void the_user_launches_the_edureka_application1() {
		BaseSteps.launchBrowser();
		//viewMorePage.scrollToSection();
		
	}
	
	@When("the user clicks on View More button")
	public void the_user_clicks_on_view_more_button() {
		viewMorePage.clickViewMore();
	}

	@When("click on Get Sample Certificate button")
	public void click_on_get_sample_certificate_button(){
	    
	}

	
		/*@When("the user enters Name and Email Id and Phone Number from Excel row {int}")
		public void the_user_enters_name_and_email_id_and_phone_number_from_excel_row(Integer rowIndex) {
		    // Load the Excel file
		    ExcelReader.loadExcel("excel_path_1");

		    // Read data from Sheet0, rowIndex
		    Map<String, String> userData = ExcelReader.getRowDataWithHeaders("Sheet1", rowIndex);

		    // Extract values
		    String name = userData.get("Name");
		    String email = userData.get("Email");
		    String phone = userData.get("Phone");

		    // Pass values to page object
		   
		    ViewMorePage.enterName(name);
		    ViewMorePage.enterEmail(email);
		    ViewMorePage.enterPhone(phone);
		}*/
	
	
	
	

	@When("the user enters Name and Email Id and Phone Number {int}")
	public void the_user_enters_name_and_email_id_and_phone_number(Integer int1) {
	  
	}

	@When("click on get certificate now button")
	public void click_on_get_certificate_now_button() {
	    
	}


	@Then("Thanks card should display")
	public void thanks_card_should_display() {
		driver.quit();
	   
	}



}
