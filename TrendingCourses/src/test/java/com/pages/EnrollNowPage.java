package com.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.setup.BaseSteps;

import io.cucumber.java.en.Given;

public class EnrollNowPage {
	WebElement element=null;
	WebDriver driver;
	 TrendingCoursesPage trendingPage;
	@Given("The user launches the application as Edureka")
	public void the_user_launches_the_application_as_edureka() {
	    // Write code here that turns the phrase above into concrete actions
		 BaseSteps.launchBrowser();
	     trendingPage = new TrendingCoursesPage(driver);
		
	    throw new io.cucumber.java.PendingException();
	}
	
	public void clickOnCourseCard() throws IOException{
		
		
		
	}

}

