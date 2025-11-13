package com.stepDefinitionTestNG;

import java.util.Properties;

import org.testng.Assert;

import com.Pages.ExploreCourses;
import com.Pages.ResourcesPage;
import com.Parameters.ExcelReader;
import com.Parameters.PropertyReader;
import com.setUp.BaseSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class Explore extends BaseSteps {
	ExploreCourses exploreCourses = new ExploreCourses(driver);
	ResourcesPage resourcesPage;
	String courseName;

@Given("the user launches the browser")
public void the_user_launches_the_browser() {
	 BaseSteps.launchBrowser();
	 driver = BaseSteps.driver;
}

@When("the user navigates to the homepage from the property file")
public void the_user_navigates_to_the_homepage_from_the_property_file() {
	driver.get(PropertyReader.get("homepage"));
	exploreCourses = new ExploreCourses(driver);
}

@When("the user selects the submenu")
public void the_user_selects_the_submenu() {
	resourcesPage=new ResourcesPage(driver);
	 resourcesPage.clickResources();
}

@When("the user navigates to the section")
public void the_user_navigates_to_the_section() {
	resourcesPage=new ResourcesPage(driver);
	resourcesPage.clickBlog();
	exploreCourses.clickMenu();
}

@When("the user searches for each course listed {int}")
public void the_user_searches_for_each_course_listed(Integer int1) {
	Properties prop = PropertyReader.readProperty();
	
	    // ✅ Now safely get the Excel path
	    String excelPath = prop.getProperty("excel_path1");
	    System.out.println("Excel path: " + excelPath); // Debug
	
	    // ✅ Defensive check
	    if (excelPath == null || excelPath.isEmpty()) {
	        throw new RuntimeException("Excel path is missing in properties file");
	    }
	
	    // ✅ Read from Excel
//	    courseName = ExcelReader.getLocalityByRow1(excelPath, 0, rowIndex);
	    
	    courseName = ExcelReader.getLocalityByRow1(excelPath, 0, int1);
	    System.out.println("Course name: " + courseName); // Debug
	
//	    driver.get(prop.getProperty("homepage"));
	    exploreCourses =new ExploreCourses(driver);
	    exploreCourses.searchCourse(courseName);
}

@Then ("validate the search course with displayed course")
public void validate_the_search_course_with_displayed_course() {
	exploreCourses.validate();
	driver.quit();
}
}

