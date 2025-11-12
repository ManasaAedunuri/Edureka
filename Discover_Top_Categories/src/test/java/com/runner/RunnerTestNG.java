package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    features = "src/test/resources/Features/discover_top_categories.feature",
	    glue = "com.stepDefinitionTestNG",
	    //tags = "@TopCategories",
	    tags = "@AI",
	    plugin = {"pretty", "html:target/cucumber-reports.html",
	    		    "json:reports/json-report.json",
				"junit: reports/junit-report.xml"},
	    monochrome = true
	)
public class RunnerTestNG extends AbstractTestNGCucumberTests {
	
}