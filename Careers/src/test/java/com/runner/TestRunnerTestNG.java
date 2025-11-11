package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = ".\\src\\test\\resources\\Features\\careers.feature",

glue = "com.stepDefinitionTestNG",
//tags="@Tc1,@Tc2"
//tags=("@Tc1 or @Tc2")
//tags = "@CI",
//tags="@CT",
plugin = {"pretty", "html:Reports/cucumber-reports.html",
		
		} ,monochrome=true
		)
public class TestRunnerTestNG extends AbstractTestNGCucumberTests{

}
