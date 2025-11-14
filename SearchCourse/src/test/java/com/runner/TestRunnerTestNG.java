package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src\\test\\resources\\Features\\search.feature",
		//tags="@first",
		//tags="@second",
		//tags="@third",
		//tags = "@fourth",
		tags = "@fifth",
		glue = {"com.stepDefinitionTestNG"},
		plugin = {"pretty", "html:Reports/cucumber-reports.html",
				"json:reports/json-report.json",
				"junit:reports/junit_report.xml","pretty", "html:target/cucumber-reports.html"}
		)

public class TestRunnerTestNG extends AbstractTestNGCucumberTests {
	
}