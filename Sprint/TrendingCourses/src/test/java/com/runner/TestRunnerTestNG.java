package com.runner;
 
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
 
@CucumberOptions(
		features = "src\\test\\resources\\Features\\trending_course.feature",
		glue = {"com.stepDefinitionTestNG"},
				//tags="@outline2",
		plugin = {"pretty", "html:Reports/cucumber-reports.html",
		},//tags="@first"
		//tags="@second",
		tags="@outline2"
			
		
		)
public class TestRunnerTestNG extends AbstractTestNGCucumberTests {
	
}
 