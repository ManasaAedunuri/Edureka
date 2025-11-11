package com.runner;
 
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
 
@CucumberOptions(
		features = "src\\test\\resources\\Features\\trending_course.feature",
		//tags="@first",
		//tags="@second",
		glue = {"com.stepDefinitionTestNG"},
		plugin = {"pretty", "html:Reports/cucumber-reports.html"}
		)
 
public class TestRunnerTestNG extends AbstractTestNGCucumberTests {
	
}
 