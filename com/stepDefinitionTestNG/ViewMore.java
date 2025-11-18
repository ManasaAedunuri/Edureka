package com.stepDefinitionTestNG;

import java.util.List;

import com.pages.CourseAccessPage;
import com.pages.EnrollNowPage;
import com.pages.ViewMorePage;

import com.parameters.ExcelUtils;
import com.parameters.PropertyReader;
import com.setup.BaseSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ViewMore extends BaseSteps {
	EnrollNowPage EnrollNow;
	CourseAccessPage courseAccessPage;
	ViewMorePage viewMorePage=new ViewMorePage(driver);
	
	@Given("the user launches the Edureka application1")
	public void the_user_launches_the_edureka_application1() {
		BaseSteps.launchBrowser();
		viewMorePage.scrollToSection();
		
	}
	
	@When("the user clicks on View More button")
	public void the_user_clicks_on_view_more_button() {
		viewMorePage.clickViewMore();
		////*[@id="__next"]/div/div[3]/div/div[1]/div/div/div/div[2] view more xpath
	}

	@When("click on Get Sample Certificate button")
	public void click_on_get_sample_certificate_button(){
		
	}

	
		
	
	@When("the user enters Name and Email Id and Phone Number {int}")
	public void the_user_enters_name_and_email_id_and_phone_number(Integer rowIndex) {
		 String excelPath = PropertyReader.get("excel_path_1");
	    List<String[]> users = ExcelUtils.readExcelData(excelPath);
	    ViewMorePage viewMorePage = new ViewMorePage(driver); // Page Object with form fields
	 
	    for (String[] user : users) {
	        String name = user[0];
	        String email = user[1];
	        String phone = user[2];
	 
	        viewMorePage.fillScholarshipForm(name, email, phone);
	        // Optionally click submit or validate results
	    }
	 
	    //driver.quit();
	    
	}
	

	@When("click on get certificate now button")
	public void click_on_get_certificate_now_button() {
		viewMorePage.clickGetCertificateNow();
	}


	@Then("Thanks card should display")
	public void thanks_card_should_display() {
		
		driver.quit();
	   
	}

}
