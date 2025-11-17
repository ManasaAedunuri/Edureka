package com.stepDefinitionTestNG;

import com.aventstack.extentreports.Status;
import com.pages.CareersPage;
import com.parameters.PropertyReader;
import com.setup.Reports;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Careers {
	
	CareersPage careersPage = new CareersPage();
	
	
	@Given("I Launch the Edureka website")
	public void i_launch_the_edureka_website() {
		//Hooks.driver.get(PropertyReader.getProperty("base.url"));

	try {
	            Hooks.driver.get(PropertyReader.getProperty("base.url"));
	            Reports.generateReport(Hooks.driver, Hooks.test, Status.PASS, "Launched Edureka website successfully");
	} catch (Exception e) {
	            Reports.generateReport(Hooks.driver, Hooks.test, Status.FAIL, "Failed to launch Edureka website");
	            throw e;
	}

	}
	
	@When("I scroll to the footer")
	public  void i_scroll_to_the_footer() throws InterruptedException {
		 
	    //careersPage.scrollToFooter();  

		 try {
		            careersPage.scrollToFooter();
		            Reports.generateReport(Hooks.driver, Hooks.test, Status.PASS, "Scrolled to footer");
		        } catch (Exception e) {
		            Reports.generateReport(Hooks.driver, Hooks.test, Status.FAIL, "Failed to scroll to footer");
		            throw e;
		        }


	}

	@When("I click on the target link")
	public void i_click_on_the_target_link() throws InterruptedException {
		//careersPage.clickCareersLink();

try {
            careersPage.clickCareersLink();
            Reports.generateReport(Hooks.driver, Hooks.test, Status.PASS, "Clicked Careers link");
        } catch (Exception e) {
            Reports.generateReport(Hooks.driver, Hooks.test, Status.FAIL, "Failed to click Careers link");
            throw e;
        }

	}

	@Then("I should be redirected to the target page")
	public void i_should_be_redirected_to_the_target_page() throws InterruptedException {
		//careersPage.verifyJoinUsPage();

try {
            careersPage.verifyJoinUsPage();
            Reports.generateReport(Hooks.driver, Hooks.test, Status.PASS, "Redirected to Join Us page");
        } catch (Exception e) {
            Reports.generateReport(Hooks.driver, Hooks.test, Status.FAIL, "Redirection failed");
            throw e;
        }

	}

	@When("I scroll down to sectionName2")
	public void i_scroll_down_to_section_name2() throws InterruptedException {
		//careersPage.scrollToOpenPositions();

try {
            careersPage.scrollToOpenPositions();
            Reports.generateReport(Hooks.driver, Hooks.test, Status.PASS, "Scrolled to Open Positions");
        } catch (Exception e) {
            Reports.generateReport(Hooks.driver, Hooks.test, Status.FAIL, "Failed to scroll to Open Positions");
            throw e;
        }

	}

	@When("I click on sectionName3 under Marketing")
	public void i_click_on_section_name3_under_marketing() throws InterruptedException {
//		careersPage.clickInternshipLink();
//        careersPage.switchToJobDescriptionTab();

try {
            careersPage.clickInternshipLink();
            careersPage.switchToJobDescriptionTab();
            Reports.generateReport(Hooks.driver, Hooks.test, Status.PASS, "Clicked Internship link and switched tab");
        } catch (Exception e) {
            Reports.generateReport(Hooks.driver, Hooks.test, Status.FAIL, "Failed to click Internship link");
            throw e;
        }

	}

	
	@Then("a new tab should open with job description")
	public void a_new_tab_should_open_with_job_description() throws InterruptedException {
		//careersPage.verifyJobDescriptionPage();

try {
            careersPage.verifyJobDescriptionPage();
            Reports.generateReport(Hooks.driver, Hooks.test, Status.PASS, "Job description page opened");
        } catch (Exception e) {
            Reports.generateReport(Hooks.driver, Hooks.test, Status.FAIL, "Job description page not opened");
            throw e;
        }


	}

	@And("I scroll down to verify job details")
	public void i_scroll_down_to_verify_job_details() throws InterruptedException   {
		//careersPage.scrollToJobDetails();
		

try {
            careersPage.scrollToJobDetails();
            Reports.generateReport(Hooks.driver, Hooks.test, Status.PASS, "Scrolled to job details");
        } catch (Exception e) {
            Reports.generateReport(Hooks.driver, Hooks.test, Status.FAIL, "Failed to scroll to job details");
            throw e;
        }

	}
	
	@Then("Job details page should be visible")
	public void job_details_page_should_be_visible() throws InterruptedException {
	   //careersPage.verifyJobDetails();

try {
            careersPage.verifyJobDetails();
            //Reports.generateReport(Hooks.driver, Hooks.test, Status.PASS, "Job details page is visible");
            Reports.captureScreenshot(Hooks.driver, "screenshot_scenario_01");
        } catch (Exception e) {
            Reports.generateReport(Hooks.driver, Hooks.test, Status.FAIL, "Job details page is NOT visible");
            throw e;
        }

	}
	
	
	 //Test Scenario_02
	
	
	
	@And("I click on blog")
	public void i_click_on_blog() throws InterruptedException {
//		careersPage.clickBlog();
//	    careersPage.switchToJobDescriptionTab();

try {
        careersPage.clickBlog();
        careersPage.switchToJobDescriptionTab();
        Reports.generateReport(Hooks.driver, Hooks.test, Status.PASS, "Clicked Blog and switched to new tab");
    } catch (Exception e) {
        Reports.generateReport(Hooks.driver, Hooks.test, Status.FAIL, "Failed to click Blog");
        throw e;
    }

	}

	@And("I click on ebook to get free ebooks in blog page")
	public void i_click_on_ebook_to_get_free_ebooks_in_blog_page() throws InterruptedException {
//		careersPage.clickEbook();
//	    careersPage.switchToJobDescriptionTab();

try {
        careersPage.clickEbook();
        careersPage.switchToJobDescriptionTab();
        Reports.generateReport(Hooks.driver, Hooks.test, Status.PASS, "Clicked Ebook and switched to new tab");
    } catch (Exception e) {
        Reports.generateReport(Hooks.driver, Hooks.test, Status.FAIL, "Failed to click Ebook");
        throw e;
    }

	}

	@And("I click on bookName in ebooks page")
	public void i_click_on_book_name_in_ebooks_page() throws InterruptedException {
//		careersPage.clickAWSBook();

try {
        careersPage.clickAWSBook();
        Reports.generateReport(Hooks.driver, Hooks.test, Status.PASS, "Clicked AWS Book");
    } catch (Exception e) {
        Reports.generateReport(Hooks.driver, Hooks.test, Status.FAIL, "Failed to click AWS Book");
        throw e;
    }

	}
	

	@Then("The Ebook is displayed")
	public void the_ebook_is_displayed() throws InterruptedException {
//	    careersPage.verifyEbook();

try {
        careersPage.verifyEbook();
        //Reports.generateReport(Hooks.driver, Hooks.test, Status.PASS, "Ebook page verified successfully");
        Reports.captureScreenshot(Hooks.driver, "screenshot_scenario_02");
    } catch (Exception e) {
        Reports.generateReport(Hooks.driver, Hooks.test, Status.FAIL, "Ebook page verification failed");
        throw e;
    }

	}
	
	
	
	 //Test Scenario_03
	
	
	  @And("I click on target1")
	   public void i_click_on_target1() throws InterruptedException {

		    		//careersPage.clickonCT();

try {
        careersPage.clickonCT();
        Reports.generateReport(Hooks.driver, Hooks.test, Status.PASS, "Clicked Corporate Training link");
    } catch (Exception e) {
        Reports.generateReport(Hooks.driver, Hooks.test, Status.FAIL, "Failed to click Corporate Training link");
        throw e;
    }

		}
	   
	   @And("I click on form")
	   public void i_click_on_form() throws InterruptedException {

		   //careersPage.clickonform();

		   try {
		          careersPage.clickonform();
		          Reports.generateReport(Hooks.driver, Hooks.test, Status.PASS, "Clicked form button");
		      } catch (Exception e) {
		          Reports.generateReport(Hooks.driver, Hooks.test, Status.FAIL, "Failed to click form button");
		          throw e;
		      }


	   }
	    
	   
	   @Then("I fill the form using data from {int} {int}")
	   public void i_fill_the_form_using_data_from(Integer int1, Integer int2) throws InterruptedException {
		   //careersPage.enterFormData(int1, int2);

try {
        careersPage.enterFormData(int1, int2);
        Reports.generateReport(Hooks.driver, Hooks.test, Status.PASS, "Filled form with data from Excel");
    } catch (Exception e) {
        Reports.generateReport(Hooks.driver, Hooks.test, Status.FAIL, "Failed to fill form");
        throw e;
    }

	   }
	   

		@And("I submit the form")
		public void i_submit_the_form() throws InterruptedException  {
			  // careersPage.clickSubmit();

try {
        careersPage.clickSubmit();
        Reports.generateReport(Hooks.driver, Hooks.test, Status.PASS, "Clicked Submit button");
    } catch (Exception e) {
        Reports.generateReport(Hooks.driver, Hooks.test, Status.FAIL, "Failed to click Submit button");
        throw e;
    }

		}
		
	   @Then("I should see the Thankyou popup and close it")
	   public void i_should_see_the_thankyou_popup_and_close_it() throws InterruptedException {
	       //Thread.sleep(1000);

try {
        Thread.sleep(1000);
       // Reports.generateReport(Hooks.driver, Hooks.test, Status.PASS, "Thank you popup displayed");
        Reports.captureScreenshot(Hooks.driver, "screenshot_scenario_03");
    } catch (Exception e) {
        Reports.generateReport(Hooks.driver, Hooks.test, Status.FAIL, "Thank you popup not displayed");
        throw e;
    }

	   }
	   
	  
	   @Then("the form should be submitted successfully")
	   public void the_form_should_be_submitted_successfully() throws InterruptedException {
		   //careersPage.formSubmitted();

try {
        careersPage.formSubmitted();
        Reports.generateReport(Hooks.driver, Hooks.test, Status.PASS, "Form submitted successfully");
        
    } catch (Exception e) {
        Reports.generateReport(Hooks.driver, Hooks.test, Status.FAIL, "Form submission failed");
        throw e;
    }

	   }	
	   
	   
	   //Test Scenario_04
	   
	   @Then("I scroll to curriculums section")
	   public void i_scroll_to_curriculums_section() throws InterruptedException {
	       //careersPage.scrollToDownload();

try {
        careersPage.scrollToDownload();
        Reports.generateReport(Hooks.driver, Hooks.test, Status.PASS, "Scrolled to curriculums section");
    } catch (Exception e) {
        Reports.generateReport(Hooks.driver, Hooks.test, Status.FAIL, "Failed to scroll to curriculums section");
        throw e;
    }

		   
	   }

	   @Then("I click on Download button")
	   public void i_click_on_download_button() throws InterruptedException {
//	       careersPage.clickDownload();

try {
        careersPage.clickDownload();
        Reports.generateReport(Hooks.driver, Hooks.test, Status.PASS, "Clicked Download button");
    } catch (Exception e) {
        Reports.generateReport(Hooks.driver, Hooks.test, Status.FAIL, "Failed to click Download button");
        throw e;
    }

	   }
	   
	   
	   @Then("I fill the form using data from {int} {int} to download the list")
	   public void i_fill_the_form_using_data_from_to_download_the_list(Integer int1, Integer int2) throws InterruptedException {
//		   careersPage.FillDownloadForm(int1, int2);

try {
        careersPage.FillDownloadForm(int1, int2);
        Reports.generateReport(Hooks.driver, Hooks.test, Status.PASS, "Filled download form with Excel data");
    } catch (Exception e) {
        Reports.generateReport(Hooks.driver, Hooks.test, Status.FAIL, "Failed to fill download form");
        throw e;
    }

	   }

	   @Then("I click on submit")
	   public void i_click_on_submit() throws InterruptedException {
	       
//		   careersPage.clickOnDownloadSubmit();

try {
        careersPage.clickOnDownloadSubmit();
        Reports.generateReport(Hooks.driver, Hooks.test, Status.PASS, "Clicked submit for download form");
    } catch (Exception e) {
        Reports.generateReport(Hooks.driver, Hooks.test, Status.FAIL, "Failed to click submit for download form");
        throw e;
    }

	   }

	   @Then("full course List is downloaded")
	   public void full_course_list_is_downloaded() throws InterruptedException {
//	       careersPage.verifySuccessfulDownload();

try {
        careersPage.verifySuccessfulDownload();
        //Reports.generateReport(Hooks.driver, Hooks.test, Status.PASS, "Full course list downloaded successfully");
        Reports.captureScreenshot(Hooks.driver, "screenshot_scenario_04");
    } catch (Exception e) {
        Reports.generateReport(Hooks.driver, Hooks.test, Status.FAIL, "Course list download failed");
        throw e;
    }

	   }
	   
	   
	    
	   //Test Scenario_05
	   
	   
	   @Then("I scroll to More Resources section to find target2")
	   public void i_scroll_to_more_resources_section_to_find_target2() throws InterruptedException {
//	       careersPage.scrollToMoreResources();

try {
        careersPage.scrollToMoreResources();
        Reports.generateReport(Hooks.driver, Hooks.test, Status.PASS, "Scrolled to More Resources section");
    } catch (Exception e) {
        Reports.generateReport(Hooks.driver, Hooks.test, Status.FAIL, "Failed to scroll to More Resources section");
        throw e;
    }

	   }

	   @Then("I click on target2")
	   public void i_click_on_target2() throws InterruptedException {
//	       careersPage.clickOnVideo();

try {
        careersPage.clickOnVideo();
        Reports.generateReport(Hooks.driver, Hooks.test, Status.PASS, "Clicked target2 (Video link)");
    } catch (Exception e) {
        Reports.generateReport(Hooks.driver, Hooks.test, Status.FAIL, "Failed to click target2 (Video link)");
        throw e;
    }

	   }

	   @Then("I scroll to find Recently Added Videos")
	   public void i_scroll_to_find_recently_added_videos() throws InterruptedException {
//	      careersPage.scrollToRecentVideos();

		   try {
		          careersPage.scrollToRecentVideos();
		          Reports.generateReport(Hooks.driver, Hooks.test, Status.PASS, "Scrolled to Recently Added Videos");
		      } catch (Exception e) {
		          Reports.generateReport(Hooks.driver, Hooks.test, Status.FAIL, "Failed to scroll to Recently Added Videos");
		          throw e;
		      }

	   }

	   @When("I click on target3")
	   public void i_click_on_target3() throws InterruptedException {
//	      careersPage.clickOnDevopsVideo();

try {
        careersPage.clickOnDevopsVideo();
        Reports.generateReport(Hooks.driver, Hooks.test, Status.PASS, "Clicked target3 (DevOps Video)");
    } catch (Exception e) {
        Reports.generateReport(Hooks.driver, Hooks.test, Status.FAIL, "Failed to click target3 (DevOps Video)");
        throw e;
    }

	   }

	   @Then("the video lectures page should be displayed")
	   public void the_video_lectures_page_should_be_displayed() throws InterruptedException {
//	       careersPage.verifyDevopsVideoSeriesPage();

try {
        careersPage.verifyDevopsVideoSeriesPage();
        //Reports.generateReport(Hooks.driver, Hooks.test, Status.PASS, "Video lectures page displayed successfully");
        Reports.captureScreenshot(Hooks.driver, "screenshot_scenario_05");
    } catch (Exception e) {
        Reports.generateReport(Hooks.driver, Hooks.test, Status.FAIL, "Video lectures page not displayed");
        throw e;
    }

	       //Thread.sleep(2000);
	       
	       
	   }
	   
	   
	   //TS_06
	   
	   
	   @Then("It should show me an error for filling invalid data")
	    public void it_should_show_me_an_error_for_filling_invalid_data() throws InterruptedException {
		   try {
		        careersPage.verifyErrorMessage();
		       // Reports.generateReport(Hooks.driver, Hooks.test, Status.PASS, "Verified Error message successfully");
		        Reports.captureScreenshot(Hooks.driver, "screenshot_scenario_06");
		    } catch (Exception e) {
		        Reports.generateReport(Hooks.driver, Hooks.test, Status.FAIL, "submitting with Invalid Data is failed");
		        throw e;
		    }
		   
	   }
	   
}
