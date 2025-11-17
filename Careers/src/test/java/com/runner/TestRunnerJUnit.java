package com.runner;
 
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

//import io.cucumber.testng.CucumberOptions;
 
@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src\\test\\resources\\Features\\careers.feature",
		//tags="@TS_01",
		glue = {"com.stepDefinitionTestNG"},
		plugin = {"pretty", "html:Reports/cucumber-reports.html",
				"json:Reports/json-report.json",
				"junit:Reports/junit_report.xml"}
		)
 
public class TestRunnerJUnit {
 
}
