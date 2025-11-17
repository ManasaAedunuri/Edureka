package com.runner;

import java.util.List; 

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = ".\\src\\test\\resources\\Features\\careers.feature",

glue = {"com.stepDefinitionTestNG"},
//tags="@TS_03",

plugin = {"pretty:Reports/PrettyReports.html", 
		"html:target/cucumber-report.html",
		"html:Reports/HTMLreports.html",
		"json:Reports/json-report.json",
		"junit:Reports/junit_report.xml"} ,
monochrome=true
		)
public class TestRunnerTestNG extends AbstractTestNGCucumberTests{
	

@Override
@DataProvider(parallel = true)
public Object[][] scenarios() {
    return super.scenarios();
}

}
