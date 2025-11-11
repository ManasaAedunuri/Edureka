package com.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src\\test\\resources\\Features\\search.feature",
		glue = {"com.stepDefinitionTestNG"},
		plugin = {"pretty", "html:Reports/cucumber-reports.html"}
		)

public class TestRunnerJUnit {

}
