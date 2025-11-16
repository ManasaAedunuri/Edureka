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
	//WebDriver driver = Hooks.driver;
	//WebDriver driver = Hooks.driver;
	
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
		//viewMorePage.clickSampleCertificate1();
	}

	
		/*@When("the user enters Name and Email Id and Phone Number from Excel row {int}")
		public void the_user_enters_name_and_email_id_and_phone_number_from_excel_row(Integer rowIndex) {
		    // Load the Excel file
		    ExcelReader1.loadExcel("excel_path_1");

		    // Read data from Sheet0, rowIndex
		    Map<String, String> userData = ExcelReader1.getRowDataWithHeaders("Sheet1", rowIndex);

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
	public void the_user_enters_name_and_email_id_and_phone_number(Integer rowIndex) {
//		ExcelReader1 excelReader1 = new ExcelReader1();
//	
//	    String excelPath = PropertyReader.get("excel_path_1");
	    

//	    String name = ExcelReader1.getName(excelPath, 0);
//	    
//	    String email = ExcelReader1.getEmail(excelPath, 1);
//	    String phone = ExcelReader1.getPhone(excelPath, 2);
//
//	    System.out.println("Name: " + name);
//	    System.out.println("Email: " + email);
//	    System.out.println("Phone: " + phone);
//
//		viewMorePage.enterUserDetails(name, email, phone);
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
	
	
	

	/*@When("the user enters Name and Email Id and Phone Number {int}")
	public void the_user_enters_name_and_email_id_and_phone_number(Integer int1) {
		String excelPath = PropertyReader.get("excel_path_1");
		
		String name = ExcelReader1.getLocalityByRow0(excelPath, 0, int1);
		// Email from column A
		String email = ExcelReader1.getLocalityByRow1(excelPath, 0, int1);

		// Phone from column B
		String phone = ExcelReader1.getLocalityByRow2(excelPath, 0, int1);

		ViewMorePage.enterName(name);
		ViewMorePage.enterEmail(email);
		ViewMorePage.enterPhone(phone);
	}*/
	
	/*@When("the user enters Name and Email Id and Phone Number {int}")
	public void the_user_enters_name_and_email_id_and_phone_number(Integer rowIndex) {
	    String excelPath = PropertyReader.get("excel_path_1");
	    String name = ExcelReader1.getLocalityByRow0(excelPath, 0, rowIndex);
	    String email = ExcelReader1.getLocalityByRow1(excelPath, 0, rowIndex);
	    String phone = ExcelReader1.getLocalityByRow2(excelPath, 0, rowIndex);

	    viewMorePage.enterUserDetails(name, email, phone);
	}*/

	@When("click on get certificate now button")
	public void click_on_get_certificate_now_button() {
		viewMorePage.clickGetCertificateNow();
	}


	@Then("Thanks card should display")
	public void thanks_card_should_display() {
		
		driver.quit();
	   
	}


	/*@When("the user enters email and phone number row {int}")
	public void the_user_enters_email_and_phone_number_row(Integer int1) {
String excelPath = PropertyReader.get("excel_path");

// Email from column A
String email = ExcelReader.getLocalityByRow(excelPath, 0, int1);

// Phone from column B
String phone = ExcelReader.getLocalityByRow1(excelPath, 0, int1);

enrollNowPage.enterEmail(email);
enrollNowPage.enterPhoneNumber(phone);

	}
	@When("clicks on the Enroll Now button in the form")
	public void clicks_on_the_enroll_now_button_in_the_form() {
		enrollNowPage.submitEnrollmentForm();
	
	}
	
	@When("the user should be redirected to the payment page")
    public void the_user_should_be_redirected_to_the_payment_page() {
		enrollNowPage.submitEnrollmentForm();
		enrollNowPage.isOnPaymentPage();
	}
	
	@Then("the payment page should display the text Order Summary")
    public void the_payment_page_should_display_the_text_Order_Summary() {
		enrollNowPage.isOrderSummaryVisible();
		driver.quit();
	}*/


}
