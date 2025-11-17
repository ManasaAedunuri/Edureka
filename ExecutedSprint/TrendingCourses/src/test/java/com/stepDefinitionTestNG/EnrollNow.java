package com.stepDefinitionTestNG;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.pages.CourseAccessPage;
import com.pages.EnrollNowPage;
import com.pages.TrendingCoursesPage;
import com.parameters.ExcelReader;
import com.parameters.PropertyReader;
import com.setup.BaseSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EnrollNow extends BaseSteps{

	WebDriver driver;
	EnrollNowPage enrollNowPage;
	CourseAccessPage courseAccessPage;
	TrendingCoursesPage trendingPage;
	@Given("the user clicks on the Enroll Now button")
	public void the_user_clicks_on_the_enroll_now_button() {
		BaseSteps.launchBrowser(); // Initializes driver and opens URL
        trendingPage = new TrendingCoursesPage(driver); // Pass driver to Page Object
		//BaseSteps.launchBrowser();
		driver = BaseSteps.driver;
		enrollNowPage = new EnrollNowPage(driver);
		courseAccessPage = new CourseAccessPage(driver);

		// Scroll to Trending Courses and click on course card
//		enrollNowPage.scrollToTrendingCourses();
		courseAccessPage.scrollToSection();
		courseAccessPage.clickOnCourseCard();
		courseAccessPage.clickOnCourseCard();
//		enrollNowPage = new EnrollNowPage(Hooks.driver);
		enrollNowPage.clickEnrollButton();
	}
	
	@When("the user enters email and phone number row {int}")
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
		//enrollNowPage.submitEnrollmentForm();
		//enrollNowPage.isOnPaymentPage();
	}
	
	@Then("the payment page should display the text Order Summary")
    public void the_payment_page_should_display_the_text_Order_Summary() {
		enrollNowPage.isOrderSummaryVisible();
		driver.quit();
	}

}