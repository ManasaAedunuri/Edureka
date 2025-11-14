package com.runner;

import java.util.List; 

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = ".\\src\\test\\resources\\Features\\careers.feature",

glue = {"com.stepDefinitionTestNG"},
tags="@TS_01",

plugin = {"pretty", "html:Reports/cucumber-reports.html",
		
		} ,monochrome=true
		)
public class TestRunnerTestNG extends AbstractTestNGCucumberTests{

}
