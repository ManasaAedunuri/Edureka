package com.stepDefinitionTestNG;

import org.openqa.selenium.WebDriver;

import com.pages.CourseAccessPage;
import com.pages.EnrollNowPage;
import com.setup.BaseSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EnrollNow extends BaseSteps {
	CourseAccessPage courseAccessPage;

	WebDriver driver = Hooks.driver;
	EnrollNowPage enrollNowPage = new EnrollNowPage(driver);
	String enrollnowData;
	int rowIndex = 0;

	@Given("the user launches the application as Edureka")
	public void the_user_launches_the_application_as_edureka() {
		BaseSteps.launchBrowser();
		courseAccessPage=new CourseAccessPage(driver);
		enrollNowPage.scrollToTrendingCourses();
		courseAccessPage.scrollToSection();
		courseAccessPage.clickOnCourseCard();
	}
	@When("the user clicks on the Enroll Now button")
	public void the_user_clicks_on_the_enroll_now_button() {
		
	}

	@When("the user enters email and phone number row {int}")
	public void the_user_enters_email_and_phone_number_row(Integer int1){ 

	}
	@When("clicks on the Enroll Now button in the form")
	public void clicks_on_the_enroll_now_button_in_the_form() {

	}
	@When("the user should be redirected to the payment page")
	public void the_user_should_be_redirected_to_the_payment_page() {

	}
	@Then("the payment page should display the text Order Summary")
	public void the_payment_page_should_display_the_text_order_summary() {

	}


	//    @Given("the user launches the Edureka application")
	//    public void the_user_launches_the_edureka_application() {
	////    	Properties prop = PropertyReader.readProperty();
	////    	 
	////	    // ✅ Now safely get the Excel path
	////	    String excelPath = prop.getProperty("excel_path");
	////	    System.out.println("Excel path: " + excelPath); // Debug
	//// 
	////	    // ✅ Defensive check
	////	    if (excelPath == null || excelPath.isEmpty()) {
	////	        throw new RuntimeException("Excel path is missing in properties file");
	////	    }
	//// 
	////	    // ✅ Read from Excel
	////	    enrollnowData = ExcelReader.getLocalityByRow(excelPath, 0, rowIndex);
	////	    System.out.println("Community name: " + enrollnowData); // Debug
	//// 
	////	    BaseSteps.launchBrowser();
	////	    driver = BaseSteps.driver;
	////	    //driver.get(prop.getProperty("homepage"));
	////        BaseSteps.launchBrowser();
	////        enrollNowPage = new EnrollNowPage(driver);
	////        enrollNowPage.clickEnrollButton();
	////        enrollNowPage.enterEmail(email);
	////        enrollNowPage.enterPhoneNumber(phone);
	////        enrollNowPage.submitEnrollmentForm();
	////        Assert.assertTrue(enrollNowPage.isOnPaymentPage(), "User is not on the payment page");
	//    	String excelPath = "src/test/resources/EnrollData.xlsx";
	//
	//        // Load Excel file once
	//        ExcelReader.loadExcel(excelPath);
	//
	//        // Read email and phone from the same row
	//        String email = ExcelReader.getCellData("Sheet1", rowIndex, 0); // Column 0 = email
	//        String phone = ExcelReader.getCellData("Sheet1", rowIndex, 1); // Column 1 = phone
	//
	//        System.out.println("Email: " + email);
	//        System.out.println("Phone: " + phone);
	//
	//        enrollNowPage.enterEmail(email);
	//        enrollNowPage.enterPhoneNumber(phone);
	//
	//    }
	////    WebDriver driver = DriverFactory.getDriver();
	////    EnrollPage enrollPage = new EnrollPage(driver);
	//
	////    @When("the user clicks on the Enroll Now button")
	////    public void the_user_clicks_on_the_enroll_now_button() {
	////        enrollNowPage.clickEnrollButton();
	////    }
	//
	////    @Then("the enrollment form should appear")
	////    public void the_enrollment_form_should_appear() {
	////        Assert.assertTrue(enrollNowPage.isEnrollmentFormVisible(), "Enrollment form is not visible");
	////    }
	//
	////    @When("the user enters email {string} and phone number {string}")
	////    public void the_user_enters_email_and_phone_number(String email, String phone) {
	////        enrollNowPage.enterEmail(email);
	////        enrollNowPage.enterPhoneNumber(phone);
	////    }
	//
	////    @When("clicks on the Enroll Now button in the form")
	////    public void clicks_on_the_enroll_now_button_in_the_form() {
	////        enrollNowPage.submitEnrollmentForm();
	////    }
	//    
	////   @When("the user should be redirected to the payment page")
	////    public void the_user_should_be_redirected_to_the_payment_page() {
	////       Assert.assertTrue(enrollNowPage.isOnPaymentPage(), "User is not on the payment page");
	////    }
	//
	//    @Then("the payment page should display the text {string}")
	//    public void the_payment_page_should_display_the_text(String expectedText) {
	//        boolean actualText = enrollNowPage.isOrderSummaryVisible();
	//        System.out.println("orderSummaryText is Visible True/False: " +actualText);
	//       // Assert.assertTrue(actualText.contains(expectedText), "Expected text '" + expectedText + "' not found. Actual: " + actualText);
	//    }
	}