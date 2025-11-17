package com.stepDefinitionTestNG;

import com.pages.CourseAccessPage;
import com.pages.EnrollNowPage;
import com.pages.KnowMorePage;
import com.pages.ViewMorePage;
import com.setup.BaseSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class KnowMore extends BaseSteps{
	
	EnrollNowPage EnrollNow;
	CourseAccessPage courseAccessPage;
	ViewMorePage viewMorePage=new ViewMorePage(driver);
	KnowMorePage knowMorePage=new KnowMorePage(driver);


@When("the user click on Know more options to become an AI engineer")
public void the_user_click_on_know_more_options_to_become_an_ai_engineer() throws InterruptedException {
    knowMorePage.clickOnKnowMore();
   
}
@And("the user fill the application with Email and Phone number <rowIndex>")
public void the_user_fill_the_application_with_email_and_phone_number_row_index() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}
@And("click on the apllication")
public void click_on_the_apllication() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}
@Then("thank you card will displayed")
public void thank_you_card_will_displayed() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}
}
