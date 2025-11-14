package com.stepDefinitionTestNG;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.pages.CareersPage;
import com.parameters.ExcelReader;
import com.parameters.PropertyReader;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Careers {
	
	CareersPage careersPage = new CareersPage();
	
	
	@Given("I Launch the Edureka website")
	public void i_launch_the_edureka_website() {
		Hooks.driver.get(PropertyReader.getProperty("base.url"));
	}
	
	@When("I scroll to the footer")
	public  void i_scroll_to_the_footer() throws InterruptedException {
		 
	    careersPage.scrollToFooter();  

	}
//
	@When("I click on the target link")
	public void i_click_on_the_target_link() throws InterruptedException {
		careersPage.clickCareersLink();
	}

	@Then("I should be redirected to the target page")
	public void i_should_be_redirected_to_the_target_page() throws InterruptedException {
		careersPage.verifyJoinUsPage();
	}

	@When("I scroll down to sectionName2")
	public void i_scroll_down_to_section_name2() throws InterruptedException {
		careersPage.scrollToOpenPositions();
	}

	@When("I click on sectionName3 under Marketing")
	public void i_click_on_section_name3_under_marketing() throws InterruptedException {
		careersPage.clickInternshipLink();
        careersPage.switchToJobDescriptionTab();
	}

	
	@Then("a new tab should open with job description")
	public void a_new_tab_should_open_with_job_description() throws InterruptedException {
		careersPage.verifyJobDescriptionPage();

	}

	@And("I scroll down to verify job details")
	public void i_scroll_down_to_verify_job_details() throws InterruptedException   {
		careersPage.scrollToJobDetails();
	}
	
	
	
	
	//Test_Scenario_02
	
	
	
	@And("I click on blog")
	public void i_click_on_blog() throws InterruptedException {
		careersPage.clickBlog();
	    careersPage.switchToJobDescriptionTab();
	}

	@And("I click on ebook to get free ebooks in blog page")
	public void i_click_on_ebook_to_get_free_ebooks_in_blog_page() throws InterruptedException {
		careersPage.clickEbook();
	    careersPage.switchToJobDescriptionTab();
	}

	@And("I click on bookName in ebooks page")
	public void i_click_on_book_name_in_ebooks_page() throws InterruptedException {
		careersPage.clickAWSBook();
	}
	

	@Then("The Ebook is displayed")
	public void the_ebook_is_displayed() {
	    careersPage.verifyEbook();
	}
	
	
	
	
	
	
	
	//test Scenario_3
	

	

	
	@And("I click on target1")
	   public void i_click_on_target1() throws InterruptedException {

		    		careersPage.clickonCT();
		    }
	   
	   @And("I click on form")
	   public void i_click_on_form() throws InterruptedException {

		   careersPage.clickonform();

	   }
	   
	   
//	   @Then("I fill the form using data from {string} {string}")
//	   public void i_fill_the_form_using_data_from(String sheet, String row) throws InterruptedException {
//
//		
//        
//        careersPage.enterName(sheet,row);
//        careersPage.enterCompanyName(sheet,row);
//        careersPage.enterTrainingNeed(sheet, row);
//        careersPage.enterEmail(sheet, row);
//        careersPage.enterPhone(sheet, row);
//        careersPage.enterQuery(sheet, row);
//        
//
////        driver.findElement(By.id("name")).sendKeys(formData.get("Name"));
////        driver.findElement(By.id("companyName")).sendKeys(formData.get("CompanyName"));
////        WebElement dropdown = driver.findElement(By.id("trainingNeed"));
////        dropdown.click();
////        dropdown.findElement(By.xpath("//option[text()='" + formData.get("TrainingNeed") + "']")).click();
////        driver.findElement(By.id("email")).sendKeys(formData.get("Email"));
////        driver.findElement(By.id("phone")).sendKeys(formData.get("Phone"));
////        driver.findElement(By.id("query")).sendKeys(formData.get("Query"));
//    
//
//	   }
	   
	   @Then("I fill the form using data from {int} {int}")
	   public void i_fill_the_form_using_data_from(Integer int1, Integer int2) throws InterruptedException {
		   careersPage.enterFormData(int1, int2);
	   }
	   
	   
	  

		@And("I submit the form")
		public void i_submit_the_form() throws InterruptedException  {
			   careersPage.clickSubmit();
		}
	   @Then("I should see the Thankyou popup and close it")
	   public void i_should_see_the_thankyou_popup_and_close_it() throws InterruptedException {
	       Thread.sleep(1000);
	   }
	   
	  
	   @Then("the form should be submitted successfully")
	   public void the_form_should_be_submitted_successfully() throws InterruptedException {
		   careersPage.formSubmitted();
	   }	
	   
	   
      //TS_04
	   
	   
	   @Then("I scroll to curriculums section")
	   public void i_scroll_to_curriculums_section() throws InterruptedException {
	       careersPage.scrollToDownload();
		   
	   }

	   @Then("I click on Download button")
	   public void i_click_on_download_button() throws InterruptedException {
	       careersPage.clickDownload();
	   }
	   
//	   @Then("I fill the form using data from {int} {int}")
//	   public void i_fill_the_form_using_data_from(Integer int1, Integer int2) throws InterruptedException {
//	       
//		   careersPage.FillDownloadForm(int1, int2);
//	   }
	   
	   @Then("I fill the form using data from {int} {int} to download the list")
	   public void i_fill_the_form_using_data_from_to_download_the_list(Integer int1, Integer int2) throws InterruptedException {
		   careersPage.FillDownloadForm(int1, int2);
	   }

	   @Then("I click on submit")
	   public void i_click_on_submit() throws InterruptedException {
	       
		   careersPage.clickOnDownloadSubmit();
	   }

	   @Then("full course List is downloaded")
	   public void full_course_list_is_downloaded() {
	       
	   }
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   //Test Scenario_05
	   
	   
	   @Then("I scroll to More Resources section to find target2")
	   public void i_scroll_to_more_resources_section_to_find_target2() throws InterruptedException {
	       careersPage.scrollToMoreResources();
	   }

	   @Then("I click on target2")
	   public void i_click_on_target2() throws InterruptedException {
	       careersPage.clickOnVideo();
	   }

	   @Then("I scroll to find Recently Added Videos")
	   public void i_scroll_to_find_recently_added_videos() throws InterruptedException {
	      careersPage.scrollToRecentVideos();
	   }

	   @When("I click on target3")
	   public void i_click_on_target3() throws InterruptedException {
	      careersPage.clickOnDevopsVideo();
	   }

	   @Then("the video lectures page should be displayed")
	   public void the_video_lectures_page_should_be_displayed() {
	       
	   }
	   
}
